package com.kjh.boardback.service.implement;

import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyBoardRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyCommentRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyBoardRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyCommentRequestDto;
import com.kjh.boardback.dto.response.ResponseDto;
import com.kjh.boardback.dto.response.groupBuy_board.*;
import com.kjh.boardback.entity.SearchLogEntity;
import com.kjh.boardback.entity.groupBuy_board.*;
import com.kjh.boardback.repository.SearchLogRepository;
import com.kjh.boardback.repository.UserRepository;
import com.kjh.boardback.repository.resultSet.GetGroupBuyBoardResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyCommentListResultSet;
import com.kjh.boardback.repository.resultSet.GetGroupBuyFavoriteListResultSet;
import com.kjh.boardback.repository.groupBuy_board.*;
import com.kjh.boardback.service.GroupBuyBoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupBuyBoardServiceImplement implements GroupBuyBoardService {

    private final GroupBuyBoardRepository groupBuyBoardRepository;
    private final GroupBuyImageRepository groupBuyImageRepository;
    private final GroupBuyCommentRepository groupBuyCommentRepository;
    private final GroupBuyFavoriteRepository groupBuyFavoriteRepository;
    private final GroupBuyBoardListViewRepository groupBuyBoardListViewRepository;
    private final UserRepository userRepository;
    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super PostGroupBuyCommentResponseDto> postComment(Integer boardNumber, String email, PostGroupBuyCommentRequestDto dto) {
        try {
            GroupBuyBoardEntity boardEntity = groupBuyBoardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PostGroupBuyCommentResponseDto.noExistBoard();

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return PostGroupBuyCommentResponseDto.noExistUser();

            GroupBuyCommentEntity commentEntity = new GroupBuyCommentEntity(boardNumber, email, dto);
            groupBuyCommentRepository.save(commentEntity);

            boardEntity.increaseCommentCount();
            groupBuyBoardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }
        return PostGroupBuyCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetLatestGroupBuyBoardListResponseDto> getLatestBoardList() {

        List<GroupBuyBoardListViewEntity> groupBuyBoardListViewEntities = new ArrayList<>();

        try{
            groupBuyBoardListViewEntities = groupBuyBoardListViewRepository.findByOrderByWriteDatetimeDesc();

        }catch (Exception exception){
            exception.printStackTrace();
            return GetLatestGroupBuyBoardListResponseDto.databaseError();
        }
        return GetLatestGroupBuyBoardListResponseDto.success(groupBuyBoardListViewEntities);
    }

    @Override
    public ResponseEntity<? super DeleteGroupBuyBoardResponseDto> deleteBoard(String email, Integer boardNumber) {
        try{
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return DeleteGroupBuyBoardResponseDto.noExistUser();

            GroupBuyBoardEntity boardEntity = groupBuyBoardRepository.findByBoardNumber(boardNumber);
            if (boardEntity ==null) return DeleteGroupBuyBoardResponseDto.noExistBoard();

            boolean isWriter = boardEntity.getWriterEmail().equals(email);
            if(!isWriter) return DeleteGroupBuyBoardResponseDto.noPermission();

            groupBuyImageRepository.deleteByBoardNumber(boardNumber);
            groupBuyCommentRepository.deleteByBoardNumber(boardNumber);
            groupBuyFavoriteRepository.deleteByBoardNumber(boardNumber);
            groupBuyBoardRepository.delete(boardEntity);



        }catch (Exception exception){
            exception.printStackTrace();
            return DeleteGroupBuyBoardResponseDto.databaseError();
        }
        return DeleteGroupBuyBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchGroupBuyBoardResponseDto> patchBoard(PatchGroupBuyBoardRequestDto requestDto, String email, Integer boardNumber) {
        try{
            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return PatchGroupBuyBoardResponseDto.noExistUser();

            GroupBuyBoardEntity boardEntity = groupBuyBoardRepository.findByBoardNumber(boardNumber);
            if (boardEntity ==null) return PatchGroupBuyBoardResponseDto.noExistBoard();

            boolean isWriter = boardEntity.getWriterEmail().equals(email);
            if(!isWriter) return PatchGroupBuyBoardResponseDto.noPermission();

            boardEntity.patchBoard(requestDto);
            groupBuyBoardRepository.save(boardEntity);

            groupBuyImageRepository.deleteByBoardNumber(boardNumber);
            List<String> imageList = requestDto.getBoardImageList();
            List<GroupBuyImageEntity> imageEntities = new ArrayList<>();

            for(String image : imageList ){
                GroupBuyImageEntity imageEntity = new GroupBuyImageEntity(boardNumber, image);
                imageEntities.add(imageEntity);
            }
            groupBuyImageRepository.saveAll(imageEntities);

        }catch (Exception exception){
            exception.printStackTrace();
            return PatchGroupBuyBoardResponseDto.databaseError();
        }
        return PatchGroupBuyBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostGroupBuyBoardResponseDto> postBoard(PostGroupBuyBoardRequestDto requestDto, String email) {
        try{
            boolean existedEmail = userRepository.existsByEmail(email);
            if(!existedEmail) return PostGroupBuyBoardResponseDto.noExistUser();

            GroupBuyBoardEntity groupBuyBoardEntity = new GroupBuyBoardEntity(requestDto, email);
            groupBuyBoardRepository.save(groupBuyBoardEntity);

            int boardNumber = groupBuyBoardEntity.getBoardNumber();

            List<String> imageList = requestDto.getBoardImageList();
            List<GroupBuyImageEntity> imageEntities = new ArrayList<>();

            for(String image : imageList ){
                GroupBuyImageEntity imageEntity = new GroupBuyImageEntity(boardNumber, image);
                imageEntities.add(imageEntity);
            }
            groupBuyImageRepository.saveAll(imageEntities);

        }catch (Exception exception){
            exception.printStackTrace();
            return PostGroupBuyBoardResponseDto.databaseError();
        }
        return PostGroupBuyBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetGroupBuyBoardResponseDto> getBoard(Integer boardNumber) {

        GetGroupBuyBoardResultSet resultSet = null;
        List<GroupBuyImageEntity> groupBuyImageEntities = new ArrayList<>();

        try{
            resultSet = groupBuyBoardRepository.getBoard(boardNumber);
            if (resultSet == null) return GetGroupBuyBoardResponseDto.noExistBoard();

            groupBuyImageEntities = groupBuyImageRepository.findByBoardNumber(boardNumber);


        }catch (Exception exception){
            exception.printStackTrace();
            return GetGroupBuyBoardResponseDto.databaseError();
        }
        return GetGroupBuyBoardResponseDto.success(resultSet,groupBuyImageEntities);
    }
    @Override
    public ResponseEntity<? super GetGroupBuyFavoriteListResponseDto> getFavoriteList(Integer boardNumber) {
        List<GetGroupBuyFavoriteListResultSet> resultSets = new ArrayList<>();

        try {
            Boolean existedBoard = groupBuyBoardRepository.existsByBoardNumber(boardNumber);
            if (!existedBoard) return GetGroupBuyFavoriteListResponseDto.noExistBoard();

            resultSets = groupBuyFavoriteRepository.getFavoriteList(boardNumber);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetGroupBuyFavoriteListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetGroupBuyCommentListResponseDto> getCommentList(Integer boardNumber) {
        List<GetGroupBuyCommentListResultSet> resultSets = new ArrayList<>();

        try {
            Boolean existedBoard = groupBuyBoardRepository.existsByBoardNumber(boardNumber);
            if (!existedBoard) return GetGroupBuyCommentListResponseDto.noExistBoard();

            resultSets = groupBuyCommentRepository.getCommentList(boardNumber);


        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }
        return GetGroupBuyCommentListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super IncreaseGroupBuyViewCountResponseDto> increaseViewCount(Integer boardNumber) {
        try {
            GroupBuyBoardEntity boardEntity = groupBuyBoardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return IncreaseGroupBuyViewCountResponseDto.noExistBoard();
            boardEntity.increaseViewCount();
            groupBuyBoardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return IncreaseGroupBuyViewCountResponseDto.success();
    }
    @Override
    public ResponseEntity<? super GetTop3GroupBuyBoardListResponseDto> getTop3BoardList() {
        List<GroupBuyBoardListViewEntity> boardListViewEntities = new ArrayList<>();

        try {
            Date beforeWeek = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sevenDaysAgo = simpleDateFormat.format(beforeWeek);
            boardListViewEntities = groupBuyBoardListViewRepository.getTop3BoardList(sevenDaysAgo);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }
        return GetTop3GroupBuyBoardListResponseDto.success(boardListViewEntities);
    }

    @Override
    public ResponseEntity<? super GetSearchGroupBuyBoardListResponseDto> getSearchBoardList(String searchWord, String preSearchWord) {

        List<GroupBuyBoardListViewEntity> boardListViewEntities = new ArrayList<>();

        try {
            boardListViewEntities = groupBuyBoardListViewRepository.getSearchBoardList(searchWord, searchWord);
            SearchLogEntity searchLogEntity = new SearchLogEntity(searchWord, preSearchWord, false);
            searchLogRepository.save(searchLogEntity);

            boolean relation = preSearchWord != null;
            if (relation) {
                searchLogEntity = new SearchLogEntity(preSearchWord, searchWord, relation);
                searchLogRepository.save(searchLogEntity);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetSearchGroupBuyBoardListResponseDto.success(boardListViewEntities);
    }

    @Override
    public ResponseEntity<? super GetUserGroupBuyBoardListResponseDto> getUserBoardList(String email) {
        List<GroupBuyBoardListViewEntity> boardListViewEntities = new ArrayList<>();

        try {
            boolean existedEmail = userRepository.existsByEmail(email);
            if (!existedEmail) return GetUserGroupBuyBoardListResponseDto.noExistUser();

            boardListViewEntities = groupBuyBoardListViewRepository.findByWriterEmailOrderByWriteDatetimeDesc(email);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetUserGroupBuyBoardListResponseDto.success(boardListViewEntities);
    }
    @Override
    public ResponseEntity<? super PatchGroupBuyCommentResponseDto> patchComment(Integer boardNumber, Integer commentNumber ,String email, PatchGroupBuyCommentRequestDto dto) {
        try{
            boolean existedEmail = userRepository.existsByEmail(email);
            if(!existedEmail) return PatchGroupBuyCommentResponseDto.noExistUser();

            GroupBuyBoardEntity boardEntity = groupBuyBoardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PatchGroupBuyCommentResponseDto.noExistBoard();

            GroupBuyCommentEntity commentEntity = groupBuyCommentRepository.findByCommentNumber(commentNumber);
            if(commentEntity == null) return PatchGroupBuyCommentResponseDto.noExistBoard();

            String commentWriterEmail = commentEntity.getUserEmail();
            boolean isCommentWriter = commentWriterEmail.equals(email);

            if(!isCommentWriter) return PatchGroupBuyCommentResponseDto.noPermission();

            commentEntity.patchComment(dto);
            groupBuyCommentRepository.save(commentEntity);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchGroupBuyCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteGroupBuyCommentResponseDto> deleteComment(Integer boardNumber, Integer commentNumber, String email) {
        try {
            GroupBuyBoardEntity boardEntity = groupBuyBoardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return DeleteGroupBuyCommentResponseDto.noExistBoard();

            boolean existedEmail = userRepository.existsByEmail(email);
            if (!existedEmail) return DeleteGroupBuyCommentResponseDto.noExistUser();

            GroupBuyCommentEntity commentEntity = groupBuyCommentRepository.findByCommentNumber(commentNumber);
            if (commentEntity == null) return DeleteGroupBuyCommentResponseDto.noExistBoard();

            String writerEmail = boardEntity.getWriterEmail();
            String commentWriterEmail = commentEntity.getUserEmail();
            boolean isWriter = writerEmail.equals(email);
            boolean isCommentWriter = commentWriterEmail.equals(email);

            if (!isWriter && !isCommentWriter) return DeleteGroupBuyCommentResponseDto.noPermission();


            groupBuyCommentRepository.delete(commentEntity);
            boardEntity.decreaseCommentCount();
            groupBuyBoardRepository.save(boardEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteGroupBuyCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PutGroupBuyFavoriteResponseDto> putFavorite(String email, Integer boardNumber) {
        try {
            boolean existedEmail = userRepository.existsByEmail(email);
            if (!existedEmail) return PutGroupBuyFavoriteResponseDto.noExistUser();

            GroupBuyBoardEntity boardEntity = groupBuyBoardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PutGroupBuyFavoriteResponseDto.noExistBoard();

            GroupBuyFavoriteEntity favoriteEntity = groupBuyFavoriteRepository.findByBoardNumberAndUserEmail(boardNumber, email);
            if (favoriteEntity == null) {
                favoriteEntity = new GroupBuyFavoriteEntity(email, boardNumber);
                groupBuyFavoriteRepository.save(favoriteEntity);
                boardEntity.increaseFavoriteCount();
            } else {
                groupBuyFavoriteRepository.delete(favoriteEntity);
                boardEntity.decreaseFavoriteCount();
            }
            groupBuyBoardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PutGroupBuyFavoriteResponseDto.success();
    }
}

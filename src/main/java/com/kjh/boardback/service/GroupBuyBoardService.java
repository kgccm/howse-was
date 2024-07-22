package com.kjh.boardback.service;


import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyBoardRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyCommentRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyBoardRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyCommentRequestDto;
import com.kjh.boardback.dto.response.groupBuy_board.*;
import org.springframework.http.ResponseEntity;

public interface GroupBuyBoardService {

    ResponseEntity<? super GetGroupBuyBoardResponseDto> getBoard(Integer boardNumber);

    ResponseEntity<? super PostGroupBuyBoardResponseDto> postBoard(PostGroupBuyBoardRequestDto requestDto, String email);

    ResponseEntity<? super PatchGroupBuyBoardResponseDto> patchBoard(PatchGroupBuyBoardRequestDto requestDto, String email, Integer boardNumber);

    ResponseEntity<? super DeleteGroupBuyBoardResponseDto> deleteBoard(String email, Integer boardNumber);

    ResponseEntity<? super GetLatestGroupBuyBoardListResponseDto> getLatestBoardList();

    ResponseEntity<? super PostGroupBuyCommentResponseDto> postComment(Integer boardNumber, String email, PostGroupBuyCommentRequestDto dto);

    ResponseEntity<? super PutGroupBuyFavoriteResponseDto> putFavorite(String email, Integer boardNumber);

    ResponseEntity<? super GetGroupBuyFavoriteListResponseDto> getFavoriteList(Integer boardNumber);

    ResponseEntity<? super PatchGroupBuyCommentResponseDto> patchComment(Integer boardNumber, Integer commentNumber, String email, PatchGroupBuyCommentRequestDto dto);

    ResponseEntity<? super GetGroupBuyCommentListResponseDto> getCommentList(Integer boardNumber);

    ResponseEntity<? super IncreaseGroupBuyViewCountResponseDto> increaseViewCount(Integer boardNumber);

    ResponseEntity<? super DeleteGroupBuyCommentResponseDto> deleteComment(Integer boardNumber, Integer commentNumber, String email);

    ResponseEntity<? super GetTop3GroupBuyBoardListResponseDto> getTop3BoardList();

    ResponseEntity<? super GetSearchGroupBuyBoardListResponseDto> getSearchBoardList(String searchWord, String preSearchWord);

    ResponseEntity<? super GetUserGroupBuyBoardListResponseDto> getUserBoardList(String email);
}

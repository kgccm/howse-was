package com.kjh.boardback.service;

import com.kjh.boardback.dto.request.board.PatchBoardRequestDto;
import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.board.PostBoardRequestDto;
import com.kjh.boardback.dto.request.board.PostCommentRequestDto;
import com.kjh.boardback.dto.response.board.*;
import com.kjh.boardback.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto,String email);
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(String email,Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super PostCommentResponseDto> postComment(Integer boardNumber, String email, PostCommentRequestDto dto);

    ResponseEntity<? super PatchCommentResponseDto> patchComment(Integer boardNumber,Integer commentNumber ,String email, PatchCommentRequestDto dto);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);

    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);

    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber,String email);

    ResponseEntity<? super DeleteCommentResponseDto> deleteComment(Integer boardNumber,String email,Integer commentNumber);

    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();
    ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList();

    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord,String preSearchWord);

    ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email);
}

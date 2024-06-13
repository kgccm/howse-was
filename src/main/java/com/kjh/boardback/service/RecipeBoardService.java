package com.kjh.boardback.service;

import com.kjh.boardback.dto.request.board.PatchBoardRequestDto;
import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.board.PostBoardRequestDto;
import com.kjh.boardback.dto.request.board.PostCommentRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PatchRecipeBoardRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PostRecipeBoardRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PostRecipeCommentRequestDto;
import com.kjh.boardback.dto.response.board.*;
import com.kjh.boardback.dto.response.recipe_board.*;
import org.springframework.http.ResponseEntity;

public interface RecipeBoardService {

    ResponseEntity<? super GetRecipeBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostRecipeBoardResponseDto> postBoard(PostRecipeBoardRequestDto dto, String email);
    ResponseEntity<? super PutRecipeFavoriteResponseDto> putFavorite(String email, Integer boardNumber);
    ResponseEntity<? super GetRecipeFavoriteListResponseDto> getFavoriteList(Integer boardNumber);

    ResponseEntity<? super PostRecipeCommentResponseDto> postComment(Integer boardNumber, String email, PostRecipeCommentRequestDto dto);

    ResponseEntity<? super PatchRecipeCommentResponseDto> patchComment(Integer boardNumber, Integer commentNumber ,String email, PatchCommentRequestDto dto);

    ResponseEntity<? super GetRecipeCommentListResponseDto> getCommentList(Integer boardNumber);

    ResponseEntity<? super IncreaseRecipeViewCountResponseDto> increaseViewCount(Integer boardNumber);

    ResponseEntity<? super DeleteRecipeBoardResponseDto> deleteBoard(Integer boardNumber,String email);

    ResponseEntity<? super DeleteRecipeCommentResponseDto> deleteComment(Integer boardNumber, Integer commentNumber ,String email);

    ResponseEntity<? super PatchRecipeBoardResponseDto> patchBoard(PatchRecipeBoardRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super GetLatestRecipeBoardListResponseDto> getLatestBoardList();
    ResponseEntity<? super GetTop3RecipeBoardListResponseDto> getTop3BoardList();

    ResponseEntity<? super GetSearchRecipeBoardListResponseDto> getSearchBoardList(String searchWord,String preSearchWord);

    ResponseEntity<? super GetUserRecipeBoardListResponseDto> getUserBoardList(String email);
}

package com.kjh.boardback.service;

import com.kjh.boardback.dto.request.trade_board.PatchTradeBoardRequestDto;
import com.kjh.boardback.dto.request.trade_board.PatchTradeCommentRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeBoardRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeCommentRequestDto;
import com.kjh.boardback.dto.response.trade_board.*;
import org.springframework.http.ResponseEntity;

public interface TradeBoardService {

    ResponseEntity<? super GetTradeBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostTradeBoardResponseDto> postBoard(PostTradeBoardRequestDto requestDto, String email);
    ResponseEntity<? super PatchTradeBoardResponseDto> patchBoard(PatchTradeBoardRequestDto requestDto, String email, Integer boardNumber);
    ResponseEntity<? super DeleteTradeBoardResponseDto> deleteBoard(String email, Integer boardNumber);
    ResponseEntity<? super GetLatestTradeBoardListResponseDto> getLatestBoardList();
    ResponseEntity<? super PostTradeCommentResponseDto> postComment(Integer boardNumber, String email, PostTradeCommentRequestDto dto);

    ResponseEntity<? super PutTradeFavoriteResponseDto> putFavorite(String email, Integer boardNumber);
    ResponseEntity<? super GetTradeFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super PatchTradeCommentResponseDto> patchComment(Integer boardNumber, Integer commentNumber , String email, PatchTradeCommentRequestDto dto);

    ResponseEntity<? super GetTradeCommentListResponseDto> getCommentList(Integer boardNumber);

    ResponseEntity<? super IncreaseTradeViewCountResponseDto> increaseViewCount(Integer boardNumber);
    ResponseEntity<? super DeleteTradeCommentResponseDto> deleteComment(Integer boardNumber, Integer commentNumber ,String email);
    ResponseEntity<? super GetTop3TradeBoardListResponseDto> getTop3BoardList();

    ResponseEntity<? super GetSearchTradeBoardListResponseDto> getSearchBoardList(String searchWord,String preSearchWord);

    ResponseEntity<? super GetUserTradeBoardListResponseDto> getUserBoardList(String email);
}

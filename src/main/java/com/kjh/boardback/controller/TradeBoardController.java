package com.kjh.boardback.controller;

import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.trade_board.PatchTradeBoardRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeBoardRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeCommentRequestDto;
import com.kjh.boardback.dto.response.trade_board.*;
import com.kjh.boardback.service.TradeBoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/trade-board")
public class TradeBoardController {

    private final TradeBoardService boardService;

    @GetMapping("/latest-list")
    public ResponseEntity<? super GetLatestTradeBoardListResponseDto> getLatestBoardList(){
        ResponseEntity<? super GetLatestTradeBoardListResponseDto> response = boardService.getLatestBoardList();
        return response;
    }

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetTradeBoardResponseDto> getBoard(
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetTradeBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostTradeBoardResponseDto> postBoard(
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PostTradeBoardRequestDto requestDto
            ){
        ResponseEntity<? super PostTradeBoardResponseDto> response = boardService.postBoard(requestDto, email);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchTradeBoardResponseDto> patchBoard(
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PatchTradeBoardRequestDto requestDto,
            @PathVariable("boardNumber") Integer boardNumber
            ){
        ResponseEntity<? super PatchTradeBoardResponseDto> response = boardService.patchBoard(requestDto, email, boardNumber);
        return response;
    }

    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteTradeBoardResponseDto> deleteBoard(
            @AuthenticationPrincipal String email,
            @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super DeleteTradeBoardResponseDto> response = boardService.deleteBoard(email, boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetTradeFavoriteListResponseDto> getFavoriteList(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetTradeFavoriteListResponseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }


    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetTradeCommentListResponseDto> getCommentList(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetTradeCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseTradeViewCountResponseDto> increaseViewCount(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super IncreaseTradeViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }
    @GetMapping("/top-3")
    public ResponseEntity<? super GetTop3TradeBoardListResponseDto> getTop3BoardList(){
        ResponseEntity<? super GetTop3TradeBoardListResponseDto> response = boardService.getTop3BoardList();
        return response;
    }

    @GetMapping(value = {"/search-list/{searchWord}","/search-list/{searchWord}/{preSearchWord}"})
    public ResponseEntity<? super GetSearchTradeBoardListResponseDto> getSearchBoardList(
            @PathVariable("searchWord") String searchWord,
            @PathVariable(value = "preSearchWord",required = false) String PreSearchWord
    ){
        ResponseEntity<? super GetSearchTradeBoardListResponseDto> response = boardService.getSearchBoardList(searchWord, PreSearchWord);
        return response;
    }

    @GetMapping("/user-board-list/{email}")
    public ResponseEntity<? super GetUserTradeBoardListResponseDto> getUserBoardList(
            @PathVariable("email") String email
    ){
        ResponseEntity<? super GetUserTradeBoardListResponseDto> response = boardService.getUserBoardList(email);
        return response;
    }
    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostTradeCommentResponseDto> postComment(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PostTradeCommentRequestDto dto
    ) {
        ResponseEntity<? super PostTradeCommentResponseDto> response = boardService.postComment(boardNumber, email, dto);
        return response;
    }


    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutTradeFavoriteResponseDto> putFavorite(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PutTradeFavoriteResponseDto> response = boardService.putFavorite(email, boardNumber);
        return response;
    }

    @PatchMapping("/{boardNumber}/{commentNumber}")
    public ResponseEntity<? super PatchTradeCommentResponseDto> patchComment(
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PatchCommentRequestDto dto,
            @PathVariable Integer boardNumber,
            @PathVariable Integer commentNumber
    ){
        ResponseEntity<? super PatchTradeCommentResponseDto> response = boardService.patchComment(boardNumber, commentNumber, email, dto);
        return response;
    }
    @DeleteMapping("/{boardNumber}/{commentNumber}")
    public ResponseEntity<? super DeleteTradeCommentResponseDto> deleteComment(
            @AuthenticationPrincipal String email,
            @PathVariable("boardNumber") Integer boardNumber,
            @PathVariable("commentNumber") Integer commentNumber
    ){
        ResponseEntity<? super DeleteTradeCommentResponseDto> response = boardService.deleteComment(boardNumber, commentNumber, email);
        return response;
    }

}

package com.kjh.boardback.controller;

import com.kjh.boardback.dto.request.board.PatchBoardRequestDto;
import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.board.PostBoardRequestDto;
import com.kjh.boardback.dto.request.board.PostCommentRequestDto;
import com.kjh.boardback.dto.response.board.*;
import com.kjh.boardback.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetFavoriteListResponseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }


    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super IncreaseViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }

    @GetMapping("/latest-list")
    public ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList(){
        ResponseEntity<? super GetLatestBoardListResponseDto> response = boardService.getLatestBoardList();
        return response;
    }

    @GetMapping("/top-3")
    public ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList(){
        ResponseEntity<? super GetTop3BoardListResponseDto> response = boardService.getTop3BoardList();
        return response;
    }

    @GetMapping(value = {"/search-list/{searchWord}","/search-list/{searchWord}/{preSearchWord}"})
    public ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(
            @PathVariable("searchWord") String searchWord,
            @PathVariable(value = "preSearchWord",required = false) String PreSearchWord
    ){
        ResponseEntity<? super GetSearchBoardListResponseDto> response = boardService.getSearchBoardList(searchWord, PreSearchWord);
        return response;
    }

    @GetMapping("/user-board-list/{email}")
    public ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(
            @PathVariable("email") String email
    ){
        ResponseEntity<? super GetUserBoardListResponseDto> response = boardService.getUserBoardList(email);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
            @RequestBody @Valid PostBoardRequestDto requestBody,
            @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }

    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PostCommentRequestDto dto
    ) {
        ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(boardNumber, email, dto);
        return response;
    }


    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PutFavoriteResponseDto> response = boardService.putFavorite(email, boardNumber);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PatchBoardRequestDto requestBody
            ){
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBody, boardNumber, email);
        return response;
    }

    @PatchMapping("{boardNumber}/{commentNumber}")
    public ResponseEntity<? super PatchCommentResponseDto> patchComment(
            @AuthenticationPrincipal String email,
            @PathVariable("boardNumber") Integer boardNumber,
            @PathVariable("commentNumber") Integer commentNumber,
            @RequestBody @Valid PatchCommentRequestDto dto
            ){
        ResponseEntity<? super PatchCommentResponseDto> response = boardService.patchComment(boardNumber, commentNumber,email, dto);
        return response;
    }

    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber, email);
        return response;
    }

    @DeleteMapping("/{boardNumber}/{commentNumber}")
    public ResponseEntity<? super DeleteCommentResponseDto> deleteComment(
        @AuthenticationPrincipal String email,
        @PathVariable("boardNumber") Integer boardNumber,
        @PathVariable("commentNumber") Integer commentNumber
    ){
        ResponseEntity<? super DeleteCommentResponseDto> response = boardService.deleteComment(boardNumber,email,commentNumber);
        return response;
    }
}

package com.kjh.boardback.controller;

import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyBoardRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PatchGroupBuyCommentRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyBoardRequestDto;
import com.kjh.boardback.dto.request.groupBuy_board.PostGroupBuyCommentRequestDto;
import com.kjh.boardback.dto.response.groupBuy_board.*;
import com.kjh.boardback.service.GroupBuyBoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groupBuy/groupBuy-board")
public class GroupBuyBoardController {

    private final GroupBuyBoardService boardService;

    @GetMapping("/latest-list")
    public ResponseEntity<? super GetLatestGroupBuyBoardListResponseDto> getLatestBoardList(){
        ResponseEntity<? super GetLatestGroupBuyBoardListResponseDto> response = boardService.getLatestBoardList();
        return response;
    }

    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetGroupBuyBoardResponseDto> getBoard(
        @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetGroupBuyBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostGroupBuyBoardResponseDto> postBoard(
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PostGroupBuyBoardRequestDto requestDto
            ){
        ResponseEntity<? super PostGroupBuyBoardResponseDto> response = boardService.postBoard(requestDto, email);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchGroupBuyBoardResponseDto> patchBoard(
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PatchGroupBuyBoardRequestDto requestDto,
            @PathVariable("boardNumber") Integer boardNumber
            ){
        ResponseEntity<? super PatchGroupBuyBoardResponseDto> response = boardService.patchBoard(requestDto, email, boardNumber);
        return response;
    }

    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteGroupBuyBoardResponseDto> deleteBoard(
            @AuthenticationPrincipal String email,
            @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super DeleteGroupBuyBoardResponseDto> response = boardService.deleteBoard(email, boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetGroupBuyFavoriteListResponseDto> getFavoriteList(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetGroupBuyFavoriteListResponseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }


    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetGroupBuyCommentListResponseDto> getCommentList(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetGroupBuyCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }

    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseGroupBuyViewCountResponseDto> increaseViewCount(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super IncreaseGroupBuyViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }
    @GetMapping("/top-3")
    public ResponseEntity<? super GetTop3GroupBuyBoardListResponseDto> getTop3BoardList(){
        ResponseEntity<? super GetTop3GroupBuyBoardListResponseDto> response = boardService.getTop3BoardList();
        return response;
    }

    @GetMapping(value = {"/search-list/{searchWord}","/search-list/{searchWord}/{preSearchWord}"})
    public ResponseEntity<? super GetSearchGroupBuyBoardListResponseDto> getSearchBoardList(
            @PathVariable("searchWord") String searchWord,
            @PathVariable(value = "preSearchWord",required = false) String PreSearchWord
    ){
        ResponseEntity<? super GetSearchGroupBuyBoardListResponseDto> response = boardService.getSearchBoardList(searchWord, PreSearchWord);
        return response;
    }

    @GetMapping("/user-board-list/{email}")
    public ResponseEntity<? super GetUserGroupBuyBoardListResponseDto> getUserBoardList(
            @PathVariable("email") String email
    ){
        ResponseEntity<? super GetUserGroupBuyBoardListResponseDto> response = boardService.getUserBoardList(email);
        return response;
    }
    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostGroupBuyCommentResponseDto> postComment(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PostGroupBuyCommentRequestDto dto
    ) {
        ResponseEntity<? super PostGroupBuyCommentResponseDto> response = boardService.postComment(boardNumber, email, dto);
        return response;
    }


    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutGroupBuyFavoriteResponseDto> putFavorite(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PutGroupBuyFavoriteResponseDto> response = boardService.putFavorite(email, boardNumber);
        return response;
    }

    @PatchMapping("/{boardNumber}/{commentNumber}")
    public ResponseEntity<? super PatchGroupBuyCommentResponseDto> patchComment(
            @AuthenticationPrincipal String email,
            @RequestBody @Valid PatchGroupBuyCommentRequestDto dto,
            @PathVariable Integer boardNumber,
            @PathVariable Integer commentNumber
    ){
        ResponseEntity<? super PatchGroupBuyCommentResponseDto> response = boardService.patchComment(boardNumber, commentNumber, email, dto);
        return response;
    }
    @DeleteMapping("/{boardNumber}/{commentNumber}")
    public ResponseEntity<? super DeleteGroupBuyCommentResponseDto> deleteComment(
            @AuthenticationPrincipal String email,
            @PathVariable("boardNumber") Integer boardNumber,
            @PathVariable("commentNumber") Integer commentNumber
    ){
        ResponseEntity<? super DeleteGroupBuyCommentResponseDto> response = boardService.deleteComment(boardNumber, commentNumber, email);
        return response;
    }

}

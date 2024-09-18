package com.kjh.boardback.entity.trade_board;

import com.kjh.boardback.dto.request.trade_board.PatchTradeBoardRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.ZoneId;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trade_board")
@Table(name = "trade_board")
public class TradeBoardEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;

    private String title;

    private String content;

    private ZonedDateTime writeDatetime;  // ZonedDateTime으로 변경

    private int favoriteCount;

    private int commentCount;

    private int viewCount;

    private String writerEmail;

    private String tradeLocation;

    private String price;

    public void increaseViewCount() {
        this.viewCount++;
    }

    public void increaseCommentCount() {
        this.commentCount++;
    }

    public void decreaseCommentCount() {
        this.commentCount--;
    }

    public void increaseFavoriteCount() {
        this.favoriteCount++;
    }

    public void decreaseFavoriteCount() {
        this.favoriteCount--;
    }

    public TradeBoardEntity(PostTradeBoardRequestDto requestDto, String email) {
        // ZonedDateTime.now()를 사용하여 현재 시간 기록 (Asia/Seoul)
        this.writeDatetime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.favoriteCount = 0;
        this.commentCount = 0;
        this.viewCount = 0;
        this.writerEmail = email;
        this.tradeLocation = requestDto.getTradeLocation();
        this.price = requestDto.getPrice();
    }

    public void patchBoard(PatchTradeBoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.tradeLocation = requestDto.getTradeLocation();
        this.price = requestDto.getPrice();
    }
}

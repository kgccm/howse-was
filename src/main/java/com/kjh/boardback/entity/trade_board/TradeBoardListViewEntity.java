package com.kjh.boardback.entity.trade_board;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trade_board_list_view")
@Table(name = "trade_board_list_view")
public class TradeBoardListViewEntity {

    @Id
    private int boardNumber;

    private String title;
    private String content;
    private String titleImage;
    private int viewCount;
    private int favoriteCount;
    private int commentCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    private ZonedDateTime writeDatetime;
    private String writerEmail;
    private String tradeLocation;
    private String price;
    private String writerNickname;
    private String writerProfileImage;

}

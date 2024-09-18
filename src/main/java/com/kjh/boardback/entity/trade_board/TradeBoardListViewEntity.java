package com.kjh.boardback.entity.trade_board;

import java.time.LocalDateTime;

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
    private LocalDateTime writeDatetime;
    private String writerEmail;
    private String tradeLocation;
    private String price;
    private String writerNickname;
    private String writerProfileImage;

}

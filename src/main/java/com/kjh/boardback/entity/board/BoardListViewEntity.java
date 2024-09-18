package com.kjh.boardback.entity.board;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZoneId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board_list_view")
@Table(name = "board_list_view")
public class BoardListViewEntity {

    @Id
    private int boardNumber;

    private String title;
    private String content;
    private String titleImage;
    private int viewCount;
    private int favoriteCount;
    private int commentCount;
    // writeDatetime을 KST로 직렬화하기 위해 @JsonFormat 어노테이션 사용
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    private ZonedDateTime writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

}

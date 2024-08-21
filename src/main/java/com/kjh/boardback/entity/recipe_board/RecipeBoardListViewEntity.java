package com.kjh.boardback.entity.recipe_board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe_board_list_view")
@Table(name = "recipe_board_list_view")
public class RecipeBoardListViewEntity {
    
    @Id
    private int boardNumber;
    
    private String title;
    private String content;
    private String titleImage;
    private int viewCount;
    private int favoriteCount;
    private int commentCount;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;
    private int type;
    private int cookingTime;
    private String step_1;
    private String step_2;
    private String step_3;
    private String step_4;
    private String step_5;
    private String step_6;
    private String step_7;
    private String step_8;



}

package com.kjh.boardback.entity.recipe_board;

import com.kjh.boardback.dto.request.recipe_board.PatchRecipeBoardRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PostRecipeBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.ZoneId;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe_board")
@Table(name = "recipe_board")
public class RecipeBoardEntity {

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

    public RecipeBoardEntity(PostRecipeBoardRequestDto requestDto, String email) {
        // ZonedDateTime.now()를 사용하여 KST 시간 기록
        this.writeDatetime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.favoriteCount = 0;
        this.commentCount = 0;
        this.viewCount = 0;
        this.writerEmail = email;
        this.type = requestDto.getType();
        this.cookingTime = requestDto.getCookingTime();
        this.step_1 = requestDto.getStep1_content();
        this.step_2 = requestDto.getStep2_content();
        this.step_3 = requestDto.getStep3_content();
        this.step_4 = requestDto.getStep4_content();
        this.step_5 = requestDto.getStep5_content();
        this.step_6 = requestDto.getStep6_content();
        this.step_7 = requestDto.getStep7_content();
        this.step_8 = requestDto.getStep8_content();
    }

    public void patchBoard(PatchRecipeBoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.cookingTime = requestDto.getCookingTime();
        this.step_1 = requestDto.getStep1_content();
        this.step_2 = requestDto.getStep2_content();
        this.step_3 = requestDto.getStep3_content();
        this.step_4 = requestDto.getStep4_content();
        this.step_5 = requestDto.getStep5_content();
        this.step_6 = requestDto.getStep6_content();
        this.step_7 = requestDto.getStep7_content();
        this.step_8 = requestDto.getStep8_content();
    }
}

package com.kjh.boardback.entity.recipe_board;

import com.kjh.boardback.dto.request.recipe_board.PatchRecipeBoardRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PostRecipeBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe_board")
@Table(name = "recipe_board")
public class RecipeBoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;

    private String title;

    private String content;

    private String writeDatetime;

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


    public void increaseViewCount(){
        this.viewCount++;
    }

    public void increaseCommentCount(){
        this.commentCount++;
    }
    public void decreaseCommentCount(){
        this.commentCount--;
    }

    public void increaseFavoriteCount(){this.favoriteCount++;}
    public void decreaseFavoriteCount(){this.favoriteCount--;}

    public RecipeBoardEntity(PostRecipeBoardRequestDto requestDto, String email){

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDateTime = simpleDateFormat.format(now);

        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writeDatetime = writeDateTime;
        this.favoriteCount = 0;
        this.commentCount = 0;
        this.viewCount = 0;
        this.writerEmail = email;
        this.type = requestDto.getType();
        this.cookingTime = requestDto.getCookingTime();
        this.step_1 = requestDto.getStep_1();
        this.step_2 = requestDto.getStep_2();
        this.step_3 = requestDto.getStep_3();
        this.step_4 = requestDto.getStep_4();
        this.step_5 = requestDto.getStep_5();
        this.step_6 = requestDto.getStep_6();
        this.step_7 = requestDto.getStep_7();
        this.step_8 = requestDto.getStep_8();
    }

    public void patchBoard(PatchRecipeBoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.cookingTime = requestDto.getCookingTime();
        this.step_1 = requestDto.getStep_1();
        this.step_2 = requestDto.getStep_2();
        this.step_3 = requestDto.getStep_3();
        this.step_4 = requestDto.getStep_4();
        this.step_5 = requestDto.getStep_5();
        this.step_6 = requestDto.getStep_6();
        this.step_7 = requestDto.getStep_7();
        this.step_8 = requestDto.getStep_8();

    }

}

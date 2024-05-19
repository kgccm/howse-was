package com.kjh.boardback.entity.recipe_board;

import com.kjh.boardback.dto.request.recipe_board.PatchRecipeBoardRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PostRecipeBoardRequestDto;
import com.kjh.boardback.dto.request.trade_board.PatchTradeBoardRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeBoardRequestDto;
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


    public void increaseViewCount(){
        this.viewCount++;
    }

    public void increaseCommentCount(){
        this.commentCount++;
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

    }

    public void patchBoard(PatchRecipeBoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();

    }

}

package com.kjh.boardback.entity.recipe_board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PostRecipeCommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.ZoneId;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe_comment")
@Table(name = "recipe_comment")
public class RecipeCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;

    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    private ZonedDateTime writeDatetime;
    private String userEmail;
    private int boardNumber;

    public RecipeCommentEntity(Integer boardNumber, String email, PostRecipeCommentRequestDto dto) {
        // ZonedDateTime.now()로 현재 시간 저장 (Asia/Seoul)
        this.writeDatetime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
    }

    public void patchComment(PatchCommentRequestDto dto) {
        this.content = dto.getContent();
    }
}

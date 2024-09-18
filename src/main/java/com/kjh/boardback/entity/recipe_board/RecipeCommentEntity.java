package com.kjh.boardback.entity.recipe_board;

import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.recipe_board.PostRecipeCommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime writeDatetime; // LocalDateTime으로 변경
    private String userEmail;
    private int boardNumber;

    public RecipeCommentEntity(Integer boardNumber, String email, PostRecipeCommentRequestDto dto) {
        // LocalDateTime.now()로 현재 시간 저장
        this.writeDatetime = LocalDateTime.now();
        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
    }

    public void patchComment(PatchCommentRequestDto dto){
        this.content = dto.getContent();
    }
}

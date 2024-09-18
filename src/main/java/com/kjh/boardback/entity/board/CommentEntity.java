package com.kjh.boardback.entity.board;

import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.board.PostCommentRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comment")
@Table(name = "comment")
public class CommentEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;

    private String content;
    private LocalDateTime writeDatetime; // LocalDateTime으로 변경
    private String userEmail;
    private int boardNumber;

    public CommentEntity(Integer boardNumber, String email, PostCommentRequestDto dto) {
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

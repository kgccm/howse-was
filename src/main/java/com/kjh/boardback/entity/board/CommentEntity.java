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

import java.time.ZonedDateTime;
import java.time.ZoneId;
import com.fasterxml.jackson.annotation.JsonFormat;

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

    // ZonedDateTime으로 변경하고, 직렬화 시 KST로 처리
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    private ZonedDateTime writeDatetime;

    private String userEmail;
    private int boardNumber;

    public CommentEntity(Integer boardNumber, String email, PostCommentRequestDto dto) {
        // 현재 시간을 KST 기준으로 저장
        this.writeDatetime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
    }

    public void patchComment(PatchCommentRequestDto dto){
        this.content = dto.getContent();
    }
}

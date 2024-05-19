package com.kjh.boardback.entity.board;

import com.kjh.boardback.dto.request.board.PostCommentRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comment")
@Table(name = "comment")
public class CommentEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;

    private String content;
    private String writeDatetime;
    private String userEmail;
    private int boardNumber;

    public CommentEntity(Integer boardNumber, String email, PostCommentRequestDto dto) {
        Date date = Date.from(Instant.now());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = dateFormat.format(date);

        this.boardNumber =boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
        this.writeDatetime =writeDatetime;
    }
}

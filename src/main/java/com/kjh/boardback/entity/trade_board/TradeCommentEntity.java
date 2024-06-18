package com.kjh.boardback.entity.trade_board;

import com.kjh.boardback.dto.request.board.PatchCommentRequestDto;
import com.kjh.boardback.dto.request.board.PostCommentRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeCommentRequestDto;
import jakarta.persistence.*;
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
@Entity(name = "trade_comment")
@Table(name = "trade_comment")
public class TradeCommentEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;

    private String content;
    private String writeDatetime;
    private String userEmail;
    private int boardNumber;

    public TradeCommentEntity(Integer boardNumber, String email, PostTradeCommentRequestDto dto) {
        Date date = Date.from(Instant.now());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = dateFormat.format(date);

        this.boardNumber =boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
        this.writeDatetime =writeDatetime;
    }

    public void patchComment(PatchCommentRequestDto dto){
        this.content = dto.getContent();
    }

}

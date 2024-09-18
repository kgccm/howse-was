package com.kjh.boardback.entity.trade_board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kjh.boardback.dto.request.trade_board.PatchTradeCommentRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeCommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.ZoneId;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trade_comment")
@Table(name = "trade_comment")
public class TradeCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    private ZonedDateTime writeDatetime;

    private String userEmail;

    private int boardNumber;

    public TradeCommentEntity(Integer boardNumber, String email, PostTradeCommentRequestDto dto) {
        // ZonedDateTime.now()를 사용하여 현재 시간 기록 (한국 시간대로 설정)
        this.writeDatetime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
    }

    public void patchComment(PatchTradeCommentRequestDto dto) {
        this.content = dto.getContent();
    }
}

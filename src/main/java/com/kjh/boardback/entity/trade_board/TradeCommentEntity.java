package com.kjh.boardback.entity.trade_board;

import com.kjh.boardback.dto.request.trade_board.PatchTradeCommentRequestDto;
import com.kjh.boardback.dto.request.trade_board.PostTradeCommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    private LocalDateTime writeDatetime;  // LocalDateTime으로 변경

    private String userEmail;

    private int boardNumber;

    public TradeCommentEntity(Integer boardNumber, String email, PostTradeCommentRequestDto dto) {
        // LocalDateTime.now()를 사용하여 현재 시간 기록
        this.writeDatetime = LocalDateTime.now();

        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.content = dto.getContent();
    }

    public void patchComment(PatchTradeCommentRequestDto dto) {
        this.content = dto.getContent();
    }
}

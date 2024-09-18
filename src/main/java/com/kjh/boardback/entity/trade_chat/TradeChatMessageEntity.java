package com.kjh.boardback.entity.trade_chat;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trade_chat_message")
@Table(name = "trade_chat_message")
public class TradeChatMessageEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageNumber;

    private int chatRoomNumber;

    private String senderEmail;

    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    private ZonedDateTime writeDatetime;
}

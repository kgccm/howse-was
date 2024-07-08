package com.kjh.boardback.entity.trade_chat;

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

    private String writeDatetime;
}

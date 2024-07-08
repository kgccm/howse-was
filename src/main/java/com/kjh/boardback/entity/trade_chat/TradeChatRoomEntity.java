package com.kjh.boardback.entity.trade_chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trade_chat_room")
@Table(name = "trade_chat_room")
public class TradeChatRoomEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatRoomNumber;

    private int boardNumber;

    private String buyerEmail;

    private String sellerEmail;

    private String recentMessage;

}

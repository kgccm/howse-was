package com.kjh.boardback.repository.trade_chat;


import com.kjh.boardback.entity.trade_chat.TradeChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeChatRoomRepository extends JpaRepository<TradeChatRoomEntity,Integer> {
}

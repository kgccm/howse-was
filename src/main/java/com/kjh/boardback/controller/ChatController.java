package com.kjh.boardback.controller;

import com.kjh.boardback.dto.object.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/chatRoom") //발행 uri
    public void sendMessage(ChatMessage message)
    {
        if (message.getType().equals(ChatMessage.MessageType.ENTER)) {
            String newMessage = message.getSender()+" 님이 입장했습니다.";
            ChatMessage chatMessage = new ChatMessage(message, newMessage);
            template.convertAndSend("/app/"+message.getRoomId(),chatMessage);
        }
        template.convertAndSend("/app/"+message.getRoomId(),message);  // 구독 uri
    }

}

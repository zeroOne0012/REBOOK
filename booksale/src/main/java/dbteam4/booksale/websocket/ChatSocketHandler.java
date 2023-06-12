package dbteam4.booksale.websocket;


import dbteam4.booksale.dto.MessageDTO;
import dbteam4.booksale.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatSocketHandler extends TextWebSocketHandler {

    private final MessageService messageService;
    private final Map<Long, WebSocketSession> userIdSessionMap =  new ConcurrentHashMap<>();


    // 생성자 오버로딩 - messageService를 인자로 받음
    public ChatSocketHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        if (payload.isEmpty()) return;

        Long senderId = (Long) session.getAttributes().get("userId");
        Long receiverId = (Long) session.getAttributes().get("receiverId");
        WebSocketSession receiverSession = userIdSessionMap.get(receiverId);

        if ( receiverSession != null) {
            receiverSession.sendMessage(new TextMessage(payload));
        }

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setMessageContent(payload);
        messageDTO.setSenderId(senderId);
        messageDTO.setReceiverId(receiverId);
        messageDTO.setSendTime(LocalDateTime.now());

        String fair = senderId < receiverId ? String.valueOf(senderId) + ":" + String.valueOf(receiverId)
                                            : String.valueOf(receiverId) + ":" + String.valueOf(senderId);

        System.out.println("fair = " + fair);
        messageDTO.setUserFair(fair);


        messageService.save(messageDTO);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        URI uri = session.getUri();
        String query = uri.getQuery();
        System.out.println("query = " + query);

        Long userId = Long.parseLong(extractParamValue(query, "userId"));
        Long otherUserId = Long.parseLong(extractParamValue(query, "otherUserId"));


        session.getAttributes().put("userId", userId);
        session.getAttributes().put("receiverId", otherUserId);

        userIdSessionMap.put(userId, session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Long userId = (Long) session.getAttributes().get("userId");
        userIdSessionMap.remove(userId);
    }

    private String extractParamValue(String query, String parameter) {
        String value ="";
        int valueIdx = query.indexOf(parameter) + parameter.length() + 1 ; // =때문에 1 추가.

        while(true) {
            if(valueIdx == query.length()) {break;}

            char c = query.charAt(valueIdx);
            if (c != '&') {
                value += String.valueOf(c);
            } else {
                break;
            }
            valueIdx++;
        }
        return value;
    }
}

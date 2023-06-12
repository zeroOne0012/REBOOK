package dbteam4.booksale.config;

import dbteam4.booksale.service.MessageService;
import dbteam4.booksale.websocket.ChatSocketHandler;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final MessageService messageService;

    public WebSocketConfig(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatSocketHandler(), "/chatting").setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler chatSocketHandler() {
        return new ChatSocketHandler(messageService);
    }
}

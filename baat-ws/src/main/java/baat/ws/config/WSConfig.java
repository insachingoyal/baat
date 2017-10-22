package baat.ws.config;

import baat.ws.handler.UserSessionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WSConfig implements WebSocketConfigurer {

	@Bean
	public UserSessionHandler userSessionHandler() {
		return new UserSessionHandler();
	}

	@Override
	public void registerWebSocketHandlers(final WebSocketHandlerRegistry registry) {
		registry.addHandler(userSessionHandler(), "/baat-ws").setAllowedOrigins("*");
	}

}
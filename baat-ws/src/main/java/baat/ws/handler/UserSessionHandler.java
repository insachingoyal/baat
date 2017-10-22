package baat.ws.handler;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserSessionHandler extends AbstractWebSocketHandler {

	private final static Map<String, Set<WebSocketSession>> SESSIONS_BY_USER_TOKENS = new ConcurrentHashMap<>();

	protected void handleTextMessage(final WebSocketSession session, final TextMessage message) throws Exception {
		final String userToken = message.getPayload();

		if (!validUserToken(userToken)) {
			session.close(CloseStatus.NOT_ACCEPTABLE.withReason("A valid user token must be passed"));
			return;
		}

		addSession(userToken, session);
	}

	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		session.close(CloseStatus.NOT_ACCEPTABLE.withReason("Message sending through WS not allowed"));
	}

	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
		// do nothing
	}

	@Override
	public void handleTransportError(final WebSocketSession session, final Throwable exception) throws Exception {
		removeSession(session);
	}

	@Override
	public void afterConnectionClosed(final WebSocketSession session, final CloseStatus status) throws Exception {
		removeSession(session);
	}

	private boolean validUserToken(final String userToken) {
		// TODO validate user token from user service

		return (userToken != null && !userToken.isEmpty());
	}

	private void addSession(final String userToken, final WebSocketSession session) {
		SESSIONS_BY_USER_TOKENS.computeIfAbsent(userToken, k -> new HashSet<>()).add(session);
	}

	private void removeSession(final WebSocketSession session) {
		for (final Map.Entry<String, Set<WebSocketSession>> sessionByUserToken : SESSIONS_BY_USER_TOKENS.entrySet()) {
			final String userToken = sessionByUserToken.getKey();
			final Set<WebSocketSession> sessions = sessionByUserToken.getValue();

			sessions.remove(session);

			if (sessions.isEmpty()) {
				SESSIONS_BY_USER_TOKENS.remove(userToken);
			}
		}
	}
}
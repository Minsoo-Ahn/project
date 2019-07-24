package project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;



public class WebsocketHandler extends TextWebSocketHandler{
	private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		System.out.println("session : "+session.getId());
		System.out.println("하나의 클라이언트 연결 됨");
	}
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> map = session.getAttributes();
		System.out.println(map.get("myId").toString());
		String msg = message.getPayload();
		System.out.println(list);
		for(WebSocketSession s : list) {
			s.sendMessage(new TextMessage(msg));
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("해제 됨");
		list.remove(session);
	}
}

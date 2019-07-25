package project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import project.service.FriendService;
import project.service.FriendServiceMine;



public class WebsocketHandler extends TextWebSocketHandler{
	FriendServiceMine friendService;
	public WebsocketHandler(FriendServiceMine friendService) {
		this.friendService = friendService;
		// TODO Auto-generated constructor stub
	}
	private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	Map<String, String> sessionList = new HashMap<String, String>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Map<String, Object> map = session.getAttributes();
		
		
		boolean check = true;
		if(sessionList.containsKey(map.get("myId").toString())) {
			check = false;
		}
		
		if(check) {
			System.out.println("하나의 클라이언트 연결 됨");
			sessionList.put(map.get("myId").toString(), session.getId());
			list.add(session);
		}
		Set<String> set = sessionList.keySet();
		for(String s : set) {
			System.out.println("session list key : "+s);
			System.out.println("session list value : "+sessionList.get(s));
		}
	}
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String msg = message.getPayload();
		System.out.println("onList"+list);
		boolean friend = sessionList.containsKey(map.get("friendId").toString());
		System.out.println(friend);
		for(WebSocketSession s : list) {
			if(s.getId().toString().equals(sessionList.get(map.get("friendId").toString()))) {
				s.sendMessage(new TextMessage(msg));
			}else if (s.getId().toString().equals(sessionList.get(map.get("myId").toString()))){
				s.sendMessage(new TextMessage(msg));
			}
			
		}
	}
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Map<String, Object> map = session.getAttributes();
		System.out.println("해제 됨");
		sessionList.remove(map.get("myId").toString());
		list.remove(session);
	}
}

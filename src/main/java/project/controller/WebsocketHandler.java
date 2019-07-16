package project.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import project.dao.FriendDao;


public class WebsocketHandler extends TextWebSocketHandler{
	@Autowired
	SqlSession sqlSession;
	
	private final Logger logger = LogManager.getLogger(getClass());

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
	}
	
	@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			// TODO Auto-generated method stub
			super.afterConnectionClosed(session, status);
		}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		FriendDao dao = sqlSession.getMapper(FriendDao.class);
		this.logger.info(message.getPayload());
		//session.sendMessage();
		super.handleTextMessage(session, message);
	}

}

package project.service;

import project.dao.ReplyDao;
import project.vo.ReplyVO;

public class ReplyServiceMine implements ReplyService{
	ReplyDao replyDao;
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public void addReply(ReplyVO replyVO) {
		replyDao.addReply(replyVO);
		
	}

	@Override
	public void deleteReply(int replySeq) {
		replyDao.deleteReply(replySeq);
		
	}
	
}

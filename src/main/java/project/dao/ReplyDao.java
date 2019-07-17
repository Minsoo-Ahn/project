package project.dao;

import project.vo.ReplyVO;

public interface ReplyDao {
	public abstract void addReply(ReplyVO replyVO);
	public abstract void deleteReply(int replySeq);
}

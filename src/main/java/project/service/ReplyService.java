package project.service;

import project.vo.ReplyVO;

public interface ReplyService {
	public abstract void addReply(ReplyVO replyVO);
	public abstract void deleteReply(int replySeq);
}

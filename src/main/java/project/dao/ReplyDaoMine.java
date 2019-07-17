package project.dao;

import org.mybatis.spring.SqlSessionTemplate;

import project.vo.ReplyVO;

public class ReplyDaoMine implements ReplyDao{
	SqlSessionTemplate sqlSessionTemplate;
	
	public ReplyDaoMine(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void addReply(ReplyVO replyVO) {
		sqlSessionTemplate.insert("addReply", replyVO);
	}

	@Override
	public void deleteReply(int replySeq) {
		
		sqlSessionTemplate.delete("deleteReply", replySeq);
	}
	
}

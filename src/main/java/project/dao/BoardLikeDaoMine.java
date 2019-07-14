package project.dao;

import org.mybatis.spring.SqlSessionTemplate;

import project.vo.BoardLikeVO;

public class BoardLikeDaoMine implements BoardLikeDao{
	SqlSessionTemplate sqlSessionTemplate;
	
	BoardLikeDaoMine(SqlSessionTemplate sqlSessionTemplate){
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void addLike(BoardLikeVO boardLikeVO) {
		sqlSessionTemplate.insert("addLike", boardLikeVO);
		
	}

	@Override
	public void deleteLike(BoardLikeVO boardLikeVO) {
		sqlSessionTemplate.delete("deleteLike",boardLikeVO);
		
	}

	@Override
	public int countLike(int seq) {
		int count = sqlSessionTemplate.selectOne("countLike",seq);
		return count;
	}

	@Override
	public int searchId(BoardLikeVO boardLikeVO) {
		int count = sqlSessionTemplate.selectOne("searchId", boardLikeVO);
		return count;
	}

	@Override
	public void updateCount(int seq) {
		sqlSessionTemplate.update("updateCount",seq);
		
	}

}

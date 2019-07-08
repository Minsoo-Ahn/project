package project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import project.vo.BoardVO;



@Repository
public class BoardDaoMine implements BoardDao{
	private SqlSessionTemplate sqlSessionTemplate;
	public BoardDaoMine(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlMapping(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	@Override
	public List<BoardVO> list() {
		return this.sqlSessionTemplate.selectList("list");
	}

	@Override
	public void insert(BoardVO booksVO) {
		sqlSessionTemplate.insert("insert",booksVO);
		
	}

	@Override
	public BoardVO select(int seq) {
		BoardVO vo= (BoardVO) sqlSessionTemplate.selectOne("select",seq);
		return vo;
	}
	@Override
	public List<BoardVO> search(String search) {
		return sqlSessionTemplate.selectList("search",search); 
	}


	
}

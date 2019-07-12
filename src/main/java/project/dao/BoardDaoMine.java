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
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("insert",boardVO);
		
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
	@Override
	public void delete(int seq) {
		sqlSessionTemplate.delete("delete",seq);
		
	}
	@Override
	public BoardVO searchBoard(int seq) {
		BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("searchBoard", seq);
		return vo;
	}


	
}

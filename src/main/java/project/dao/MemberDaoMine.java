package project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import project.vo.MemberVO;

public class MemberDaoMine implements MemberDao{
	private SqlSessionTemplate sqlSessionTemplate;
	public MemberDaoMine(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlMapping(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public void add(MemberVO memberVO) {
		sqlSessionTemplate.insert("add",memberVO);
		
	}
	@Override
	public MemberVO selectId(String id) {
		
		return sqlSessionTemplate.selectOne("selectById", id);
	}
	@Override
	public void accontSetting(MemberVO memberVO) {
		sqlSessionTemplate.update("accountSetting", memberVO);
		
	}
	@Override
	public List<String> friendId(String id) {
		return sqlSessionTemplate.selectList("friendId",id);
	}
	
	@Override
	public int countPending(String id) {
		return sqlSessionTemplate.selectOne("countPending", id);
		
	}
	@Override
	public void uploadImage(MemberVO memberVO) {
		sqlSessionTemplate.update("uploadImage", memberVO);
		
	}

}

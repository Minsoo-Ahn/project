package project.dao;

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

}

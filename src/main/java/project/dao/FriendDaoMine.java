package project.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import project.vo.FriendVO;

public class FriendDaoMine implements FriendDao{
	SqlSessionTemplate sqlSessionTemplate;
	
	FriendDaoMine(SqlSessionTemplate sqlSessionTemplate){
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public void add(FriendVO friendVO) {
		sqlSessionTemplate.insert("addFriend", friendVO);
		
	}

	@Override
	public void delete(FriendVO friendVO) {
		sqlSessionTemplate.delete("deleteFriend", friendVO);
		
	}

}

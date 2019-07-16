package project.dao;

import java.util.List;
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

	@Override
	public List<String> pendingList(String id) {
		return sqlSessionTemplate.selectList("pendingList", id);
	}
	@Override
	public void update(FriendVO friendVO) {
		sqlSessionTemplate.update("updateFriend", friendVO);
		
	}
	@Override
	public int checkFriend(FriendVO friendVO) {
		return sqlSessionTemplate.selectOne("checkFriend", friendVO);
	}
	
}

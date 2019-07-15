package project.service;

import project.dao.FriendDao;
import project.vo.FriendVO;

public class FriendServiceMine implements FriendService{

	FriendDao friendDao;
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@Override
	public void add(FriendVO friendVO) {
		friendDao.add(friendVO);
		
	}

	@Override
	public void delete(FriendVO friendVO) {
		friendDao.delete(friendVO);
		
	}

}

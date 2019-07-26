package project.service;

import java.util.List;

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


	@Override
	public List<String> pendingList(String id) {

		return friendDao.pendingList(id);
	}

	@Override
	public void update(FriendVO friendVO) {
		friendDao.update(friendVO);
		
	}

	@Override
	public int checkFriend(FriendVO friendVO) {
		return friendDao.checkFriend(friendVO);
	}

	@Override
	public void updateChat(FriendVO friendVO) {
		friendDao.updateChat(friendVO);
		
	}

	@Override
	public String checkChat(FriendVO friendVO) {
		return friendDao.checkChat(friendVO);
	}



}

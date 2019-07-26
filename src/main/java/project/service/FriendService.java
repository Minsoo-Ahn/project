package project.service;

import java.util.List;

import project.vo.FriendVO;

public interface FriendService {
	abstract void add(FriendVO friendVO);
	abstract void delete(FriendVO friendVO);
	abstract List<String> pendingList(String id);
	abstract void update(FriendVO friendVO);
	abstract int checkFriend(FriendVO friendVO);
	abstract void updateChat(FriendVO friendVO);
	abstract String checkChat(FriendVO friendVO);
}

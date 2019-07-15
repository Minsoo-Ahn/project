package project.service;

import project.vo.FriendVO;

public interface FriendService {
	abstract void add(FriendVO friendVO);
	abstract void delete(FriendVO friendVO);
}

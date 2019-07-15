package project.dao;

import java.util.Map;

import project.vo.FriendVO;

public interface FriendDao {
	abstract void add(FriendVO friendVO);
	abstract void delete(FriendVO friendVO);
}

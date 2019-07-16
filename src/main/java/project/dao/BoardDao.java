package project.dao;

import java.util.List;

import project.vo.BoardVO;
import project.vo.MemberVO;

public interface BoardDao {
	public abstract List<BoardVO> list();
	public abstract void insert(BoardVO boardVO);
	public abstract BoardVO select(int seq);
	public abstract List<BoardVO> search(String search);
	public abstract void delete(int seq);
	public abstract BoardVO searchBoard(int seq);
	public abstract List<String> idList(String search);
	public abstract MemberVO searchMember(String id);
	
}

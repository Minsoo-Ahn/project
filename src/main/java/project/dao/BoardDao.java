package project.dao;

import java.util.List;

import project.vo.BoardVO;

public interface BoardDao {
	public abstract List<BoardVO> list();
	public abstract void insert(BoardVO boardVO);
	public abstract BoardVO select(int seq);
	public abstract List<BoardVO> search(String search);
}

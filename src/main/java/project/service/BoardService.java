package project.service;

import java.util.List;

import project.vo.BoardVO;



public interface BoardService {
	public abstract List<BoardVO> list();
	public abstract void write(BoardVO booksVO);
	public abstract BoardVO read(int seq);
	public abstract List<BoardVO> search(String search);
	public abstract void delete(int seq);
	public abstract BoardVO searchBoard(int seq);
}

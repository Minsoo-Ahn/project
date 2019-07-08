package project.service;

import java.util.List;

import org.springframework.stereotype.Service;


import project.dao.BoardDao;
import project.vo.BoardVO;

@Service
public class BoardServiceMine implements BoardService{
	private BoardDao boardDao;
	

	

	@Override
	public List<BoardVO> list() {
		return boardDao.list();
	}

	@Override
	public void write(BoardVO booksVO) {
		boardDao.insert(booksVO);
		
	}

	@Override
	public BoardVO read(int seq) {
		return boardDao.select(seq);
	}

	@Override
	public List<BoardVO> search(String search) {
		return boardDao.search(search);
	}

	public BoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
}

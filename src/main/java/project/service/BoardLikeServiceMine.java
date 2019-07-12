package project.service;

import project.dao.BoardLikeDao;
import project.vo.BoardLikeVO;

public class BoardLikeServiceMine implements BoardLikeService{
	BoardLikeDao boardLikeDao;
	

	public void setBoardLikeDao(BoardLikeDao boardLikeDao) {
		this.boardLikeDao = boardLikeDao;
	}

	@Override
	public void addLike(BoardLikeVO boardLikeVO) {
		boardLikeDao.addLike(boardLikeVO);
		
	}

	@Override
	public void deleteLike(BoardLikeVO boardLikeVO) {
		boardLikeDao.deleteLike(boardLikeVO);
		
	}

	@Override
	public int countLike(int seq) {
		int count = boardLikeDao.countLike(seq);
		return count;
	}

	@Override
	public int searchId(BoardLikeVO boardLikeVO) {
		int count = boardLikeDao.searchId(boardLikeVO);
		return count;
	}

}

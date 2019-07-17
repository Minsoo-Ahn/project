package project.service;

import java.util.List;

import project.vo.BoardVO;
import project.vo.MemberVO;
import project.vo.ReplyVO;



public interface BoardService {
	public abstract List<BoardVO> list();
	public abstract List<ReplyVO> listComment();
	public abstract void write(BoardVO booksVO);
	public abstract BoardVO read(int seq);
	public abstract List<BoardVO> search(String search);
	public abstract void delete(int seq);
	public abstract BoardVO searchBoard(int seq);
	public abstract List<String> idList(String search);
	public abstract MemberVO searchMember(String id);

}

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
	public abstract List<MemberVO> idList(String search);
	public abstract MemberVO searchMember(String id);
	public abstract List<String> friendId(String id);
	public abstract int countPending(String id);
}

package project.service;

import java.util.List;

import project.vo.BoardVO;
import project.vo.MemberVO;



public interface MemberService {
	public abstract void signUp(MemberVO memberVO);
	public abstract MemberVO selectId(String id);
	public abstract void memberEdit(MemberVO memberVO);
	//	public abstract List<BoardVO> list();
//	public abstract List<BoardVO> search(String search);
}

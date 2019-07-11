package project.dao;

import java.util.List;

import project.vo.MemberVO;

public interface MemberDao {
	public abstract void add(MemberVO memberVO);
	public abstract MemberVO selectId(String id);
	public abstract void accontSetting(MemberVO memberVO);
//	public abstract List<BoardVO> list();
//	public abstract List<BoardVO> search(String search);
}

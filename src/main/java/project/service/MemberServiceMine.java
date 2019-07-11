package project.service;

import project.dao.MemberDao;
import project.vo.MemberVO;

public class MemberServiceMine implements MemberService{
	MemberDao memberDao;
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	@Override
	public void signUp(MemberVO memberVO) {
		memberDao.add(memberVO);
		
	}
	@Override
	public MemberVO selectId(String id) {
		
		return memberDao.selectId(id);
	}
	@Override
	public void memberEdit(MemberVO memberVO) {
		memberDao.accontSetting(memberVO);
		
	}
	
}

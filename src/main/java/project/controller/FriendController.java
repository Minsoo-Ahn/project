package project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.service.FriendService;
import project.vo.FriendVO;
import project.vo.MemberVO;


@Controller
public class FriendController {
	FriendService friendService;

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	
	@RequestMapping(value="/friendRequest/{id}", method=RequestMethod.GET)
	public String list(FriendVO friendVO,@PathVariable String id,Model model,HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		if(memberVO ==null) {
			return "redirect:/login";
		}
		friendVO.setId1(memberVO.getId());
		friendVO.setId2(id);
		friendVO.setRelationship("friend");
		friendService.add(friendVO);
		return "redirect:/main";
	}
}

package project.controller;

import java.util.HashMap;
import java.util.Map;

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
		friendVO.setRelationship("pending");
		if(friendService.checkFriend(friendVO) != 0) {
			return "redirect:/main";
		}
		friendService.add(friendVO);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/requestList", method=RequestMethod.GET)
	public String requestList(HttpSession session, Model model) {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(memberVO ==null) {
			return "redirect:/login";
		}
		model.addAttribute("pendingList",friendService.pendingList(memberVO.getId()));
		return "/requestList";
	}
	
	@RequestMapping(value="/pendingAccept/{id}", method=RequestMethod.GET)
	public String pendingAccept(FriendVO friendVO, HttpSession session, Model model, @PathVariable String id) {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(memberVO ==null) {
			return "redirect:/login";
		}
		friendVO.setId1(memberVO.getId());
		friendVO.setId2(id);
		friendVO.setRelationship("friend");
		friendService.add(friendVO);
		friendVO.setId1(id);
		friendVO.setId2(memberVO.getId());
		friendService.update(friendVO);
		session.setAttribute("pending", (int)session.getAttribute("pending")-1);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/pendingReject/{id}", method=RequestMethod.GET)
	public String pendingReject(FriendVO friendVO, HttpSession session, Model model, @PathVariable String id) {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(memberVO ==null) {
			return "redirect:/login";
		}
		friendVO.setId1(memberVO.getId());
		friendVO.setId2(id);
		friendVO.setRelationship("rejected");
		friendService.add(friendVO);
		friendVO.setId1(id);
		friendVO.setId2(memberVO.getId());
		friendService.update(friendVO);
		session.setAttribute("pending", (int)session.getAttribute("pending")-1);
		return "redirect:/main";
	}

	@RequestMapping(value="/chatRequest/{id}")
	public String chat(HttpSession session, @PathVariable String id, Model model) {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		String id1 = memberVO.getId();
		session.setAttribute("myId", id1);
		session.setAttribute("friendId", id);
		return "/chat";
	}
}

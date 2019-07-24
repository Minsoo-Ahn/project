package project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.service.ReplyService;
import project.vo.MemberVO;
import project.vo.ReplyVO;

@Controller
public class ReplyController {
	ReplyService replyService;

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/reply", method=RequestMethod.POST, produces = "application/json")
	public String add(ReplyVO replyVO , @RequestParam("seq") int seq, @RequestParam("comments") String comments, HttpServletRequest request, HttpSession session) {
		JSONObject obj = new JSONObject();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(memberVO ==null) {
			obj.put("msg", "Login please!");
			return obj.toJSONString();
		}
		if(comments == null | comments.equals("")) {
			obj.put("msg", "Need something comments :)");
			return obj.toJSONString();
		}
		replyVO.setSeq(seq);
		replyVO.setId(memberVO.getId());
		replyVO.setComments(comments);
		replyService.addReply(replyVO);
		obj.put("success", "Successfully commented!");
		return obj.toJSONString();
	}
	
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/replyDelete", method=RequestMethod.POST, produces = "application/json")
	public String delete(ReplyVO replyVO , @RequestParam("replySeq") int replySeq, HttpServletRequest request, HttpSession session) {
		JSONObject obj = new JSONObject();

		replyService.deleteReply(replySeq);
		obj.put("success", "Successfully deleted!");
		return obj.toJSONString();
	}
}

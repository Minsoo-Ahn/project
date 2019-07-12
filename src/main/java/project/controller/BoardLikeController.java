package project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.controller.SearchCommand;
import project.dao.BoardLikeDao;
import project.service.BoardLikeService;
import project.service.BoardService;
import project.vo.BoardLikeVO;
import project.vo.BoardVO;
import project.vo.MemberVO;

@Controller
public class BoardLikeController {
	BoardLikeService boardLikeService;
	
	public void setBoardLikeService(BoardLikeService boardLikeService) {
		this.boardLikeService = boardLikeService;
	}

	@RequestMapping(value="/boardLike/{seq}", method=RequestMethod.GET)
	public String boardLike(BoardLikeVO like,Model model, @PathVariable int seq, HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");

		if(memberVO ==null) {
			model.addAttribute("msg", "Please Login for this option");
			return "redirect:/main";
		}
		like.setId(memberVO.getId());
		like.setSeq(seq);
		if(boardLikeService.searchId(like) == 0) {
			boardLikeService.addLike(like);
		}else {
			boardLikeService.deleteLike(like);
		}
		boardLikeService.countLike(seq);
			return "/checkPassword";
	}
}

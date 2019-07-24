package project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import project.controller.SearchCommand;
import project.dao.BoardLikeDao;
import project.service.BoardService;
import project.vo.BoardLikeVO;
import project.vo.BoardVO;
import project.vo.MemberVO;

@Controller
public class BoardController {
	BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String list(BoardVO boardVO,Model model, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		model.addAttribute("boardList", boardService.list());
		model.addAttribute("commentList", boardService.listComment());
		if(memberVO != null) {
		List<String> list = new ArrayList<String>();
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		list = boardService.friendId(memberVO.getId());
		for(int i=0; i< list.size(); i++) {
			memberList.add(i, boardService.searchMember(list.get(i)));
		}
		session.setAttribute("friendList", memberList);
		
		int pendingNum = boardService.countPending(memberVO.getId());
		session.setAttribute("pending", pendingNum);
		}
		return "/main";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String list(BoardVO boardVO, MemberVO memberVO,SearchCommand searchCommand,Model model) {
		if( !searchCommand.getSearch().equals("")) {
			model.addAttribute("boardList",boardService.search(searchCommand.getSearch()) );
			
			List<MemberVO> memberList = boardService.idList(searchCommand.getSearch());
			model.addAttribute("memberList",memberList);
			return "/main";
		}
		return "redirect:/main";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {

		return "/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpServletRequest rq, BoardVO boardVO, @RequestParam("fileName")MultipartFile mf,HttpSession session, Model model) throws IllegalStateException, IOException {
		if(!mf.getOriginalFilename().equals("")) {
		String path = rq.getSession().getServletContext().getRealPath("uploads");
		String path2 = "D:\\반응형웹개발자\\Spring\\springwork\\project\\src\\main\\webapp\\uploads";
		boardVO.setImage(mf.getOriginalFilename());
		mf.transferTo(new File(path , mf.getOriginalFilename()));
		mf.transferTo(new File(path2 , mf.getOriginalFilename()));
		}
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		if(memberVO == null) {
			model.addAttribute("msg","Please Login for this option");
			return "redirect:/main";
		}
		boardVO.setId(memberVO.getId());
		boardService.write(boardVO);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/boardDelete/{seq}", method=RequestMethod.GET)
	public String boardDelete(Model model, @PathVariable int seq, HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		if(memberVO ==null) {
			model.addAttribute("msg", "Please Login for this option");
			return "redirect:/main";
		}
		model.addAttribute("seq",seq);
			return "/checkPassword";
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.POST)
	public String boardDelete(HttpSession session, @RequestParam("password")String password, @RequestParam("seq")int seq, Model model) {
		MemberVO memberVO =(MemberVO) session.getAttribute("member");
		if(memberVO.getPassword().equals(password)) {
			boardService.delete(seq);
			model.addAttribute("msg","Successfully deleted!");
		}else {
			model.addAttribute("msg", "Wrong password");
		}
			return "redirect:/main";
	}
	
}

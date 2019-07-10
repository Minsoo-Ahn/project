package project.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.controller.SearchCommand;
import project.service.BoardService;
import project.vo.BoardVO;
import project.vo.MemberVO;

@Controller
public class BoardController {
	BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("boardList", boardService.list());
		return "/main";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String list(SearchCommand searchCommand,Model model) {
		if( !searchCommand.getSearch().equals("")) {
			model.addAttribute("boardList",boardService.search(searchCommand.getSearch()) );
			return "/main";
		}
		model.addAttribute("boardList", boardService.list());
		return "/main";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpServletRequest rq, BoardVO boardVO, @RequestParam("fileName")MultipartFile mf) throws IllegalStateException, IOException {
		if(!mf.getOriginalFilename().equals("")) {
		String path = rq.getSession().getServletContext().getRealPath("/upload");
		boardVO.setImage(mf.getOriginalFilename());
		mf.transferTo(new File(path , mf.getOriginalFilename()));
		}
		
		boardVO.setId("id");
		boardService.write(boardVO);
		return "redirect:/main";
	}

}

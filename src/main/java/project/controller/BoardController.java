package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.controller.SearchCommand;
import project.service.BoardService;

@Controller
public class BoardController {
	BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("boardList", boardService.list());
		System.out.println(boardService.list().get(0).getId());
		return "/main";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String list(SearchCommand searchCommand,Model model) {
		System.out.println(searchCommand.getSearch());
		if( !searchCommand.getSearch().equals("")) {
			model.addAttribute("boardList",boardService.search(searchCommand.getSearch()) );
			return "/main";
		}
		model.addAttribute("boardList", boardService.list());
		System.out.println(boardService.list());
		return "/main";
	}
}

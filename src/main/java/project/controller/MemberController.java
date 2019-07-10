package project.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import project.service.MemberService;
import project.vo.MemberVO;

@SessionAttributes("memberVO")
@Controller
public class MemberController {
	MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String add( Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "/signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String add(@Valid MemberVO memberVO, BindingResult br) {
		if(br.hasErrors()) {
			return "/signup";
		}
		memberService.signUp(memberVO);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@CookieValue("cookie")Cookie cookie, Model model) {
		model.addAttribute("id", cookie.getValue());
		return "/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("checkbox")boolean check, @RequestParam("id") String id, @RequestParam("password")String password, Model model, HttpServletResponse response) {
		MemberVO memberVO = memberService.selectId(id);
		if(memberVO == null) {
			model.addAttribute("msg", "Invalid ID");
			return "/login";
		}
		if(!memberVO.getPassword().equals(password)) {
			model.addAttribute("msg", "Invalid Password");
			return "/login";
		}
		Cookie cookie = new Cookie("cookie", id);
		if(check) {
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*15);
		response.addCookie(cookie);
		} else {
		cookie.setMaxAge(0);
		}
		return "redirect:/main";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(SessionStatus session) {
		session.setComplete();
		System.out.println(session.isComplete());
		return "redirect:/main";
	}
}

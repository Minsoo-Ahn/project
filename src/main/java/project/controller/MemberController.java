package project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.multipart.MultipartFile;

import project.service.MemberService;
import project.vo.BoardVO;
import project.vo.MemberVO;

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
	public String login(HttpServletRequest request, Model model) {
		Cookie cookies[] = request.getCookies();
		if(cookies.length != 1) {
			for(int i=0; i<cookies.length; i++) {
					if(cookies[i].getName().equals("cookie")) {
						model.addAttribute("id",cookies[i].getValue());
					}
			}
		}
		return "/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("password")String password, HttpSession session, HttpServletResponse response) {
		List<String> list = new ArrayList<String>();
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberVO memberVO = memberService.selectId(id);
		if(memberVO == null) {
			return "/login";
		}
		if(!memberVO.getPassword().equals(password)) {
			return "/login";
		}
		Cookie cookie = new Cookie("cookie", id);
		cookie.setPath("/");
		if(request.getParameter("checkbox") != null) {
		cookie.setMaxAge(60*60*24*15);
		} else {
		cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		session.setAttribute("member", memberVO);
		//friend list add
		
		list = memberService.friendId(id);
		for(int i=0; i< list.size(); i++) {
			memberList.add(i, memberService.selectId(list.get(i)));
		}
		session.setAttribute("friendList", memberList);
		
		int pendingNum = memberService.countPending(id);
		session.setAttribute("pending", pendingNum);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	@RequestMapping(value="/accountSetting", method=RequestMethod.GET)
	public String accountSetting(HttpSession session) {
		if(session.getAttribute("member") != null) {
		return "/accountSetting";
		}
		else {
			return "/login";
		}
	}
	@RequestMapping(value="/accountSetting", method=RequestMethod.POST)
	public String accountSetting(@Valid MemberVO memberVO, BindingResult br) {
		if(br.hasErrors()) {
			return "/accountSetting";
		}
		memberService.memberEdit(memberVO);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/forgotPassword", method=RequestMethod.GET)
	public String forgetPassword() {
		
			return "/forgotPassword";
	}
	@RequestMapping(value="/forgotPassword", method=RequestMethod.POST)
	public String forgetPassword(MemberVO memberVO,Model model, HttpSession session) {
		MemberVO member = memberService.selectId(memberVO.getId());
		if(member ==null) {
			model.addAttribute("msg","ID does not exist");
		}
		if(member.getEmail().equals(memberVO.getEmail()) & member.getName().equals(memberVO.getName()) 
				& member.getPhone().equals(memberVO.getPhone())) {
			session.setAttribute("memberInfo", member);
			return "redirect:/resetPassword";
		}
		return "/forgotPassword";
	}
	@RequestMapping(value="/resetPassword", method=RequestMethod.GET)
	public String resetPassword() {
		System.out.println("success");
			return "/resetPassword";
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	public String resetPassword(@RequestParam("password")String password, HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
		memberVO.setPassword(password);
		memberService.memberEdit(memberVO);
		session.removeAttribute("member");
			return  "redirect:/main";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profile(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member ==null) {
			return "/login";
		}
			return "/profile";
	}
	
	
	@RequestMapping(value="/imageUpload", method=RequestMethod.POST)
	public String write(HttpServletRequest rq, BoardVO boardVO, @RequestParam("fileName")MultipartFile mf,HttpSession session) throws IllegalStateException, IOException {
		if(!mf.getOriginalFilename().equals("")) {
		String path = rq.getSession().getServletContext().getRealPath("uploads");
		String path2 = "D:\\반응형웹개발자\\Spring\\springwork\\project\\src\\main\\webapp\\uploads";
		mf.transferTo(new File(path , mf.getOriginalFilename()));
		mf.transferTo(new File(path2 , mf.getOriginalFilename()));
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO.setImage(mf.getOriginalFilename());
		System.out.println(memberVO.getImage());
		System.out.println(memberVO.getId());
		memberService.uploadImage(memberVO);
		}
		return "redirect:/profile";
	}
}

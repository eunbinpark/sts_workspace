package bitedu.bipa.tiles.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tiles.service.MemberService;
import bitedu.bipa.tiles.vo.User;


@Controller
@RequestMapping("/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView nlist() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("data","MemberList");
		mav.setViewName("/member/list");
		
		return mav;
	}
	
	@RequestMapping(value="/viewRegist.do", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = null;
		mav = new ModelAndView();
		mav.addObject("data","MemberList");
		mav.setViewName("/member/joinForm");
		return mav;
	}
	
	@RequestMapping(value="/viewLogin.do", method=RequestMethod.GET)
	public ModelAndView viewLogin() {
		ModelAndView mav = null;
		mav = new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = null;
		mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("/member/loginForm");
		return mav;
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pass") String pass, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		boolean result;
		String url = "/member/loginForm";
		
		User user = new User(id, pass);
		result = memberService.login(user);
		
		if(result) {
			session.setAttribute("user", new User(id,pass));
			url = "main";
		} else {
			mav.addObject("data", "���̵� ��й�ȣ�� �ٽ� �Է����ּ���.");
			// 메인페이지입니다.
		}
		
		mav.setViewName(url);
		return mav;
	}
}

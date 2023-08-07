package bitedu.bipa.tilesPEB.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tilesPEB.service.MemberService;
import bitedu.bipa.tilesPEB.vo.MemberVO;

@Controller("memberController")
@RequestMapping("/member")
public class MemberController {

	@Autowired
	public MemberService memberService;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView memberList() {
		ModelAndView mav = null;
		mav = new ModelAndView();
		mav.addObject("data", "MemberList");
		mav.setViewName("/member/memberList");
		return mav;
	}

	@RequestMapping(value = "/viewRegist.do", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = null;
		mav = new ModelAndView();
		mav.addObject("data", "MemberList");
		mav.setViewName("/member/joinForm");
		return mav;
	}

	@RequestMapping(value = "/viewLogin.do", method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		ModelAndView mav = null;
		mav = new ModelAndView();
		mav.addObject("data", "LoginForm");
		mav.setViewName("/member/loginForm");
		return mav;
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = null;
		mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pass") String pass, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String url = "/member/loginForm";

		boolean result;
		result = memberService.login(id, pass);

		if (result) {
			session.setAttribute("id", id);
	        // �α��� ���� �� ���� �������� �����̷�Ʈ
			url = "main";
	        mav.addObject("message", "�α��ο� �����ϼ̽��ϴ�.");
	    } else {
	        // �α��� ���� �� �α��� �������� �����̷�Ʈ�ϸ� �޽��� ����
	        mav.addObject("message", "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.");
			mav.addObject("data", "���� �������Դϴ�!!");
			// �����������Դϴ�.
	    }
		
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	public @ResponseBody String idCheck(@RequestParam("id") String id) {
		boolean result;
		result = memberService.checkID(id);
		return String.valueOf(result);
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public @ResponseBody String join(@RequestParam("id") String id, @RequestParam("pass") String password,
			@RequestParam("phone") String phone) {
		boolean result;
		MemberVO member = new MemberVO(id, password, phone);
		result = memberService.regist(member);
		return String.valueOf(result);
	}
}

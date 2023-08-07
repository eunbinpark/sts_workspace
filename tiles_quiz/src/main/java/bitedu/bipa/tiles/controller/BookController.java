package bitedu.bipa.tiles.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tiles.vo.User;

@Controller("bookController")
@RequestMapping("/book")
public class BookController {

	@RequestMapping("/list.do")
	public ModelAndView list(HttpSession session) {
		ModelAndView mav = null;
		mav = new ModelAndView();
		String url = "/book/list";
		User user = (User)session.getAttribute("user");
		if(user==null) {
			url = "/member/loginForm";
			mav.addObject("data","관리자가 아닙니다.");
		}	
		mav.setViewName(url);

		return mav;
	}
}

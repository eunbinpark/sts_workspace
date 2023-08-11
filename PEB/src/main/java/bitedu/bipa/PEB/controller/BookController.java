package bitedu.bipa.PEB.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.PEB.service.BookService;
import bitedu.bipa.PEB.vo.BookVO;
import bitedu.bipa.PEB.vo.MemberVO;

@Controller("bookController")
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/list.do")
	public ModelAndView list(HttpSession session) {
		ModelAndView mav = null;
		mav = new ModelAndView();
		
		ArrayList<BookVO> bookLsit = bookService.findAllBook();
		
		String url = "/book/list";
		String member = (String) session.getAttribute("id");
		if(member==null) {
			url = "/member/loginForm";
			mav.addObject("data","관리자가 아닙니다.");
		}	
		mav.addObject("data", bookLsit);
		mav.setViewName(url);

		return mav;
	}
}

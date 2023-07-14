package bitedu.bipa.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.test.service.BookService;
import bitedu.bipa.test.vo.BookVo;

@Controller("BookController")
@RequestMapping("mybatisdb")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<BookVo> list = bookService.searchAllBook();
		mav.addObject("list", list);
		mav.setViewName("./manager/book_list");
		
		return mav;
	}

	@RequestMapping(value="/view_regist.do", method = RequestMethod.GET)
	public ModelAndView viewRegist() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("./manager/book_regist");
		
		return mav;
	}

	@RequestMapping(value="/regist.do", method = RequestMethod.GET)
	public ModelAndView regist(@ModelAttribute("book") BookVo book) {
		ModelAndView mav = new ModelAndView();
		
		bookService.registeBook(book);
		mav.setViewName("redirect:list.do");
		
		return mav;
	}

	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam("bookSeq") int bookSeq) {
		ModelAndView mav = new ModelAndView();
		
		BookVo book = bookService.findBook(bookSeq);
		mav.addObject("book", book);
		mav.setViewName("./manager/book_detail");
		
		return mav;
	}

	@RequestMapping(value="/remove.do", method = RequestMethod.GET)
	public ModelAndView remove(@RequestParam("bookSeq") int bookSeq) {
		ModelAndView mav = new ModelAndView();
		
		boolean flag = bookService.removeBook(bookSeq);
		mav.setViewName("redirect:list.do");
		
		return mav;
	}

	@RequestMapping(value="/view_update.do", method = RequestMethod.GET)
	public ModelAndView viewUpdate(@RequestParam("bookSeq") int bookSeq) {
		ModelAndView mav = new ModelAndView();
		
		BookVo book = bookService.findBook(bookSeq);
		mav.addObject("book", book);
		mav.setViewName("./manager/book_update");
		
		return mav;
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute("book") BookVo book) {
		ModelAndView mav = new ModelAndView();
		
		boolean flag = bookService.modifyBook(book);
		mav.setViewName("redirect:list.do");
		
		return mav;
	}
}

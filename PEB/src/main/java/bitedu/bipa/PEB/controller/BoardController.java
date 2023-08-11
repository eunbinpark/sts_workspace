package bitedu.bipa.PEB.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.PEB.service.BoardService;
import bitedu.bipa.PEB.vo.BoardVO;

@Controller("boardController")
@RequestMapping("/guestbook")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";
		mav.setViewName(url);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/checkID", method = RequestMethod.POST)
	public String ajaxCheckID(@RequestParam("id") String id) {
		String result = null;
		// DB처리 (Service-DAO-Table)
		System.out.println(id);
		result = "false";
		return result;
	}

	@RequestMapping(value = "/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		String url = "/board/list";
		ArrayList<BoardVO> list = (ArrayList) boardService.getBoardList();
		mav.addObject("list", list);
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/viewWriteForm.do", method = RequestMethod.GET)
	public ModelAndView viewWrite() {
		ModelAndView mav = new ModelAndView();
		String url = "/board/writeItem";

		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public ModelAndView write(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("writer") String writer, @RequestParam("createDate") String createDate, @RequestParam("pass") String password) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";
		BoardVO board = new BoardVO();
		
		System.out.println(title);
		
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setCreateDate(new Timestamp(System.currentTimeMillis()));
		board.setPassword(password);
		
		System.out.println(board);

		boolean flag = boardService.writeItem(board);

		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView remove(@RequestParam("seq") int seq) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";

		boolean flag = boardService.removeItem(seq);

		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam("seq") int seq) {
		ModelAndView mav = new ModelAndView();
		String url = "/board/detail";

		BoardVO board = boardService.findItem(seq);
		mav.addObject("board", board);
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value = "/searching.do", method = RequestMethod.GET)
	public ModelAndView searching(@RequestParam("search") String search) {
		ModelAndView mav = new ModelAndView();

		String url = "/board/list";

		ArrayList<BoardVO> list = (ArrayList) boardService.getBoardListSome(search);

		mav.addObject("list", list);
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/viewUpdateForm.do", method = RequestMethod.POST)
	public ModelAndView viewUpdate(@ModelAttribute("board") BoardVO board) {
		ModelAndView mav = new ModelAndView();
		String url = "/board/update";
		// System.out.print(board);
		mav.addObject("board", board);
		mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("board") BoardVO board) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";

		boolean flag = boardService.updateItem(board); // modify로 수정 나중에

		mav.setViewName(url);
		return mav;
	}
}

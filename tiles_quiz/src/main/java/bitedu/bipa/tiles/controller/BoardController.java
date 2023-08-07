package bitedu.bipa.tiles.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.tiles.service.BoardService;
import bitedu.bipa.tiles.vo.BookCopy;

@Controller("boardController")
@RequestMapping("/guestbook")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";
		mav.setViewName(url);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/checkID",method = RequestMethod.POST)
	public String ajaxCheckID(@RequestParam("id") String id) {
		String result = null;
		//DB처리 (Service-DAO-Table)
		System.out.println(id);
		result = "false";
		return result;
	}
	
	@RequestMapping(value="/list.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		String url = "/board/list";
		ArrayList<BookCopy> list = (ArrayList<BookCopy>)boardService.getBoardList();
		mav.addObject("list",list);
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/viewWriteForm.do",method=RequestMethod.GET)
	public ModelAndView viewWrite() {
		ModelAndView mav = new ModelAndView();
		String url = "/board/writeItem";
		
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/write.do",method=RequestMethod.POST)
	public ModelAndView write(@ModelAttribute("board") BookCopy board) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";
		//System.out.println(board);
		//boolean flag = boardService.saveItem(board);
		
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";
		//upload
		String path = "D:\\dev\\upload_files\\";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024*1024*10);
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookCopy board = null;
		try {
			board = boardService.upload(items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!board.getTitle().equals("")&&!board.getContent().equals("")&&!board.getWriter().equals("")) {
			boolean flag = boardService.saveItem(board);
		} else {
			upload = null;
			items = null;
		}
		
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/download.do",method = RequestMethod.GET)
	public void download(@RequestParam("fileName") String fileName,HttpServletResponse resp) {
		File downloadFile = new File("D:\\dev\\upload_files\\data\\"+fileName);
		
		try {
			fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html; charset=UTF-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-Disposition", "attatchment;filename="+fileName);
		
		try {
			FileInputStream fis = new FileInputStream(downloadFile);
			OutputStream os = resp.getOutputStream();
			byte[] buffer = new byte[256];
			int length = 0;
			while((length=fis.read(buffer))!=-1) {
				os.write(buffer, 0, length);
			}
			os.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("seq") int seq) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";

		boolean flag = boardService.removeItem(seq);
		
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/search.do",method=RequestMethod.GET)
	public ModelAndView search(@RequestParam("seq") int seq) {
		ModelAndView mav = new ModelAndView();
		String url = "./board/detail";

		BookCopy board = boardService.findItem(seq);
		mav.addObject("board",board);
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/viewUpdateForm.do",method=RequestMethod.POST)
	public ModelAndView viewUpdate(@ModelAttribute("board") BookCopy board) {
		ModelAndView mav = new ModelAndView();
		String url = "./board/update";
		//System.out.print(board);
		mav.addObject("board",board);
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("board") BookCopy board) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:./list.do";

		boolean flag = boardService.updateItem(board); // modify로 수정 나중에
		
		mav.setViewName(url);
		return mav;
	}
}

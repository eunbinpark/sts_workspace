package bitedu.bipa.PEB.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.PEB.dao.BookDAO;
import bitedu.bipa.PEB.vo.BookVO;

@Service("bookService")
public class BookService {

	@Autowired
	private BookDAO bookDAO;
	
	public ArrayList<BookVO> findAllBook() {
		ArrayList<BookVO> bookList = bookDAO.SelectAllBook();
		
		return bookList;
	}
}

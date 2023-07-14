package bitedu.bipa.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.test.dao.BookDao;
import bitedu.bipa.test.vo.BookVo;

@Service("BookService")
public class BookService {

	@Autowired
	private BookDao bookDao;

	//Create
	public boolean registeBook(BookVo book) {
		boolean flag = false;
		flag = bookDao.insertBook(book);
		
		return flag;
	}
	
	//ReadAll
	public ArrayList<BookVo> searchAllBook() {
		ArrayList<BookVo> list = null;
		list = bookDao.selectAllBook();
		
		return list;
	}

	//ReadOne
	public BookVo findBook(int bookSeq) {
		BookVo book = null;
		book = bookDao.selectBook(bookSeq);
		
		return book;
	}

	//Update
	public boolean modifyBook(BookVo book) {
		boolean flag = false;
		flag = bookDao.updateBook(book);
		
		return flag;
	}

	//Delete
	public boolean removeBook(int bookSeq) {
		boolean flag = false;
		flag = bookDao.deleteBook(bookSeq);
		
		return flag;
	}
}

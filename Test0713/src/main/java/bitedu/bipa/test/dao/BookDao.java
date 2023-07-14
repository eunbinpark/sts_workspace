package bitedu.bipa.test.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.test.vo.BookVo;

@Repository("BookDao")
public class BookDao {

//	@Autowired
//	private SqlSession sqlSession;
	
	//Create
	public boolean insertBook(BookVo book) {
		boolean flag = false;
		
		return flag;
	}
	
	//ReadAll
	public ArrayList<BookVo> selectAllBook() {
		ArrayList<BookVo> list = null;
		
		return list;
	}
	
	//ReadOne
	public BookVo selectBook(int bookSeq) {
		BookVo book = null;
		
		return book;
	}
	
	//Update
	public boolean updateBook(BookVo book) {
		boolean flag = false;
		
		return flag;
	}
	
	//Delete
	public boolean deleteBook(int bookSeq) {
		boolean flag = false;
		
		return flag;
	}
}

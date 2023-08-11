package bitedu.bipa.PEB.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.PEB.vo.BookVO;

@Repository("bookDAO")
public class BookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<BookVO> SelectAllBook() {
		ArrayList<BookVO> result;
		result = (ArrayList) sqlSession.selectList("mapper.book.selectAllBook");
		
		return result;
	}
}

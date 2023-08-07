package bitedu.bipa.tiles.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.tiles.vo.BookCopy;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BookCopy> findAll() throws SQLException{
		List<BookCopy> list = null;
		list = sqlSession.selectList("mapper.board.selectBoardList");
		//System.out.println(list.size());
		return list;
	}

	public boolean insertBoard(BookCopy board) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.board.insertBoard", board);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteItem(int seq) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.board.deleteBoard", seq);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
	
	public boolean updateCount(int seq) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.board.updateCounter", seq);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
	public BookCopy selectItem(int seq) throws SQLException {
		// TODO Auto-generated method stub
		BookCopy board = null;
		board = sqlSession.selectOne("mapper.board.findBoard", seq);
		return board;
	}

	public boolean updateItem(BookCopy board) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.board.updateBoard", board);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
}





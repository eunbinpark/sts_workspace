package bitedu.bipa.PEB.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.PEB.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<BoardVO> findAll() throws SQLException{
		ArrayList<BoardVO> boardList = null;
		boardList = (ArrayList)sqlSession.selectList("mapper.board.selectBoardList");
		//System.out.println(list.size());
		return boardList;
	}
	
	public ArrayList<BoardVO> findSome(String search) throws SQLException{
		ArrayList<BoardVO> boardList = null;
		boardList = (ArrayList)sqlSession.selectList("mapper.board.selectBoardListSome", search);
		//System.out.println(list.size());
		return boardList;
	}

	public boolean insertBoard(BoardVO board) throws SQLException {
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
	public BoardVO selectItem(int seq) throws SQLException {
		// TODO Auto-generated method stub
		BoardVO board = null;
		board = sqlSession.selectOne("mapper.board.findBoard", seq);
		return board;
	}

	public boolean updateItem(BoardVO board) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.board.updateBoard", board);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
}

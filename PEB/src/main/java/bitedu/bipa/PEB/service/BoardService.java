package bitedu.bipa.PEB.service;

import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.PEB.dao.BoardDAO;
import bitedu.bipa.PEB.vo.BoardVO;

@Service("boardService")
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public ArrayList<BoardVO> getBoardList(){
		ArrayList<BoardVO> list = null;
		try {
			list = boardDAO.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<BoardVO> getBoardListSome(String search){
		ArrayList<BoardVO> list = null;
		try {
			list = boardDAO.findSome(search);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean writeItem(BoardVO board) {
		boolean flag = false;
		
		try {
			//System.out.println("service "+board);
			flag = boardDAO.insertBoard(board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean removeItem(int seq) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = boardDAO.deleteItem(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	public BoardVO findItem(int seq) {
		// TODO Auto-generated method stub
		BoardVO board = null;
		try {
			//조회수 증가 수정
			boardDAO.updateCount(seq);
			board = boardDAO.selectItem(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return board;
	}

	public boolean updateItem(BoardVO board) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = boardDAO.updateItem(board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public BoardVO upload(List<FileItem> items) throws Exception {
		// TODO Auto-generated method stub
		BoardVO board = null;
		board = new BoardVO();
		for(FileItem item : items) {
			if(item!=null&item.isFormField()) {
				//일반적인 Form값 추출
				String fieldName = item.getFieldName();
				if(fieldName.equals("title")) {
					board.setTitle(item.getString("UTF-8"));
				} else if(fieldName.equals("content")) {
					board.setContent(item.getString("UTF-8"));
				} else if(fieldName.equals("writer")) {
					board.setWriter(item.getString("UTF-8"));
				} else if(fieldName.equals("createDate")) {
					board.setCreateDate(new Timestamp(System.currentTimeMillis()));
				}
			} else {
				// uplode할 데이터에 대한 정보 추출
				String fieldName = item.getFieldName();
				if(fieldName.equals("attacheImg")) {
					String temp = item.getName();
					//System.out.println(temp);
					int index = temp.lastIndexOf("\\");
					String fileName = temp.substring(index+1);
					//board.setAttatchImg(fileName);
					File uploadFile = new File("D:\\dev\\upload_files\\images\\"+fileName);
					item.write(uploadFile);
				} else if(fieldName.equals("attacheData")) {
					String temp = item.getName();
					//System.out.println(temp);
					int index = temp.lastIndexOf("\\");
					String fileName = temp.substring(index+1);
					//System.out.println("fileName "+fileName);
					if(fileName!=null&&!fileName.equals("")) {
						board.setAttatchData(fileName);
						File uploadFile = new File("D:\\dev\\upload_files\\data\\"+fileName);
						item.write(uploadFile);
					}
				}
			}
		}
		return board;
	}
}

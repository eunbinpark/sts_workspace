package bitedu.bipa.PEB.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.PEB.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean IDcheck(String id) {
		int result;
		result = sqlSession.selectOne("mapper.member.selectId", id);

		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean loginMember(String id, String password) {
		String result = sqlSession.selectOne("mapper.member.selectPasswordById", id);
		
		if(result != null && result.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean registMember(MemberVO member) {

		int result = 0;
		result = sqlSession.insert("mapper.member.insertMember", member);

		//System.out.println(result);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
}

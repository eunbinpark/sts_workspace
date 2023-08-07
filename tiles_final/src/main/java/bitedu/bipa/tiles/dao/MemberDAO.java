package bitedu.bipa.tiles.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitedu.bipa.tiles.vo.User;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean IDcheck(String id) {
		int result;
		result = sqlSession.selectOne("mapper.member.idCheck", id);

		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean loginUser(User user) {
		int result;
		result = sqlSession.selectOne("mapper.member.login", user);
		
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
}

package bitedu.bipa.tiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.tiles.dao.MemberDAO;
import bitedu.bipa.tiles.vo.User;

@Service("memberService")
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public boolean checkID(String id) {
		boolean result = memberDAO.IDcheck(id);
		return result;
	}
	
	public boolean login(User user) {
		boolean result = memberDAO.loginUser(user);
		return result;
	}
}

package bitedu.bipa.tilesPEB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.tilesPEB.dao.MemberDAO;
import bitedu.bipa.tilesPEB.vo.MemberVO;


@Service("memberService")
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public boolean checkID(String id) {
		boolean result = memberDAO.IDcheck(id);
		return result;
	}
	
	public boolean login(String id, String password) {
		boolean result = memberDAO.loginMember(id, password);
		return result;
	}
	
	public boolean regist(MemberVO member) {
		boolean result = memberDAO.registMember(member);

		return result;
	}
}

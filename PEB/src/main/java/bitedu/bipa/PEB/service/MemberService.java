package bitedu.bipa.PEB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.PEB.dao.MemberDAO;
import bitedu.bipa.PEB.vo.MemberVO;


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

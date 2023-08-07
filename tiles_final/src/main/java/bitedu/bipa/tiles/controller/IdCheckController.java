package bitedu.bipa.tiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bitedu.bipa.tiles.service.MemberService;


@RestController("idCheck")
@RequestMapping("/id")
public class IdCheckController{
	
	@Autowired
	public MemberService memberService;
	
	@RequestMapping(value="/idCheck.do", method=RequestMethod.GET)
	public @ResponseBody String viewJoin(@RequestParam("id") String id) {
		boolean result;
		result = memberService.checkID(id);
		return String.valueOf(result);
	}
}
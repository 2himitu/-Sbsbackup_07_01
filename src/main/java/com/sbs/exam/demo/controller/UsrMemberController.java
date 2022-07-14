package com.sbs.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.demo.service.MemberService;
import com.sbs.exam.demo.util.Ut;
import com.sbs.exam.demo.vo.Member;

@Controller
public class UsrMemberController {
	
	private MemberService memberService; 
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,String email) {
		if(Ut.empty(loginId)) {
			return "loginId를 입력해주세요.";
		}
		if(Ut.empty(loginPw)) {
			return "loginPw를 입력해주세요.";
		}
		if(Ut.empty(name)) {
			return "name를 입력해주세요.";
		}
		if(Ut.empty(nickname)) {
			return "nickname를 입력해주세요.";
		}
		if(Ut.empty(cellphoneNo)) {
			return "cellphoneNo를 입력해주세요.";
		}
		if(Ut.empty(email)) {
			return "email를 입력해주세요.";
		}
		int id = memberService.join(loginId,loginPw,name,nickname,cellphoneNo,email);
		
		if(id ==-1 ) {
			return"이미 있는 아이디 입니다.";
		}
		if(id ==-2 ) {
			return"이미 이름과 이메일이 사용중입니다.";
		}
		Member member = memberService.getMemberById(id);
		
		return member;
	}
}

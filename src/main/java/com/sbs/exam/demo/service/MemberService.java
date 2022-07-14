package com.sbs.exam.demo.service;

import org.springframework.stereotype.Service;

import com.sbs.exam.demo.repository.MemberRepository;
import com.sbs.exam.demo.util.Ut;
import com.sbs.exam.demo.vo.Member;
import com.sbs.exam.demo.vo.ResultData;

@Service
public class MemberService {
	private MemberRepository memberRepository;
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	
	public ResultData join(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		//id 중복체크
		Member oldMember = getMemberByLoginId(loginId);
		if(oldMember !=null) {
			return ResultData.from("F-7", Ut.f("아이디(%s)는 이미있는 아이디 입니다.",loginId));
		}
		// name =email 중복체크
		oldMember = getMemberByNameAndEmail(name,email);
		if(oldMember !=null) {
			return ResultData.from("F-8", Ut.f("이름(%s)과 이메일(%s)는(은) 이미 사용중입니다.",name,email));
		}
		memberRepository.join(loginId,loginPw,name,nickname,cellphoneNo,email);
		int id = memberRepository.getLastInsertId();
		
		return ResultData.from("S-1","가입완료",id);

		
		
	}
	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name,email);
	}

	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		Member member = memberRepository.getMemberById(id);
		
		return member;
	}
	

}

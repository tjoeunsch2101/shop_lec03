package com.tjoeun.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjoeun.shop.dto.MemberDto;
import com.tjoeun.shop.entity.Member;
import com.tjoeun.shop.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	
	private final MemberService memberService;

	private final PasswordEncoder passwordEncoder;
	
	@GetMapping("/signup")
	public String signup(MemberDto memberDto) {
		return "member/signup";
	}
	
	@PostMapping("/signup_proc")
  public String signup_proc(MemberDto memberDto) {
		
		log.info(">>>>>>>>>>>>>>>> memberDto : " + memberDto);
		
		Member member = Member.createMember(memberDto, passwordEncoder);
		log.info(">>>>>>>>>>>>>>>> member : " + member);
		memberService.saveMember(member);
		
		return "member/signin";
	}
	

}

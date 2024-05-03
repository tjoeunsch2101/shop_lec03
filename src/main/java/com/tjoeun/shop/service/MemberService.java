package com.tjoeun.shop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tjoeun.shop.entity.Member;
import com.tjoeun.shop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		validateDuplicatedMember(member);
		return memberRepository.save(member);
	}
	
	// 이미 가입한 회원이 있는지 검사하기
	public void validateDuplicatedMember(Member member){
		
		// argument 로 넣은 이메일(ember.getEmail()) 로 
    // 이미 가입한 회원이 있는지 검사하기
		Optional<Member> foundMember =  memberRepository.findByEmail(member.getEmail());
		
		// DB 에 저장된 회원 정보
	  if(foundMember.isPresent()) {
	  	System.out.println("이미 가입한 회원 이름 : " + foundMember.get().getName());
		  throw new IllegalStateException("이미 있는 회원입니다.");
	  }
		
		
	}
	
	
	
	

}

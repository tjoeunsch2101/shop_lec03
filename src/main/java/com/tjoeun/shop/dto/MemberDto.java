package com.tjoeun.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
	
  private String name;
	private String email;
	private String password;
	private String address;

}

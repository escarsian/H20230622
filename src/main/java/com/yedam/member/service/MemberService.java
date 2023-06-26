package com.yedam.member.service;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;
//인터페이스 - 구현객체.(jdbc, mybatis)
public interface MemberService {
	public MemberVO login(String id,  String pw);
	public boolean addMember(MemberVO member);
	public MemberVO getMemeber(String id);
	public MemberVO select(String id);
	public MemberVO Modify(String id, String phone, String addr);
	public MemberVO update(MemberVO member);
}

package com.yedam.member.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.com.DataSource;
import com.yedam.member.persistence.MemberMapper;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);

	@Override
	public MemberVO login(String id, String pw) {
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		System.out.println(vo);
		return mapper.login(vo);
	}

	@Override
	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return mapper.insert(member) == 1;
	}

	@Override
	public MemberVO getMemeber(String id) {
		// TODO Auto-generated method stub
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		return mapper.select(vo);
	}

	@Override
	public MemberVO select(String id) {
		// TODO Auto-generated method stub
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		return mapper.select(vo);
	}

	@Override
	public MemberVO Modify(String id, String phone, String addr) {
		// TODO Auto-generated method stub
		MemberVO member = new MemberVO();
		member.setUserId(id);
		member.setUserPhone(phone);
		member.setUserAddr(addr);
		return mapper.modify(member);
	}


	@Override
	public boolean update(MemberVO member) {
		// TODO Auto-generated method stub
		return mapper.update(member) == 1;
	}
}

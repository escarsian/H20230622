package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.com.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class ModifyMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id, phone, addr
		
		//service     / mapper/ jsp 순서로 만들기.
		//modifyMember/ update/ 게시글 목록.
		HttpSession session = req.getSession();
		
		String id = req.getParameter("uid");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		MemberVO member = new MemberVO();
		member.setUserId(id);
		member.setUserPhone(phone);
		member.setUserAddr(addr);
		
		
		MemberService service = new MemberServiceImpl();
		service.update(member);
		
		if(member != null) {
			resp.sendRedirect("boardList.do");
		}
		
		System.out.println(member);

	}

}

package com.yedam.member.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.com.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberInfoControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//"loginId"
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("loginId");
//		String name = (String) session.getAttribute("loginName");
		//service(getMember)에 등록 /mapper(select)에도 등록 / jsp(화면)에도 등록.
		MemberVO member = new MemberVO();
//		member.setUserId("user2222");
//		member.setUserName("hong");
//		member.setUserBirth(new Date());
//		member.setUserImg("anemone-3527401.jpg");
//		member.setUserAddr("대구 중구");
//		member.setUserPhone("010-1111-1111");
		member.setUserId(id);
//		member.setUserName(name);
//		member.setUserBirth();
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = service.select(id);
		
		req.setAttribute("info", vo );
		
		req.getRequestDispatcher("WEB-INF/jsp/member/memberInfo.jsp").forward(req, resp);
	}

}

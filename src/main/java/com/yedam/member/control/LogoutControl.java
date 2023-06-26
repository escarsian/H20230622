package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.com.Controller;

public class LogoutControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
//		session.removeAttribute("loginID");
//		session.removeAttribute("loginName");
		session.invalidate(); //세션객체 삭제.
		
		resp.sendRedirect("memberLoginForm.do");
		
	}

}

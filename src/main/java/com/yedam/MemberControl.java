package com.yedam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.com.Controller;

public class MemberControl implements Controller{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("member 컨트롤");
	}
 
}

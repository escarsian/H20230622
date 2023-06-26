package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.control.AddMemberControl;
import com.yedam.board.control.BoardAddControl;
import com.yedam.board.control.BoardFormControl;
import com.yedam.board.control.BoardListControl;
import com.yedam.board.control.BoardModifyControl;
import com.yedam.board.control.BoardModifyFormControl;
import com.yedam.board.control.BoardRemoveControl;
import com.yedam.board.control.BoardSearchControl;
import com.yedam.com.Controller;
import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.member.control.MemberInfoControl;
import com.yedam.member.control.MemberJoinForm;
import com.yedam.member.control.ModifyMemberControl;

public class FrontController extends HttpServlet {
	
	HashMap<String, Controller> menu;  // menu의 타입.
	String enc;
	
	public FrontController() {
		menu = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		enc = config.getInitParameter("charset");
		System.out.println("init.");
		menu.put("/main.do", new MainControl());
		menu.put("/boardList.do", new BoardListControl());
		menu.put("/boardForm.do", new BoardFormControl());
		menu.put("/addBoard.do", new BoardAddControl());
		menu.put("/getBoard.do", new BoardSearchControl());
		menu.put("/modifyFrom.do", new BoardModifyFormControl()); 
		menu.put("/boardModify.do", new BoardModifyControl());
		menu.put("/boardRemove.do", new BoardRemoveControl());
		
		//회원관련
		menu.put("/memberLoginForm.do", new LoginFormControl()); //로그인화면
		menu.put("/memberLogin.do", new LoginControl()); //로그인처리.
		menu.put("/memberLogout.do", new LogoutControl()); // 
		menu.put("/memberJoinForm.do", new MemberJoinForm());  
		menu.put("/addMember.do",new AddMemberControl());
		menu.put("/memberInfo.do", new MemberInfoControl());
		menu.put("/modifyMember.do", new ModifyMemberControl());
	
		
		menu.put("/member.do", new MemberControl());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		 
		String uri = req.getRequestURI();
		String cpath = req.getContextPath(); //application 이름.
		String path = uri.substring(cpath.length());
		System.out.println("uri: " + uri);
		System.out.println("cpath: " + cpath);
		System.out.println("path: " + path);
		
		Controller msg = menu.get(path);  //url pattern - 실행.
		msg.exec(req, resp);
		
	}
}

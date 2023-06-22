package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceImpl;
import com.yedam.board.vo.BoardVO;
import com.yedam.com.Controller;

public class BoardAddControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String wr = req.getParameter("writer");
		String tl = req.getParameter("title");
		String ctn = req.getParameter("content");
		 
		if(wr ==null || tl==null || ctn==null) {
			req.setAttribute("errorMsg", "필수값을 입력하세요!!");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		}
		
		BoardVO vo = new BoardVO();
		vo.setBrdTitle(tl);
		vo.setBrdWriter(wr);
		vo.setBrdContent(ctn);
		
		BoardService service = new BoardServiceImpl();
		if(service.addBoard(vo)) {
			resp.sendRedirect("boardList.do"); //목록 페이지로 감.
		}else {
			resp.sendRedirect("addBoard.do"); //그렇지 않으면 다시 등록하는 
		}
	}

}

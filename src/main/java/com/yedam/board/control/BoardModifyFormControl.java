package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.com.Controller;

public class BoardModifyFormControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//글 번호 조회 후 수정화면으로 정보 지정.
		String no = req.getParameter("bno");
		BoardService service = new BoardServiceMybatis();
		BoardVO vo = service.getBoard(Long.parseLong(no));
		
		// 요청 정보에 값을 지정.
		req.setAttribute("board", vo);
		
		req.getRequestDispatcher("WEB-INF/jsp/boardModify.jsp").forward(req, resp);
		
	}

}

package com.yedam.com;

import java.util.List;

import com.yedam.board.persistence.BoardDAO;
import com.yedam.board.vo.BoardVO;

public class TestMain {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();

		BoardVO brd = new BoardVO();
		brd.setBrdContent("내용테스트23");
		brd.setBrdWriter("new");
		brd.setBrdNo(5);
		brd.setBrdTitle("title123");

		if (dao.selectBoard(brd.getBrdNo()) != null) {
			System.out.println("조회 성공...");
		}

		List<BoardVO> list = dao.boardList();
		for (BoardVO vo : list) {
			System.out.println(vo.toString());
		} 
	}
}

package com.yedam.com;

import java.util.List;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;

public class TestMain {
	public static void main(String[] args) {
		BoardService service = new BoardServiceMybatis();
//		
		PageDTO dto = new PageDTO(3, service.totalCnt());
		System.out.println(dto);
	}
}

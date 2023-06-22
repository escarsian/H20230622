package com.yedam.board.persistence;

import java.util.List;

import com.yedam.board.service.BoardService;
import com.yedam.board.vo.BoardVO;

public class BoardMybatis implements BoardService {

	@Override
	public boolean addBoard(BoardVO vo) {
		return false;
	}

	@Override
	public BoardVO getBoard(long brdNo) {
		return null;
	}

	@Override
	public boolean editBoard(BoardVO vo) {
		return false;
	}

	@Override
	public boolean delBoard(long brdNo) {
		return false;
	}

	@Override
	public List<BoardVO> list() {
		return null;
	}

}

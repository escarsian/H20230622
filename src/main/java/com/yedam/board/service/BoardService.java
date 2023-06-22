package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	public boolean addBoard(BoardVO vo);
	public BoardVO getBoard(long brdNo);
	public boolean editBoard(BoardVO vo);
	public boolean delBoard(long brdNo);
	public List<BoardVO> list();
}

package com.yedam.board.persistence;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardList(int page);
	public BoardVO selectBoard(long no);
	public int updateCnt(long bno);
	public int deleteCnt(long bno);
	public int updateBoard(BoardVO board);
	public int insertBoard(BoardVO board);
	public int totalCnt();
}

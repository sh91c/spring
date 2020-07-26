package com.pknu.board.dao;

import java.util.List;

import com.pknu.board.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> getBoardList();

	public BoardVO getContent(int idx);

	public void addBoard(BoardVO vo);

	public void delBoard(int idx);

	public void updateBoard(BoardVO vo);

	public void setIdx(int idx);
}

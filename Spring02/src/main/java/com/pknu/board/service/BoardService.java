package com.pknu.board.service;

import java.util.List;

import com.pknu.board.vo.BoardVO;

// DB연결 외에 다른 업무 서비스를 구현해야할 때 사용
public interface BoardService {
	public List<BoardVO> getBoardList();

	public BoardVO getContent(int idx);

	public void addBoard(BoardVO vo);

	public void delBoard(int idx);

	public void updateBoard(BoardVO vo);
}

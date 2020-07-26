package com.pknu.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.board.dao.BoardDAO;
import com.pknu.board.service.BoardService;
import com.pknu.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	// @Repository의 id를 변수 이름으로
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList() {
		// DB와 관련없는 업무 서비스를 구현
		
		return boardDAO.getBoardList();
	}

	@Override
	public BoardVO getContent(int idx) {
		BoardVO boardVO = boardDAO.getContent(idx);
		return boardVO;
	}

	@Override
	public void addBoard(BoardVO vo) {
		boardDAO.addBoard(vo);
	}

	@Override
	public void delBoard(int idx) {
		boardDAO.delBoard(idx); // idx 번 글 삭제
		
		// 삭제 후 다른 글 번호 재 부여(DB 외 로직,, 핵심 로직이 아님)
		boardDAO.setIdx(idx);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		
	}

}

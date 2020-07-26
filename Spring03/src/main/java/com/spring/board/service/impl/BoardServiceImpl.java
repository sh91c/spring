package com.spring.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDAO;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getList() {
		List<BoardVO> boardList = boardDAO.getList();
		return boardList;
	}

	@Override
	public void addBoard(HashMap<String, Object> map) {
		boardDAO.addBoard(map);
		
	}

	@Override
	public void delContent(HashMap<String, Object> map) {
		boardDAO.delContent(map);
		
	}

	@Override
	public List<BoardVO> getContent(HashMap<String, Object> map) {
		List<BoardVO> views = boardDAO.getContent(map);
		return views;
	}

	@Override
	public void updateContent(HashMap<String, Object> map) {
		boardDAO.updateContent(map);
	}




}

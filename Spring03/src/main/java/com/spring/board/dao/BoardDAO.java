package com.spring.board.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.board.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> getList();

	void addBoard(HashMap<String, Object> map);

	void delContent(HashMap<String, Object> map);

	List<BoardVO> getContent(HashMap<String, Object> map);

	void updateContent(HashMap<String, Object> map);


	
}

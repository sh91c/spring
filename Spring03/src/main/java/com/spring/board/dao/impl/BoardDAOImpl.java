package com.spring.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDAO;
import com.spring.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> getList() {
		// map : 결과를 돌려받는 역할
		HashMap<String, Object> map = new HashMap<>();
		sqlSession.selectList("Board.BoardList",map);
		List<BoardVO> boardList = (List<BoardVO>) map.get("result");
		return boardList;
	}

	@Override
	public void addBoard(HashMap<String, Object> map) {
		
		sqlSession.insert("Board.BoardInsert", map);
	}

	@Override
	public void delContent(HashMap<String, Object> map) {
		sqlSession.delete("Board.BoardDelete", map);
	}

	@Override
	public List<BoardVO> getContent(HashMap<String, Object> map) {
		System.out.println("map1 : " + map);
		sqlSession.selectList("Board.BoardContent", map);
		System.out.println("map2 : " + map);
		List<BoardVO> views = (List<BoardVO>) map.get("result");
		System.out.println("views :" + views);
		return views;
	}

	@Override
	public void updateContent(HashMap<String, Object> map) {
		sqlSession.update("Board.BoardUpdate", map);
	}



}

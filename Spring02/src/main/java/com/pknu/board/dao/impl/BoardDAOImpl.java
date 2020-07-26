package com.pknu.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.board.dao.BoardDAO;
import com.pknu.board.vo.BoardVO;

// DB연결은 @Repository("id")
//@Qualifier("이름") : 같은 타입의 여러개 클래스가 있을때 @Qualifier 어노테이션으로 이름을 지정할 수 있다.
@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	// SqlSessionFactory class: DB 연결 - 마이바티스
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> getBoardList() {
		// 목록을 조회할 때 selectList
		List<BoardVO> list = sqlSession.selectList("Board.BoardList");
		return list;
	}

	@Override
	public BoardVO getContent(int idx) {
		// 하나만 조회할 때 selectOne 
		BoardVO boardVO = sqlSession.selectOne("Board.BoardContent", idx);
		return boardVO;
	}

	@Override
	public void addBoard(BoardVO vo) {
		sqlSession.insert("Board.BoardWrite", vo);
	}

	@Override
	public void delBoard(int idx) {
		sqlSession.delete("Board.BoardDelete", idx);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		sqlSession.update("Board.BoardUpdate", vo);
	}

	@Override
	public void setIdx(int idx) {
		sqlSession.update("Board.BoardIdxService", idx);
	}
}

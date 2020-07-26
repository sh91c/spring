package com.pknu.menu.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.menu.dao.MenuDAO;
import com.pknu.menu.vo.MenuVO;

@Repository("menuDAO")
public class MenuDAOImpl implements MenuDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MenuVO> getList(HashMap<String, Object> map) {
		// select 결과를 map에 담음
		sqlSession.selectList("Menu.MenuList",map);
		
		// map은 커서타입으로 되어있어서 캐스팅한다.
		List<MenuVO> menuList =  (List<MenuVO>)map.get("result");
		return menuList;
	}

	@Override
	public void setWriteMenu(HashMap<String, Object> map) {
		sqlSession.insert("Menu.MenuInsert", map);
		
	}

	@Override
	public void deleteMenu(HashMap<String, Object> map) {
		sqlSession.delete("Menu.MenuDelete", map);
		
	}

	@Override
	public MenuVO getView(HashMap<String, Object> map) {
		// 하나만 조회한다고 해도 기본적으로 CURSOR는 여러개이므로, 컬렉션 리스트로 값을 받아
		// 첫번째 원소의 값을 menuVO에 리턴한다.
		
		sqlSession.selectList("Menu.MenuView", map);
		
		List<MenuVO> menuList = (List<MenuVO>) map.get("result");
		
		MenuVO menuVO = menuList.get(0);
		
		return menuVO;
	}

	@Override
	public void updateMenu(HashMap<String, Object> map) {
		sqlSession.update("Menu.MenuUpdate", map);
		
	}

}

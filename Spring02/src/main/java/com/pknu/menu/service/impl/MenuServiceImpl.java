package com.pknu.menu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.menu.dao.MenuDAO;
import com.pknu.menu.service.MenuService;
import com.pknu.menu.vo.MenuVO;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public List<MenuVO> getList(HashMap<String, Object> map) {
		List<MenuVO> menuList = menuDAO.getList(map); 
		return menuList;
	}

	@Override
	public void setWriteMenu(HashMap<String, Object> map) {
		menuDAO.setWriteMenu(map);
		
	}

	@Override
	public void deleteMenu(HashMap<String, Object> map) {
		menuDAO.deleteMenu(map);
		
	}

	@Override
	public MenuVO getView(HashMap<String, Object> map) {
		System.out.println("map : " + map);
		MenuVO view = menuDAO.getView(map);
		System.out.println("view : " +view);
		return view;
	}

	@Override
	public void updateMenu(HashMap<String, Object> map) {
		menuDAO.updateMenu(map);
		
	}

}

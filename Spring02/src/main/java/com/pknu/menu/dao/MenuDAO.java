package com.pknu.menu.dao;

import java.util.HashMap;
import java.util.List;

import com.pknu.menu.vo.MenuVO;

public interface MenuDAO {

	List<MenuVO> getList(HashMap<String, Object> map);

	void setWriteMenu(HashMap<String, Object> map);

	void deleteMenu(HashMap<String, Object> map);

	MenuVO getView(HashMap<String, Object> map);

	void updateMenu(HashMap<String, Object> map);

	

}

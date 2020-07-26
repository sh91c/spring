package com.pknu.menu.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pknu.menu.service.MenuService;
import com.pknu.menu.vo.MenuVO;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/Menus/List")
	public ModelAndView menuList() {
		
		// HashMap은 프로시저에 값을 전달하고 돌려받는 역할
		HashMap<String, Object> map = new HashMap<>();
		map.put("menu_id", "MENU01");
		
		List<MenuVO> menuList = menuService.getList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/menulist");
		mv.addObject("menuList", menuList);
		return mv;
	}
	
	@RequestMapping("/Menus/WirteForm")
	public String writeForm() {
		return "menus/menuWrite";
	}
	
	@RequestMapping("/Menus/Write")
	public String write(MenuVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("menu_name", vo.getMenu_name());
		menuService.setWriteMenu(map);
		return "redirect:/Menus/List";
	}
	
	// 삭제
	@RequestMapping("/Menus/DeleteForm")
	public String deleteForm(MenuVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("menu_id", vo.getMenu_id());
		menuService.deleteMenu(map);
		return "redirect:/Menus/List";
	}
	
	// update 대상 조회
	@RequestMapping("/Menus/UpdateForm")
	public ModelAndView updateForm(MenuVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("menu_id", vo.getMenu_id());
		
		MenuVO menuVO = menuService.getView(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/menuUpdate");
		mv.addObject("menuVO", menuVO);
		return mv;
	}
	
	// update 대상 조회 후 DB 업데이트
	@RequestMapping("/Menus/Update")
	public String update(MenuVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("menu_id", vo.getMenu_id());
		map.put("menu_name", vo.getMenu_name());
		map.put("menu_seq", vo.getMenu_seq());
		
		menuService.updateMenu(map);
		
		return "redirect:/Menus/List";
	}
}

package com.spring.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/Board/List")
	public ModelAndView list() {
		List<BoardVO> boardList = boardService.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/list");
		mv.addObject("boardList", boardList);
		
		return mv;
	}
	
	@RequestMapping("/Board/WriteForm")
	public String writeForm() {
		return "board/write";
	}
	
	@RequestMapping("/Board/Write")
	public String write(BoardVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("title", vo.getTitle());
		map.put("name", vo.getName());
		
		boardService.addBoard(map);
		return "redirect:/Board/List";
	}
	
	// delete
	@RequestMapping("/Board/Delete")
	public String delete(BoardVO vo){
		HashMap<String, Object> map = new HashMap<>();
		map.put("idx", vo.getIdx());
		boardService.delContent(map);
		return "redirect:/Board/List";
	}
	
	
	// updateForm
	@RequestMapping("/Board/UpdateForm")
	public ModelAndView updateForm(BoardVO vo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("idx", vo.getIdx());
		
		List<BoardVO> views = boardService.getContent(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/updateForm");
		mv.addObject("boardList", views);
		return mv;
	}
	
	//Update
	@RequestMapping("/Board/Update")
	public String update(@RequestParam HashMap<String, Object> map) {
		boardService.updateContent(map);
		return "redirect:/Board/List";
	}
}

package com.pknu.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pknu.board.service.BoardService;
import com.pknu.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/Board/List")
	public String list(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "list";
	}
		
	@RequestMapping("/Board/Content")
	public String content(int idx, Model model) {
		System.out.println("idx : " + idx);
		BoardVO boardVO =boardService.getContent(idx);
		System.out.println(boardVO);
		model.addAttribute("board", boardVO);
		return "content";
	}
	
	// 새 글쓰기 (클라이언트 단)
	@RequestMapping("/Board/WriteForm")
	public String writeForm() {
		return "write";
	}
	
	// 새 글쓰기 (DB)
	@RequestMapping("/Board/Write")
	public String write(BoardVO vo) {
		boardService.addBoard(vo);
		return "redirect:/Board/List";
	}
	
	// 삭제하기
	@RequestMapping("/Board/Delete")
	public String delete(int idx) {
		boardService.delBoard(idx);
		return "redirect:/Board/List";
	}
	
	/*
	 public String delete(int idx) {
		boardService.delBoard(idx);
		return "redirect:/Board/List";
	}
	 */
	
	// 수정하기 (클라이언트 단)
	@RequestMapping("/Board/UpdateForm")
	public String updateForm(int idx, Model model) {
		BoardVO vo = boardService.getContent(idx);
		model.addAttribute("board", vo);
		return "update";
	}
	
	
	// 수정하기 (DB)
	@RequestMapping("/Board/Update")
	// = public String update(idx, title, name)
	public String update(BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:/Board/Content?idx=" + vo.getIdx();
	}
}

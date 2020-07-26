package com.pknu.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.user.dao.UserDAO;
import com.pknu.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping("/")
	public String home(Model model) {  
		model.addAttribute("age", 27); // map 방식 key - value, model은 전역변수처럼 사용
		return "home";				   //  ㄴ 이걸 JSP에서 ${변수명} 으로 사용한다.
	}
	
	@RequestMapping("/List")
	public String list(Model model) {
		List<UserVO> list = userDao.getList(); // UserDAOImpl.java에서 override
		model.addAttribute("userList", list);
		return "list";
	}
	
	@RequestMapping("/WriteForm")
	public String writeForm() {
		return "write";
	}
	
	@RequestMapping("/Write")
//	WriteForm에서 작성된 input태그 name속성인 name, tel이 여기로 전달되어 UserVO로 전달된다.
	public String write(UserVO vo, Model model) {
		userDao.addUser(vo);
		return "redirect:/List";
	}
	
//	/View?tel=010~~
	@RequestMapping("/View")
	public String view(String tel, Model model) {
		UserVO vo = userDao.getView(tel);
		model.addAttribute("user", vo);
		return "view";
	}
	
	@RequestMapping("/DeleteForm")
	public String delete(UserVO vo) {
		userDao.delUser(vo);
		return "redirect:/List";
	}
	
	@RequestMapping("/UpdateForm") // UpdateForm?tel=010~~
	public String updateForm(String tel, Model model) {
		// 수정할 정보를 조회
		UserVO vo = userDao.getView(tel);
		// 전달
		model.addAttribute("user", vo);
		return "update";
	}
	
	@RequestMapping("/Update")
	public String update(UserVO vo) {
		userDao.updateUser(vo);
		return "redirect:/List";
	}
}

package com.pknu.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.spring.vo.BoardVO;

@Controller
public class TempController {
		@RequestMapping("/")
		public String home() {
			return "home";
		}
		
		@RequestMapping("/temp1") // /temp1?a=hello&b=1
		public String temp1(HttpServletRequest request, HttpServletResponse reponse) {
			// HttpServletRequest, Response를 사용해서 파라미터 처리
			String a = request.getParameter("a");
			String b = request.getParameter("b");
			
			HttpSession session = request.getSession();
			
			System.out.println("temp1");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			return "none";
		}
		
		@RequestMapping("/temp2") // /temp2?a=hello&b=2
		// 컬렉션, 제너릭을 사용해서 파라미터를 받아옴
		public String temp2(@RequestParam Map<String, String> map) {
			String a = map.get("a");
			String b = map.get("b");
			
			System.out.println("temp2");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			return "none";
		}
		
		@RequestMapping("/temp3") // /temp3?a=hello&b=3
		public String temp3(
				// 데이터 타입을 @RequeestParam 옆에 바로 선언하면서 파라미터를 받아옴
				@RequestParam("a") String a,
				@RequestParam("b") int b
				) {
			
			System.out.println("temp3");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			return "none";
		}
		
		// VO를 사용해서 파라미터 처리하기
		@RequestMapping("/temp4")
		public String temp4(BoardVO vo) {
			System.out.println("temp4");
			System.out.println("a : " + vo.getA());
			System.out.println("b : " + vo.getB());
			System.out.println(vo.toString());
			return "none";
		}
		
		//------------------------------------------
		@RequestMapping("/temp5")
		public String temp5(
				@RequestParam("a") String a,
				@RequestParam("b") int b,
				Model model
				) {
			
			System.out.println("temp5");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			System.out.println("--------------------");
			
			// Model 클래스는 다른 페이지로 값을 전달하기 위해 담는 객체 (HttpServlet~과 같은 역할..)
			// Model의 내용 확인 : Map 구조로 저장된다 (key : value)
			// Model안에 값 할당
			model.addAttribute("a",a);
			model.addAttribute("b",b);
			
			System.out.println("model5 내부 값");
			Map<String, Object> map = model.asMap();
			System.out.println("--------------------");
			for (String key : map.keySet()) {
				System.out.println(key + " : "+ map.get(key).toString());
			}
			System.out.println("--------------------");
			
			return "none";
		}
		
		@RequestMapping("/temp6")
		public String temp6(BoardVO vo,	Model model	) {
			
			System.out.println("temp6");
			System.out.println("a : " + vo.getA());
			System.out.println("b : " + vo.getB());
			System.out.println("--------------------");
			
			// Model 클래스는 다른 페이지로 값을 전달하기 위해 담는 객체 (HttpServlet~과 같은 역할..)
			// Model의 내용 확인 : Map 구조로 저장된다 (key : value)
			// Model안에 값 할당
			model.addAttribute("a", vo.getA());
			model.addAttribute("b", vo.getB());
			
			System.out.println("model6 내부 값");
			Map<String, Object> map = model.asMap();
			System.out.println("--------------------");
			for (String key : map.keySet()) {
				System.out.println(key + " : "+ map.get(key).toString());
			}
			System.out.println("--------------------");
			
			return "none";
		}
		
		@RequestMapping("/temp7")
		public String temp7(
				@ModelAttribute("attrName")	BoardVO vo,	Model model
				) {
			
			System.out.println("temp7");
			System.out.println("a : " + vo.getA());
			System.out.println("b : " + vo.getB());
			System.out.println("--------------------");
			
			// Model 클래스는 다른 페이지로 값을 전달하기 위해 담는 객체 (HttpServlet~과 같은 역할..)
			// Model의 내용 확인 : Map 구조로 저장된다 (key : value)
			
			// @ModelAttribute 사용 결과는?
			
			System.out.println("model7 내부 값");
			Map<String, Object> map = model.asMap();
			System.out.println("--------------------");
			for (String key : map.keySet()) {
				System.out.println(key + " : "+ map.get(key).toString());
			}
			System.out.println("--------------------");
			
			return "noneModel";
		}
		
		// PathVariable
		// 어떤 규칙으로 파라미터를 가져오는지에 대한 규칙 정의
		@RequestMapping("/temp8/{a}/{b}")
		public String tempPath(
				@PathVariable("a") String a,
				@PathVariable("b") int b
				) {
			
			System.out.println("temp8");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
						
			return "none";
		}
		
		@RequestMapping("/temp9/{a}/{b}")
		public String tempPath9(BoardVO vo) {
			
			System.out.println("temp9");
			System.out.println("a : " + vo.getA());
			System.out.println("b : " + vo.getB());
						
			return "none";
		}
		
		@RequestMapping("/temp10/{a}/{b}")
		public String tempPath10(
				@ModelAttribute("attrName") BoardVO vo,
				Model model
				) {
			
			System.out.println("temp10");
			System.out.println("a : " + vo.getA());
			System.out.println("b : " + vo.getB());
						
			return "noneModel";
		}
}
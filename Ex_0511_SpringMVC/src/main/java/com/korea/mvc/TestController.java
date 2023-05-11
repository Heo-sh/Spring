package com.korea.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Mypath;

@Controller
public class TestController {
	
	public TestController() {
		System.out.println("---Testcontroller의 기본생성자---");
	}
	
	@RequestMapping("/test.do") //내가 url에 test.do를 요청하면
	public String test(Model model, HttpServletRequest request) { //test() 메서드가 실행이 된다.
		
		String [] fruits = {"사과", "복숭아", "바나나", "딸기", "수박"};
		String ip = request.getRemoteAddr();
		
		model.addAttribute("fruits", fruits);
		model.addAttribute("ip", ip);
		
		return Mypath.TestClass.VIEW_PATH + "test.jsp"; //WEB-INF/views/안에 있는 test.jsp를 실행해줘라
		//ex) 게시판과 관련된 1, 2, 3.jsp는 board폴더에 넣어서 관리를 하고
		//    회원과 관련된 4, 5, 6.jsp는 member폴더에 넣어서 관리를 하고 싶다.
		//    - 상수를 만들어서 경로를 만들어서 사용한다.
	}
	
	//하나의 컨트롤러에 여러 개의 매핑이 가능하다.
	//- 파일 개수가 줄어듬
	//- servlet을 여러 개 만들 필요가 없어짐
	@RequestMapping("/test2.do")
	public String test2() {
		return Mypath.TestClass.VIEW_PATH + "test2.jsp";
	}
}

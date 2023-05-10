package com.korea.test_di;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImpl;

//스프링이 해당 클래스가 Controller라는 것을 인식시키기 위해
//반드시 사용해야 한다.
@Controller
public class BoardController {

	BoardServiceImpl service;

	public void setService(BoardServiceImpl service) {
		this.service = service;
	}
	
	//사용자가 요청한 url을 접수
	//사용자가 board/list.do를 요청하면 해당 메서드가 실행된다.
	//jsp의 url매핑이라고 생각하면 된다.
	@RequestMapping("/board/list.do")
	public String list() {
		return "board_list"; //포워딩
	}
	
	//root-context.xml은 Controller를 제외한 모든 객체를 만든다.
	//유일하게 컨트롤러만이 servlet-context.xml에서 만들어진다.
//	public BoardController() {
//		System.out.println("---BoardController의 기본생성자 호출---");
//	}
	
	
	
}

package com.korea.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Mypath;
import vo.PersonVO;

@Controller
public class ParamController {
	@RequestMapping(value={"/", "/insert.do"})
	public String insert_form() {
		return Mypath.PATH + "insert_form.jsp";
	}
	
	@RequestMapping("/insert1.do")
	//name=???&age=???&tel=???
	//Spring에서는 넘오오는 파라미터의 이름과 받는 메서드의 파라미터 이름이 같으면 자동으로 받아진다.
	//jsp에서는 String으로만 받았는데 Spring에서는 자료타입 또한 자동으로 변환해서 받아준다.
	public String insert1(Model model, String name, int age, String tel) {
		PersonVO vo = new PersonVO();
		vo.setAge(age);
		vo.setName(name);
		vo.setTel(tel);
		
		model.addAttribute("vo", vo);
		
		return Mypath.PATH + "insert_result.jsp";
	} //파라미터를 낱개로 받아 insert_result.jsp로 보내주기
	
	@RequestMapping("/insert2.do")
	public String insert2(Model model, PersonVO vo) {
		//파라미터로 넘어온 name, tel, age를 vo객체에 자동으로 setting을 해준다.
		//현재 PersonVO에 변수가 세 개 있는데 파라미터를 두개만(ex: name, age) 던지게 되면
		//tel은 자동으로 null값이 들어간다.
		//PersonVO의 변수보다 많은 개수의 파라미터를 던지게 되면 문제가 생긴다.
		model.addAttribute("vo", vo);
		
		return Mypath.PATH + "insert_result.jsp";
	} //파라미터를 객체로 받아 insert_result2.jsp로 보내주기
}

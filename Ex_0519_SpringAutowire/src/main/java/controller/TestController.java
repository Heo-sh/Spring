package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class TestController {
	
	//setter나 생성자 injetion이 안된다! 그러니 autowired!!!
	@Autowired
	DeptDAO dept_dao;
	
	public TestController() {
		System.out.println("TestController 기본생성자");
	}
	
	@RequestMapping("dept_list.do")
	public String deptlist(Model model) {
		List<DeptVO> list = dept_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/dept_list.jsp";
	}
	
	@RequestMapping("/")
	public String loginForm() {
		return "/WEB-INF/views/login_form.jsp";
	}
	
	@PostMapping("login")
						//아이디라는 이름으로 el표기법을 쓸 수 있다.
	public String login(@ModelAttribute("id") String id, String pw) {
		//어떤 아이디냐에 따라 관리자 페이지, 일반인 페이지로 보낼 수 있다.
		if(id.equals("admin")) {
			return "/WEB-INF/views/admin.jsp";
		} else {
			return "/WEB-INF/views/main.jsp";
		}
	}
}

package com.korea.visit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
	VisitDAO visit_dao;
	
	public VisitController(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	@RequestMapping(value= {"/","visit_list.do"})
	public String select(Model model) {
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list",list);
		return MyCommon.VIEW_PATH+"visit_list.jsp";
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		return MyCommon.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	//새 글 작성
	@RequestMapping("insert.do")
	//name=???&content=???&pwd=???
	public String insert(VisitVO vo, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		int res = visit_dao.insert(vo);
		
		//sendRedirect("visit_list.do");
		return "redirect:visit_list.do";
	}
}

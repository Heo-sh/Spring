package com.kore.test;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.GogekDAO;
import vo.GogekVO;

@Controller
public class GogekController {

	public static final String VIEW_PATH = "/WEB-INF/views/gogek/";
	
	GogekDAO gogek_dao;
	
	public void setGogek_dao(GogekDAO gogek_dao) {
		this.gogek_dao = gogek_dao;
	}

	@RequestMapping("gogek.do")
	public String list(Model model) {
		List<GogekVO> list = gogek_dao.selectList();
		
		model.addAttribute("list", list);
		return VIEW_PATH + "gogek_list.jsp";
	}
	
}

package com.kore.test;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SungtbDAO;
import vo.SungtbVO;

@Controller
public class SungtbController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/sungtb/";

	SungtbDAO sungtb_dao;
	
	public SungtbController(SungtbDAO sungtb_dao) {
		this.sungtb_dao = sungtb_dao;
	}
	
	@RequestMapping("sungtb.do")
	public String list(Model model) {
		List<SungtbVO> list = sungtb_dao.selectList();
		
		model.addAttribute("list", list);
		return VIEW_PATH + "sungtb_list.jsp";
	}
}

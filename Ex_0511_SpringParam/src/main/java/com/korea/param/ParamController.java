package com.korea.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Mypath;

@Controller
public class ParamController {
	@RequestMapping(value={"/", "/insert.do"})
	public String insert_form() {
		return Mypath.PATH + "insert_form.jsp";
	}
}

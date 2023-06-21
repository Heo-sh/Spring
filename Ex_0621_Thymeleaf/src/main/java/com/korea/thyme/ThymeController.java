package com.korea.thyme;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.MemberVO;

@Controller
public class ThymeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("data", "타임리프 예제입니다.");
		return "ex01.html";
	}
	
	@RequestMapping("ex02")
	public String ex02(Model model) {
		MemberVO vo = new MemberVO();
		vo.setMemNo(1);
		vo.setMemId("user1");
		vo.setMemNm("홍길동");
		vo.setRegDt(LocalDateTime.now());
		model.addAttribute("vo", vo);
		return "ex02.html";
	}
}

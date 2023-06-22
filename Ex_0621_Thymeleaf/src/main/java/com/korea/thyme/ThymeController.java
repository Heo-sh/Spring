package com.korea.thyme;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping("ex03")
	public String ex03(Model model) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for (int i = 0; i <= 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setMemNo(i);
			vo.setMemId("user" + i);
			vo.setMemNm("이름" + i);
			vo.setRegDt(LocalDateTime.now());
			
			list.add(vo);
		}
		
		model.addAttribute("list", list);
		
		return "ex03.html";
	}
	
	@RequestMapping("ex04")
	public String ex04(Model model) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for (int i = 1; i <= 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setMemNo(i);
			vo.setMemId("user" + i);
			vo.setMemNm("이름" + i);
			vo.setRegDt(LocalDateTime.now());
			
			list.add(vo);
		}
		
		model.addAttribute("list", list);
		
		return "ex04.html";
	}
	
	@RequestMapping("ex05")
	public String ex05(Model model) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for (int i = 1; i <= 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setMemNo(i);
			vo.setMemId("user" + i);
			vo.setMemNm("이름" + i);
			vo.setRegDt(LocalDateTime.now());
			
			list.add(vo);
		}
		model.addAttribute("list", list);
		
		return "ex05.html";
	}
	
	@RequestMapping("ex06")
	public String ex06() {
		return "ex06.html";
	}

	@RequestMapping("ex07")
	public String ex07(Model model, String param1, String param2) {
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		
		return "ex07.html";
	}

	@RequestMapping("ex08")
	public String ex08(Model model) {
		MemberVO vo = new MemberVO();
		vo.setMemNo(1);
		vo.setMemId("user1");
		vo.setMemNm("홍길동");
		vo.setRegDt(LocalDateTime.now());
		model.addAttribute("vo", vo);
		return "ex08.html";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

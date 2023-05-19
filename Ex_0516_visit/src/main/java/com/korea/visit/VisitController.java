package com.korea.visit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired
	ServletContext application;
	
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
		
		//파일이 넘어올 경우
		//절대경로 잡기
		String webPath = "resources/upload/";
		String savePath = application.getRealPath(webPath);
		System.out.println(savePath);
		
		//업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		
		//업로드된 파일이 존재한다면
		if (!photo.isEmpty()) {
			//업로드된 실제 파일이름
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				//동일파일명 방지
				long time = System.currentTimeMillis();
				
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			} 

			try {
				//업로드를 위한 실제 파일을 물리적으로 기록
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		
		int res = visit_dao.insert(vo);
		
		//sendRedirect("visit_list.do");
		return "redirect:visit_list.do";
	}
	
	//글 삭제
	@RequestMapping("delete.do")
	@ResponseBody //return 값을 view형태로 인식하지 않고 콜백메서드로 전달을 하기 위한 어노테이션
	//idx=???&pwd=???
	public String delete(int idx, String pwd) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("pwd", pwd);
		
		int res = visit_dao.delete(map);
		
		//Ajax의 사용이유 중 제일 큰 건
		//- 사용 여부에 대한 알림을 받기 위함이 좀 크다.
		String result = "no";
		
		if (res == 1) {
			result = "yes";
		}
										//json
		String finRes = String.format("[{'res' : '%s'}]", result); //괄호를 잘 보자
		
		//@ResponseBody를 쓰지않으면 return에서 "[{'res'} : '%s'].jsp"를 찾는다.
		return finRes;
	}
	
	//글 수정
	@RequestMapping("modify_form.do")
	public String modify_form(Model model, int idx) {
		//파라미터로 넘어온 idx를 이용해 해당 idx를 가진 게시물 정보를 얻어온다.
		VisitVO vo =  visit_dao.selectOne(idx);
		
		//바인딩
		model.addAttribute("vo", vo);
		
		return MyCommon.VIEW_PATH + "visit_modify_form.jsp";
	}
	
	@RequestMapping("modify.do")
	public String modify(VisitVO vo, HttpServletRequest request) {
		//현재 vo에 담겨서 넘어오는 내용이 무엇일까?
		//내용, 비밀번호
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = visit_dao.update(vo);
		
		return "redirect:visit_list.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

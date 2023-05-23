package com.korea.bbs;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BoardDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	HttpServletRequest request;
	
	BoardDAO board_dao;
	
	public BoardController(BoardDAO board_dao) {
		this.board_dao = board_dao;
	}
	
	@RequestMapping(value = {"/", "board_list.do"})
	public String list(Model model, String page) {
		
		//페이징 처리
		int nowPage = 1;
		
		//null이 아니고 비어있지 않다면!
		if (page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		//한 페이지에 표시될 게시물의 시작과 끝번호 계산
		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//페이지 번호에 따른 전체 게시글 조회
		List<BoardVO> list = board_dao.selectList(map);
		
		//전체 게시물 수 조회 -> 페이지 개수를 생성하기 위해서 필요
		int rowTotal = board_dao.getRowTotal();
		
		//페이지 메뉴 생성    static으로 되어 있기에 객체 생성 없이 호출 가능
		String pageMenu = Paging.getPaging("board_list.do", nowPage, rowTotal, Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);
		
		request.getSession().removeAttribute("show");
		
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return Common.VIEW_PATH + "board_list.jsp?page=" + nowPage;
	}
	
	//1건의 게시글 보기
	@RequestMapping("view.do")
	public String view(Model model, int idx, int page) {
		//view.do?idx=???&page=???
		BoardVO vo = board_dao.selectOne(idx);
		
		//한 번 클릭할 때마다 조회수가 1씩 증가(but, F5를 눌렀을 때 조회수 증가는 막아야 함)
		//조회 수 증가
		HttpSession session = request.getSession();
		String show = (String)session.getAttribute("show");
		
		if(show == null) {
			int res = board_dao.update_readhit(idx);
			session.setAttribute("show", "no_show");
		}
		
		model.addAttribute("vo", vo);
		
		return Common.VIEW_PATH + "board_view.jsp?page=" + page;
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		return Common.VIEW_PATH + "insert_form.jsp";
	}
	
	//새 글 추가하기
	@RequestMapping("insert.do")
	public String insert(BoardVO vo) {
		String ip = request.getRemoteAddr(); //ip 받기
		vo.setIp(ip);
		
		int res = board_dao.insert(vo);
		
		if (res > 0) {
			return "redirect:board_list.do";			
		}
		
		return null;
	}
	
	//글 삭제하기
	@RequestMapping("del.do")
	@ResponseBody
	public String delete(int idx) {
		BoardVO baseVO = board_dao.selectOne(idx);
		
		baseVO.setName("unknown");
		baseVO.setSubject("이미 삭제된 글입니다.");
		
		int res = board_dao.del_update(baseVO);
		
		if (res > 0) {
			return "[{'result' : 'yes'}]";
		}
		
		return "[{'result' : 'no'}]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

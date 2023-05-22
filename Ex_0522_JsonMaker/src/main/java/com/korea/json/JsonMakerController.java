package com.korea.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVO;

@Controller
public class JsonMakerController {
	//Ajax로 값을 돌려줄 때 반환형을 잘 써야한다.
	
	//vo가 알아서 json형태로 바뀌어서 반환
	@RequestMapping("vo_to_json")
	@ResponseBody //Ajax를 써서 넘어왔다.
	public PersonVO voJson() {
		PersonVO vo = new PersonVO();
		vo.setName("홍길동");
		vo.setAddr("인천시 부평구");
		vo.setAge(30);
		
		return vo;
	}
	
	@RequestMapping("map_to_json")
	@ResponseBody
	public HashMap<String, Object> mapJson() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "홍길동");
		map.put("age", 20);
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("home", "032-1111-1111");
		map2.put("cell", "010-2222-2222");
		
		map.put("tel", map2); //map 안에 map을 넣은 형태
		
		return map;
	}
	
	//map의 결과: {"name":"홍길동","tel":{"cell":"010-2222-2222","home":"032-1111-1111"},"age":20}
	//json.tel.home.value = "032-1111-1111"
	
	@RequestMapping("list_to_json")
	@ResponseBody
	public List<PersonVO> listJson() {
		List<PersonVO> list = new ArrayList<PersonVO>();
		
		PersonVO p1 = new PersonVO();
		p1.setName("홍길동");
		p1.setAddr("인천시 부평구");
		p1.setAge(30);
		
		PersonVO p2 = new PersonVO();
		p2.setName("김길동");
		p2.setAddr("서울시 강북구");
		p2.setAge(40);
		
		list.add(p1);
		list.add(p2);
		
		return list;
	}
	
	//list의 결과: [{"name":"홍길동","addr":"인천시 부평구","age":30},{"name":"김길동","addr":"서울시 강북구","age":40}]
	//json배열로 이루어짐 -> json[1].name = "김길동"
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 

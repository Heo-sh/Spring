package com.korea.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {
	
	//자동주입 == 필드주입
	//sessin, application, request와 같은 jsp, servlet에서 제공을 해주는 객체이기 때문에
	//스프링에서도 지원을 한다.
	//jsp에서 Servlet을 지원해주는 객체를 따로 생성해주는 과정 없이 자동으로 만들어 주는 어노테이션
	//무조건은 아니지만 코드를 조금만 손보면 원하는 객체를 다 만들 수 있다.
	//ServletContext에서 수동으로 Bean객체를 만들어 사용도 가능
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext application;
	
	static final String VIEW_PATH = "/WEB-INF/views/"; //경로
	
	@RequestMapping(value = {"/", "insert_form.do"})
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}
	
	@RequestMapping("upload.do")
	public String upload(PhotoVO vo) {
		//jsp에서 넘어오는 PhotoVO vo에는 title과 이미지에 대한 정보만 넘어온다.
		
		//우선 지정한 경로에 파일이 잘 업로드 되는 지 확인하기
		//String savePath = "c:/myupload"; //c드라이브 안에 myupload 폴더
		String webPath = "resources/upload/";
		//String savePath = request.getServletContext().getRealPath(webPath); //절대경로
		String savePath = application.getRealPath(webPath); //절대경로
		System.out.println(savePath);
		
		
		//업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";

		//!photo.isEmpty(): photo객체에 내용이 뭐라도 들어있다.
		if (!photo.isEmpty()) {
			//실제 넘어온 파일의 이름을 준비해둔 filename 변수에 넣어준다.
							//getOriginalFilename(): 업로드된 실제 파일명
			filename = photo.getOriginalFilename();
			
			//파일을 저장할 경로를 설정
			File saveFile = new File(savePath, filename);
			
			if (!saveFile.exists()) { //1.경로가 없다면
				//2.폴더를 만들어라
				saveFile.mkdirs(); //s는 영어로 복수, 한개를 만드냐 여러개의 파일을 만드냐의 차이. 하지만 폴더를 하나만 만들더라도 s를 무조건 붙이는 게 좋다.
				//파일일지라도 폴더로 만들어진다.
			} else {
				//동일한 이름의 파일일 경우 폴더형태로 변환이 불가하므로
				//업로드한 시간을 붙여서 이름이 중복되는 것을 방지
				
									//자바가 만들어진 1970년부터 2023 현재까지의 시간을 1000분의 1초로 저장을 한다.
				long time = System.currentTimeMillis();
				
										//날짜_파일이름
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			//물리적으로 파일을 업로드하는 코드
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		//vo.getPhoto();로 얻어온 파일정보에서 파일이름을 뽑아서 넣어주자.
		//PhotoVO까지 jsp에서 넘어온 파일의 실제 파일이름을 보내준다.
		vo.setFilename(filename);
		
		//실제파일 이름이 잘 넘어오는지 확인해봄
		//System.out.println(filename);
		
		//바인딩
		request.setAttribute("vo", vo);
		
		//포워딩
		return VIEW_PATH + "insert_result.jsp";
	}
}

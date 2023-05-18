package vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhotoVO {
	//jsp에서 넘어오는 title, photo
	private String title; //보내는 자가 설정한 제목(이름)
	private MultipartFile photo; //사진이든 동영상이든 일단 넘어온 미디어의 실제 정보
	private String filename; //넘어온 미디어의 실제 이름(실제 파일 제목)
}

package vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VisitVO {
	private int idx;
	private String name, content, pwd, ip, regdate, filename;
	private MultipartFile photo; //실제 파일의 이름을 가져오기 위한 수단에 불과함
}

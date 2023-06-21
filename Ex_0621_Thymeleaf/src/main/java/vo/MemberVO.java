package vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private int memNo;
	private String memId;
	private String memNm;
	private LocalDateTime regDt; //등록 날짜
	private LocalDateTime modDt; //수정 날짜
}

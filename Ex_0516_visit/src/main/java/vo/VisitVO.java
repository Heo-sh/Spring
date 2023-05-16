package vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VisitVO {
	private int idx;
	private String name, content, pwd, ip, regdate;
}

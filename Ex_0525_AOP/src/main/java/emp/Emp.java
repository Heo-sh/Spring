package emp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Emp {
	private String empno;
	private String ename;
	
	public Emp(String empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	}
}

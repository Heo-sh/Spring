package emp;

import java.util.ArrayList;
import java.util.List;

public class EmpManager {
	List<Emp> emps = new ArrayList<Emp>();
	 
	public List<Emp> getAllEmps() {
		System.out.println("[Target Method] get AllEmps() called...");
		return emps;
	}
	
	public void setEmp(Emp e) {
		emps.add(e);
	}
}

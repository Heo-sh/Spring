package emp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Emptest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Context_5_AOP.class);
		
		//Context_5_AOP 클래스 내부의 empManager() 메서드
		EmpManager manager = (EmpManager)context.getBean("empManager"); //EmpManger 클래스의 객체
		
		manager.setEmp(new Emp("1", "홍길동"));
		manager.setEmp(new Emp("2", "정종철"));
		
		List<Emp> emps = manager.getAllEmps();
		System.out.println(emps);
	}
}

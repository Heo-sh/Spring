package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Advice {
	//advice: 공통 기능
	//공통기능이 담긴 클래스
	
	//실제 advice가 적용될 지점
						//dao 패키지에 있는 *클래스의 모든 메서드의 parameter
	@Pointcut("execution(* dao.*DAO.*(..))") //일종의 정규식
	public void myPoint() {
		
	}
	
	//myPoint가 실행되기 전에 before 메서드 실행
	@Before("myPoint()") //JoinPoint는 aspectj.lang
	public void before(JoinPoint jp) {
		//핵심 기능 이전에 실행되는지 확인 하기 위해
		//jp.getSignature(): 타겟으로 삼고있는 메서드의 정보를 반환
		System.out.println("--before: " + jp.getSignature());
		//console 반환: --before: void dao.TestDAO.test()
	}
	
	@After("myPoint()")
	public void after(JoinPoint jp) {
		//jp.toLongString(): 타겟으로 삼은 메서드를 완전하게 표현한 메서드(메서드의 리턴타입, 파라미터 타입을 표기)
		System.out.println("--after: " + jp.toLongString());
		//console 반환: --after: execution(public void dao.TestDAO.test())
	}
}

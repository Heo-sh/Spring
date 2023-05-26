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
	
	long start; //시작 시간을 담을 변수
	
	//실제 advice가 적용될 지점
						//dao 패키지에 있는 *클래스의 모든 메서드의 parameter(0개 이상)
	@Pointcut("execution(* dao.*DAO.*(..))") //일종의 정규식
	public void myPoint() {
		
	} //console 반환: --call TestDAO.test()--
	
	//myPoint(타겟 메서드)가 실행되기 전에 before 메서드 실행
	@Before("myPoint()") //JoinPoint는 aspectj.lang, pointcut이 걸린 위치의 정보를 받는 클래스
	public void before(JoinPoint jp) {
		//핵심 기능 이전에 실행되는지 확인 하기 위해
		//jp.getSignature(): 타겟으로 삼고있는 메서드의 정보를 반환
		//System.out.println("--before: " + jp.getSignature());
		//console 반환: --before: void dao.TestDAO.test()
		
		//before()가 호출됐을 때의 시간
		start = System.currentTimeMillis();
	}
	
	@After("myPoint()") //타겟 메서드가 실행되고 나서
	public void after(JoinPoint jp) {
		//jp.toLongString(): 타겟으로 삼은 메서드를 완전하게 표현한 메서드(메서드의 리턴타입, 파라미터 타입을 표기)
		//System.out.println("--after: " + jp.toLongString());
		//console 반환: --after: execution(public void dao.TestDAO.test())
		
		//after()가 호출됐을 때의 시간
		long end = System.currentTimeMillis();
		System.out.printf("[수행시간]: %d(ms)\n", end - start);
		
		//응용방법의 예로, 로그인한 유저의 시간을 파악할 수 있다.
	}
}

package emp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpLoggingAspect {
	
	@Before("execution(* emp.EmpManager.get*(..))")
	public void before(JoinPoint jp) {				//핵심정보에서 이름을 반환하라
		System.out.println(">>> before advice: " + jp.getSignature().getName());
	}
	//>>> before advice: getAllEmps
	
	//@Around: 핵심 메서드가 실행되기 전, return된 후 around메서드가 적용된다.
	@Around("execution(* emp.EmpManager.get*(..))")		//try catch 역할을 한다.
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">>> around advice[전]: " + pjp.getSignature().getName());
		
		Object o = pjp.proceed();
		
		System.out.println(">>> around advice[후]: " + pjp.getSignature().getName());
		
		return o;
	}
//	>>> around advice[전]: getAllEmps
//	>>> around advice[후]: getAllEmps

	
	//@AfterReturning: 어노테이션을 사용하며 포인트컷 메서드가 정상종료된 후 적용된다.
	@AfterReturning(pointcut = "execution(* emp.EmpManager.*(..))", returning = "retVal")
	public void afterReturning(JoinPoint jp, Object retVal) {
		System.out.println(">>> afterReturning advice: " + jp.getSignature().getName());
		
		System.out.println(">>> afterReturning advice return value is " + retVal);
	}
	
	//>>> afterReturning advice: setEmp
	//>>> afterReturning advice return value is null
//	>>> afterReturning advice: getAllEmps
//	>>> afterReturning advice return value is [Emp [empno=1, ename=홍길동], Emp [empno=2, ename=정종철]]
//	[Emp [empno=1, ename=홍길동], Emp [empno=2, ename=정종철]]
	
	//@AfterThrowing: 포인트컷 메서드에서 예외가 발생할 때 적용
	@AfterThrowing(pointcut = "execution(* emp.EmpManager.*(..))", throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println(">>> afterThrowing advice: " + ex);
	}
}

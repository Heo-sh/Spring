package emp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Context_5_AOP {
	
	@Bean
	public EmpManager empManager() {
		return new EmpManager();
	}
	
	@Bean
	public EmpLoggingAspect loggingAspect() {
		return new EmpLoggingAspect();
	}
}

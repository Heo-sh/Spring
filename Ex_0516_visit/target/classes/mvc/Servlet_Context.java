package mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.korea.visit.VisitController;
import com.korea.visit.VisitJsonController;

import dao.VisitDAO;


@Configuration
@EnableWebMvc
//@ComponentScan("com.korea.visit")
//어노테이션에도 상속관계가 있다
/*
 *@Component
 *	ㄴ@Controller
 *	ㄴ@Service
 *	ㄴ@Repository 
 * */
//컴포넌트의 자식객체가 들어있으면 사실 Controller가 아니어도 만들어 질 수 있다.
public class Servlet_Context implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
//	  @Bean 
//	  public InternalResourceViewResolver resolver() {
//	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	  resolver.setViewClass(JstlView.class); resolver.setPrefix("/WEB-INF/views/");
//	  resolver.setSuffix(".jsp"); return resolver; }
	
	
//	@Bean
//	public SawonController sawonController(SawonDAO sawon_dao) {
//		SawonController = new SawonController();
//		sawonController.setSawon_dao(sawon_dao);
//		return sawonController;
//	} //setter 주입
	
	@Bean
	public VisitController visitController(VisitDAO visit_dao) {
		return new VisitController(visit_dao);
	}
	
//	@Bean
//	public VisitJsonController visitJsonController(VisitDAO visit_dao) {
//		return new VisitJsonController(visit_dao);
//	}
}

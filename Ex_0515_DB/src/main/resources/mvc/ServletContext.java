package mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kore.test.GogekController;
import com.kore.test.SawonController;
import com.kore.test.SungtbController;

import dao.GogekDAO;
import dao.SawonDAO;
import dao.SungtbDAO;


@Configuration
@EnableWebMvc
//@ComponentScan("com.korea.db")
//어노테이션에도 상속관계가 있다
/*
 *@Component
 *	ㄴ@Controller
 *	ㄴ@Service
 *	ㄴ@Repository 
 * */
//컴포넌트의 자식객체가 들어있으면 사실 Controller가 아니어도 만들어 질 수 있다.
public class ServletContext implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
//	  @Bean 
//	  public InternalResourceViewResolver resolver() {
//	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	  resolver.setViewClass(JstlView.class); resolver.setPrefix("/WEB-INF/views/");
//	  resolver.setSuffix(".jsp"); return resolver; }
	
	@Bean
	public SawonController sawonController(SawonDAO sawon_dao) {
		return new SawonController(sawon_dao);
	} //생성자로 주입을 하는 법
	
//	@Bean
//	public SawonController sawonController(SawonDAO sawon_dao) {
//		SawonController = new SawonController();
//		sawonController.setSawon_dao(sawon_dao);
//		return sawonController;
//	} //setter 주입
	
	@Bean
	public GogekController gogekController(GogekDAO gogek_dao) {
		GogekController gogekController = new GogekController();
		gogekController.setGogek_dao(gogek_dao);
		return gogekController;
	}
	
	@Bean
	public SungtbController sungtbController(SungtbDAO sungtb_dao) {
		return new SungtbController(sungtb_dao);
	}
	
}

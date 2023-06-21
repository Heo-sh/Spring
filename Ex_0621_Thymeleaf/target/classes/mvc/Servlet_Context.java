package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.korea.thyme.ThymeController;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;


@Configuration
@EnableWebMvc
//자동탐색
//@ComponentScan("com.korea.bbs")
//@ComponentScan(basePackages = {"controller", "dao"})
//컨트롤러 뿐만 아니라 Component의 자식요소를 전부 탐색해서 객체로 만들어 준다.
//자동 생성으로 객체를 생성하면 setter, 생성자 injection으로 sqlSession을 받을 수 없다.
//어노테이션에도 상속관계가 있다
/*
 *@Component
 *	ㄴ@Controller
 *	ㄴ@Service
 *	ㄴ@Repository 
 * */
//컴포넌트의 자식객체가 들어있으면 사실 Controller가 아니어도 만들어 질 수 있다.
public class Servlet_Context implements WebMvcConfigurer {
	
	@Autowired
	ApplicationContext applicationContext; //Spring을 통해서 만들어진 객체들 누가 요청을 할 때 이미 만들어진 Bean 객체를 꺼내와서 주입해주는 역할
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		//폴더별 관리를 하려면 setPrefix와 setSuffix를 주석처리해주면 된다.
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false); //캐시 사용을 할 것인지를 정하는 코드(사용하면 HTML 수정 시 서버를 재기동해야 함)
		return templateResolver;
	}
	
	//Thymeleaf의 templateEngine(jsp냐, tempateEngine이냐) 설정, template file을 읽어올 때 선언한 TemplateResolver를 사용한다. 
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(templateResolver());
		springTemplateEngine.setEnableSpringELCompiler(true); //EL표기법을 사용할 것 인지를 정하는 코드
		//mvn에서 가져온 라이브러리들을 사용하기 위해선 이렇게 추가해줘야 한다.
		springTemplateEngine.addDialect(new Java8TimeDialect()); //Java8의 시간타입을 지원하기 위한 Dialect 추가
		springTemplateEngine.addDialect(new LayoutDialect()); //Layout 추가 기능 추가하기
		return springTemplateEngine;
	}
	
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setContentType("text/html");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateEngine(templateEngine()); //templateEngine 호출
		return resolver;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(thymeleafViewResolver());
	}
//	  @Bean 
//	  public InternalResourceViewResolver resolver() {
//	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	  resolver.setViewClass(JstlView.class); resolver.setPrefix("/WEB-INF/views/");
//	  resolver.setSuffix(".jsp"); return resolver; }

	@Bean
	public ThymeController thymeContorller() {
		return new ThymeController();
	}
}










































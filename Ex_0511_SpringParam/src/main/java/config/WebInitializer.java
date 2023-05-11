package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml역할을 하는 클래스
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootContext.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletContext.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	//filter
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter charaterEncodingFilter = new CharacterEncodingFilter();
		charaterEncodingFilter.setEncoding("UTF-8");
		charaterEncodingFilter.setForceEncoding(true);
		return new Filter[] {charaterEncodingFilter};
	}
	
	
	
	
	
	
}

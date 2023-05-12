package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import context.Context_1_dataSource;
import context.Context_2_mybatis;
import context.Context_3_dao;
import mvc.ServletContext;

//web.xml역할을 하는 클래스
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {Context_1_dataSource.class, 
							Context_2_mybatis.class, 
							Context_3_dao.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletContext.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	//filter: 모든 jsp파일을 utf-8로 인코딩하라는 코드
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter charaterEncodingFilter = new CharacterEncodingFilter();
		charaterEncodingFilter.setEncoding("UTF-8");
		charaterEncodingFilter.setForceEncoding(true);
		return new Filter[] {charaterEncodingFilter};
	}
	
	
	
	
	
	
}

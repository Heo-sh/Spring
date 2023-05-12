package context;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//bean객체를 여기서 만든다.
//Mybatis에 관련된 객체만 관리할 설정파일이다.
@Configuration
public class Context_2_mybatis {
	DataSource ds; //받아서 넣은 걸 넣고!
	
	public Context_2_mybatis(BasicDataSource ds) {
		this.ds = ds; //1에서 받아서 넣어주고
	} //생성자 주입
	
	@Bean
	public SqlSessionFactoryBean factoryBean() {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean().setDataSource(ds); //여기서 사용
		
		//Mybatis 설정파일 경로
		Resource configLocation = new ClassPathResource("config/mybatis/maybatis-config.xml");
		factoryBean.setConfigLocation(configLocation);
		
		return factoryBean;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factoryBean) {
		return new SqlSessionTemplate(factoryBean);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package context;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//Mybatis에 관련된 객체만 관리할 설정파일
@Configuration
public class Context_2_mybatis {
	
//	public Context_2_mybatis() {
//		// TODO Auto-generated constructor stub
//	} //생성자를 통해 DataSource ds를 받은 후 Bean객체에서 이용 가능
	
	@Bean
	public SqlSessionFactory factoryBean(DataSource ds) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds);
		
		// 추가적인 MyBatis 설정 -> 경로
        factoryBean.setConfigLocation(new ClassPathResource("config/mybatis/mybatis-config.xml"));
        return factoryBean.getObject();
  
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionBean(SqlSessionFactory factoryBean) {
		return new SqlSessionTemplate(factoryBean);
	}
}

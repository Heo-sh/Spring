package context;

import java.sql.Connection;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.DeptDAO;

//DAO에 관련된 객체만 관리할 설정파일
@Configuration
public class Context_3_dao {

	

	@Bean
	public DeptDAO dept_dao(SqlSession sqlSession) {
		DeptDAO dept_dao = new DeptDAO();
		dept_dao.setSqlSession(sqlSession);
		return dept_dao;
	}
}

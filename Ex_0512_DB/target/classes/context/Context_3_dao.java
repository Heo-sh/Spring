package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.DeptDAO;

//bean객체를 여기서 만든다.
//DAO에 관련된 객체만 관리할 설정파일이다.
@Configuration
public class Context_3_dao {
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession; //Context_2_mybatis의 SqlSessionTemplate Bean객체
	}
	
	@Bean
	public DeptDAO dept_dao() {
		DeptDAO dao = new DeptDAO();
		dao.setSqlSession(sqlSession);
		return dao;
	}
	
} 

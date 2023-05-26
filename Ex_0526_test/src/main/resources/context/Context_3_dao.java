package context;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import dao.DeptDAO;
import vo.DeptVO;

//DAO에 관련된 객체만 관리할 설정파일
@Configuration
//Spring이 자동으로 개발자의 메소드를 호출하기 전에 가로챌 수 있게 하는 옵션
@EnableAspectJAutoProxy
public class Context_3_dao {

	@Bean
	public DeptDAO dept_dao(SqlSession sqlSession) {
		return new DeptDAO(sqlSession);
	}
}

package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.BoardDAO;

//DAO에 관련된 객체만 관리할 설정파일
@Configuration
public class Context_3_dao {
	
	@Bean
	public BoardDAO board_dao(SqlSession sqlSession) {
		return new BoardDAO(sqlSession);
	}
	
}

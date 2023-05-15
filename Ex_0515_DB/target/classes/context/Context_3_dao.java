package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.GogekDAO;
import dao.SawonDAO;
import dao.SungtbDAO;

//DAO에 관련된 객체만 관리할 설정파일
@Configuration
public class Context_3_dao {
	
	@Bean
	public SawonDAO sawon_dao(SqlSession sqlSession) {
		SawonDAO sawon_dao = new SawonDAO();
		sawon_dao.setSqlSession(sqlSession);
		return sawon_dao;
	}
	
	@Bean
	public GogekDAO gogek_dao(SqlSession sqlSession) {
		GogekDAO gogek_dao = new GogekDAO();
		gogek_dao.setSqlSession(sqlSession);
		return gogek_dao;
	}
	
	@Bean
	public SungtbDAO sungtb_dao(SqlSession sqlSession) {
		SungtbDAO sungtb_dao = new SungtbDAO();
		sungtb_dao.setSqlSession(sqlSession);
		return sungtb_dao;
	}
}

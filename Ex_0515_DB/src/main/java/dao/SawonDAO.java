package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVO;

public class SawonDAO {
	//Spring에는 jsp에서 썻던 singleton이 내장이 되어있어
	//db 연결해주는 Bean객체만 잘 생성이 되어있다면
	//호풀만 해서 DB 연결이 가능하다.
	
	SqlSession sqlSession;
	
	//생성자 주입
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	} //Context2에서 SqlSession을 받아온다.
	
	//DB-사원테이블 조회
	public List<SawonVO> selectList() {
		List<SawonVO> list = sqlSession.selectList("sawon.sawon_list");
		return list;
	}
}

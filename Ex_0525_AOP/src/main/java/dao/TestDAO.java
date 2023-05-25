package dao;

import org.apache.ibatis.session.SqlSession;

public class TestDAO {
	SqlSession sqlSession;
	
	public TestDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void test() { //이 메서드가 target
		System.out.println("--call TestDAO.test()--");
	}
}

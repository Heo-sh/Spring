package dao;

import org.apache.ibatis.session.SqlSession;

public class TestDAO {
	SqlSession sqlSession;
	
	public TestDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void test() { //이 메서드가 target
		System.out.println("--call TestDAO.test()--");
		
		//test()메서드의 수행 시간을 Advice에서 캐치할 예정
		//메서드 한 개를 호출하는 시간은 사실 상 0초에 가깝기 때문에
		//임의로 딜레이를 주기 위해서 sleep을 추가
		try {
			Thread.sleep(1000); //1000: 1초
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

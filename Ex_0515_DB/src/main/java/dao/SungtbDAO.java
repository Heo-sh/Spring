package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SungtbVO;

public class SungtbDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	public List<SungtbVO> selectList() {
		List<SungtbVO> list = sqlSession.selectList("s.sungtb_list");
		return list;
	}
	
}

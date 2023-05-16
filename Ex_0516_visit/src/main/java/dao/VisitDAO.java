package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	SqlSession sqlSession;
	
	public VisitDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
    //방명록 전체 조회
	public List<VisitVO> selectList(){
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}

	//방명록에 새글 추가하기
	public int insert(VisitVO vo) {
		int res = sqlSession.insert("v.visit_insert", vo);
		return res;
	}
	
}

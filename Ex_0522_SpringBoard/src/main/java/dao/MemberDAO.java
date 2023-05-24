package dao;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {
	SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//DB에 아이디가 있는지 검증
	public MemberVO loginCheck(String id) {
		MemberVO vo = sqlSession.selectOne("m.loginCheck", id);
		return vo;
	}
	
}

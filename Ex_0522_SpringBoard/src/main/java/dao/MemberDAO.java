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
	
	//id중복체트
	public int check_id(String id) {
		int res = sqlSession.selectOne("m.check_id", id);
		return res;
	}
	
	//실제 회원가입(DB에 저장)
	public int insert(MemberVO vo) {
		int res = sqlSession.insert("m.member_insert", vo);
		return res;
	}
}

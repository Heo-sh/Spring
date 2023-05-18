package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	
	SqlSession sqlSession; //db에 접속하는 객체
	
	public VisitDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	} //파라미터를 받는 생성자
	
    //방명록 전체 조회(조회가 되는 데이터가 여러 개)
	public List<VisitVO> selectList(){
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}

	//방명록에 새글 추가하기(추가된 행 수 만큼 정수로 반환)
	public int insert(VisitVO vo) {
		int res = sqlSession.insert("v.visit_insert", vo);
		return res;
	}
	
	//글 삭제하기(삭제된 행 수만큼 정수로 반환)
	public int delete(Map<String, Object> map) {
		//mapper로 parameter를 보낼 때는 무조건 하나만 보낼 수 밖에 없기에
		//map을 통해서 묶어서 mapper로 보낸다.
		int res = sqlSession.delete("v.visit_delete", map);
		return res;
	}
	
	//수정을 위한 게시글 한 건 조회하기
	public VisitVO selectOne(int idx) {
		VisitVO vo = sqlSession.selectOne("v.visit_one", idx);
		return vo;
	}
	
	//if, 메서드를 만들 때 반환형을 모르겠으면,
	//접근제한자와 메서드명을 먼저 만들고, 안에서 무슨 내용을 할 지 먼저 써봐라.
	//그러면 어떤 파라미터로 해야하는 지 반환형을 결정할 수 있다.
//	public selectOne() {
//		sqlSession.selectOne(null, sqlSession)
//	}
	
	//글 수정하기(수정된 행 개수만큼 정수로 반환)
	public int update(VisitVO vo) {
		int res = sqlSession.update("v.visit_update", vo);
		return res;
	}
}

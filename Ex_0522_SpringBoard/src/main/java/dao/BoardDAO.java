package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import vo.BoardVO;

public class BoardDAO {

	SqlSession sqlSession;
	
	public BoardDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//1. 페이지별 게시글 조회
	public List<BoardVO> selectList(Map<String, Integer> map) {
		List<BoardVO> list = sqlSession.selectList("b.board_list", map);
		
		return list;
	}
	
	//전체 게시물 수 조회
	public int getRowTotal() {
		int res = sqlSession.selectOne("b.board_count");
		
		return res;
	}
	
	
}

package service;

import java.util.List;

import dao.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {

	BoardDAOImpl dao;
	
	//root-context로부터 dao의 정보를 받아옴
	public BoardServiceImpl(BoardDAOImpl dao) {
		this.dao = dao;
	} //생성자 -> 언제 호출되는가? -> 객체가 생성될 때 -> 생성되는 곳: root-context.xml
	
	@Override
	public List<Object> selectList() {
		return dao.selectList();
	}
	
}

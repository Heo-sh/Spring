package dao;

import java.util.List;

//interface : 추상메서드 밖에 들어갈 수 없다.
public interface BoardDAO {
	//DB와 연동하여 CRUD기능을 가지고 있다.
	public int insert(Object ob);
	
	public List<Object> selectList();
	
	public int update(Object ob);
	
	public int delete(int idx);
}

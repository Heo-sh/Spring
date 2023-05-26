package com.korea.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import context.Context_1_dataSource;
import context.Context_2_mybatis;
import context.Context_3_dao;
import dao.DeptDAO;
import lombok.extern.log4j.Log4j;
import vo.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Context_1_dataSource.class, Context_2_mybatis.class, Context_3_dao.class})
@Log4j
public class DeptTest {
	@Autowired
	private DeptDAO dept_dao;
	
	@Test
	public void getListTest() {
								//람다식
		dept_dao.selectList().forEach(log::info);;
		
//		List<DeptVO> list = dept_dao.selectList();
//		
//		//향상된 for문
//		for(DeptVO vo : list) {
//			System.out.printf("%d / %s / %s\n", vo.getDeptno(), vo.getDname(), vo.getLoc());
//		}
		
		/* -- return to console --
		 * INFO : jdbc.connection - 1. Connection opened INFO : jdbc.audit - 1.
		 * Connection.new Connection returned INFO : jdbc.audit - 1.
		 * Connection.isClosed() returned false INFO : jdbc.audit - 1.
		 * Connection.getAutoCommit() returned true INFO : jdbc.audit - 1.
		 * Connection.isClosed() returned false INFO : jdbc.audit - 1.
		 * Connection.getAutoCommit() returned true INFO : jdbc.audit - 1.
		 * Connection.clearWarnings() returned INFO : jdbc.audit - 1.
		 * Connection.getAutoCommit() returned true INFO : jdbc.connection - 1.
		 * Connection closed INFO : jdbc.audit - 1. Connection.close() returned INFO :
		 * jdbc.connection - 2. Connection opened INFO : jdbc.audit - 2. Connection.new
		 * Connection returned INFO : jdbc.audit - 2. Connection.isClosed() returned
		 * false INFO : jdbc.audit - 2. Connection.getAutoCommit() returned true INFO :
		 * jdbc.audit - 2. Connection.getAutoCommit() returned true INFO : jdbc.audit -
		 * 2. PreparedStatement.new PreparedStatement returned INFO : jdbc.audit - 2.
		 * Connection.prepareStatement(select * from dept) returned
		 * net.sf.log4jdbc.sql.jdbcapi.PreparedStatementSpy@44c5a16f INFO : jdbc.sqlonly
		 * - select * from dept
		 * 
		 * INFO : jdbc.sqltiming - select * from dept {executed in 15 msec} INFO :
		 * jdbc.audit - 2. PreparedStatement.execute() returned true INFO :
		 * jdbc.resultset - 2. ResultSet.new ResultSet returned INFO : jdbc.audit - 2.
		 * PreparedStatement.getResultSet() returned
		 * net.sf.log4jdbc.sql.jdbcapi.ResultSetSpy@40ee0a22 INFO : jdbc.resultset - 2.
		 * ResultSet.getMetaData() returned
		 * oracle.jdbc.driver.OracleResultSetMetaData@562c877a INFO : jdbc.resultset -
		 * 2. ResultSet.getType() returned 1003 INFO : jdbc.resultset - 2.
		 * ResultSet.next() returned true INFO : jdbc.resultset - 2.
		 * ResultSet.getInt(DEPTNO) returned 10 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(DNAME) returned 총무부 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(LOC) returned 101 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.next() returned true INFO : jdbc.resultset - 2.
		 * ResultSet.getInt(DEPTNO) returned 20 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(DNAME) returned 영업부 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(LOC) returned 202 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.next() returned true INFO : jdbc.resultset - 2.
		 * ResultSet.getInt(DEPTNO) returned 30 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(DNAME) returned 전산실 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(LOC) returned 303 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.next() returned true INFO : jdbc.resultset - 2.
		 * ResultSet.getInt(DEPTNO) returned 40 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(DNAME) returned 관리부 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(LOC) returned 404 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.next() returned true INFO : jdbc.resultset - 2.
		 * ResultSet.getInt(DEPTNO) returned 50 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(DNAME) returned 경리부 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultset - 2.
		 * ResultSet.getString(LOC) returned 505 INFO : jdbc.resultset - 2.
		 * ResultSet.wasNull() returned false INFO : jdbc.resultsettable -
		 * |deptno |dname|loc  
		 * |10     |총무부 |101 | 
		 * |20     |영업부 |202 | 
		 * |30     |전산실 |303 | 
		 * |40     |관리부 |404 | 
		 * |50     |경리부 |505 |
		 * |-------|-----|----|
		 * 
		 * INFO : jdbc.resultset - 2. ResultSet.next() returned false INFO :
		 * jdbc.resultset - 2. ResultSet.close() returned void INFO : jdbc.audit - 2.
		 * Connection.getMetaData() returned
		 * oracle.jdbc.driver.OracleDatabaseMetaData@22d1886d INFO : jdbc.audit - 2.
		 * PreparedStatement.close() returned INFO : jdbc.audit - 2.
		 * Connection.isClosed() returned false INFO : jdbc.audit - 2.
		 * Connection.getAutoCommit() returned true INFO : jdbc.audit - 2.
		 * Connection.clearWarnings() returned INFO : jdbc.audit - 2.
		 * Connection.getAutoCommit() returned true 10 / 총무부 / 101 20 / 영업부 / 202 30 /
		 * 전산실 / 303 40 / 관리부 / 404 50 / 경리부 / 505 INFO : jdbc.connection - 2.
		 * Connection closed INFO : jdbc.audit - 2. Connection.close() returned
		 */
		
	}
}

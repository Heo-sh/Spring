package com.korea.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import context.Context_1_dataSource;
import lombok.extern.log4j.Log4j;

//JUnit 프레임워크의 테스트 실행방법을 확장할 때 사용하는 어노테이션
//톰캣 대신에 스프링에 접근할 수 있게 해준다.
@RunWith(SpringJUnit4ClassRunner.class)

//설정파일을 읽어야 하는데, 설정파일을 로드해주는 어노테이션
@ContextConfiguration(classes = {Context_1_dataSource.class})

//log 객체를 생성
@Log4j
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	//test하고자 하는 코드에 @Test를 붙인다.
	@Test
	public void testConnection(){
		try {
			Connection connection = dataSource.getConnection();
			log.info(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//javaVersion과 xml에 넣은 spring-test의 버전이 달라서 일어난 오류
	//버전 확인을 잘하자!
	//java.lang.NoClassDefFoundError: org/springframework/core/annotation/MergedAnnotations

}

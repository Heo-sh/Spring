<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>고객번호</th>
				<th>고객이름</th>
				<th>고객주소</th>
				<th>주민번호</th>
				<th>담당자번호</th>
			</tr>
			<c:forEach var="g" items="${list}">
				<tr>
					<td>${g.gobun}</td>
					<td>${g.goname}</td>
					<td>${g.goaddr}</td>
					<td>${g.gojumin}</td>
					<td>${g.godam}</td>
				</tr>	
			</c:forEach>
		</table>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국</th>
			<th>영</th>
			<th>수</th>
		</tr>
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.no}</td>
				<td>${s.name}</td>
				<td>${s.kor}</td>
				<td>${s.eng}</td>
				<td>${s.mat}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
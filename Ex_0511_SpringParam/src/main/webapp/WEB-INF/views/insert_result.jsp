<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<ul style="border: 1px solid black">
			<li style="list-style: none">${vo.name}</li>			
			<li style="list-style: none">${vo.age}</li>			
			<li style="list-style: none">${vo.tel}</li>			
		</ul>
	</body>
</html>
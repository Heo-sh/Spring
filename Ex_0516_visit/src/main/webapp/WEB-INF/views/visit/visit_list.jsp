<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- webapp폴더까지의 경로 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/visit.css">
	</head>
	<body>
		<div id="main_box" align="right">
				<h1>방명록 리스트</h1>					<!-- 스프링에서는 jsp에서 jsp로 이동불가 -->
				<input type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		<c:forEach var="vo" items="${list}">
			<div class="visit_box">
				<div class="type_content">
					${vo.content}
				</div>
				<div class="type_name">
					작성자: ${vo.name}(${vo.ip})
				</div>
				<div class="type_regdate">
					작성일: ${vo.regdate}
				</div>
				<div>
					<form>
						<input type="hidden" name="idx" value="${vo.idx}">
						비밀번호 <input type="password" name="pwd">
						<input type="button" value="수정" onclick="modify(this.form)">
						<input type="button" value="삭제" onclick="del(this.form)">
					</form>
				</div>
			</div>
		</c:forEach>
	</body>
</html>
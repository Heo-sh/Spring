<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table {
				border-collapse: collapse;
			}
		</style>
	</head>
	<body>
		<table border="1" align="center" width="700">
			<tr>
				<td colspan="5">
					<img alt="" src="resources/img/title_04.gif">
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.idx}</td>
					<!-- 제목을 위한 코드 -->
					<td>
						<!-- 댓글의 깊이만큼 들여쓰기를 해라 -->
						<c:forEach begin="1" end="${vo.depth}">
							&nbsp;					
						</c:forEach>
						<!-- 댓글의 깊이가 0이 아니라면 ㄴ을 붙여라 -->
						<c:if test="${vo.depth ne 0 }">ㄴ</c:if>
						
						<!-- 삭제되지 않은 글이라면 클릭 가능 -->
						<c:if test="${vo.del_info ne -1}">
							<a href="view.do?idx=${vo.idx}&page=${param.page}" style="text-decoration: none">
								<font color="black">
									${vo.subject}
								</font>
							</a>
						</c:if>
						
						<!-- 삭제된 글은 클릭하지 못 하도록 처리 -->
						<c:if test="${vo.del_info eq -1}">
							<font color="gray">
									${vo.subject}
							</font>
						</c:if>
					</td>
					<td>${vo.name}</td>
					<td>${vo.regdate}</td>
					<td>${vo.readhit}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center">${pageMenu}</td>
			</tr>
			<tr>
				<td colspan="5" align="right">
					<img 
						src="resources/img/btn_reg.gif" 
						onclick="location.href='insert_form.do'"
						style="cursor:pointer"
					>
				</td>
			</tr>
		</table>
	</body>
</html>
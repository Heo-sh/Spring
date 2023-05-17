<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function send(f) {
				var idx = f.idx.value;
				var content = f.content.value;
				var pwd = f.pwd.value;
				
				if (!confirm("수정하시겠습니까?")) {
					return;
				}
				
				f.action = "modify.do";
				f.method = "POST";
				f.submit();
			}
		</script>
	</head>
	<body>
		<form>
			<!-- 수정할 때 어던 방명록 글에 할 것인지에 대한 식별자 -->
			<input type="hidden" name="idx" value="${vo.idx}">
			
			<table border="1" align="center">
				<caption>:::방명록 수정:::</caption>
				<tr>
					<th>작성자</th>
					<td>${vo.name}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea 
							rows="10" 
							cols="40" 
							name="content"
							style="resize: none;"
							warp="on"
						>
						${vo.content}
						</textarea>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pwd" value="${vo.pwd}">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="수정" onclick="send(this.form)">
						<input type="button" value="취소" onclick="location.href='visit_list.do'">
					</td>
				</tr>
			</table>
		</form>		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function send_check() {
				var f = document.f;
				
				//유효성 검사
				
				f.method = "GET";
				f.action = "insert.do";
				f.submit();
			}
		</script>
	</head>
	<body>
		<form name="f">
			<table border="1">
				<caption>:::새 글 쓰기:::</caption>
				<tr>
					<th>제목</th>
					<td>
						<input name="subject">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input name="name">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea 
							rows="10" 
							cols="50" 
							name="content"
							style="resize: none;"
						>
						</textarea>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pwd">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<img 
							src="resources/img/btn_reg.gif" 
							style="cursor: pointer;"
							onclick="send_check();"	
						>
						<img 
							src="resources/img/btn_back.gif" 
							style="cursor: pointer;"
							onclick="location.href='board_list.do'"
						>
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function send(f) {
				var name = f.name.value;
				var content = f.content.value.trim();
				var pwd = f.pwd.value;
				
				if (name == '') {
					alert("이름을 입력하세요");
					return;
				}
				if (content == '') {
					alert("내용을 입력하세요");
					return;
				}
				if (pwd == '') {
					alert("비밀번호를 입력하세요");
					return;
				}
				
				f.method = "GET";
				f.action = "insert.do";
				f.submit();
			}
		</script>
	</head>
	<body>
		<form>
			<table border="1" align="center"> 
				<caption>:::새 글 작성:::</caption>
				<tr>
					<th>작성자</th>
					<td>
						<input name="name" style="width: 300px">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<!-- wrap속성: on -> 끝에서 알아서 enter값이 적용 -->																
						<textarea 
							rows="10" 
							cols="40" 
							name="content" 
							style="resize: none;"
							wrap="on"
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
					<td colspan="2" align="center">
						<input type="button" value="등록하기" onclick="send(this.form)">
						<input type="button" value="취소하기" onclick="location.href='visit_list.do'">
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>
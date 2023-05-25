<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="resources/js/httpRequest.js"></script>
		<script type="text/javascript">
			function login(f) {
				var id = f.id.value.trim();
				var pw = f.pw.value.trim();
				
				//유효성 검사
				if (id == "") {
					alert("아이디를 입력하세요");
					return;
				} 
				
				if (pw == "") {
					alert("비밀번호를 입력하세요");
					return;
				} 
				
				var url = "login.do";
				var param = "id=" + id + "&pw=" + pw;
				
				sendRequest(url, param, myCheck, "POST");
			}
			
			function myCheck() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var data = xhr.responseText;
					var json = (new Function('return' + data))();
					
					if (json[0].result == 'no_id') {
						alert("아이디가 존재하지 않습니다.");
					} else if (json[0].result == 'no_pw') {
						alert("비밀번호가 일치하지 않습니다.");
					} else {
						alert("로그인 성공");
						location.href = "board_list.do";
					}
				}
			}
		</script>
	</head>
	<body>
		<form>
			<table border="1" align="center">
				<caption>:::Login:::</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input name="id">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input name="pw" type="password">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="로그인" onclick="login(this.form);">
						<input type="button" value="취소" onclick="location.href='board_list.do'">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="회원가입" onclick="location.href='member_insert_form.do'">
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="resources/js/httpRequest.js"></script>
		<script type="text/javascript">
			//중복을 눌러야만 가입이 가능하게 하기 위한 변수
			var b_idCheck = false;
			
			//아이디 중복 체크를 하기 위한 메서드
			function check_id() {
				var id = document.getElementById("id").value.trim();
				
				if (id == '') {
					alert("id를 입력하세요");
					return;
				}
				
				url = "check_id.do";
				param = "id=" + encodeURIComponent(id);
				
				sendRequest(url, param, resultFn, "POST");
			} //check_id()
			
			function resultFn() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var data = xhr.responseText;
					var json = (new Function('return' + data)());
					
					//id가 중복이라면
					if (json[0].result == 'no') {
						alert("중복된 id입니다.");
						return;
					} else { //id가 중복이 아니라면
						alert("사용가능한 id입니다.");
						b_idCheck = true;
						return;
					}
				}
			} //resultFn()
			
			function che() {
				b_idCheck = false;
			} //che()
			
			function send(f) {
				//입력내용 체크
				var id = f.id.value.trim();
				var pw = f.pw.value.trim();
				var name = f.name.value.trim();
				var email = f.email.value.trim();
				
				//유효성 검사
				if (pw == '') {
					alert("비밀번호 입력!");
					return;
				}
				
				//중복 체크 했는지 안 했는지
				if (!b_idCheck) {
					alert("아이디 중복 확인!");
					return;
				}
				
				f.action = "member_insert.do";
				f.method = "POST";
				f.submit();
				
			} //send(f)
		</script>
	</head>
	<body>
		<form>
			<table border="1" align="center">
				<caption>:::회원가입:::</caption>
				<tr>
					<th>아이디</th>
					<td>
						<!-- onchange: 글자가 한 글자라도 바뀌면 che() 메서드가 호출된다. -->
						<input 
							name="id" 
							id="id"
							placeholder="아이디"
							onchange="che()"
						>
						<input 
							type="button" 
							value="중복"
							onclick="check_id()"
						>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input name="pw" type="password" placeholder="비밀번호">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input name="name" placeholder="이름">
					</td>
				</tr>
				<tr>
					<th>email</th>
					<td>
						<input name="email" placeholder="example@example.com">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="가입" onclick="send(this.form)">
						<input type="button" value="취소" onclick="location.href='board_list.do'">
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>
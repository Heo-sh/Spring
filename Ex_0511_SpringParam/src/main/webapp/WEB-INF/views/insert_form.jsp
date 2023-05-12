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
				var age = f.age.value;
				var tel = f.tel.value;
				
				//유효성 검사
				if (name == '') {
					alert("이름을 입력하세요");
					return;
				}
				if (age == '') {
					alert("나이를 입력하세요");
					return;
				}
				if (tel == '') {
					alert("전화번호를 입력하세요");
					return;
				}
				
				f.action = "insert1.do"; //어디로 데이터를 보낼지
				f.method = "POST"; //어떻게 데이터를 보낼지
				f.submit(); //실제로 보내주는 메서드
			} //낱개로 받기
			
			function send2(f) {
				var name = f.name.value;
				var age = f.age.value;
				var tel = f.tel.value;
				
				//유효성 검사
				if (name == '') {
					alert("이름을 입력하세요");
					return;
				}
				if (age == '') {
					alert("나이를 입력하세요");
					return;
				}
				if (tel == '') {
					alert("전화번호를 입력하세요");
					return;
				}
				
				f.action = "insert2.do";
				f.method = "POST";
				f.submit();
			} //객체로 받기
		</script>
	</head>
	<body>
		<form>
			<table border="1" align="center">
				<caption>:::개인정보 입력:::</caption>
				<tr>
					<th>이름</th>
					<td>
						<input name="name">
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>
						<input name="age">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input name="tel">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input
							type="button"
							value="낱개로 받기"
							onclick="send(this.form)"
						>
						<input
							type="button"
							value="객체로 받기"
							onclick="send2(this.form)"
						>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
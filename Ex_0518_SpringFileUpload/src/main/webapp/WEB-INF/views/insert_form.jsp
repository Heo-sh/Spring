<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function send(f) {
				f.action = "upload.do";
				f.submit();
			}
		</script>
	</head>
	<body>
		<!-- 파일 업로드 코드시 method는 반드시 post, enctype="multipart/form-data"도 무조건 -->
		<form method="post" enctype="multipart/form-data">
			제목: <input name="title"><br>
			<!-- photo: 사진에 대한 정보(이름, 용량, etc...) -->
			사진: <input type="file" name="photo"><br>
			<input type="button" value="전송" onclick="send(this.form)">
		</form>
	</body>
</html>
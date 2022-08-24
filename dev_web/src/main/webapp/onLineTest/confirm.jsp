<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수험자 확인 및 시험 시작</title>
<script>
	function start() {
		location.href="q1.jsp";
	}
</script>
</head>
<body>
	수험자 확인 및 시험 시작
	<!-- 시작버튼을 눌렀을 때 1번문제로 이동 -->
	<input type="button" onclick="start()" value="시험시작">
</body>
</html>
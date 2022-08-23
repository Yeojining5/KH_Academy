<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제하기</title>
</head>
<body>
<%
	// 응답으로 내려보내야 한다
	Cookie cook1 = new Cookie("notebook","");
	cook1.setMaxAge(0); // 쿠키에 유효 기간을 0으로 설정 -> 삭제!
	response.addCookie(cook1);
	
%>
</body>
</html>
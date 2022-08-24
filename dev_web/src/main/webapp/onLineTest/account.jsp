<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 확인</title>
</head>
<body>
	판정 페이지 입니다.
<%
	// 이코드가 먼저 결정이 된다.
	String isPass = request.getParameter("isPass");
	boolean bpass = Boolean.parseBoolean(isPass);
	if(bpass) {
%>
		당신은 합격 입니다.
<% 
} else {
%>	
		당신은 불합격 입니다.
<%
	}
%>

 
</body>
</html>
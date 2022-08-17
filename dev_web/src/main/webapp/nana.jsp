<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String cnt_ = request.getParameter("cnt");

int cnt = 100; // 기본값
if(cnt_ != null && !cnt_.equals("")) // 널과 빈문자열이 아닐때 모두
	cnt = Integer.parseInt(cnt_);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	for(int i=0;i<cnt;i++) {
	%>
		안녕 Servlet!!<br>
	<% 
	}
	%>
</body>
</html>
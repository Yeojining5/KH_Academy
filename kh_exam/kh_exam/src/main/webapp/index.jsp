<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request와 session이 다른 점은 시간을 지원한다는 점
	String s_mem_name = (String)session.getAttribute("s_mem_name");
	out.print("세션에 담긴 이름 : "+s_mem_name);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
index페이지 입니다.
<%
	// s_mem_name이 null인 경우 index.jsp페이지는 절대로 볼 수 없다.
	// sendRedirect로 요청하면 페이지가 이동하고 URL도 변경 됨
	// 기존에 요청은 끊어지고 새로운 요청이 일어남
	//if(s_mem_name == null) response.sendRedirect("./loginForm.jsp");
	//else response.sendRedirect("./main.jsp");
%>
</body>
</html>
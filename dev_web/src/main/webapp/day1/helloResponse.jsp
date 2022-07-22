<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	out.print(name);
	out.print("<hr>");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>helloResponse.jsp</title>
</head>
<body>
hello.do요청에 대한 응답 페이지 입니다.<br>
요청이 유지되지 않아요<br>
주소창이 바뀌어 있어요<br>
</body>
</html>
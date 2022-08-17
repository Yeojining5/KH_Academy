<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!-- ------------MVC Model 1 ------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("result", "hello");
%>
<body>
	<%=request.getAttribute("result") %> 입니다
	result ==> ${requestScope.result} 입니다 <br>
	names[0] ==> ${names[0]}<br>
	names[1] ==> ${names[1]}<br>
	notice.title ==> ${notice.title}<br>
	notice.id ==> ${notice.id}<br>
	${result}<br> <!-- pageContext인 hello를 출력 -->
	
	
</body>
</html>
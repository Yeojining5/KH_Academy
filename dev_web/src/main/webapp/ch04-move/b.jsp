<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp 페이지</title>
</head>
<body>
<%!
	//디클러레이션
	int age = 10; //전역변수 선언
	public String getName() { // 메소드 선언 가능함 그러나 쓰지 않는다
		return "강감찬";
	}
%>
<%
	String r_name = (String)request.getAttribute("r_name");
	out.print(r_name);
%>
	1. 이 페이지는 a.jsp페이지 내에 출력됩니다.
	<br>
	2. 여기는 b.jsp페이지 내용입니다.

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, book.ch1.DeptVO, java.util.ArrayList" %>
<%
	// sendRedirect - 불가 (반드시 유지해야 하는 상황 - 쿠키, 세션)
	// forward - 가능 - 출력
	String s_name = (String)request.getAttribute("s_name");
	List<DeptVO> list = (List)request.getAttribute("list");
	out.print("서버에서 요청 객체에 담은 값 : "+s_name); // null
	out.print("<br>");
	out.print(list.get(0).getDeptno()
			+", "+list.get(0).getDname()+", "+list.get(0).getLoc());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
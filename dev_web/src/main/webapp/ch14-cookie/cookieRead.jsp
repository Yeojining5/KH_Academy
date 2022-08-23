<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹서버에서 쿠키 생성하기</title>
</head>
<body>
<%
	// 인스턴스화 후 응답쪽으로 내려보냄
	Cookie cook1 = new Cookie("notebook", "갤럭시9");
	cook1.setMaxAge(60); // 1분
	
	// 생성자는 메소드 오버로딩 - 같은 이름의 생성자 여러개 가능함
	Cookie cook2 = new Cookie("age", String.valueOf(30));
	List<String> names = new ArrayList<>();
	session.setAttribute("s_age", 30); // 쿠키와 달리 숫자를 넣을 수 있다. 
	session.setAttribute("s_names", names);
	cook2.setMaxAge(60); // 1분
	cook2.setPath("/");
	
	Cookie cook3 = new Cookie("coffee", "콜드브루");
	cook3.setMaxAge(60); // 1분
	
	response.addCookie(cook1);
	response.addCookie(cook2);
	response.addCookie(cook3);
%>
</body>
</html>
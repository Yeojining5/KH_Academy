<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키에 담긴 정보 읽기</title>
</head>
<body>
<%
	Cookie cooks[] = request.getCookies();
	int size = 0;
	if(cooks!=null) {
		size = cooks.length; //4
	}
	
	out.print("size : " +size);
	
	out.print("<br>");
	
	for(int i=0;i<size;i++) {
		out.print(cooks[i].getName()+ "," +cooks[i].getValue());
		out.print("<br>");
	}
%>
</body>
</html>
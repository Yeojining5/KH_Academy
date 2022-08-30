<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.vo.Notice" %>    
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	out.print(list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
</head>
<body>
공지사항 목록
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.vo.Notice" %>    
<%
// forward는 시간과는 관계가 없다. - 쿠키(문자열만, 텍스트만-> Base64, Base32)와 세션
// 바이너리 코드(문자,숫자 공존) - 첨부파일 처리가 가능하다
// 바이너리는 get방식으로 전송이 불가함
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
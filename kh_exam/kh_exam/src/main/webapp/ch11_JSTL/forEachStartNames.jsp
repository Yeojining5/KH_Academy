<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이름 목록</title>
</head>
<body>
<c:forEach var="names" items="${myNames}">
	<li>${names}</li>
</c:forEach>
</body>
</html>
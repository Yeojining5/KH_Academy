<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.EmpVO" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	EmpVO evo = new EmpVO();
	evo.setEmpno(7566);
	evo.setEname("이순신");
	evo.setJob("영업");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p251</title>
</head>
<body>
<%=evo.getEmpno() %>
<br>
${evo.empno}<br>
${evo.ename}<br>
${evo.job}<br>
<hr>
<c:set var="evo" value="<%=evo %>"/>
<c:set var="ename" value="${evo.ename}"/>
<% evo.setEname("이순신"); %>
${ename}
</body>
</html>








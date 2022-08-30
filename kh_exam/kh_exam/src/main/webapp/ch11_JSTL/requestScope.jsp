<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.EmpVO" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	EmpVO evo = new EmpVO();
	evo.setEmpno(7566);
	//pageScope, applicationScope
	request.setAttribute("empno", 7499);
	session.setAttribute("ename", "김춘추");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestScope.jsp</title>
</head>
<body>
사원번호 : ${requestScope.empno}<br>
사원명 : ${sessionScope.ename}<br>
</body>
</html>
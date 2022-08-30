<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>    
<%@ page import="model.vo.DeptVO" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	DeptVO dVO = new DeptVO();
	List<DeptVO> bList = new ArrayList<DeptVO>();	
	dVO.setDeptno(10);
	dVO.setDname("총무부");
	dVO.setLoc("인천");
	bList.add(dVO);
	dVO = null;
	dVO = new DeptVO();
	dVO.setDeptno(20);
	dVO.setDname("영업부");
	dVO.setLoc("서울");
	bList.add(dVO);
	dVO = null;
	dVO = new DeptVO();
	dVO.setDeptno(30);
	dVO.setDname("자재부");
	dVO.setLoc("부산");
	bList.add(dVO);
	int size = bList.size();
	int no = size;
%>
<c:set var="el_bList" value="<%=bList %>"/>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- jstl 적용 전 -->
<table border="1">
<!-- 9번 반복 -->
<%
	for(int j=1;j<10;j++){
%>
	<tr>
<!-- 8번 반복:단수 -->
<%
		for(int i=2;i<10;i++){
%>
		<td><%=i+"*"+j+"="+(i*j) %></td>
<%
		}
%>		
<!-- 8번 반복 -->
	</tr>
<%
	}///////// end of outter for
%>	
</table>
<hr>
<!-- jstl 적용 후 -->
<table border="1">
<!-- 9번 반복 -->
<c:forEach var="j" begin="1" end="9" step="1">
	<tr>
<!-- 8번 반복:단수 -->
	<c:forEach var="i" begin="2" end="9" step="1">
		<td>${i}*${j}=${i*j}</td>
	</c:forEach>		
<!-- 8번 반복 -->
	</tr>
</c:forEach>
</table>
<hr>
<!-- 자료구조 테스트 -->
<c:forEach var="dept" items="${el_bList}" varStatus="x">
	${dept.dname}
</c:forEach>
</body>
</html>












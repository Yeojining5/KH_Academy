<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ page import="java.util.List, java.util.Map" %>    
<%
//http://localhost:8000/kh_exam/board/boardList
	int size = 0;
    List<Map<String, Object>> boardList 
    						= (List<Map<String, Object>>)request.getAttribute("boardList");
    if(boardList!=null){
    	size = boardList.size();
    	out.print("size:"+size);
    }
%>
<c:set var="el_size" value="<%=size %>"/>
<c:set var="el_boardList" value="<%=boardList %>"/>
el_size : ${el_size}
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoardList.jsp</title>
</head>
<body>
<table border="1" width="600" height="350">
<c:choose>
<c:when test="${el_size==0}">
	<!-- 검색 결과가 없을 때 시작 -->
	<tr>
		<td colspan="4">조회결과가 없습니다.</td>
	</tr>
	<!-- 검색 결과가 없을 때  끝   -->
</c:when>	
<c:when test="${el_size>0}">
	<c:forEach var="board" items="${el_boardList}">
	<!-- 검색 결과가 있을 때 시작  -->
	<tr>
		<td>${board.BM_NO}</td>
		<td>
<!-- 너 댓글이니? -->	
<c:if test="${board.BM_POS>0}">	
	<c:forEach var="j" begin="1" end="${board.BM_POS}" step="1">
		&nbsp;&nbsp;
	</c:forEach>	
	<img src="./reply.gif" border="0">
		<a href="./read.jsp?bm_no=${board.BM_NO}">
		${board.BM_TITLE}
		</a>
</c:if>
<!-- 원글인 경우 -->
		<a href="./read.jsp?bm_no=${board.BM_NO}">
		${board.BM_TITLE}
		</a>
		</td>
		<td>${board.BM_WRITER}</td>
		<td>${board.BM_DATE}</td>
	</tr>
	</c:forEach>
	<!-- 검색 결과가 있을 때  끝 -->
</c:when>	
</c:choose>
</table>
</body>
</html>
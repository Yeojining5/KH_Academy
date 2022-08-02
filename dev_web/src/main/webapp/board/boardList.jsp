<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %> 

<%
	List<Map<String,Object>> boardList = 
	(List<Map<String,Object>>)request.getAttribute("boardList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
게시판 목록
<table border="1" width="500px">
	<tr>
		<td>코치명</td>
		<td>수업유형</td>
		<td>hp</td>
	</tr>
<%
	//스크립틀릿
	if(boardList!=null){
		for(int i=0;i<boardList.size();i++){
			Map<String,Object> rmap = boardList.get(i);
%>	
	<tr>
		<td><% out.print(rmap.get("코치명")); %></td>
		<td><%=rmap.get("수업유형") %></td>
		<td><%=rmap.get("hp") %></td>
	</tr>
<%
		}// end of for
	}////// end of if
	else{
%>	
	<tr>
		<td colspan="3">조회결과가 없습니다.</td>
	</tr>	
<%
	}
%>	
</table>
</body>
</html>
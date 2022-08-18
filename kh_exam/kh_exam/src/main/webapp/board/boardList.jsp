<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.vo.Board" %>    
<%
	List<Board> boardList = (List<Board>)request.getAttribute("boardList");
	out.print(boardList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록 보기</title>
</head>
<body>
글목록 보기
<table border="1" width="800px">
	<tr>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
	</tr>
<%
	for(int x=0;x<boardList.size();x++){
		Board board = boardList.get(x);
%>	
	<tr>
		<td><%=board.getBoardTitle() %></td>
		<td><%=board.getBoardWriter() %></td>
		<td><%=board.getBoardContent() %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>
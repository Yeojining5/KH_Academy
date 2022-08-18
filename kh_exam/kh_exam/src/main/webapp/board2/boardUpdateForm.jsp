<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" import="java.util.ArrayList, model.vo.*"%>
<%
	Board2 b = (Board2) request.getAttribute("board2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <form action="<%=request.getContextPath()%>/board2/update.bo" method="post">
   <table border="1">
    <input type="hidden" value="<%=b.getTbId()%>" name="id">
    <tr>
     <th>제목</th>
     <td>
     	<input type="text" name="title" value="<%=b.getTbTitle()%>">
      </td>
    </tr>
    <tr>  
     <th>작성자</th>
     <td>
     <input type="text" name="writer" value="<%=b.getTbWriter()%>" readonly>
     </td>
    </tr>
    <tr>
     <th>내용</th>
     <td colspan="4">
     <textarea name="content" cols="60" rows="15" style="resize: none;"><%=b.getTbContent()%></textarea>
     </td>
    </tr>
   </table>
   <div align="center">
    <button type="button" onclick="javascript:history.back();">취소</button>
    <button id="submit" type="submit">수정</button>
   </div>
  </form>
 </div>
</body>
</html>​
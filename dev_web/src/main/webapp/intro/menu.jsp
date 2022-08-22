<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	// include directive 방식으로 할때는 같은 이름의 변수는 사용이 불가함 
 	// top.jsp와 Duplicate loccal variable s_name, s_age 오류
 	//String s_name = (String)session.getAttribute("s_name");
 	//Integer s_age = (Integer)session.getAttribute("s_age");
 	//out.print("세션에 담긴값들 "+s_name+","+s_age);
 	
 %>
    
<table border="1" borderColor="gray" width="100%" height="100%">
	<tr>
		<td align="left" valign="top">
			<table>
				<tr>
					<td><a href="index.jsp?menu=intro">인트로</a></td>
				</tr>
				<tr>
					<td><a href="index.jsp?menu=notice">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="index.jsp?menu=qna">Q&A게시판</a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
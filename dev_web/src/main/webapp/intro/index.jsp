<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String menu = request.getParameter("menu");
	String c_name = null;
	Cookie[] cooks = request.getCookies();
	if(cooks != null && cooks.length!=0){
		for(int i=0;i<cooks.length;i++) {
			if("c_name".equals(cooks[i].getName())){
				c_name = cooks[i].getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TerrGYM Project</title>

<script type="text/javascript">
	function login(){
		alert("login호출 성공");
		// 사용자가 입력한 아이디와 비번을 넘긴다 - 전송
		document.getElementById("f_login").submit(); // clogin.pj (menu.jsp)
	}
	
	function logout() {
		location.href = "clogout.jsp";
	}

</script>

</head>
<body>
	<table align ="center" width="1200px" height="550px">
	 	<tr>
	 		<td colspan="2" width="1200px" height="100px">
	 		<%@ include file="top.jsp" %>
	 		</td>
	 	</tr>
	 	
	 	<tr>
	 	<!----------------- [[컨텐츠 화면 출력]] ----------------->
			<td align="center" width="1000px" height="400px">
<%
	if(menu == null) {
%>			
			<%@ include file="main.jsp" %>
<%
	} else if("intro".equals(menu)) {	// index.jsp?menu=intro
%>			
			<%@ include file="intro.jsp" %>
<%
	} else if("notice".equals(menu)) {	// index.jsp?menu=notice
%>	
			<%@ include file="notice.jsp" %>
<%
	} else if("qna".equals(menu)) {		// index.jsp?menu=qna
%>	
			<%@ include file="qna.jsp" %>
<%
	}
%>				
			</td>
		<!----------------- [[컨텐츠 화면 출력]] ----------------->
<%
	
%>		
		<!----------------- [[메뉴 화면 출력]] ----------------->
			<td align="center" width="200px" height="400px">
			<%@ include file="menu.jsp" %>
			</td>
		<!----------------- [[메뉴 화면 출력]] ----------------->
	 	</tr>
	 	
	 	<tr>
	 		<td colspan="2" width="1200px" height="50px">
	 		<%@ include file="bottom.jsp" %>
	 		</td>
	 	</tr>
	</table>
</body>
</html>
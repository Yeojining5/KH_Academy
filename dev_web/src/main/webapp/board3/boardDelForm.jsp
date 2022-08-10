<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/easyui_common.jsp" %>   
<%
	String pbm_no = request.getParameter("b_no");
	String pbm_pw = request.getParameter("b_pw");
%>	  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글삭제</title>
</head>
<body>    
 <div style="margin-bottom:20px">
 	<input id="u_pw" name="u_pw" class="easyui-textbox" label="비밀번호:" style="width:200px;height:25px">
 </div>
</body>
</html>
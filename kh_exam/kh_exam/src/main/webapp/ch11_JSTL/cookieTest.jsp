<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	Cookie c_id = new Cookie("mem_id","test");
	c_id.setPath("/");
	c_id.setMaxAge(60*2);
	response.addCookie(c_id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie cooks[] = request.getCookies();
	if(cooks !=null){
		for(int i=0;i<cooks.length;i++){
			if(cooks[i].getName().equals("mem_id")){
				out.print(cooks[i].getValue()+"<br>");
			}
			else{
				out.print(cooks[i].getValue()+"<br>");
			}
		}
	}
%>
<hr>
쿠키이름 : ${cookie.mem_id.name}<br>
쿠키값 : ${cookie.mem_id.value}<br>

</body>
</html>










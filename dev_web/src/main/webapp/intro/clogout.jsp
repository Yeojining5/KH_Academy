<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 삭제 처리
	Cookie c_name = new Cookie("c_name", "");
	c_name.setPath("/");
	c_name.setMaxAge(0);
	response.addCookie(c_name);
	response.sendRedirect("./index.jsp");
%>
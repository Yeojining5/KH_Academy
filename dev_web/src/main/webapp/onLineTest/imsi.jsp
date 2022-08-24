<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test5 = request.getParameter("htest5");
	out.print("5번문제 답안지 : "+test5);
	// 쿠키 생성하기
	Cookie ctest5 = new Cookie("test3", test5);
	ctest5.setPath("/onLineTest");
	ctest5.setMaxAge(30*60); // 60은 1분
	response.addCookie(ctest5);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 오라클에서 꺼내온 이름을 모든 페이지에서 공유하고 싶다면 어떡하지?
	// 서블릿과 JSP(출력페이지) 사이에서 유지하기 - forward - request scope
	String s_name = "이순신";
	int s_age = 30;
	
	// forward와 상관없이 값을 유지(사용) 가능함
	// scope : request
	// 페이지 안에서만 쓰이는 request는 유용하지 않다 forward! (senRedirect를 말하는 사람은 기초가X)
	// session은 forward(req,res)이든 sendRedirect이든 상관없이 그 시간 동안 무조건 유지된다
	// 
	session.setAttribute("s_name", s_name);
	session.setMaxInactiveInterval(3000); 
	session.setAttribute("s_age", s_age);
%>

<jsp:useBean id="myName" scope="page" class="java.lang.String" />
<jsp:useBean id="yourName" scope="request" class="java.lang.String" />
<jsp:useBean id="herName" scope="session" class="java.lang.String" />
<jsp:useBean id="hisName" scope="application" class="java.lang.String" />
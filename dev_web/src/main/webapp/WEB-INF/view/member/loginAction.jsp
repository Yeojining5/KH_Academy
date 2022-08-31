<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 상수를 넣어서 모델1 방식으로 구현(원래는 DB에서 가져오는 방식)
	// 오라클서버에 아이디와 비번을 넘겨서 모두를 만족하면
	// 아이디와 비번이 일치하면 이름을 가져온다
	// SELECT mem_name FROM 회원 WHERE 아이디=? AND 비번=?
	// 오라클 서버에서 조회된 이름을 세션객체에 담는다.
	// 
	session.setAttribute("s_name", "나초보");
%>
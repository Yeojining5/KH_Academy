<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>    
<%@ page import="model.vo.MemberVO" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request와 session값 출력해 보기</title>
</head>
<body>
<hr>
jstl 사용하여 출력하기.
<c:forEach var="rmem" items="${rmemList}">
	아이디 : ${rmem.mem_id} 
	이  름 : ${rmem.mem_name}
</c:forEach>
<hr>
세션에서 읽어온 이름 : ${sname}
<!-- 
결론
jstl을 사용해서 값을 읽어올 때에는 
따로 getAttribute메소드 호출 없이도 직접 세션값을
출력할 수 있다.

 -->
 <hr>
<c:set var="el_rmemList" value="${rmemList}"/>
 요청객체 정보 : ${rmemList} <!-- 주소번지 출력 -->
 <br>
 회원아이디 : ${el_rmemList[0].mem_id},<!-- test -->
 회원이  름 : ${el_rmemList[0].mem_name} <!-- 홍길동 -->
 <br>
 회원아이디 : ${el_rmemList[1].mem_id},<!-- haha -->
 회원이  름 : ${el_rmemList[1].mem_name} <!-- 이순신 -->
 <br>
 우편번호 : ${param.mem_post} <!-- 123 -->
 <br>
 이 름 : ${param.mem_name} <!-- 유재석 -->
</body>
</html>








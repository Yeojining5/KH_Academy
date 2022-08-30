<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, model.vo.MemberVO" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- insert here -->
<%-- <jsp:useBean id="moCtrl" type=com.intro.AbstractClass | com.intro.Interface/> --%>
<% 
	//MemoController moCtrl = new MemoController();
 	List<MemberVO> memList = 
		(List<MemberVO>)session.getAttribute("memList");
	int size = 0;
//	if(memList!=null){//회원목록이 있어?
	if(memList.size()>0){//회원목록이 있어?
			
	}
		size = memList.size();
%> 
<!-- set은 setAttribute()로 생각한다. -->
<!-- el_size는 서버에서 조회된 결과를 담은 row의 수 -->
<c:set var="el_size" value="${memList.size()}"/>
<!-- el_num은 순번을 세는 변수 -->
<c:set var="el_num" value="${el_size}"/>
<!-- el_id는 세션 아이디를 담을 변수 -->
<c:set var="el_id" value="<%=s_id %>"/>
<!-- 서버에서 조회결과를 담은 변수에 자료구조 주소붙임. -->
<c:set var="el_memList" value="${memList}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">
//보내는 사람 아이디
	function memoForm(p_id,p_name){//p_id:받는사람 아이디
		var url = "memoForm.jsp?to_id="+p_id+"&to_name="+p_name;		
		cmm_window_popup(url
                ,500
                ,250
                ,"memoForm");
	}
</script>
</head>  
<body>
<table width="100%" height="100%" border="1" borderColor="green">
<tr valign="top">
	<td>
	<!-- 회원 목록 화면 추가하기 시작-->
	<table align="center" width="500" height="200" border="1" borderColor="blue">
		<thead>
			<tr>
				<td align="center" colspan="4">회원목록</td>
			</tr>
		</thead>
		<!-- 테이블 헤더 시작 -->
		<tr>
			<td align="center">회원번호</td>
			<td align="center">회원아이디</td>
			<td align="center">회원명</td>
			<td align="center">&nbsp;</td>
		</tr>
		<!-- 테이블 헤더  끝 -->	
	<c:if test="${el_size>0}">
<%
	int num = size;
%>	
	<c:forEach var="member" items="${el_memList}">
		<tr>
			<td align="center"><%=num-- %></td>
			<td align="center">${member.mem_id}</td>
			<td align="center">${member.mem_name}</td>
			<td align="center">
<!-- DB에서 조회한 아이디와 세션아이디가 다르니? -->
<c:if test="${member.mem_id ne el_id}">		
			<a href="javascript:memoForm('${member.mem_id}','${member.mem_name}')">쪽지</a>
</c:if>		
<c:if test="${member.mem_id eq el_id}">		
			쪽지
</c:if>	
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${el_size==0}">
		<tr>
			<td align="center" colspan="4">회원목록이 없습니다.</td>
		</tr>
	</c:if>
	</table>		
	<!-- 회원 목록 화면 추가하기 끝  -->
	</td>
</tr>
</table>
</body>
</html>

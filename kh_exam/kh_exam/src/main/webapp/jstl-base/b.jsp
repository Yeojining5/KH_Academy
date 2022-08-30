<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>    
<%@ page import="model.vo.MemberVO" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>request와 session값 출력해 보기</title>
</head>
<body>
<%
	List<MemberVO> rmemList = 
			(List<MemberVO>)request.getAttribute("rmemList");
	out.print("rmemberList:"+rmemList);
	out.print("<br>");
	List<MemberVO> smemList2 = 
			(List<MemberVO>)session.getAttribute("smemList");
	for(int i=0;i<smemList2.size();i++){
		out.print("id : "+smemList2.get(i).getMem_id()
				 +", name : "+smemList2.get(i).getMem_name());
	}
%>
<hr>
jstl 사용하여 출력하기.
<c:forEach var="smem" items="${smemList}">
	아이디 : ${smem.mem_id} 
	이  름 : ${smem.mem_name}
</c:forEach>
<hr>
세션에서 읽어온 이름 : ${sname}
<!-- 
결론
jstl을 사용해서 값을 읽어올 때에는 
따로 getAttribute메소드 호출 없이도 직접 세션값을
출력할 수 있다.

 -->
</body>
</html>








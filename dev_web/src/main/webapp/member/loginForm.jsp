<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	웹서비스에서 이용하는 프로토콜은(http) 비상태 프로토콜이다
	상태가 유지되지 않는다.
	요청을 하면 연결을 하고 요청에 대한 응답이 나가고 나면 연결이 끊어진다
	- 현재 내가 요청한 페이지에 내용이 아직도 보이고 있는데 .. 왜 끊어졌다는 걸까?
	html, css, js는 로컬 PC에 다운로드가 일어난다 - 처리주체는 브라우저
	장바구니와 같은 개념은 쿠키,세션에 담아둘 수 있다.
	쿠키 -> 문자열-텍스트-base2,8,16,32,64 -> 메모리의 주소번지와 관계 -> 개인pc에 저장되므로 노출될 수 있다.
	세션 -> Object타입 - 서버컴 cash memory 
	둘다 저장소이다.
	session.setAttribute("s_name","김유신");
 -->
 <%
 	// 세션 가져오기 session.getAttribute -> 오브젝트 이므로 (String)으로 변환
 	String s_name = (String)session.getAttribute("s_name"); // 세션에 담긴 이름을 넣기위해 선언된 변수
 	//s_name="강감찬";
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/common/easyui_common.jsp" %>
<script>
	function login() {
		location.href="loginAction.jsp"
	}
	function logout() {
		location.href="logout.jsp" // 모델1방식 - 이건 MVC패턴이 아님
	}
</script>
</head>
<body>
<!-- 세션값이 null일 때 -->
<%
	// 너 로그인 안했는데 -> 로그인화면 보여주기
	if(s_name==null) {
%>
	<form id="f_login">
		<input class="easyui-textbox" label="아이디" name="mem_id" data-options="iconCls:'icon-man'" style="width:200px">
		<br>
		<input class="easyui-textbox" label="비밀번호" name="mem_pw" data-options="iconCls:'icon-lock'" style="width:200px">
		<a id="btn_login" href="javascript:login()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">로그인</a>
		</form>
<%	
	}
	else {
%>

<!-- 세션값이 존재할 때, 로그인 성공 시 
	로그아웃 버튼을 누르면 해당 사용자에 관한 모든 세션을 회수함
-->
	<%="s_name" %>님 환영합니다.
	<a id="btn_logout" href="javascript:logout()" class="easyui-linkbutton">로그아웃</a>
<%
	}
%>

</body>
</html>
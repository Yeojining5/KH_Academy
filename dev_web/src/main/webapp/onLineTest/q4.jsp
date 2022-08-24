<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test3 = request.getParameter("htest3");
	out.print("3번문제 답안지 : "+test3);
	// 쿠키 생성하기
	Cookie ctest3 = new Cookie("test3", test3);
	ctest3.setPath("/onLineTest");
	ctest3.setMaxAge(30*60); // 60은 1분
	response.addCookie(ctest3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제4</title>
<script type="text/javascript">
	function test(pcb) {
		for(let i=0; i<document.f_test1.cb.length;i++) {
			if(pcb == i)
				document.f_test1.cb[i].checked = 1;
			else
				document.f_test1.cb[i].checked = 0;
		}
	}
	
	function prev() {
		location.href = "q3.jsp";
	}
	
	function next() {
		let temp = 1;
		for(let i =0;i<document.f_test1.cb.length;i++) {
			if(document.f_test1.cb[i].checked==1) {
				document.f_test1.htest4.value = temp;
			}
			else {
				temp = temp + 1;
			}
		} /////////////// end of for
		document.f_test1.submit(); // q2.jsp로 이동
	}
</script>
</head>
<body>
	<form name="f_test1" method="get" action="q5.jsp">
		<input type="hidden" name="htest4">
		문제4. 다음 중 테이블에 대한 설명으로 틀린 것을 고르시오.<br>
		<input type="checkbox" name="cb" onChange="test(0)">
		row와 column으로 구성되어있다.<br>
		<input type="checkbox" name="cb" onChange="test(1)">
		테이블에는 반드시 index가 있어야 한다.<br>
		<input type="checkbox" name="cb" onChange="test(2)">
		컬럼에는 적당한 타입을 선택하고 담을 수 있는 크기도 설정할 수 있다.<br>
		<input type="checkbox" name="cb" onChange="test(3)">
		테이블에는 PK도 올 수 있고 FK도 올 수 있다.
		<br>
		<br>
		<input type="button" value="이전문제" onClick="prev()">
		<input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>
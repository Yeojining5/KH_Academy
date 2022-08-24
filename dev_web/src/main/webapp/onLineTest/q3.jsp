<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test2 = request.getParameter("htest2");
	out.print("2번문제 답안지 : "+test2);
	// 쿠키 생성하기
	Cookie ctest2 = new Cookie("test2", test2);
	ctest2.setPath("/onLineTest");
	ctest2.setMaxAge(30*60); // 60은 1분
	response.addCookie(ctest2);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제3</title>
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
		location.href = "q2.jsp";
	}
	
	function next() {
		let temp = 1;
		for(let i =0;i<document.f_test1.cb.length;i++) {
			if(document.f_test1.cb[i].checked==1) {
				document.f_test1.htest3.value = temp;
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
	<form name="f_test1" method="get" action="q4.jsp">
		<input type="hidden" name="htest3">
		문제3. 다음 중 DCL구문으로 맞는 것을 고르시오.<br>
		<input type="checkbox" name="cb" onChange="test(0)">grant<br>
		<input type="checkbox" name="cb" onChange="test(1)">drop<br>
		<input type="checkbox" name="cb" onChange="test(2)">alter<br>
		<input type="checkbox" name="cb" onChange="test(3)">delete<br>
		<br>
		<input type="button" value="이전문제" onClick="prev()">
		<input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>
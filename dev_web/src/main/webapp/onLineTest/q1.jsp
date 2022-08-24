<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<script type="text/javascript">
	// 브라우저가 DOM 트리 구성할 때, 하나이면 그 이름이 그대로 적용되지만
	// 같은 이름이 여러개이면 자동으로 배열 전환 처리(브라우저)
	function test(pcb) {
		console.log(pcb); //pcb는 checkbox에 대한 index값이다. 그래서 0부터
		// 4지선다형이므로 for문 사용
		for(let i=0; i<document.f_test1.cb.length;i++) {
			if(pcb == i)
				document.f_test1.cb[i].checked = 1;
			else
				document.f_test1.cb[i].checked = 0;
		}
	}
	// 다음문제로 이동하기 - URL이 바뀜 - 기존 요청이 끊어진다 - 유지문제
	function next() {
		// 사용자가 선택한 답안정보를 기억할 것
		// 헌재 페이지에 대한 사용자의 선택을 전송하기
		console.log("next");
		let temp = 1;
		for(let i =0;i<document.f_test1.cb.length;i++) {
			if(document.f_test1.cb[i].checked==1) {
				document.f_test1.htest1.value = temp;
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
	<form name="f_test1" method="get" action="q2.jsp">
		<input type="hidden" name="htest1">
		문제1. 다음 중 DML구문이 아닌 것을 고르시오.<br>
		<input type="checkbox" name="cb" onChange="test(0)">select<br>
		<input type="checkbox" name="cb" onChange="test(1)">insert<br>
		<input type="checkbox" name="cb" onChange="test(2)">create<br>
		<input type="checkbox" name="cb" onChange="test(3)">delete<br>
		<br>
		<input type="button" value="다음문제" onClick="next()">
	</form>
</body>
</html>
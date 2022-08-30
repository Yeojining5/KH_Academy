<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch10:EL 예제</title>
</head>
<body>
<div align="center">
<H2>ch10:EL 예제-상품선택</H2>
<HR>
1. 선택한 상품은 : ${param.sel} <BR><!-- request.getParameter("sel")과 동일한다. -->
2. num1 + num2 = ${product.num1+product.num2} <BR>
</div>
</body>
</html>
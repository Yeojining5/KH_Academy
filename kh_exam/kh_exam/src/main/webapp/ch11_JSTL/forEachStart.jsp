<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%
	List<String> myNames = new ArrayList<String>();
	myNames.add(0,"이순신");
	myNames.add(1,"김유신");
	myNames.add(2,"강감찬");
	request.setAttribute("myNames", myNames);
%>
<jsp:forward page="forEachStartNames.jsp"/>
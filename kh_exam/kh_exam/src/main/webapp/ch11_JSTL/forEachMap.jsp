<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%
	List<HashMap> mList = new ArrayList<HashMap>();
	HashMap<String,Object> member = 
			new HashMap<String,Object>();
	member.put("name","이순신");
	member.put("age",26);
	member.put("address","서울시 영등포구 영등포동");
	mList.add(member);
	member = new HashMap<String,Object>();
	member.put("name","이성계");
	member.put("age",28);
	member.put("address","서울시 구로구 개봉동");
	mList.add(member);
	member = new HashMap<String,Object>();
	member.put("name","이황");
	member.put("age",29);
	member.put("address","서울시 마포구 공덕동");
	mList.add(member);
	request.setAttribute("mList",mList);
%>
<jsp:forward page="forEachMapView2.jsp"/>
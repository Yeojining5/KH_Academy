<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
	String rb_no = null;
	String rb_pw = null;
    String rb_title = null;
	String rb_writer = null;
	String rb_content = null;
	String rb_date = null;
	String rb_group = null;
	String rb_pos = null;
	String rb_step = null;
	List<Map<String,Object>> boardList = 
			(List<Map<String,Object>>)request.getAttribute("boardList");	
	if(boardList !=null && boardList.size()>0){
		rb_no = boardList.get(0).get("B_NO").toString();
		rb_pw = boardList.get(0).get("B_PW").toString();
		rb_title = boardList.get(0).get("B_TITLE").toString();
		rb_writer = boardList.get(0).get("B_WRITER").toString();
		rb_content = boardList.get(0).get("B_CONTENT").toString();
		rb_date = boardList.get(0).get("B_DATE").toString();
		rb_group = boardList.get(0).get("B_GROUP").toString();
		rb_pos = boardList.get(0).get("B_POS").toString();
		rb_step = boardList.get(0).get("B_STEP").toString();
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/easyui_common.jsp" %>
<script>
//html만으로 처리
//javascript만으로 처리
//html+javascript혼합 처리(권장-리액트)
	function boardList(){
		location.href="./boardList.pj";
	}
	function dlgIns_save(){
		$("#f_boardIns").submit();
	}
	function repleForm(){
		$("#dlg_boardIns").dialog('open');
	}
	function updateForm(){
		$("#dlg_boardUpd").dialog('open');
	}	
	function dlgUpd_save(){
		$("#f_boardUpd").submit();
	}	
	function deleteForm(){
		//리액트 계속 - import(ES6, module, ES6기준문법-안전함, require-CommonJS)
		$("#dlg_boardDel").dialog({
			title:'글삭제- 비번확인',
			href:'boardDelForm.jsp?b_no=<%=rb_no%>&b_pw=<%=rb_pw%>',
			modal:true,
			closed: true
		});
		$("#dlg_boardDel").dialog('open');
	}	
	function boardDel(){
		console.log('boardDel호출 성공');
		//자바스크립트에서는 값에 더블 혹은 싱글 쿼테이션을 안붙이면 변수
		let db_pw = "<%=rb_pw%>";
		const u_pw = $("#u_pw").textbox('getValue');
		if(u_pw == db_pw){
			$.messager.confirm('Confirm', '정말 삭제할거야?',function(r){
				if(r){
					location.href="./boardDelete.pj?b_no="+<%=rb_no%>;
				}
			});
		}else{
			alert("비번이 틀려요");
		}
	}
</script>
</head>
<body>
    <table align="center" id="p" class="easyui-panel" title="글상세보기" data-options="footer:'#tb_read'"
        style="width:670px;height:380px;padding:10px;background:#fafafa;">
	    	<tr>
	    	<td>제목</td>
	    	<td><input id="b_title" value="<%=rb_title%>" name="b_title" data-options="width:'450px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>작성자</td>
	    	<td><input id="b_writer" value="<%=rb_writer%>" name="b_writer" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>내용</td>
	    	<td><input id="b_content" value="<%=rb_content%>" name="b_content" data-options="multiline:'true', width:'570px', height:'90px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>작성일</td>
	    	<td><input id="b_date" value="<%=rb_date%>" name="b_date" class="easyui-textbox"></td>
	    	</tr>	    	
	   </table>
	 <div id="tb_read" style="padding:2px 5px;" align="center">
	    <a href="javascript:repleForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">댓글쓰기</a>
	    <a href="javascript:updateForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">수정</a>
	    <a href="javascript:deleteForm()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
	    <a href="javascript:boardList()" class="easyui-linkbutton" iconCls="icon-search" plain="true">목록</a>
	</div>
<!-- 글삭제 시작 -->
    <div id="dlg_boardDel" footer="#btn_boardDel" class="easyui-dialog" 
         title="삭제하기" data-options="modal:true,closed:true" 
         style="width:600px;height:200px;padding:10px">
		<div id="btn_boardDel" align="right">
			<a href="javascript:boardDel()" class="easyui-linkbutton" iconCls="icon-ok">확인</a>
			<a href="javascript:boardDelClose()" class="easyui-linkbutton" iconCls="icon-clear">닫기</a>
		</div>
	</div>
<!-- 글삭제  끝  -->	
<!--수정 화면 추가 시작 -->
    <div id="dlg_boardUpd" footer="#tb_boardUpd" class="easyui-dialog" title="수정하기" data-options="modal:true,closed:true" style="width:600px;height:400px;padding:10px">
        <!-- 바이너리(문자열+숫자) 파일을 전송할 때는 반드시 post방식 처리 첨부파일 처리시 -->
        <!-- base2, base8, base16, base64 텍스트 파일(문자열치환-파일크기가 커진다) -->
        <!-- <form id="f_boardIns" method="post" enctype="multipart/form-data" action="./boardInsert.pj"> -->
        <form id="f_boardUpd" method="get" action="./boardUpdate.pj">
        <!-- 태그안에 자바변수 사용가능한가? 가능함 -->
	    <input type="hidden" id="b_no" name="b_no" value="<%=rb_no%>">
        	<table>
        		<tr>
        			<td width="100px">제&nbsp;&nbsp;&nbsp;목</td>
        			<td width="500px"><input id="b_title" value="<%=rb_title %>" name="b_title" class="easyui-textbox" data-options="width:'250px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">작&nbsp;성&nbsp;자</td>
        			<td width="500px"><input id="b_writer" value="<%=rb_writer %>" name="b_writer" class="easyui-textbox" data-options="width:'150px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">내&nbsp;&nbsp;&nbsp;용</td>
        			<td width="500px"><input id="b_content" value="<%=rb_content %>" name="b_content" class="easyui-textbox" data-options="multiline:'true',width:'350px', height:'90px'" required></td>
        		</tr>
        	</table>
        </form>
    </div>
    <!-- 다이얼로그 화면 버튼 추가 시작 -->
	<div id="tb_boardUpd">
	<a href="javascript:dlgUpd_save()" class="easyui-linkbutton">저장</a>
	<a href="javascript:dlgUpd_close()" class="easyui-linkbutton">닫기</a>
	</div>    
    <!-- 다이얼로그 화면 버튼 추가  끝   -->
<!-- 수정 화면 추가  끝   -->	
	
<!--댓글 화면 추가 시작 -->
    <div id="dlg_boardIns" footer="#tb_boardIns" class="easyui-dialog" title="댓글쓰기" data-options="modal:true,closed:true" style="width:600px;height:400px;padding:10px">
        <!-- 바이너리(문자열+숫자) 파일을 전송할 때는 반드시 post방식 처리 첨부파일 처리시 -->
        <!-- base2, base8, base16, base64 텍스트 파일(문자열치환-파일크기가 커진다) -->
        <form id="f_boardIns" method="post" enctype="multipart/form-data" action="./boardInsert.pj">
        <!-- <form id="f_boardIns" method="get" action="./boardInsert.pj">  -->
        <!-- 태그안에 자바변수 사용가능한가? 가능함 -->
	    <input type="hidden" id="b_group" name="b_group" value="<%=rb_group%>">
	    <input type="hidden" id="b_pos" name="b_pos" value="<%=rb_pos%>">
	    <input type="hidden" id="b_step" name="b_step" value="<%=rb_step%>">
        	<table>
        		<tr>
        			<td width="100px">제&nbsp;&nbsp;&nbsp;목</td>
        			<td width="500px"><input id="b_title" name="b_title" class="easyui-textbox" data-options="width:'250px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">작&nbsp;성&nbsp;자</td>
        			<td width="500px"><input id="b_writer" name="b_writer" class="easyui-textbox" data-options="width:'150px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">내&nbsp;&nbsp;&nbsp;용</td>
        			<td width="500px"><input id="b_content" name="b_content" class="easyui-textbox" data-options="multiline:'true',width:'350px', height:'90px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">비&nbsp;&nbsp;&nbsp;번</td>
        			<td width="500px"><input id="b_pw" name="b_pw" class="easyui-textbox" data-options="width:'100px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">첨부파일</td>
        			<td width="500px"><input id="bs_file" name="bs_file" class="easyui-filebox" data-options="width:'350px'"></td>
        		</tr>
        	</table>
        </form>
    </div>
    <!-- 다이얼로그 화면 버튼 추가 시작 -->
	<div id="tb_boardIns">
	<a href="javascript:dlgIns_save()" class="easyui-linkbutton">저장</a>
	<a href="javascript:dlgIns_close()" class="easyui-linkbutton">닫기</a>
	</div>    
    <!-- 다이얼로그 화면 버튼 추가  끝   -->
<!-- 댓글 화면 추가  끝   -->	
</body>
</html>
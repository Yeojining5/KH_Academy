package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 한글 깨지지 않도록 + 브라우저의 자의적인 해석 방지
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=HTF-8");
		// post요청시 한글 깨지는 문제 해결
		//req.setCharacterEncoding("UTF-8"); 
		
		PrintWriter out = res.getWriter();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		out.println(title);
		out.println(content);
		
		
	}
	
}

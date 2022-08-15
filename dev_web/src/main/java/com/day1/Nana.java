package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 한글 깨지지 않도록 + 브라우저의 자의적인 해석 방지
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=HTF-8");
		
		PrintWriter out = res.getWriter();
		
		String cnt_ = req.getParameter("cnt");
		
		int cnt = 100; // 기본값
		if(cnt_ != null && !cnt_.equals("")) // 널과 빈문자열이 아닐때 모두
			cnt = Integer.parseInt(cnt_);
		
		for(int i=0;i<cnt;i++)
			out.println((i+1)+": 안녕 Servlet!!<br/>");
		
		
	}
	
}

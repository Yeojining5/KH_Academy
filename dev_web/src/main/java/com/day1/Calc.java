package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=HTF-8");
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String op = req.getParameter("operator");
		
		// 빈 문자열이 올 수도 있으므로 디폴트값 0으로 설정
		int x = 0;
		int y = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		int result = 0;
		
		if(op.equals("덧셈")) {
			result = x+y;
		} else {
			result = x-y;
		}
		
		
		res.getWriter().printf("result is %d\n", result);
		
	}
	
}

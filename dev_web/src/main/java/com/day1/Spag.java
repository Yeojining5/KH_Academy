package com.day1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0; // 기본값
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")) // 널과 빈문자열이 아닐때 모두
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2 != 0) 
			result = "홀수";
		
		else 
			result = "짝수";
		
		request.setAttribute("result", result); // "request"에 result값을 담음
		
		String[] names = {"tomato", "apple"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요");
		request.setAttribute("notice", notice);
		
		// Dispatcher를 통해 forward를 할 수 있다.
		// 현재 작업했던 내용을 req,res에 담으면 spag.jsp로 이어져서 요청이 진행될 것
		// spag.jsp에서 넘겨받은 req, res를 이어갈 수 있다. 꺼내쓸 수 있음
		RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response); 
		
		
	}
}

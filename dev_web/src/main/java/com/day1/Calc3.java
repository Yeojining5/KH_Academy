package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies(); // 쿠키를 읽어들이기. 배열로 오는 것은 디폴트
		
		// 사용자입력 값 -> exp생성 -> 쿠키에저장 -> redirect
		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");
		
		String exp = "";
		// 쿠키 읽어오기
		if(cookies != null) // 쿠키가 NULL이 아닐 때 조건
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue(); // 이 exp를 아래 html에서 동적으로 출력해주면됨
					break;
				}
		}
		
		if(operator != null && operator.equals("=")) {
			// 계산 로직
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) { 
				e.printStackTrace();
			}    
		}
		// C버튼 누르면 쿠키 삭제하기
		else if(operator != null && operator.equals("C")) {
			exp = "";
		}
		
		else {
			exp += (value == null)?"":value;
			exp += (operator == null)?"":operator;
			exp += (dot == null)?"":dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		
		if(operator != null && operator.equals("C")) 
//			expCookie.setMaxAge(0); // 쿠키가 저장되자마자 삭제되는 코드
		
		res.addCookie(expCookie);
		res.sendRedirect("calcpage"); // @WebSerblet(/"calcpage")와 동일하게
		}
		
	}
	

package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		ServletContext application = req.getServletContext(); // 어플리케이션 저장소
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies(); // 쿠키를 읽어들이기. 배열로 오는 것은 디폴트
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=HTF-8");
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		
		// =는 저장된 값을 가져와서 연산을 수행해야 함
		if(op.equals("=")) {
			// object로 값을 반환하기 때문에 래퍼클래스 integer 사용
			// "value" "op" 키워드를 반환
//			int x = (Integer)application.getAttribute("value"); // 저장소에서 값 가져오기
//			int x = (Integer)session.getAttribute("value"); // 저장소에서 값 가져오기
			
			// 배열로 담긴 쿠키 꺼내기 - 1) value 찾기
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v;
//			String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			// 배열로 담긴 쿠키 꺼내기 - 2) operator 찾기
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			
			int result = 0;
			
			if(operator.equals("+")) {
				result = x+y;
			} else {
				result = x-y;
			}
			res.getWriter().printf("result is %d\n", result);
			
		} else {
			// 덧셈과 뺄셈은 값과 op를 저장하는 것이 끝(하는일이 같음)
			// setAttribute는 map 컬렉션과 비슷한 개념. 값을 담는 작업
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			
//			session.setAttribute("value", v);
//			session.setAttribute("op", op); 
			
			// 쿠키 값은 반드시 문자열로 보내야함
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2"); // 쿠키 옵션 추가 ( "/" 모든 페이지를 요청할 때마다 해당Cookie를 가져와라) 
			valueCookie.setMaxAge(24*60*60); // 하루동안 쿠키 유지 
			opCookie.setPath("/calc2"); 
			res.addCookie(valueCookie); // 클라이언트에게 쿠키 보내기 
			res.addCookie(opCookie);
			
			res.sendRedirect("calc2.html");
		}
		
	}
	
}

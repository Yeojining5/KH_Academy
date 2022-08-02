package com.mvc.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// POJO
// XXX.gym -> 무조건 FrontMVC클래스 인터셉트 하자
public class FrontMVC extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC.class);
	// doGet과 doPost로 나누어서 기능 구현하는게 싫데 - 창구를 일원화 한다
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doService 호출 성공");
		ActionForward af = null;
		// BoardController는 서블릿으로 설계하지 않았다.
		// 앞단에 FrontMVC를 경유하니까...
		// 스프링이 이렇게 하던데....
		String uri = req.getRequestURI();// -> /pay/payList.gym
		logger.info("uri:"+uri);
		String context = req.getContextPath();
		logger.info("context:"+context);
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf(".");
		command = command.substring(0,end);
		String upmu[] = null;// upmu[0]=업무이름, upmu[1]=메소드이름통일
		upmu = command.split("/");
		BoardController boardController = new BoardController();
		//MemberController memberController = new MemberController();
		//PayController payController = new PayController();
		//다 좋은데 BoardController에는 req와 res가 없는데 어떡하지?
		//메소드의 파라미터 자리는 지변이다
		//서블릿 클래스만이 객체주입(게으른...)을 받을 수 있다.
		//참조에 의한 호출
		if("board".equals(upmu[0])) {
			req.setAttribute("upmu", upmu);
			af = boardController.execute(req, res);			
		}
		if(af != null) {
			if(af.isRedirect()) {
				//res.sendRedirect("xxx.jsp");
				res.sendRedirect(af.getPath());
			}else {// forward - 유지, 주소안변함, 그런데 페이지는 바뀌었다
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req, res);
			}
		}
	}////////////end of doService	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");
		doService(req,res);		
	}
}

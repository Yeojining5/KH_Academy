package com.mvc.step2;
import java.io.IOException;

import javax.servlet.ServletException;
// void -> ActionForward -> String(spring4.0, 5.0, boot)
// -> ModelAndView(Object도 담을 수 있고 scope처리도 가능 : spring2.5에서 사용되었던 방법)
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// 시중 교재에서는 어노테이션으로 url매핑을 처리하지만
// 수업에서는 스프링 프레임워크를 최대한 흉내내 보자는 취지로 사용하지 않는다


public class ActionServlet extends HttpServlet {

	Logger logger = Logger.getLogger(ActionServlet.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
				logger.info("doService 호출 성공");
				// 요청 URL을 통해서 해당하는 업무의 컨트롤 클래스 객체를 주입받고
				// 메소드 이름까지도 결정할 수 있다면 좋을 것 같은데...
				String requestURI = req.getRequestURI(); // -> /board2/boardApp.kh?crud=select
				// 컨텍스트는 톰캣 서버의 server.xml에 배포된 위치 정보 값을 참조함
				// /dev_web or /
				String contextPath = req.getContextPath();
				String command = requestURI.substring(contextPath.length()+1);
				int end = command.lastIndexOf(".");
				command = command.substring(0,end);
				String upmu[] = null;
				upmu = command.split("/");
				logger.info(upmu[0]+","+upmu[1]);
				req.setAttribute("upmu", upmu);
				Board2Controller board2Controller = new Board2Controller();
				board2Controller.execute(req, res);
			}	
	
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

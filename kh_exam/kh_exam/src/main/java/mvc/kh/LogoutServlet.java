package mvc.kh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class LogoutServlet extends HttpServlet {
	Logger logger = Logger.getLogger(LogoutServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");	
		HttpSession session = req.getSession();
		//세션에 담긴 모든 정보 삭제할 때 사용
		session.removeAttribute("loginUser");
		//session.invalidate();
		//세션 하나만 삭제할 때는
		res.sendRedirect("./index.jsp");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}		
}

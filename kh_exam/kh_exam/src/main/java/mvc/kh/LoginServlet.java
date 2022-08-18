package mvc.kh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class LoginServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardWriteServlet.class);
	LoginService boardService = new LoginService();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");	
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		String mem_name = null;
		mem_name = boardService.login(mem_id, mem_pw);
		if(mem_name==null) {
			req.setAttribute("msg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, res);
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("s_mem_name", mem_name);
			res.sendRedirect("../index.jsp");
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}		
}

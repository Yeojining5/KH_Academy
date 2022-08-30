package mvc.kh;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class NoticeSelectServlet extends HttpServlet {
	Logger logger = Logger.getLogger(NoticeSelectServlet.class);
	NoticeService noticeService = new NoticeService();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		ArrayList<Notice> list = new NoticeService().selectList();
		req.setAttribute("list", list);
		String page = null;
		if(list !=null) {
			page = "/WEB-INF/views/notice/noticeList.jsp";
		}else {
			page = "/WEB-INF/views/common/errorPage.jsp";
			
		}
		req.getRequestDispatcher(page).forward(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}	
}

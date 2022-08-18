package mvc.kh;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		// 별로인 것은 NullPointerException방어코드를 작성할 수 없기 때문에....
		// 리펙토링
		//req.getRequestDispatcher(page).forward(req, res);
		RequestDispatcher view = req.getRequestDispatcher(page);
		view.forward(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}	
}

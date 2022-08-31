package com.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));

		String url = "jdbc:oracle:thin:@192.168.0.4:1521:orcl11";
		String sql = "SELECT * FROM NOTICE WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"scott","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			rs.next();

				// Model -> Java코드와 HTML 코드를 연결해주는 최소한의 데이터 변수
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writerId = rs.getString("WRITER_ID");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				Notice notice = new Notice (
							id,
							title,
							regdate,
							writerId,
							hit,
							files,
							content
						);
						
				request.setAttribute("n", notice);
				
				// 먼저, request를 저장소로 이용해 데이터 심어주기
				/*
				request.setAttribute("title", title);
				request.setAttribute("regdate", regdate);
				request.setAttribute("writerId", writerId);
				request.setAttribute("hit", hit);
				request.setAttribute("files", files);
				request.setAttribute("content", content);
				*/
				
			   rs.close();
			   st.close();
			   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 서블릿에서 서블릿으로 전이할 수 있는 방법 2가지
		// redirect forward(이거사용)
		// forward를 통해 담은 내용을 jsp 뷰단에서 꺼내쓸 수 있다.
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp")
		.forward(request, response);
		
		
	}
}

package com.mvc.step3;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
// 메소드가 좌중괄호 우중괄호 묶여있는것 만으로도 구현한 것과 동일함
public class AuthController implements Controller3 {
	Logger logger = Logger.getLogger(AuthController.class);
	AuthLogic authLogic = new AuthLogic();
	// upmu[0]=auth, upmu[1]=login
	//http://localhost:8000/auth/login.pj?mem_id=tomato&mem_pw=123
	//http://localhost:8000/auth/login.pj?mem_id=banana&mem_pw=123
	
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		logger.info("login 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		String s_name = null;
		HttpSession session = req.getSession();
		s_name = authLogic.login(pMap);
		session.setAttribute("s_name", s_name);
		String path = "redirect:index.jsp";
		
		return path;
	}

}

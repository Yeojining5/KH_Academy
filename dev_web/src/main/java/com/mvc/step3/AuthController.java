package com.mvc.step3;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.MemberVO;
// 메소드가 좌중괄호와 우중괄호로 묶여 있는것 만으로도 구현한 것과 동일함
public class AuthController implements Controller3 {
	Logger logger = Logger.getLogger(AuthController.class);
	AuthLogic authLogic = new AuthLogic();
	@Override
	public Object clogin(HttpServletRequest req, HttpServletResponse res) {
		logger.info("clogin 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		MemberVO mVO = null;
		mVO = authLogic.login(pMap);
		String s_name = null;
		s_name = mVO.getMem_name();
		Cookie c = new Cookie("c_name", s_name);
		c.setPath("/");
		c.setMaxAge(60*3);
		res.addCookie(c);
		String path = "redirect:index.jsp";
		return path;
	}	
	// upmu[0]=auth, upmu[1]=login
	//http://localhost:8000/auth/login.pj?mem_id=tomato&mem_pw=123
	//http://localhost:8000/auth/login.pj?mem_id=banana&mem_pw=123
	@Override
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		logger.info("login 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		MemberVO mVO = null;
		HttpSession session = req.getSession();
		mVO = authLogic.login(pMap);
		session.setAttribute("mVO", mVO);
		// sendRedirect로 이동해도 괜찮아 -> 세션값이 유지가 되니까
		String path = "redirect:index.jsp";
		return path;
	}
	
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
	public Object memberList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}



}

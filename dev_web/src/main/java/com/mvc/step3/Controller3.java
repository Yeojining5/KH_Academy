package com.mvc.step3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 인터페이스는 추상 메소드만 갖는다
// 반드시 구현체 클래스가 필요하다.
// 단독으로 인스턴스화 할 수 없다.
// 메소드 뒤에 좌중괄호 우중괄호가 없다. - 세미콜론으로 끝났다 - 추상메소드
// 명세서이다 - 반드시 구현해 주었으면 해
public interface Controller3 {
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String,Object> pMap);
	public String execute(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res);
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res);
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res);
}

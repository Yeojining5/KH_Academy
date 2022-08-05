package com.mvc.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

// 왜 굳이 ModelAndView를 추가했나? Model, ModelMap
// spring2.5까지 많이 사용하던 클래스이다.
// req.setAttribute("boardList", boardList); -> 이걸쓰지 않고 유지하고 싶다!
// 위 코드를 쓰지 않고 화면에서 boardList를 사용하고싶다. 어떡하지?
// 서블릿에 의존적이지 않은 프레임워크가 정답이다
// Request 없이도 조회된 결과를 화면에 전달할 수 있었으면 해
public class ModelAndView {
	Logger logger = Logger.getLogger(ModelAndView.class);
	HttpServletRequest req = null; // 없이 전달하고 싶다는 말이지만 내부적으로 코드는 존재해야함(다른것으로 대체)
	private String viewName = null; // 캡슐화 -> getter setter로 가져오게
	List<Map<String,Object>> reqList = new ArrayList<>();
	//String viewName = new String(); // 이건 복사본이야!! 원본을 써야해
	// 객체 재사용을 static(공유-싱글톤패턴 하나)을 쓰지 말고 해 -> 생성자를 이용해서 해봐
	public ModelAndView() { } // 디폴트 생성자
	// 왜 파라미터가 있는 생성자 이어야만 하는가?
	// JButton jbtn = new JButton();
	// jbtn.setText("전송");  -> 코드가 훨씬 간결하다. 버튼의 라벨을 붙이는데 메소드 사용
	// JButton jbtn = new JButton("전송");
	
	// 내가 req를 갖고있지 않음 -> ModelAndView를 만든 이유 req를 안쓰려고!
	// req를 쓰면 서블릿에 의존적으로 되기 때문
	// 갖고 있지 않으니까 req -> ActionSupport에 있어 -> 거기서 가져와야 해
	// Controller -> HandlerMappping(스프링에서 훔친거) - 스프링에서는 SimpleHandlerMappping
	// 생성자의 파라미터를 통해서 객체를 주입받는다.
	// setter 객체주입법과 생성자객체 주입법을 스프링이 제공하고 있다.
	public ModelAndView (HttpServletRequest req) {
		this.req  = req;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	public String getViewName () {
		return viewName;
	}
	public void addObject(String name, Object obj) {
		logger.info(name+", "+obj);
		Map<String,Object> pMap = new HashMap<>();
		pMap.put(name, obj);
		req.setAttribute(name, obj);
		reqList.add(pMap);
		
	}
}

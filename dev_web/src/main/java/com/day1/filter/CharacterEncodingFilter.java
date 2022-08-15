package com.day1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//요청이 올 때마다 필터 실행됨
// 필터는 톰캣이 처음 실행될 때도 실행

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request
			, ServletResponse response
			, FilterChain chain)
			throws IOException, ServletException {
		
		// 요청을 받은 후 흐름을 넘기는 것. 다음 필터 or 서블릿을 실행되게 함
		// 그 후에 결과가 돌아온 후에 println이 실행됨
//		System.out.println("before filter");
//		chain.doFilter(request, response);
//		System.out.println("after filter");
		
		// 따라서 인코딩을 실행한 후에 필터를 적용하면 
		// 모든 서블릿의 한글 인코딩문제를 해결할 수 있음
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}

}

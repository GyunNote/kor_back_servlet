package com.study.servlet_study.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")  //모든경로 의미 ==> *
public class ResponseCharactorEncodingFilter extends HttpFilter implements Filter {

	
	public void destroy() {
		
	}


	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		httpResponse.setCharacterEncoding("utf-8");
		
		
		chain.doFilter(request, response);    // 기준으로 위가 전처리 영역 , 밑이 후처리 영역
		
//		httpResponse.getWriter().println("무조건 후처리함");
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}

package com.study.servlet_study.filter;

import java.io.IOException;
import java.util.Arrays;

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


@WebFilter("/*")
public class RequestCharactorEncodingFilter extends HttpFilter implements Filter {

	public void destroy() {
	
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	//	HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String[] methods = new String[] {"POST","PUT"};

		System.out.println(httpRequest.getMethod());    //getMethod 에 어떤게 있는지 확인용 이거랑 밑의 asList에서 받는 게 같으면 utf-8을 실행한다
		
		if(Arrays.asList(methods).contains(httpRequest.getMethod().toUpperCase())){
			
			httpRequest.setCharacterEncoding("utf-8");
			
		}
		
		
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}

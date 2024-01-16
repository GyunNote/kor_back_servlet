package com.study.servlet_study.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.utils.ParamsConverter;


@WebServlet("/http")
public class HttpStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HttpStudyServlet() {
        super();
       
    }

	
    //HTTP 메소드
    //POST요청  ==> C reate(추가)
    //GET요청 ==>    R ead(조회)
    //PUP 요청 ==>   U pdate(수정)
    //DELETE ==>     D elete (삭제)
    
//로그인은 POST요청으로 무조건 GET으로 하면 주소창에 다뜸
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Map<String, String> paramsMap = new HashMap<>();
		
		request.getParameterMap().forEach((k,v) -> {
			//String[] valueArray = v;
			StringBuilder builder = new StringBuilder();     //문자열이 잘려있을때 이어붙일려고 사용
			
			Arrays.asList(v).forEach(value -> builder.append(value));  //배열을 리스트 자료형으로 바꿔줌 그리고 빌더안에서 하나씩 받아 이어붙임
			
			paramsMap.put(k, builder.toString());
			//System.out.println(k + ":" + builder.toString());
		//	for(String value : v ) {
		//		System.out.print(value);
		//	}
		//	System.out.println();
		});
		System.out.println(paramsMap);
		//System.out.println(request.getParameter("name")); 하나씩 하고 싶으면 이렇게 하면됨
		Map<String, String> paramsMap2 = new HashMap<>();
		Iterator<String> ir = request.getParameterNames().asIterator();
		while(ir.hasNext()) {
			String key = ir.next();
			paramsMap2.put(key, request.getParameter(key));
			System.out.println(ir.next());
			
		}
		
		
//		String nameParams = request.getParameter("name");
//		String phoneParam = request.getParameter("phone");
//		String emailParam = request.getParameter("email");
//		String addressParam = request.getParameter("address");
//		
//		System.out.println(nameParams);
//		System.out.println(phoneParam);
//		System.out.println(emailParam);
//		System.out.println(addressParam);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Map<String, String> paramsMap = ParamsConverter.convertParamsMapToMap(request.getParameterMap());
		System.out.println(paramsMap);
		
		
	}

	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
   

}

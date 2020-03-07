package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.StaticStatus;
import com.itheima.domain.Customer;
//检查客户是否登陆且是否激活过滤器
// url-pattern:  /apply/*
public class CheckCustomerLoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		try{
			request = (HttpServletRequest)req;
			response = (HttpServletResponse)resp;
		}catch(Exception e){
			throw new RuntimeException("non-http request or response");
		}
		
		//查看HttpSession中的客户登陆标记
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG);
		if(customer==null){
			response.sendRedirect(request.getContextPath());//重定向到主页
			return;
		}
		
		chain.doFilter(request, response);//放行
		
	}

	public void destroy() {

	}

}

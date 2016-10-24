package cn.tedu.note.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		//获取请求
		String path = request.getRequestURI();
		String reg = ".*edit\\.html$";
		if (path.matches(reg)) {
			checkLogin(request,response,chain);
			return;
		}
		
		reg = ".*\\.do";
		String account = ".*account.*\\.do";
		if (path.matches(reg) && !path.matches(account)) {
			checkDo(request,response,chain);
			return;
		}
		chain.doFilter(request, response);
	}

	private void checkDo(HttpServletRequest request, HttpServletResponse response,FilterChain chain) throws IOException, ServletException {
		String name = "loginUserId";
		String value = null;
		value = getCookie(request, name, value);
		if (value==null) {
			String json = "{\"state\":1,\"message\":\"必须登录!\"}";
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().println(json);
			return;
		}
		chain.doFilter(request, response);
	}

	private void checkLogin(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		//读取cookie 检查是否登录了 
		String name = "loginUserId";
		String value = null;
		value = getCookie(request, name, value);
		if (value==null) {
			String path = "log_in.html";
			response.sendRedirect(path);
			return;
		}
//		有cookie就放过
		chain.doFilter(request,response);
	}

	private String getCookie(HttpServletRequest request, String name, String value) {
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				value = cookie.getName();
			}
		}
		return value;
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

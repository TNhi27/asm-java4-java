package com.truongta.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongta.entities.User;
import com.truongta.utils.HttpFilter;

@WebFilter(filterName = "auth-user",urlPatterns = {"/share-video/*","/like-video/*","/change-password/*"})
public class AuthFilter implements HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		User user = (User) request.getSession().getAttribute("user");
		String er="";
		
		if (user == null) {
			er = response.encodeURL("VuiLongDangNhap");
		}
		
		if (!er.isEmpty()) {
			request.getSession().setAttribute("securi",uri);
			response.sendRedirect("/Java4_ASM_PC00653/login?er="+response.encodeURL(er));
		} else {
			chain.doFilter(request, response);
		}
	}
	
}

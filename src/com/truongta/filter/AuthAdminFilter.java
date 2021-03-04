package com.truongta.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongta.entities.User;
import com.truongta.utils.HttpFilter;

@WebFilter(filterName = "auth-admin",urlPatterns = {"/admin/*","/create/*","/updata/*","/delete/*","/reset/*","/edit/*"})
public class AuthAdminFilter implements HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String uri = req.getRequestURI();
		User user = (User) req.getSession().getAttribute("user");
		String er="";
		if (user==null) {
			er = res.encodeURL("VuiLongDangNhap");
		}else if(!user.isAdmin()){
			er=res.encodeURL("Ban khong phai admin trang web");
		}
		
		if (!er.isEmpty()) {
			req.getSession().setAttribute("securi",uri);
			res.sendRedirect("/Java4_ASM_PC00653/login?er="+res.encodeURL(er));
		} else {
			chain.doFilter(req, res);
		}
		
	}

}

package com.truongta.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.truongta.DAOs.UserDao;
import com.truongta.entities.User;

import com.truongta.utils.RRShare;
@MultipartConfig
@WebServlet("/edit-profile")
public class EditProfileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		HttpSession s = req.getSession();
		try {
			User u = (User) s.getAttribute("user");
			System.out.println("da vao dc edit profile");
			resp.setCharacterEncoding("UTF-8"); 
			resp.getWriter().write(" <label for=\"\">Username</label>\r\n"
	    		+ "                        <input value=\""+u.getId()+"\" type=\"text\" name=\"username\" id=\"\" class=\"form-control\" placeholder=\"Username\"\r\n"
	    		+ "                            aria-describedby=\"helpId\"> <br>\r\n"
	    		+ "                            <label for=\"\">Full name</label>\r\n"
	    		+ "                        <input value=\""+u.getFullName()+"\" type=\"text\" name=\"fullname\" id=\"\" class=\"form-control\" placeholder=\"Full name\"\r\n"
	    		+ "                            aria-describedby=\"helpId\"> <br>\r\n"
	    		+ "                            <label for=\"\">Email</label>\r\n"
	    		+ "                        <input value=\""+u.getEmail()+"\" type=\"text\" name=\"emailu\" id=\"\" class=\"form-control\" placeholder=\"Email\"\r\n"
	    		+ "                            aria-describedby=\"helpId\"> <br>\r\n"
	    		+ "                        <hr>\r\n"
	    		+ "                        <button onclick=\"rep()\" type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n"
	    		+ "                        <button onclick=\"edit()\" type=\"submit\" class=\"btn btn-primary\">UPDATE</button>");
	} catch (Exception e) {
		resp.getWriter().write("<h1>Bro Chua Login</h1>");
	}
}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		try {
			User user = (User) s.getAttribute("user");
			user.setFullName(req.getParameter("fullname"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			
			UserDao udao = new UserDao();
			udao.update(user);
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8"); 
			resp.getWriter().write("<div id=\"tb\" class=\"alert alert-success\" role=\"alert\">\r\n"
					+ "Cap nhat thanh cong\r\n"
					+ "</div>");
		} catch (Exception e) {
			resp.getWriter().write("<div id=\"tb\" class=\"alert alert-danger\" role=\"alert\">\r\n"
					+ "  Cap nhat khong thanh cong!\r\n"
					+ "</div>");
			e.printStackTrace();
		}
	}
	}

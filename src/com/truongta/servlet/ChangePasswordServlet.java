package com.truongta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.truongta.DAOs.UserDao;
import com.truongta.entities.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/change-password")
public class ChangePasswordServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwc = req.getParameter("pwc");
		String pwm = req.getParameter("pwm");
		String rpw = req.getParameter("rpw");
		UserDao udao = new UserDao();
		HttpSession s = req.getSession();
		User  user = (User) s.getAttribute("user");
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8"); 
		if (user == null) {
			
		}else {
			if (user.getPassword().equals(pwc)) {
				if (pwm.equals(rpw)) {
					user.setPassword(pwm);
					udao.update(user);
					resp.getWriter().write("<div id=\"tb\" class=\"alert alert-success\" role=\"alert\">\r\n"
							+ " Thay Doi Password Thanh Cong !\r\n"
							+ "</div>");
				}else {
					resp.getWriter().write("<div id=\"tb\" class=\"alert alert-success\" role=\"alert\">\r\n"
							+ " Mat Khau Moi Khong Khop !\r\n"
							+ "</div>");
				}
			}else {
				resp.getWriter().write("<div id=\"tb\" class=\"alert alert-success\" role=\"alert\">\r\n"
						+ " Mat Khau Cu Khong Trung Khop !\r\n"
						+ "</div>");
			}
		}
	}

}

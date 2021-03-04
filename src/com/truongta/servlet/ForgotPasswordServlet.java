package com.truongta.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.truongta.DAOs.UserDao;
import com.truongta.entities.User;
import com.truongta.utils.XMail;


@WebServlet({"/showpassword","/send-code"})
public class ForgotPasswordServlet extends HttpServlet{
	UserDao udao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession s = req.getSession();
		if (uri.contains("showpassword")) {
			String user = req.getParameter("user");
			String email = req.getParameter("email");
			List<User> users = udao.findAll();
			
			
			boolean kt =true;
			for (User u : users) {
				if (u.getId().equals(user) && u.getEmail().equals(email)) {
					Random r = new Random();
					int code = r.nextInt((9999 - 1000) + 1) + 1000;
					
					System.out.println(code);
					s.setAttribute("code", code);
					XMail.sendMail(email, "Forgot Password", "Code : "+code);
					
					kt=false;
					
					resp.setContentType("text/plain");  
				    resp.setCharacterEncoding("UTF-8"); 
				    resp.getWriter().write(" <form action=\"\" method=\"POST\">\r\n"
				    		+ "                        <input type=\"text\" name=\"code\" id=\"\" class=\"form-control\" placeholder=\"Code\"\r\n"
				    		+ "                            aria-describedby=\"helpId\"> <br>\r\n"
				    		+"							<input hidden value=\""+u.getEmail()+"\"  name=\"emailToSend\" >"
				    		+"							<input hidden value=\""+u.getPassword()+"\"  name=\"passToSend\" >"
				    		+ "                        <hr>\r\n"
				    		+ "                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n"
				    		+ "                        <button onclick=\"sendCode()\"  class=\"btn btn-primary\">Retrieve</button>\r\n"
				    		+ "	</form>");
				}
			}
			

			if (kt) {
				resp.setContentType("text/plain");  
			    resp.setCharacterEncoding("UTF-8"); 
			    resp.getWriter().write("Thong tin ban nhap khong trung khop");
			}
			
		}else {
			int code = Integer.parseInt(req.getParameter("code"));
			int codex = (int) s.getAttribute("code");
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			if (code==codex) {
				XMail.sendMail(email, "Password","Password :"+ pass);
				resp.setContentType("text/plain");  
			    resp.setCharacterEncoding("UTF-8"); 
			    resp.getWriter().write("<div class=\"alert alert-success\" role=\"alert\">\r\n"
			    		+ "  Da Gui Password Den Email Cua Ban !\r\n"
			    		+ "</div>");
			}else {
				resp.setContentType("text/plain");  
			    resp.setCharacterEncoding("UTF-8"); 
			    resp.getWriter().write("<div class=\"alert alert-success\" role=\"alert\">\r\n"
			    		+ "  Code Ban Nhap Khong Khop!\r\n"
			    		+ "</div>");
			}
		}
		
	}
	
	
}

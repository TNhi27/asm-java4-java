package com.truongta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongta.utils.XMail;
@WebServlet("/share-video")
public class ShareVideoServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String mess = req.getParameter("mess");
		String link = "https://www.youtube.com/watch?v="+id;
		
		
		XMail.sendMail(email, mess, link);
		
		resp.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    resp.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    resp.getWriter().write("<div id=\"tb\" class=\"alert alert-success\" role=\"alert\">\r\n"
	    		+ "  Share Video Success !\r\n"
	    		+ "</div>");
		
		
	}
}

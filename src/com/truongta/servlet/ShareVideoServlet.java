package com.truongta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.truongta.DAOs.ShareDao;
import com.truongta.DAOs.VideoDao;
import com.truongta.entities.Share;
import com.truongta.entities.User;
import com.truongta.entities.Video;
import com.truongta.utils.XMail;
@WebServlet("/share-video")
public class ShareVideoServlet extends HttpServlet{
	ShareDao sdao = new ShareDao();
	VideoDao vdao = new   VideoDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String mess = req.getParameter("mess");
		String link = "https://www.youtube.com/watch?v="+id;
		System.out.println(id);
		XMail.sendMail(email, mess, link);
		//tao entity Share
		HttpSession s = req.getSession();
		User user = (User) s.getAttribute("user");
		Video video = vdao.findById(id);
		
		
		Share share = new Share();
		share.setEmail(email);
		share.setUser(user);
		share.setVideo(video);
		sdao.create(share);
		
		resp.setContentType("text/plain");  
	    resp.setCharacterEncoding("UTF-8"); 
	    resp.getWriter().write("<div id=\"tb\" class=\"alert alert-success\" role=\"alert\">\r\n"
	    		+ "  Share Video Success !\r\n"
	    		+ "</div>");
		
		
	}
}

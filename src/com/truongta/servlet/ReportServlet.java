package com.truongta.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongta.DAOs.ReportDao;
import com.truongta.DAOs.VideoDao;
import com.truongta.entities.Favorite;
import com.truongta.entities.Report;
import com.truongta.entities.UserFav;
import com.truongta.entities.UserShare;
import com.truongta.entities.Video;

@WebServlet({"/admin/reports","/admin/share-report"})
public class ReportServlet extends HttpServlet{
	ReportDao rdao = new ReportDao();
	VideoDao vdao = new VideoDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Report> list = rdao.getReport();
		
	
		if (req.getRequestURI().contains("/admin/reports")) {
			req.setAttribute("favorite", list);
			req.getRequestDispatcher("/views/admin/thongke.jsp").forward(req, resp);
		}
		if (req.getRequestURI().contains("/admin/share-report")) {
			String id = req.getParameter("idShare");
			List<UserShare> us = rdao.getUserShare(id);
			String data="";
			for (UserShare u : us) {
				data+="<tr>\r\n"
						+ "	<td>"+u.getFromUser()+"</td>\r\n"
						+ "	<td>"+u.getFromEmail()+"</td>\r\n"
						+ "	<td>"+u.getToEmail()+"</td>\r\n"
						+ "	<td>"+u.getDaySend()+"</td>\r\n"
						+ "	</tr>";
			}
			resp.setContentType("text/plain");  
		    resp.setCharacterEncoding("UTF-8"); 
		    resp.getWriter().write(data);
		}
	}
}

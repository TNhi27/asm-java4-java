package com.truongta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongta.DAOs.VideoDao;
import com.truongta.entities.Video;
@WebServlet({"/admin/home","/admin/all-video"})
public class ViewAdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String uri = req.getRequestURI();
			VideoDao vdao = new VideoDao();
			System.out.println(uri);
			if (uri.contains("admin/home")) {
				
				req.getRequestDispatcher("/views/admin/admin.jsp").forward(req, resp);
			}
			if (uri.contains("admin/all-video")) {
				List<Video> list = vdao.findAll();
				req.setAttribute("videos", list);
				req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

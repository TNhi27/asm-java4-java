package com.truongta.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.truongta.DAOs.VideoDao;
import com.truongta.entities.Video;
import com.truongta.utils.RRShare;
import com.truongta.utils.XForm;
@MultipartConfig
@WebServlet({"/create","/updata","/delete","/reset","/edit"})
public class AdVideoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		VideoDao vdao = new VideoDao();
		if (uri.equals("/Java4_ASM_PC00653/edit")) {
			Video video = vdao.findById(req.getParameter("id"));
			
			req.setAttribute("video", video);
			List<Video> list = vdao.findAll();
			req.setAttribute("videos", list);
			req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String uri = req.getRequestURI();
			VideoDao vdao = new VideoDao();
			
			
			if (uri.equals("/Java4_ASM_PC00653/create")) {
				Video video = this.getForm(req);
				vdao.create(video);
				List<Video> list = vdao.findAll();
				req.setAttribute("videos", list);
				req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
			}
			if (uri.equals("/Java4_ASM_PC00653/updata")) {
				try {
					Video video = this.getForm(req);
					vdao.update(video);
					req.setAttribute("mess", "Cap Nhat Thanh Cong");
				} catch (Exception e) {
					req.setAttribute("mess", "Khong Duoc De Trong Poster");
				}
				
				List<Video> list = vdao.findAll();
				req.setAttribute("videos", list);
				req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
			}
			if (uri.equals("/Java4_ASM_PC00653/delete")) {
				String id = req.getParameter("idytb");
			
				
				vdao.remove(id);
				req.setAttribute("mess", "Xoa Thanh Cong");
				List<Video> list = vdao.findAll();
				req.setAttribute("videos", list);
				req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
			}
			if (uri.equals("/Java4_ASM_PC00653/reset")) {
				List<Video> list = vdao.findAll();
				req.setAttribute("videos", list);
				req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
			}
		
		
	}
	public Video getForm(HttpServletRequest req) throws NullPointerException{
		RRShare.add(req, null);
		Video video = new Video();
		String id = req.getParameter("idytb");
		String title = req.getParameter("title");
		int  views = Integer.parseInt(req.getParameter("views"));
		boolean active = Boolean.parseBoolean(req.getParameter("active"));
		String descrip = req.getParameter("description");
		String poster = XForm.saveFile("poster", "/static/file").getName();
		
		video.setId(id);
		video.setTitle(title);
		video.setViews(views);
		video.setDescription(descrip);
		video.setActive(active);
		video.setPoster(poster);
		
		
		return video;
		
	}
}

package com.truongta.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.truongta.DAOs.FavoriteDao;
import com.truongta.DAOs.SeenDao;
import com.truongta.DAOs.UserDao;
import com.truongta.DAOs.VideoDao;
import com.truongta.entities.Favorite;
import com.truongta.entities.Seen;
import com.truongta.entities.User;
import com.truongta.entities.Video;


@WebServlet(value = {"/","/user/favorite","/chi-tiet"})
public class IndexServlet extends HttpServlet{
	VideoDao vdao = new VideoDao();
	SeenDao sdao = new SeenDao();
	FavoriteDao fdao = new  FavoriteDao();
	SeenDao seendao = new   SeenDao();
	UserDao udao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession s = req.getSession();
		User user = (User) s.getAttribute("user");
		if (uri.equals("/Java4_ASM_PC00653/")) {
			if (user != null) {
				List<Video> videos = vdao.findAll();
				List<Favorite> favorite = fdao.findByUser(user.getId());
				req.setAttribute("fav", favorite);
				req.setAttribute("videos", videos);
				req.setAttribute("view", "/views/user/trangchu.jsp");
			}else {
				List<Video> videos = vdao.findAll();
				req.setAttribute("videos", videos);
				req.setAttribute("view", "/views/user/trangchu.jsp");
			}
			
			
			
		}else if (uri.equals("/Java4_ASM_PC00653/favorite")) {
			if (user == null) {
				
				req.setAttribute("error", "Chua Co Video Yeu Thich");
				req.setAttribute("view", "/views/user/error.jsp");
			}else {
				List<Favorite> list = fdao.findByUser(user.getId());
				req.setAttribute("favorite", list);
				req.setAttribute("view", "/views/user/favorite.jsp");
			}
			
			
		}else if (uri.equals("/Java4_ASM_PC00653/chi-tiet")) {
			
			String id = req.getParameter("id");
			Video v = vdao.findById(id);
			
			if (user != null) {
				Seen seen = new Seen();
				seen.setUser(udao.findById(user.getId()));
				seen.setVideo(v);
				seendao.create(seen);
				
				v.setViews(v.getViews()+1);
				vdao.update(v);
				
				
				List<Video> list = sdao.getSeenVideo(user.getId());
				List<Favorite> favorite = fdao.findByUser(user.getId());
				req.setAttribute("fav", favorite);			
				req.setAttribute("seen", list);
			}
			
			req.setAttribute("video", v);
			req.setAttribute("view", "/views/user/chi_tiet.jsp");
		}
		
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
	
	
}

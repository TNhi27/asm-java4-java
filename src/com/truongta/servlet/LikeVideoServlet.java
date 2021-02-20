package com.truongta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.truongta.DAOs.FavoriteDao;
import com.truongta.DAOs.UserDao;
import com.truongta.DAOs.VideoDao;
import com.truongta.entities.Favorite;
import com.truongta.entities.User;
import com.truongta.entities.Video;

@WebServlet("/like-video")
public class LikeVideoServlet extends HttpServlet{
	VideoDao vdao = new VideoDao();
	UserDao udao = new UserDao();
	FavoriteDao fdao = new FavoriteDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		User user = (User) s.getAttribute("user");
		Video video = vdao.findById(req.getParameter("id"));
		
		List<Favorite> list = fdao.findAll();
		boolean ck =true;
		for (Favorite f : list) {
			if (f.getUser().getId().equals(user.getId()) && f.getVideo().getId().equals(video.getId())) {
				ck=false;
				fdao.remove(f.getId());
				System.out.println("Da unlike video"+video.getId());
			}
		}
		if (ck) {
			Favorite favorite = new Favorite();
			favorite.setUser(user);
			favorite.setVideo(video);
			fdao.create(favorite);
			System.out.println("Da like video"+video.getId());
		}
		
		
		
		List<Video> videos = vdao.findAll();
		List<Favorite> favorite = fdao.findByUser(user.getId());
		req.setAttribute("fav", favorite);
		req.setAttribute("videos", videos);
		req.setAttribute("view", "/views/user/trangchu.jsp");
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
}

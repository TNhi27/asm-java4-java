package com.truongta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongta.DAOs.FavoriteDao;
import com.truongta.DAOs.VideoDao;
import com.truongta.entities.Favorite;
import com.truongta.entities.User;
import com.truongta.entities.Video;
@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	VideoDao vdao = new VideoDao();
	FavoriteDao fdao = new FavoriteDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		User user = (User) req.getSession().getAttribute("user");
		List<Video> list = vdao.findByKeyword(key);
		if (user != null) {
			
			List<Favorite> favorite = fdao.findByUser(user.getId());
			req.setAttribute("fav", favorite);
			req.setAttribute("videos", list);
			req.setAttribute("view", "/views/user/trangchu.jsp");
		}else {
			req.setAttribute("videos", list);
			req.setAttribute("view", "/views/user/trangchu.jsp");
		}
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
}

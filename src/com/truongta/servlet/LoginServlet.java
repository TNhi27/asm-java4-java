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

import com.truongta.utils.RRShare;


@WebServlet({"/login","/dang-ki","/logout"})
public class LoginServlet extends HttpServlet{
	VideoDao vdao = new VideoDao();
	FavoriteDao fdao = new FavoriteDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String view ="";
		System.out.println(uri);
		if (uri.equals("/Java4_ASM_PC00653/login")) {
			view = "/views/login.jsp";
		}else if (uri.equals("/Java4_ASM_PC00653/dang-ki")){
			view = "/views/dangki.jsp";
		}else if(uri.equals("/Java4_ASM_PC00653/logout")) {
			HttpSession s = req.getSession();
			s.removeAttribute("user");
			List<Video> videos = vdao.findAll();
			req.setAttribute("videos", videos);
			req.setAttribute("view", "/views/user/trangchu.jsp");
			view = "/views/user/index.jsp";
		}
		
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		UserDao dao = new UserDao();
		if (uri.equals("/Java4_ASM_PC00653/login")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			List<User> list = dao.findAll();
			boolean kt = false;
			for (User u : list) {
				if (u.getId().equals(username)&&u.getPassword().equals(password)) {
					kt= true;
					
					HttpSession session = req.getSession();
					session.setAttribute("user", u);
					if (u.isAdmin()) {
						req.getRequestDispatcher("views/admin/admin.jsp").forward(req, resp);
					}else {
						List<Video> videos = vdao.findAll();
						List<Favorite> favorite = fdao.findByUser("truongta1");
						req.setAttribute("fav", favorite);
						req.setAttribute("videos", videos);
						req.setAttribute("view", "/views/user/trangchu.jsp");
						req.getRequestDispatcher("views/user/index.jsp").forward(req, resp);
					}
					
				}
			}
			
			if (kt==false) {
				req.setAttribute("mess", true);
				req.getRequestDispatcher("views/login.jsp").forward(req, resp);
			}
		}
	}
}

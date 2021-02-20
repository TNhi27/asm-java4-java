package com.truongta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.truongta.DAOs.UserDao;
import com.truongta.entities.User;
@MultipartConfig
@WebServlet({"/admin/users","/admin/edit-user","/admin/updata-user"})
public class AdUserServlet extends HttpServlet{
	UserDao udao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		List<User> list = udao.findAll();
		req.setAttribute("users", list);
		if (uri.contains("users")) {
			
			req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
		}
		if (uri.contains("edit-user")) {
			String id = req.getParameter("idu");
			User u = udao.findById(id);
			req.setAttribute("user", u);
			
			req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		List<User> list = udao.findAll();
		req.setAttribute("users", list);
		if (uri.contains("updata-user")) {
			
			User u = this.getForm(req);
			req.setAttribute("user", u);
			udao.update(u);
			req.setAttribute("mess", "Cap Nhat Thanh Cong");
			req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
		}
		if (uri.contains("delete-user")) {
			
			User u = this.getForm(req);
			udao.remove(u.getId());
			req.setAttribute("mess", "Xoa Thanh Cong");
			req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
		}
	}
	
	public User getForm(HttpServletRequest req) {
		User u = new User();
		try {
			BeanUtils.populate(u, req.getParameterMap());
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

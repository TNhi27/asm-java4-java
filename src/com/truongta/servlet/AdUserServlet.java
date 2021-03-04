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

import com.truongta.DAOs.ReportDao;
import com.truongta.DAOs.UserDao;
import com.truongta.entities.User;
import com.truongta.entities.UserFav;
@MultipartConfig
@WebServlet({"/admin/users","/admin/edit-user","/admin/updata-user","/admin/change-video"})
public class AdUserServlet extends HttpServlet{
	UserDao udao = new UserDao();
	ReportDao rdao = new ReportDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String uri = req.getRequestURI();
			
			List<User> list = udao.findAll();
			req.setAttribute("users", list);
			if (uri.contains("users")) {
				
				req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
			}else
			if (uri.contains("edit-user")) {
				String id = req.getParameter("idu");
				User u = udao.findById(id);
				req.setAttribute("user", u);
				
				req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		List<User> list = udao.findAll();
		req.setAttribute("users", list);
		if (uri.equals("/Java4_ASM_PC00653/admin/change-video")) {
			String idv = req.getParameter("idnow");
			List<UserFav> ufav = rdao.getFavoriteByUser(idv);
			String data="";
			for (UserFav a : ufav) {
				data+="<tr>\r\n"
						+ "	<td>"+a.getUserID()+"</td>\r\n"
						+ "	<td>"+a.getFullName()+"</td>\r\n"
						+ "	<td>"+a.getEmail()+"</td>\r\n"
						+ "	<td>"+a.getDay()+"</td>\r\n"
						+ "	</tr>";
			}
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(data);
		}
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

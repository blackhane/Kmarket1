package kr.co.Kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminDAO;

@WebServlet("/admin/cs/notice/delete2.do")
public class NoticeDeleteController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		AdminDAO.getInstance().deleteNotice(no);
		
		resp.sendRedirect("/Kmarket/admin/cs/notice/list.do?resultCode=101");
	}

}

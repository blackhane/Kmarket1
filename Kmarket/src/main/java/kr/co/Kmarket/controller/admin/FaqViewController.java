package kr.co.Kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CsFaqVO;

@WebServlet("/admin/cs/faq/view.do")
public class FaqViewController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		AdminDAO dao = AdminDAO.getInstance();
		CsFaqVO faq = dao.FaqView(no);
		
		req.setAttribute("faq", faq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_admin/_cs/_faq/view.jsp");
		dispatcher.forward(req, resp);
	}

}

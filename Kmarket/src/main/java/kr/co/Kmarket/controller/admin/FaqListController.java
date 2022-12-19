package kr.co.Kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/cs/faq/list.do")
public class FaqListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String ls = req.getParameter("ls");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		if(ls == null) {
			ls = "전체보기";
		}
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_faq/list.jsp");
		dispathcer.forward(req, resp);
	}
	
}

package kr.co.Kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminQnaDAO;
import kr.co.Kmarket.VO.CsQnaVO;

@WebServlet("/admin/cs/qna/view.do")
public class QnaViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		AdminQnaDAO dao = AdminQnaDAO.getInstance();
		CsQnaVO qna = dao.QnaView(no);
		CsQnaVO comment = dao.selectComment(no);
		
		req.setAttribute("qna", qna);
		req.setAttribute("comment", comment);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_qna/view.jsp");
		dispathcer.forward(req, resp);
		
	}
}

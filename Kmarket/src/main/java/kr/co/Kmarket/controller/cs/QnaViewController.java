package kr.co.Kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsQnaDAO;
import kr.co.Kmarket.DAO.admin.AdminQnaDAO;
import kr.co.Kmarket.VO.CsQnaVO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/cs/qna/view.do")
public class QnaViewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String group = req.getParameter("group");
		String pg = req.getParameter("pg");
		
		CsQnaVO comment = AdminQnaDAO.getInstance().selectComment(no);
		CsVO vo = CsQnaDAO.getInstance().selectArticle(no);
		
		req.setAttribute("article", vo);
		req.setAttribute("group", group);
		req.setAttribute("pg", pg);
		req.setAttribute("comment", comment);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_qna/view.jsp");
		dispatcher.forward(req, resp);
	}
}

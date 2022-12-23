package kr.co.Kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsNoticeDAO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/cs/notice/view.do")
public class NoticeViewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String kind = req.getParameter("kind");
		String pg = req.getParameter("pg");
		
		CsNoticeDAO dao = CsNoticeDAO.getInstance();
		CsVO vo = dao.selectArticle(no);
		dao.updateArticleHit(no);
		
		req.setAttribute("vo", vo);
		req.setAttribute("kind", kind);
		req.setAttribute("pg", pg);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_notice/view.jsp");
		dispatcher.forward(req, resp);
	}
}

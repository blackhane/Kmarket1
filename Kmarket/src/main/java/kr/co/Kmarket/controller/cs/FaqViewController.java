package kr.co.Kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsFaqDAO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/cs/faq/view.do")
public class FaqViewController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String group = req.getParameter("group");
		
		CsFaqDAO dao = CsFaqDAO.getInstance();
		CsVO vo = dao.selectArticle(no);
		dao.updateArticleHit(no);
		
		req.setAttribute("group", group);
		req.setAttribute("article", vo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_faq/view.jsp");
		dispatcher.forward(req, resp);
	}
}

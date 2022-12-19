package kr.co.Kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsFaqDAO;
import kr.co.Kmarket.VO.CsVO;
@WebServlet("/cs/faq/list.do")
public class FaqListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CsVO> vo1 = CsFaqDAO.getInstance().selectArticles("a");
		List<CsVO> vo2 = CsFaqDAO.getInstance().selectArticles("b");
		List<CsVO> vo3 = CsFaqDAO.getInstance().selectArticles("c");
		List<CsVO> vo4 = CsFaqDAO.getInstance().selectArticles("d");
		req.setAttribute("articles1", vo1);
		req.setAttribute("articles2", vo2);
		req.setAttribute("articles3", vo3);
		req.setAttribute("articles4", vo4);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_faq/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}

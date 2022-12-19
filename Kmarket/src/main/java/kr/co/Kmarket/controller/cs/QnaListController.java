package kr.co.Kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsQnaDAO;
import kr.co.Kmarket.VO.CsVO;
@WebServlet("/cs/qna/list.do")
public class QnaListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CsVO> vo = CsQnaDAO.getInstance().selectArticles();
		req.setAttribute("articles", vo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_qna/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}

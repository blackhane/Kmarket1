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
		String group = req.getParameter("group");
		
		CsFaqDAO dao = CsFaqDAO.getInstance();
		//그룹 => 카테고리 찾기
		List<String> cate = dao.searchCate(group);
		List<CsVO> articles = dao.selectArticles(group);
		
		req.setAttribute("articles", articles);
		req.setAttribute("cate", cate);
		req.setAttribute("group", group);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_faq/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}

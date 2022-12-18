package kr.co.Kmarket.controller.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsNoticeDAO;
import kr.co.Kmarket.VO.CsVO;
@WebServlet("/cs/notice/list.do")
public class NoticeListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		
		CsNoticeDAO dao = CsNoticeDAO.getInstance();
		List<CsVO> vo = new ArrayList<>();
		
		if(group.equals("all")) {
			vo = dao.selectArticles();
		}else {
			vo = dao.selectArticles(group);
		}
		
		req.setAttribute("kind", group);
		req.setAttribute("articles", vo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_notice/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}

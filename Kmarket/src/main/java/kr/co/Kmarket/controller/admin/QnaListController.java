package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminQnaDAO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/admin/cs/qna/list.do")
public class QnaListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		AdminQnaDAO dao = AdminQnaDAO.getInstance();

		
		List<CsVO> vo = dao.selectQna(group, cate);
		req.setAttribute("vo", vo);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_admin/_cs/_qna/QnaList.jsp");
		dispatcher.forward(req, resp);
	}
}

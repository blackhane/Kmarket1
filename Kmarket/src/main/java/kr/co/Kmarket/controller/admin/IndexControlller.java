package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CsNoticeVO;

@WebServlet("/admin/index.do")
public class IndexControlller extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		String ls = req.getParameter("ls");
		
		List<CsNoticeVO> notice = AdminDAO.getInstance().selectNotice(cate, ls);
		req.setAttribute("notice", notice);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_admin/index.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}

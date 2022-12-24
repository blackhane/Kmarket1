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
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/admin/index.do")
public class IndexControlller extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminDAO dao = AdminDAO.getInstance();
		
		List<CsNoticeVO> notice = dao.selectNotice();
		List<CsVO> qna = dao.selectQna();
		
		req.setAttribute("notice", notice);
		req.setAttribute("qna", qna);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_admin/index.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}

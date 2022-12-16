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
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/Kmarket/admin/cs/notice/list.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<CsNoticeVO> notice = AdminDAO.getInstance().selectNotice();
		req.setAttribute("notice", notice);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_notice/list.jsp");
		dispathcer.forward(req, resp);
	}
	
	
}
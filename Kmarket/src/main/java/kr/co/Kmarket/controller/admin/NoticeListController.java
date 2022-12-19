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

@WebServlet("/admin/cs/notice/list.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String cate = req.getParameter("cate");
		String ls = req.getParameter("ls");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		if(ls == null) {
			ls = "전체보기";
		}
		
		List<CsNoticeVO> notice = AdminDAO.getInstance().selectNotice(cate, ls);
		req.setAttribute("notice", notice);
		
		
		CsNoticeVO vo = new CsNoticeVO();
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		
		req.setAttribute("vo", vo);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_notice/list.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
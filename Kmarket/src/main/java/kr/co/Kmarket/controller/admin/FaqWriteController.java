package kr.co.Kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/admin/cs/faq/write.do")
public class FaqWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_faq/write.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String regip = req.getRemoteAddr();
		
		CsVO vo = new CsVO();
		vo.setGroup(group);
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setRegip(regip);
		
		AdminDAO dao = AdminDAO.getInstance();
		dao.insertFaq(vo);
		
		resp.sendRedirect("/Kmarket/admin/cs/faq/list.do");
	}
	
}

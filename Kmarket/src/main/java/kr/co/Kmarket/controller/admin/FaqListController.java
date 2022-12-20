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
import kr.co.Kmarket.VO.CsFaqVO;

@WebServlet("/admin/cs/faq/list.do")
public class FaqListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		List<CsFaqVO> faq = AdminDAO.getInstance().selectFaq(cate);
		req.setAttribute("faq", faq);
		
		CsFaqVO vo = new CsFaqVO();
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		
		req.setAttribute("vo", vo);
		
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_faq/list.jsp");
		dispathcer.forward(req, resp);
	}
	
}

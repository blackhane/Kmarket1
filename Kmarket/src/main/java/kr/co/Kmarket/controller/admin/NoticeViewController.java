package kr.co.Kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CsNoticeVO;


@WebServlet("/admin/cs/notice/view.do")
public class NoticeViewController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String no = req.getParameter("no");
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");
		
				
		AdminDAO dao =  AdminDAO.getInstance();
		CsNoticeVO notice = dao.NoticeView(no);
		
		req.setAttribute("notice", notice);
		req.setAttribute("cate", cate);
		req.setAttribute("pg", pg);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_notice/view.jsp");
		dispathcer.forward(req, resp);
	}
}

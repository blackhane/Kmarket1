package kr.co.Kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CsNoticeVO;


@WebServlet("/admin/cs/notice/modify.do")
public class NoticeModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		CsNoticeVO vo = AdminDAO.getInstance().NoticeView(no);
		
		req.setAttribute("vo", vo);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_notice/modify.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		if(cate.equals("고객 서비스")) {
			group = "service";
		}else if(cate.equals("안전거래")){
			group = "safe";
		}else if(cate.equals("위해상품")){
			group = "danger";
		}else if(cate.equals("이벤트 당첨")){
			group = "event";
		}
		
		AdminDAO.getInstance().updateNotice(no, group, cate, title, content);
		
		resp.sendRedirect("/Kmarket/admin/cs/notice/view.do?no=" + no);
	}

}

package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.net.URLEncoder;

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
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");
		
		CsNoticeVO vo = AdminDAO.getInstance().NoticeView(no);
		
		req.setAttribute("vo", vo);
		req.setAttribute("cate", cate);
		req.setAttribute("pg", pg);
		
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
		
		String ct = URLEncoder.encode("전체보기", "UTF-8");
		resp.sendRedirect("/Kmarket/admin/cs/notice/list.do?cate="+ct+"&pg=1");
	}

}

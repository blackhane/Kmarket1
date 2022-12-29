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
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/admin/cs/notice/write.do")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_notice/write.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String regip = req.getRemoteAddr();
		String group = req.getParameter("group");
		
		if(cate.equals("고객 서비스")) {
			group = "service";
		}else if(cate.equals("안전거래")){
			group = "safe";
		}else if(cate.equals("위해상품")){
			group = "danger";
		}else if(cate.equals("이벤트 당첨")){
			group = "event";
		}
		
		CsVO vo = new CsVO();
		vo.setGroup(group);
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setRegip(regip);
		
		AdminDAO dao = AdminDAO.getInstance();
		dao.insertNotice(vo);
		
		// 리다이렉트
		String ct = URLEncoder.encode("전체보기", "UTF-8");
		resp.sendRedirect("/Kmarket/admin/cs/notice/list.do?cate="+ct+"&pg=1");
		
	}

}

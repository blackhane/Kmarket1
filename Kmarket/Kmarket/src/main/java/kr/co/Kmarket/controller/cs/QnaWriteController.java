package kr.co.Kmarket.controller.cs;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsQnaDAO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/cs/qna/write.do")
public class QnaWriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		req.setAttribute("group", group);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_qna/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("type1");
		String cate = req.getParameter("type2");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String uid = req.getParameter("uid");
		String regip = req.getRemoteAddr();
		
		CsVO vo = new CsVO();
		vo.setGroup(group);
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setUid(uid);
		vo.setRegip(regip);
		
		CsQnaDAO.getInstance().insertArticle(vo);
		String encoded = URLEncoder.encode(group, "UTF-8");
		resp.sendRedirect("/Kmarket/cs/qna/list.do?group="+encoded);
	}

}

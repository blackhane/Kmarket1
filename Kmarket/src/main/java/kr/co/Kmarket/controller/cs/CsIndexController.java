package kr.co.Kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.HelpDAO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/cs/index.do")
public class CsIndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CsVO> notice = HelpDAO.getInstance().selectListNotice();
		List<CsVO> qna = HelpDAO.getInstance().selectListQna();
		
		req.setAttribute("notice", notice);
		req.setAttribute("qna", qna);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/index.jsp");
		dispatcher.forward(req, resp);
	}
	
}

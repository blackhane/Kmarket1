package kr.co.Kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CsQnaDAO;
import kr.co.Kmarket.VO.CsVO;
@WebServlet("/cs/qna/list.do")
public class QnaListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		
		CsQnaDAO dao = CsQnaDAO.getInstance();
		
		//페이징
		int start = 0;
		int total = 0;
		int lastPageNum = 0;
		int currentPage = 1;
		int currentPageGroup = 1;
		int pageGroupStart = 0;
		int pageGroupEnd = 0;
		
		//현재 페이지 번호
		String pg = req.getParameter("pg");
		if(pg != null){
			currentPage = Integer.parseInt(pg);
		}
		
		//현재 페이지 그룹 (ex: 1~10 11~20 21~30)
		currentPageGroup = (int)Math.ceil(currentPage / 10.0);
		pageGroupStart = (currentPageGroup -1) * 10 + 1; //시작번호
		pageGroupEnd= currentPageGroup * 10; //끝번호
		
		//전체 게시물 갯수
		total = dao.selectCountTotal(group);
		
		//마지막 페이지 번호
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 +1;
		}
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		//글 번호 인덱스 (ex:1페이지=0부터, 2페이지=10부터)
		start = (currentPage - 1) * 10;
		
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("total", total);
		req.setAttribute("start", start);

		List<CsVO> vo = dao.selectArticles(group, start);
		req.setAttribute("articles", vo);
		req.setAttribute("group", group);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_cs/_qna/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}

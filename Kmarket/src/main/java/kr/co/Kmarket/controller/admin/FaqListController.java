package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CsFaqVO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/admin/cs/faq/list.do")
public class FaqListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		if(cate == null) {
			cate = "";
		}
		
		System.out.println(cate);
		
		AdminDAO dao = AdminDAO.getInstance();
		List<CsFaqVO> faq = new ArrayList<>();
		
		//페이징 처리
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
		if(group.equals("전체보기") && cate.equals("")) {
			total = dao.countTotalFaq();
		}else if(cate.equals("전체보기")) {
			total = dao.countTotalFaq(group);
		}else {
			total = dao.countTotalFaq(group, cate);
		}
		logger.debug("total : " + total);
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
		logger.debug("pageGroupEnd : " + pageGroupStart);
		logger.debug("pageGroupEnd : " + pageGroupEnd);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("total", total);
		req.setAttribute("start", start);
		
		
		if(group.equals("전체보기") && cate.equals("")) {
			faq = dao.selectFaq(start);
		}else if(cate.equals("전체보기")) {
			faq = dao.selectFaq(group, start);
		}else {
			faq = dao.selectFaq(group, cate, start);
		}
		
		req.setAttribute("faq", faq);
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_faq/list.jsp");
		dispathcer.forward(req, resp);
	}
	
}

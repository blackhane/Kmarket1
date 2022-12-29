package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.utils.pageHelper;

@WebServlet("/admin/cs/notice/page.do")
public class NoticePage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("cate");
		
		//페이징 처리
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
		AdminDAO dao = AdminDAO.getInstance();
		
		if(cate.equals("전체보기")) {
			total = dao.selectNoticeTotal();
		}else {
			total = dao.selectNoticeTotal(cate);
		}
		
		//마지막 페이지 번호
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 +1;
		}
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		pageHelper ph = new pageHelper();
		ph.setPageGroupStart(pageGroupStart);
		ph.setPageGroupEnd(pageGroupEnd);
		ph.setCurrentPage(currentPage);
		ph.setLastPageNum(lastPageNum);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(ph);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData.toString());
		logger.debug(jsonData.toString());
		writer.flush();
	}

}

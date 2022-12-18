package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CateVO;
import kr.co.Kmarket.VO.ProductVO;
import kr.co.Kmarket.VO.ReviewVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String prodNo = req.getParameter("prodNo");
		
		ProductDAO dao = ProductDAO.getInstance();
		String c1Name = dao.selectCate1Name(cate1);
		String c2Name = dao.selectCate2Name(cate1, cate2);
		ProductVO item = dao.selectProduct(prodNo);
		dao.updateProductHit(prodNo);
		
		CateVO vo = new CateVO();
		vo.setCate1(cate1);
		vo.setCate2(cate2);
		vo.setC1Name(c1Name);
		vo.setC2Name(c2Name);
		
		req.setAttribute("item", item);
		req.setAttribute("cate", vo);
		
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
		total = dao.selectCountReview(prodNo);
		
		//마지막 페이지 번호
		if(total % 5 == 0){
			lastPageNum = total / 5;
		}else{
			lastPageNum = total / 5 +1;
		}
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		//글 번호 인덱스 (ex:1페이지=0부터, 2페이지=10부터)
		start = (currentPage - 1) * 5;
		
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("total", total);
		req.setAttribute("start", start);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/view.jsp");
		dispatcher.forward(req, resp);
	}
}

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

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String level = req.getParameter("level");
		String company = req.getParameter("company");
		String search = req.getParameter("search");
		String keyword = req.getParameter("keyword");
		
		System.out.println(search);
		System.out.println(keyword);
		
		List<ProductVO> products = new ArrayList<>();
		AdminDAO dao = AdminDAO.getInstance();
		
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
		currentPageGroup = (int)Math.ceil(currentPage / 10.0); //총번호
		pageGroupStart = (currentPageGroup -1) * 10 + 1; //시작번호
		pageGroupEnd= currentPageGroup * 10; //끝번호
		
		//전체 게시물 갯수
		
		if(level.equals("7")) {
			//모든상품
			if(keyword != null) {
				total = dao.selectCountTotal1(keyword);	
			}else {
				total = dao.selectCountTotal();	
			}
		}else {
			//판매자상품
			if(keyword != null) {
				total = dao.selectCountTotal(company, keyword);
			}else {
				total = dao.selectCountTotal(company);	
			}
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
		
		//글 번호 인덱스 (ex:1페이지=0부터, 2페이지=10부터)
		start = (currentPage - 1) * 10;
		
		
		if(level.equals("7")) {
			//모든상품
			if(keyword != null) {
				products = dao.selectProduct1(search, keyword, start);
			}else {
				products = dao.selectProduct(start);
			}
		}else {
			//판매자상품
			if(keyword != null) {
				products = dao.selectProduct(search, company, keyword, start);
			}else {
				products = dao.selectProduct(company, start);	
			}
			
		}
		
		
		
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("total", total);
		req.setAttribute("start", start);
		
		req.setAttribute("products", products);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_product/list.jsp");
		dispathcer.forward(req, resp);
		
		
		/*
		 * String thumb1 = req.getParameter("thumb1"); String prodNo =
		 * req.getParameter("prodNo"); String prodName = req.getParameter("prodName");
		 * String price = req.getParameter("price"); String discount =
		 * req.getParameter("discount"); String point = req.getParameter("point");
		 * String stock = req.getParameter("stock"); String seller =
		 * req.getParameter("seller"); String hit = req.getParameter("hit");
		 */
		
//		ProductVO vo = new ProductVO();
//		vo.setThumb1(thumb1);
//		vo.setProdNo(prodNo);
//		vo.setProdName(prodName);
//		vo.setPrice(price);
//		vo.setDiscount(discount);
//		vo.setPoint(point);
//		vo.setStock(stock);
//		vo.setSeller(seller);
//		vo.setHit(hit);
	
	}
	
}
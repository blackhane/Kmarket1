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


@WebServlet("/product/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String ls = req.getParameter("ls");
		
		if(ls == null) {
			ls = "0";
		}
		
		ProductDAO dao = ProductDAO.getInstance();
		
		String c1Name = dao.selectCate1Name(cate1);
		String c2Name = dao.selectCate2Name(cate1, cate2);
		
		CateVO vo = new CateVO();
		vo.setCate1(cate1);
		vo.setC1Name(c1Name);
		vo.setCate2(cate2);
		vo.setC2Name(c2Name);
		
		//페이징 처리
		int start = 0;
		int total = 0;
		int lastPageNum = 0;
		int currentPage = 1;
		int currentPageGroup = 1;
		int pageGroupStart = 0;
		int pageGroupEnd = 0;
		int pageStartNum = 0;
		
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
		total = dao.selectCountTotal(cate1, cate2);
		
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
		
		List<ProductVO> product = dao.selectProducts(cate1, cate2, ls, start);
		
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("total", total);
		req.setAttribute("start", start);
		
		req.setAttribute("product", product);
		req.setAttribute("cate", vo);
		req.setAttribute("ls", ls);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/list.jsp");
		dispatcher.forward(req, resp);
	}
}

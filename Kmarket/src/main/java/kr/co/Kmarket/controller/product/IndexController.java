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
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDAO dao = ProductDAO.getInstance();
		//베스트 상품
		List<ProductVO> best = dao.selectProductsBest1();
		req.setAttribute("best", best);
		//히트 상품
		List<ProductVO> hit = dao.selectProductsBest2("hit");
		req.setAttribute("hit", hit);
		//추천 상품
		List<ProductVO> recommend = dao.selectProductsBest2("score");
		req.setAttribute("recommend", recommend);
		//최신 상품
		List<ProductVO> newItem = dao.selectProductsBest2("rdate");
		req.setAttribute("newItem", newItem);
		//할인 상품
		List<ProductVO> discount = dao.selectProductsBest2("discount");
		req.setAttribute("discount", discount);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_product/index.jsp");
		dispathcer.forward(req, resp);
	}
}

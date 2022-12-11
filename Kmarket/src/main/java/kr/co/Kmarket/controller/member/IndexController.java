package kr.co.Kmarket.controller.member;

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

@WebServlet("/")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO dao = ProductDAO.getInstance();
		//베스트 상품
		List<ProductVO> best = dao.selectProductsBest1();
		//히트 상품
		List<ProductVO> hit = dao.selectProductsBest2("hit");
		//추천 상품
		List<ProductVO> recommend = dao.selectProductsBest2("score");
		//최신 상품
		List<ProductVO> newItem = dao.selectProductsBest2("rdate");
		//할인 상품
		List<ProductVO> discount = dao.selectProductsBest2("discount");
		
		req.setAttribute("best", best);
		req.setAttribute("hit", hit);
		req.setAttribute("recommend", recommend);
		req.setAttribute("newItem", newItem);
		req.setAttribute("discount", discount);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/index.jsp");
		dispathcer.forward(req, resp);
	}
}

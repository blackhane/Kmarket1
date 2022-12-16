package kr.co.Kmarket.controller.product;

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

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CartVO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//뷰 페이지에서 올 경우
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		
		ProductVO vo = ProductDAO.getInstance().selectOrderProduct(prodNo, count);
		List<ProductVO> orderList = new ArrayList<>();
		orderList.add(vo);
		
		req.setAttribute("orderList", orderList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//장바구니에서 올 경우
		String jsonData = req.getParameter("jsonData");
		String[] item = jsonData.split(",");
		logger.debug("상품번호 : " +item.length);
		
		CartDAO dao =CartDAO.getInstance();
		List<CartVO> orderList = new ArrayList<>();
		
//		for(int i=0; i<len; i++) {
//			String cartNo = item[i];
//			logger.debug("카트번호 : " + cartNo);
//			CartVO vo = dao.selectCartOrder(cartNo);
//			orderList.add(vo);
//		}
		
		req.setAttribute("orderList", orderList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
		
	}
}

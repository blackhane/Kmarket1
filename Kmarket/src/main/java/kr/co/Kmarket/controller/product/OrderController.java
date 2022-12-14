package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CartVO;
import kr.co.Kmarket.VO.OrderItemVO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		
		ProductDAO dao = ProductDAO.getInstance();
		
		//상품보기 => 주문
		ProductVO item = dao.selectProduct(prodNo);
		item.setCount(count);
		
		req.setAttribute("items", item);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		CartDAO dao = CartDAO.getInstance();
		
		//장바구니 => 주문
		List<CartVO> items = dao.selectCartItem(uid);
		CartVO total = dao.selectTotalCart(uid);
		
		req.setAttribute("items", items);
		req.setAttribute("total", total);
	}
}

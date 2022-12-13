package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CartVO;

@WebServlet("/product/cart.do")
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		List<CartVO> carts = ProductDAO.getInstance().selectCartItem(uid);
		
		req.setAttribute("cart", carts);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/cart.jsp");
		dispatcher.forward(req, resp);
	}
}

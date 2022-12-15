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
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CartVO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		int count = Integer.parseInt(req.getParameter("count"));
		
		ProductDAO dao = ProductDAO.getInstance();
		
		//상품보기 => 주문
		ProductVO item = dao.selectProduct(prodNo);
		item.setCount(count);
		item.setDisPrice(item.getPrice()/100*item.getDiscount());
		
		List<ProductVO> vo = new ArrayList<>();
		vo.add(item);
		req.setAttribute("items", vo);

		//장바구니에서 왔어요~
		int comeCart = 0;
		req.setAttribute("comeCart", comeCart);
		
		HttpSession session = req.getSession();
		session.setAttribute("sessItem", vo);
		
		//최종결제정보
		ProductVO total = new ProductVO();
		total.setCount(count);
		total.setPrice(item.getPrice()*count);
		total.setDisPrice(item.getDisPrice()*count);
		total.setDelivery(item.getDelivery()*count);
		total.setPoint(item.getPoint()*count);
		req.setAttribute("total", total);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		CartDAO dao = CartDAO.getInstance();
		
		//장바구니 => 주문
		List<CartVO> items = dao.selectCartItem(uid);
		req.setAttribute("items", items);
		
		//장바구니에서 왔어요~
		int comeCart = 1;
		req.setAttribute("comeCart", comeCart);
		
		HttpSession session = req.getSession();
		session.setAttribute("sessItem", items);
		
		//최종결제정보
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
	}
}

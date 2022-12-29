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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CartVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//뷰 페이지에서 올 경우
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		
		CartVO vo = ProductDAO.getInstance().selectOrderProduct(prodNo, count);
		List<CartVO> orderList = new ArrayList<>();
		orderList.add(vo);
		
		req.setAttribute("orderList", orderList);
		HttpSession session = req.getSession();
		session.setAttribute("sessItem", orderList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//장바구니에서 올 경우
		String[] cartNos = req.getParameterValues("chk");
		
		CartDAO dao =CartDAO.getInstance();
		List<CartVO> orderList = new ArrayList<>();
		
		for(int i=0; i<cartNos.length; i++) {
			String cartNo = cartNos[i];
			CartVO vo = dao.selectCartOrder(cartNo);
			orderList.add(vo);
		}
		
		req.setAttribute("orderList", orderList);
		HttpSession session = req.getSession();
		session.setAttribute("sessItem", orderList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
		
	}
}

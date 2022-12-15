package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.VO.OrderItemVO;

@WebServlet("/product/complete.do")
public class CompleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		CartDAO dao = CartDAO.getInstance();
		
		//주문완료
		OrderItemVO vo = dao.selectOrderLatest(uid);
		req.setAttribute("order", vo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/complete.jsp");
		dispatcher.forward(req, resp);
	}
	
}

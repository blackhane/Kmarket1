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
		String prodNo = req.getParameter("prodNo");
		CartDAO dao = CartDAO.getInstance();

		//주문완료
		OrderItemVO vo = dao.selectOrderLatest(uid);
		req.setAttribute("order", vo);
		
		//포인트적립
		String sPoint = vo.getSavePoint();
		dao.updatePointUp(sPoint, uid);
		//포인트사용
		String uPoint = vo.getUsedPoint();
		dao.updatePointDown(uPoint, uid);
		//상품판매갯수++
		String count = vo.getOrdCount();
		dao.updateProductSoldUp(count, prodNo);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/complete.jsp");
		dispatcher.forward(req, resp);
	}
}

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
public class ordreasdf extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		String uid = req.getParameter("uid");
		
		ProductDAO dao1 = ProductDAO.getInstance();
		CartDAO dao2 = CartDAO.getInstance();
		if(prodNo != null) {
			ProductVO item = dao1.selectProduct(prodNo);
			HttpSession session = req.getSession();
			session.setAttribute("item", item);
			req.setAttribute("iCount", count);
		}else {
			List<CartVO> items = dao2.selectCartItem(uid);
			CartVO total = dao2.selectTotalCart(uid);
			req.setAttribute("items", items);
			req.setAttribute("total", total);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String count = req.getParameter("count");
		String price = req.getParameter("price");
		String discount = req.getParameter("discount");
		String delivery = req.getParameter("delivery");
		String savePoint = req.getParameter("savePoint");
		String usedPoint = req.getParameter("usedPoint");
		String ordTotPrice = req.getParameter("ordTotPrice");
		String recipName = req.getParameter("orderer");
		String recipHp = req.getParameter("hp");
		String recipZip = req.getParameter("zip");
		String recipAddr1 = req.getParameter("addr1");
		String recipAddr2 = req.getParameter("addr2");
		String payment = req.getParameter("payment");
		String ordComplete = null;
		
		OrderItemVO vo = new OrderItemVO();
		vo.setOrdUid(uid);
		vo.setOrdCount(count);
		vo.setOrdPrice(price);
		vo.setOrdDiscount(discount);
		vo.setOrdDelivery(delivery);
		vo.setSavePoint(savePoint);
		vo.setUsedPoint(usedPoint);
		vo.setOrdTotPrice(ordTotPrice);
		vo.setRecipName(recipName);
		vo.setRecipHp(recipHp);
		vo.setRecipZip(recipZip);
		vo.setRecipAddr1(recipAddr1);
		vo.setRecipAddr2(recipAddr2);
		vo.setOrdPayment(payment);
		vo.setOrdComplete(ordComplete);
		
		int result = CartDAO.getInstance().insertOrderItem(vo);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
	}
}

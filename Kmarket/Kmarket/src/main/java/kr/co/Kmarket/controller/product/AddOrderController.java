package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.VO.OrderItemVO;

@WebServlet("/product/orderHelper.do")
public class AddOrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("ordUid");
		String count = req.getParameter("ordCount");
		String price = req.getParameter("ordPrice");
		String discount = req.getParameter("ordDiscount");
		String delivery = req.getParameter("ordDelivery");
		String savePoint = req.getParameter("savePoint");
		String usedPoint = req.getParameter("usedPoint");
		String totalPrice = req.getParameter("totalPrice");
		String recipName = req.getParameter("recipName");
		String recipHp = req.getParameter("recipHp");
		String recipZip = req.getParameter("recipZip");
		String recipAddr1 = req.getParameter("recipAddr1");
		String recipAddr2 = req.getParameter("recipAddr2");
		String payment = req.getParameter("payment");
		
		OrderItemVO vo = new OrderItemVO();
		vo.setOrdUid(uid);
		vo.setOrdCount(count);
		vo.setOrdPrice(price);
		vo.setOrdDiscount(discount);
		vo.setOrdDelivery(delivery);
		vo.setSavePoint(savePoint);
		vo.setUsedPoint(usedPoint);
		vo.setTotalPrice(totalPrice);
		vo.setRecipName(recipName);
		vo.setRecipHp(recipHp);
		vo.setRecipZip(recipZip);
		vo.setRecipAddr1(recipAddr1);
		vo.setRecipAddr2(recipAddr2);
		vo.setOrdPayment(payment);
		
		CartDAO dao = CartDAO.getInstance();
		int result = dao.insertOrderItem(vo);
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] cartNo = req.getParameterValues("cartNo");

		logger.debug("cartNo : " + cartNo.length);
		
		CartDAO dao = CartDAO.getInstance();
		
		int result = 0;
		for(int i=0; i<cartNo.length; i++) {
			result = dao.deleteCart(cartNo[i]);
		}
		
		if(cartNo.length == 0) {
			result = 1;
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		writer.flush();
	}
		
}

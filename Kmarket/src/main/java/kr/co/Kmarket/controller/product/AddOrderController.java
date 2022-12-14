package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.VO.OrderItemVO;

@WebServlet("/product/orderHelper.do")
public class AddOrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String count = req.getParameter("count");
		String price = req.getParameter("price");
		String discount = req.getParameter("disPrice");
		String delivery = req.getParameter("delivery");
		String savePoint = req.getParameter("savePoint");
		String usedPoint = req.getParameter("usedPoint");
		String totalPrice = req.getParameter("totalPrice");
		String recipName = req.getParameter("orderer");
		String recipHp = req.getParameter("hp");
		String recipZip = req.getParameter("zip");
		String recipAddr1 = req.getParameter("addr1");
		String recipAddr2 = req.getParameter("addr2");
		String payment = req.getParameter("payment");
		String[] prodNoArr = req.getParameterValues("prodNoArr");
		
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
		String uid = req.getParameter("uid");
		
		//장바구니 비우기
		int result = CartDAO.getInstance().deleteCarts(uid);
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
	}
}

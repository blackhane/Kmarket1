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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.VO.OrderItemVO;
import kr.co.Kmarket.VO.OrderVO;

@WebServlet("/product/orderHelper.do")
public class AddOrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
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

		String[] arr = req.getParameterValues("arr");
		String comeCart = req.getParameter("comeCart");
		
		//주문완료가 맞다면
		if(result > 0) {
			for(int i=0; i<arr.length; i+=2) {
				//i가 짝수=번호, 홀수=갯수
				String prodNo = arr[i];
				String sold = arr[i+1];
				
				//판매갯수 ++
				dao.updateProductSoldUp(prodNo, sold);
				
				//재고량--
				dao.updateProductStockDown(prodNo, sold);
			}
			//장바구니를 거쳐 왔다면
			if(comeCart.equals("1")) {
				//장바구니 비우기
				dao.deleteCarts(uid);
			}
			//포인트적립
			dao.updatePointUp(savePoint, uid);
			//포인트사용
			dao.updatePointDown(usedPoint, uid);
			//포인트적립 기록
			dao.insertPoint(uid,result,savePoint);
		}
		
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] jsonData = req.getParameterValues("array");
		
		Gson gson = new Gson();
		OrderVO vo = gson.fromJson(jsonData.toString(), OrderVO.class);
		
		logger.debug("vo: " +vo);
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", 1);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
	}
	
}

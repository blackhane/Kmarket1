package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CartVO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/product/addCart.do")
public class AddCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		String price = req.getParameter("price");
		String discount = req.getParameter("discount");
		String point = req.getParameter("point");
		String delivery = req.getParameter("delivery");
		String total = req.getParameter("total");
		
		CartVO vo = new CartVO();
		vo.setUid(uid);
		vo.setProdNo(prodNo);
		vo.setCount(count);
		vo.setPrice(price);
		vo.setDiscount(discount);
		vo.setPoint(point);
		vo.setDelivery(delivery);
		vo.setTotal(total);
		
		//장바구니 입력
		int result = ProductDAO.getInstance().insertCart(vo);
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
}

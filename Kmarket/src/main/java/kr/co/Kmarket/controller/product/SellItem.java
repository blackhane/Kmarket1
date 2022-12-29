package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.VO.CartVO;

@WebServlet("/sell.do")
public class SellItem extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		HttpSession session = req.getSession();
		List<CartVO> orderList = (List<CartVO>) session.getAttribute("sessItem");
		
		int result = 0;
		CartDAO dao = CartDAO.getInstance();
		for(int i=0; i<orderList.size(); i++) {
			CartVO vo = new CartVO();
			vo.setProdNo(orderList.get(i).getProdNo());
			vo.setCount(orderList.get(i).getCount());
			vo.setPrice(orderList.get(i).getPrice());
			vo.setDiscount(orderList.get(i).getDiscount());
			vo.setPoint(orderList.get(i).getPoint());
			vo.setDisPrice(orderList.get(i).getDisPrice());
			dao.insertOrder(vo,uid);
			result = 1;
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
	}
}

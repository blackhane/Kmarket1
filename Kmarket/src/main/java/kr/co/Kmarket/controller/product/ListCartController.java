package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.OrderItemVO;

@WebServlet("/product/listCart.do")
public class ListCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		OrderItemVO vo = ProductDAO.getInstance().selectCartItem(uid);
		
		resp.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		String jsonData = gson.toJson(vo);
		PrintWriter writer = resp.getWriter();
		writer.write(jsonData);
		writer.flush();
	}
}
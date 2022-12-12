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

@WebServlet("/product/deleteCart.do")
public class DelCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] jsonData = req.getParameterValues("jsonData");
		System.out.println(jsonData);
		ProductDAO dao = ProductDAO.getInstance();
		for(int i=0; i<jsonData.length; i++) {
			System.out.println(jsonData[i]);
			//dao.deleteCart(arrayChk[i]);
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", "1");
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
}

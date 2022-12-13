package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CartVO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/product/cartHelper.do")
public class DelCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] cartNo = req.getParameterValues("chkBox");
		int result = 0;
		
		ProductDAO dao = ProductDAO.getInstance();
		for(int i=0; i<cartNo.length; i++) {
			result = dao.deleteCart(cartNo[i]);
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		CartVO vo = ProductDAO.getInstance().selectTotalCart(uid);
		
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String json = gson.toJson(vo);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		writer.flush();
	}
}

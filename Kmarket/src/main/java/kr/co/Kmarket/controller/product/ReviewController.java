package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.ReviewVO;

@WebServlet("/product/review.do")
public class ReviewController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String start = req.getParameter("start");
		
		ProductDAO dao = ProductDAO.getInstance();
		
		
		List<ReviewVO> reviews = dao.selectReviews(prodNo,Integer.parseInt(start));
		
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String jsonData = gson.toJson(reviews);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
		writer.flush();
	}
	
}

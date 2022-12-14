package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.CartDAO;
import kr.co.Kmarket.VO.OrderItemVO;

@WebServlet("/product/complete.do")
public class CompleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		
		//판매갯수 ++
		int result = CartDAO.getInstance().updateProductSoldUp(prodNo, count);
		
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
		
		CartDAO dao = CartDAO.getInstance();
		//주문완료
		OrderItemVO vo = dao.selectOrderLatest(uid);
		req.setAttribute("order", vo);
		//포인트적립
		String sPoint = vo.getSavePoint();
		dao.updatePointUp(sPoint, uid);
		//포인트사용
		String uPoint = vo.getUsedPoint();
		dao.updatePointDown(uPoint, uid);
		//포인트적립 기록
		dao.insertPoint(uid,vo.getOrdNo(),sPoint);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/complete.jsp");
		dispatcher.forward(req, resp);
	}
	
}

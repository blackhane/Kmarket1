package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductVO> products = AdminDAO.getInstance().selectProduct();	
		req.setAttribute("products", products);
		
		/*
		 * String thumb1 = req.getParameter("thumb1"); String prodNo =
		 * req.getParameter("prodNo"); String prodName = req.getParameter("prodName");
		 * String price = req.getParameter("price"); String discount =
		 * req.getParameter("discount"); String point = req.getParameter("point");
		 * String stock = req.getParameter("stock"); String seller =
		 * req.getParameter("seller"); String hit = req.getParameter("hit");
		 */
		
//		ProductVO vo = new ProductVO();
//		vo.setThumb1(thumb1);
//		vo.setProdNo(prodNo);
//		vo.setProdName(prodName);
//		vo.setPrice(price);
//		vo.setDiscount(discount);
//		vo.setPoint(point);
//		vo.setStock(stock);
//		vo.setSeller(seller);
//		vo.setHit(hit);
	
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_product/list.jsp");
		dispathcer.forward(req, resp);
	}
	
}
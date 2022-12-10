package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CateVO;
import kr.co.Kmarket.VO.productVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String prodNo = req.getParameter("prodNo");
		
		ProductDAO dao = ProductDAO.getInstance();
		String c1Name = dao.selectCate1Name(cate1);
		String c2Name = dao.selectCate2Name(cate1, cate2);
		productVO product = dao.selectProduct(prodNo);
		
		CateVO vo = new CateVO();
		vo.setC1Name(c1Name);
		vo.setC2Name(c2Name);
		
		req.setAttribute("product", product);
		req.setAttribute("cate", vo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/view.jsp");
		dispatcher.forward(req, resp);
	}
}

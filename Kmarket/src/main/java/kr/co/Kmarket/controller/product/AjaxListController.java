package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.DAO.ProductDAO;
import kr.co.Kmarket.VO.CateVO;
import kr.co.Kmarket.VO.ProductVO;


@WebServlet("/product/list2.do")
public class AjaxListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		ProductDAO dao = ProductDAO.getInstance();
		
		//카테고리1 이름
		String c1Name = dao.selectCate1Name(cate1);
		//카테고리2 이름
		String c2Name = dao.selectCate2Name(cate1, cate2);
		
		CateVO vo = new CateVO();
		vo.setCate1(cate1);
		vo.setC1Name(c1Name);
		vo.setCate2(cate2);
		vo.setC2Name(c2Name);
		
		req.setAttribute("cate", vo);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_product/list2.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sort = req.getParameter("sort");
		String pg = req.getParameter("start");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		int start = (Integer.parseInt(pg) - 1) * 10;
		
		switch(sort) {
		case "1":
			sort = "`sold` DESC";
			break;
		case "2":
			sort = "`price`-(`price`/100 * `discount`) ASC";
			break;
		case "3":
			sort = "`price`-(`price`/100 * `discount`) DESC";
			break;
		case "4":
			sort = "`score` DESC";
			break;
		case "5":
			sort = "`review` DESC";
			break;
		case "6":
			sort = "`rdate` DESC";
			break;
		}
		
		List<ProductVO> products = ProductDAO.getInstance().ajaxProductList(cate1, cate2, sort, start);
		
		resp.setContentType("application/json;charset=UTF-8");		
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(products);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData.toString());
		writer.flush();
	}
}

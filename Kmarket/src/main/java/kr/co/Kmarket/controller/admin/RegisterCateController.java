package kr.co.Kmarket.controller.admin;

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
import kr.co.Kmarket.VO.CateVO;

@WebServlet("/admin/product/findCate2.do")
public class RegisterCateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
	
		List<CateVO> vo = ProductDAO.getInstance().selectFindCate2(cate1);
		
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String jsonData = gson.toJson(vo);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
		writer.flush();
	}
}

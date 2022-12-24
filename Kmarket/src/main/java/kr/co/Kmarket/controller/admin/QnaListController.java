package kr.co.Kmarket.controller.admin;

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

import kr.co.Kmarket.DAO.admin.AdminQnaDAO;
import kr.co.Kmarket.VO.CsVO;

@WebServlet("/admin/cs/qna/list.do")
public class QnaListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_admin/_cs/_qna/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		List<CsVO> qna = AdminQnaDAO.getInstance().selectQna(group, cate);
		
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String jsonResult = gson.toJson(qna);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonResult.toString());
		writer.flush();
	}
}

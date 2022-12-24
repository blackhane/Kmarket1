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
import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CsNoticeVO;

@WebServlet("/admin/cs/notice/list.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_cs/_notice/list.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");
		
		int start = (Integer.parseInt(pg) - 1) * 10;
		
		List<CsNoticeVO> notice = AdminDAO.getInstance().selectNotice(cate,start);
		
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String jsonResult = gson.toJson(notice);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonResult.toString());
		writer.flush();
	}
}
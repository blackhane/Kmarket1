package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.DAO.admin.AdminQnaDAO;

@WebServlet("/admin/cs/qna/delete.do")
public class QnaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		AdminQnaDAO dao = AdminQnaDAO.getInstance();
		dao.deleteQna(no);

		resp.sendRedirect("/Kmarket/admin/cs/qna/list.do?code=101");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] chkArr = req.getParameterValues("chkArr");
		
		AdminQnaDAO dao = AdminQnaDAO.getInstance();
		
		int result = 0;
		for(int i=0; i<chkArr.length; i++) {
			result = dao.deleteQna(chkArr[i]);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		writer.flush();
	}
}

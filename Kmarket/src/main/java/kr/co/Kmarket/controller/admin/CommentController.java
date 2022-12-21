package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.admin.AdminQnaDAO;

@WebServlet("/admin/cs/qna/comtent.do")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String no = req.getParameter("no");
		
		List<ArticleVO> comments = ArticleDAO.getInstance().selectComment(no);
		
		Gson gson = new Gson();
		
		String jsonResult = gson.toJson(comments);
		System.out.println(jsonResult);
		
		PrintWriter writer = resp.getWriter();
		writer.print(jsonResult);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String parent = req.getParameter("parent");
		String content = req.getParameter("content");
		String uid = req.getParameter("uid");
		String regip = req.getRemoteAddr();
	
		AdminQnaDAO dao = AdminQnaDAO.getInstance();
		int result = dao.insertComment(parent, content, uid, regip);
		dao.updateCommentHit(no);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}

}

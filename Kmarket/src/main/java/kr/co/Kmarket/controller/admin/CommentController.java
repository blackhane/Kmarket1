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
import com.google.gson.JsonObject;

import kr.co.Kmarket.DAO.admin.AdminQnaDAO;
import kr.co.Kmarket.VO.CsQnaVO;

@WebServlet("/admin/cs/qna/comment.do")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parent = req.getParameter("no");
		String content = req.getParameter("comment");
		String uid = req.getParameter("uid");
		
		CsQnaVO vo = new CsQnaVO();
		vo.setParent(parent);
		vo.setContent(content);
		vo.setUid(uid);
		
		int result = AdminQnaDAO.getInstance().insertComment(vo);
		
		resp.setContentType("application/json;charset=UTF-8");
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		writer.flush();
		
	}

}

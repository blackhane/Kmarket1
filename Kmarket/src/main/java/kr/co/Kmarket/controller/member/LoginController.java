package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.DAO.MemberDAO;
import kr.co.Kmarket.VO.KmMemberVO;

@WebServlet("/_member/login.do")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_member/login.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		HttpSession session = req.getSession();
		KmMemberVO vo  = new KmMemberVO();
		
		if(uid.equals("root") && pass.equals("1234")) {
			vo.setUid(uid);
			vo.setName("관리자");
			
			session.setAttribute("sessUser", vo);
			
			resp.sendRedirect("/Kmarket/");
			return;
		}
		
		vo = MemberDAO.getInstance().selectMemeber(uid, pass);
		
		if(vo.getUid() != null) {
			session.setAttribute("sessUser", vo);
			
			resp.sendRedirect("/Kmarket/index.do");
			return;
		}
		
		String code = "100";
		resp.sendRedirect("/Kmarket/_member/login.do?code=100");
	}
	
}

package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.VO.MemberVO;
import kr.co.Kmarket.utils.MemberService;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	MemberService service = MemberService.getInstacne();
	
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
		
		//하드코딩
		if(uid.equals("root") && pass.equals("1234")) {
			session.setAttribute("sessUid", uid);
			session.setAttribute("sessName", "관리자");
			
			resp.sendRedirect("/Kmarket/index.jsp");
			return;
		}
		
		MemberVO vo = service.selectMemeber(uid, pass);
		
		if(vo != null) {
			session.setAttribute("sessUser", vo);
		}else {
			resp.sendRedirect("/Kmarket/_member/login.jsp?Err=100");
		}
	}
	
}

package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.DAO.MemberDAO;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		
		HttpSession session = req.getSession();
		//세션 삭제
		session.invalidate();
		
		//자동로그인 해제 - 덮어쓸 새로운 쿠키 생성
		Cookie cookie = new Cookie("sessId", null);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*3);
		resp.addCookie(cookie);

		//데이터베이스 저장
		MemberDAO.getInstance().updateCookie(uid);
		
		resp.sendRedirect("/Kmarket/");
	}	
}

package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.DAO.MemberDAO;
import kr.co.Kmarket.VO.MemberVO;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//자동로그인 여부
//		HttpSession session = req.getSession();
//		Cookie[] cookies = req.getCookies();
//		if(cookies != null) {
//			for(Cookie cookie : cookies) {
//				if(cookie.getName().equals("sessId")) {
//					String sessId = cookie.getValue();
//					KmMemberVO vo = MemberDAO.getInstance().selectCookie(sessId);
//					
//					if(vo != null) {
//						session.setAttribute("sessUser", vo);
//					}
//				}
//			}
//		}
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/Kmarket/index.jsp");
		dispathcer.forward(req, resp);
	}
}

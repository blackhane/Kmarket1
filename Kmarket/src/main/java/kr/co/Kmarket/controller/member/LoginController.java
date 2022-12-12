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

@WebServlet("/member/login.do")
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
		String auto_login = req.getParameter("auto_login");
		
		HttpSession session = req.getSession();
		MemberVO vo  = new MemberVO();
		MemberDAO dao = MemberDAO.getInstance();
		
		//하드코딩
		if(uid.equals("root") && pass.equals("1234")) {
			vo.setUid(uid);
			vo.setName("관리자");
			
			session.setAttribute("sessUser", vo);
			
			resp.sendRedirect("/Kmarket/");
			return;
		}
		
		vo = dao.selectMemeber(uid, pass);
		
		//회원 O
		if(vo.getUid() != null) {
			session.setAttribute("sessUser", vo);

			//자동로그인 체크
			if(auto_login != null) {
				String sessId = session.getId();
				
				//쿠키생성
				Cookie cookie = new Cookie("sessId", sessId);
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*3);
				resp.addCookie(cookie);

				//데이터베이스 저장
				dao.makeCookie(uid, sessId);
			}
			
			resp.sendRedirect("/Kmarket/");
			return;
		}
		
		//로그인 실패
		String code = "100";
		resp.sendRedirect("/Kmarket/_member/login.do?code=100");
	}
	
}

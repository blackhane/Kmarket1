package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.MemberDAO;
import kr.co.Kmarket.VO.KmMemberTermsVO;

@WebServlet("/_member/signup.do")
public class SignupController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sign = req.getParameter("sign");
		req.setAttribute("sign", sign);
		
		KmMemberTermsVO vo = MemberDAO.getInstance().selectSignup();
		req.setAttribute("vo", vo);
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_member/signup.jsp");
		dispathcer.forward(req, resp);
	}
}

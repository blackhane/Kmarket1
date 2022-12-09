package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.MemberDAO;
import kr.co.Kmarket.VO.MemberTermsVO;

@WebServlet("/_member/join.do")
public class JoinController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_member/join.jsp");
		dispathcer.forward(req, resp);
	}
}

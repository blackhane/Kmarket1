package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.DAO.MemberDAO;
import kr.co.Kmarket.VO.MemberVO;

@WebServlet("/member/registerSeller.do")
public class RegisterSellerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_member/registerSeller.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass2");
		String company = req.getParameter("company");
		String ceo = req.getParameter("ceo");
		String bizRegNum = req.getParameter("bizRegNum");
		String comRegNum = req.getParameter("comRegNum");
		String tel = req.getParameter("tel");
		String fax = req.getParameter("fax");
		int type = 5;
		String email = req.getParameter("email");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String manager = req.getParameter("manager");
		String managerHp = req.getParameter("managerHp");
		String regip = req.getRemoteAddr();
	
		MemberVO vo = new MemberVO();
		vo.setUid(uid);
		vo.setPass(pass);
		vo.setCompany(company);
		vo.setCeo(ceo);
		vo.setBizRegNum(bizRegNum);
		vo.setComRegNum(comRegNum);
		vo.setTel(tel);
		vo.setFax(fax);
		vo.setType(type);
		vo.setEmail(email);
		vo.setZip(zip);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setManager(manager);
		vo.setManagerHp(managerHp);
		vo.setRegip(regip);
		
		MemberDAO.getInstance().insertMemberSell(vo);
		
		resp.sendRedirect("/Kmarket/member/login.do?code=101");
	}
}

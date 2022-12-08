package kr.co.Kmarket.utils;

import kr.co.Kmarket.VO.MemberVO;
import kr.co.Kmarket.dao.member.MemberDAO;

public class MemberService {

	//싱글톤 선언
	private static MemberService instacne = new MemberService();
	public static MemberService getInstacne() {
		return instacne;
	}
	private void Service () {}
	
	//멤버 DAO
	private MemberDAO dao = MemberDAO.getInstance();
	
	
	//로그인체크
	public MemberVO selectMemeber(String uid, String pass) {
		return dao.selectMemeber(uid, pass);
	}
}

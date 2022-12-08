package kr.co.Kmarket.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.KmMemberTermsVO;
import kr.co.Kmarket.VO.KmMemberVO;
import kr.co.Kmarket.utils.DBCP;
import kr.co.Kmarket.utils.SQL_member;

public class MemberDAO extends DBCP {
	
	//싱글톤
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//일반 회원가입
	public void insertMember(KmMemberVO vo) {
		try {
			logger.info("신규 회원가입 - 일반");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_member.INSERT_MEMBER);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHp());
			psmt.setInt(6, vo.getType());
			psmt.setString(7, vo.getZip());
			psmt.setString(8, vo.getAddr1());
			psmt.setString(9, vo.getAddr2());
			psmt.setString(10, vo.getRegip());
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	//판매자 회원가입
	public void insertMemberSell(KmMemberVO vo) {
		try {
			logger.info("신규 회원가입 - 판매자");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_member.INSERT_MEMBER);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHp());
			psmt.setInt(6, vo.getType());
			psmt.setString(7, vo.getZip());
			psmt.setString(8, vo.getAddr1());
			psmt.setString(9, vo.getAddr2());
			psmt.setString(10, vo.getRegip());
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//로그인 체크
	public KmMemberVO selectMemeber(String uid, String pass) {
		KmMemberVO vo = new KmMemberVO();
		try {
			logger.info("로그인 체크");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_member.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setGender(rs.getInt(3));
				vo.setHp(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setType(rs.getInt(6));
				vo.setPoint(rs.getInt(7));
				vo.setLevel(rs.getInt(8));
				vo.setZip(rs.getString(9));
				vo.setAddr1(rs.getString(10));
				vo.setAddr2(rs.getString(11));
				vo.setCompany(rs.getString(12));
				vo.setCeo(rs.getString(13));
				vo.setBizRegNum(rs.getString(14));
				vo.setComRegNum(rs.getString(15));
				vo.setTel(rs.getString(16));
				vo.setManager(rs.getString(17));
				vo.setManagerHp(rs.getString(18));
				vo.setFax(rs.getString(19));
				vo.setWdate(rs.getString(20));
				vo.setRdate(rs.getString(21));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//약관
	public KmMemberTermsVO selectSignup() {
		KmMemberTermsVO vo = new KmMemberTermsVO();
		try {
			logger.info("약관 불러오기");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_member.SELECT_TERMS);
			if(rs.next()) {
				vo.setTerms(rs.getString(1));
				vo.setPrivacy(rs.getString(2));
				vo.setLocation(rs.getString(3));
				vo.setFinance(rs.getString(4));
				vo.setTax(rs.getString(5));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

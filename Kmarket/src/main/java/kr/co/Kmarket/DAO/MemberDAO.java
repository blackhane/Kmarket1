package kr.co.Kmarket.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.MemberTermsVO;
import kr.co.Kmarket.VO.MemberVO;
import kr.co.Kmarket.utils.DBCP;
import kr.co.Kmarket.utils.MemberSQL;

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
	public void insertMember(MemberVO vo) {
		try {
			logger.info("신규 회원가입 - 일반");
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.INSERT_MEMBER);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getGender());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHp());
			psmt.setInt(7, vo.getType());
			psmt.setString(8, vo.getZip());
			psmt.setString(9, vo.getAddr1());
			psmt.setString(10, vo.getAddr2());
			psmt.setString(11, vo.getRegip());
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	//판매자 회원가입
	public void insertMemberSell(MemberVO vo) {
		try {
			logger.info("신규 회원가입 - 판매자");
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.INSERT_MEMBER);
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
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//로그인 체크
	public MemberVO selectMemeber(String uid, String pass) {
		MemberVO vo = new MemberVO();
		try {
			logger.info("로그인 체크");
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setGender(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setType(rs.getInt(7));
				vo.setPoint(rs.getInt(8));
				vo.setLevel(rs.getInt(9));
				vo.setZip(rs.getString(10));
				vo.setAddr1(rs.getString(11));
				vo.setAddr2(rs.getString(12));
				vo.setCompany(rs.getString(13));
				vo.setCeo(rs.getString(14));
				vo.setBizRegNum(rs.getString(15));
				vo.setComRegNum(rs.getString(16));
				vo.setTel(rs.getString(17));
				vo.setManager(rs.getString(18));
				vo.setManagerHp(rs.getString(19));
				vo.setFax(rs.getString(20));
				vo.setRegip(rs.getString(21));
				vo.setRdate(rs.getString(23));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//자동로그인
	public void makeCookie(String uid, String sessId) {
		try {
			logger.info("쿠키 저장~");
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.MAKE_COOKIE);
			psmt.setString(1, sessId);
			psmt.setString(2, uid);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//쿠키 체크 
	public MemberVO selectCookie(String sessId) {
		MemberVO vo = new MemberVO();
		try {
			logger.info("쿠키 검색~");
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.FIND_COOKIE);
			psmt.setString(1, sessId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setGender(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setType(rs.getInt(7));
				vo.setPoint(rs.getInt(8));
				vo.setLevel(rs.getInt(9));
				vo.setZip(rs.getString(10));
				vo.setAddr1(rs.getString(11));
				vo.setAddr2(rs.getString(12));
				vo.setCompany(rs.getString(13));
				vo.setCeo(rs.getString(14));
				vo.setBizRegNum(rs.getString(15));
				vo.setComRegNum(rs.getString(16));
				vo.setTel(rs.getString(17));
				vo.setManager(rs.getString(18));
				vo.setManagerHp(rs.getString(19));
				vo.setFax(rs.getString(20));
				vo.setWdate(rs.getString(21));
				vo.setRdate(rs.getString(22));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//자동로그인 해제
	public void updateCookie(String uid) {
		try {
			logger.info("로그아웃");
			conn = getConnection();
			psmt = conn.prepareStatement(MemberSQL.UPDATE_COOKIE);
			psmt.setString(1, uid);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//약관
	public MemberTermsVO selectSignup() {
		MemberTermsVO vo = new MemberTermsVO();
		try {
			logger.info("약관 불러오기");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(MemberSQL.SELECT_TERMS);
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

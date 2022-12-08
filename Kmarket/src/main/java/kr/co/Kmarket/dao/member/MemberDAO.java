package kr.co.Kmarket.dao.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.MemberVO;
import kr.co.Kmarket.utils.DBCP;
import kr.co.Kmarket.utils.Sql_member;

public class MemberDAO extends DBCP {
	
	//싱글톤
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//로그인 체크
	public MemberVO selectMemeber(String uid, String pass) {
		MemberVO vo = null;
		try {
			logger.info("로그인 체크");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_member.SELECT_USER);
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
}

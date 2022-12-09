package kr.co.Kmarket.utils;

public class MemberSQL {

	//회원가입
	public static String INSERT_MEMBER = "INSERT INTO `km_member` (`uid`,`pass`,`name`,`gender`,`email`,`hp`,`type`,`zip`,`addr1`,`addr2`,`regip`,`rdate`) VALUES (?,SHA(?,256),?,?,?,?,?,?,?,?,?,NOW())";
	
	//로그인 체크 SHA2(?,256)
	public static String SELECT_USER = "SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	
	//쿠키 저장
	public static String MAKE_COOKIE = "UPDATE `km_member` SET `sessId`=?, `sessLimitDate`=DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `uid`=?";
	
	//쿠키 찾기
	public static String FIND_COOKIE = "SELECT COUNT(*) FROM `km_member` WHERE `sessId`=? AND `sessLimitDate` > NOW()";
	
	//약관
	public static String SELECT_TERMS = "SELECT * FROM `km_member_terms`";
}

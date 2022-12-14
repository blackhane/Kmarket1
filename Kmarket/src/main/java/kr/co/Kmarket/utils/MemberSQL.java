package kr.co.Kmarket.utils;

public class MemberSQL {

	//회원가입
	public static String INSERT_MEMBER = "INSERT INTO `km_member` SET "
												+ "`uid`=?, "
												+ "`pass`=SHA2(?,256), "
												+ "`name`=?, "
												+ "`gender`=?, "
												+ "`email`=?, "
												+ "`hp`=?, "
												+ "`type`=?, "
												+ "`zip`=?, "
												+ "`addr1`=?, "
												+ "`addr2`=?, "
												+ "`regip`=?, "
												+ "`rdate`=NOW()";
	
	//회원가입
	public static String INSERT_MEMBER_SELLER = "INSERT INTO `km_member` SET "
												+ "`uid`=?, "
												+ "`pass`=SHA2(?,256), "
												+ "`company`=?, "
												+ "`ceo`=?, "
												+ "`bizRegNum`=?, "
												+ "`comRegNum`=?, "
												+ "`tel`=?, "
												+ "`email`=?, "
												+ "`fax`=?, "
												+ "`type`=?, "
												+ "`zip`=?, "
												+ "`addr1`=?, "
												+ "`addr2`=?, "
												+ "`manager`=?, "
												+ "`managerHp`=?, "
												+ "`regip`=?, "
												+ "`rdate`=NOW()";
	
	//로그인 체크
	public static String SELECT_USER = "SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	
	//자동로그인 체크 (쿠키 저장)
	public static String MAKE_COOKIE = "UPDATE `km_member` SET `sessId`=?, `sessLimitDate`=DATE_ADD(NOW(), INTERVAL 3 DAY) WHERE `uid`=?";
	
	//재방문 (쿠키 찾기)
	public static String FIND_COOKIE = "SELECT * FROM `km_member` WHERE `sessId`=? AND `sessLimitDate` > NOW()";
	
	//로그아웃 (자동로그인 해제 - 쿠키 덮어쓰기)
	public static String UPDATE_COOKIE = "UPDATE `km_member` SET `sessId`=NULL, `sessLimitDate`=NULL WHERE `uid`=?";
	
	//약관
	public static String SELECT_TERMS = "SELECT * FROM `km_member_terms`";
	
}

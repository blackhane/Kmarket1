package kr.co.Kmarket.utils;

public class SQL_member {

	//회원가입
	public static String INSERT_MEMBER = "INSERT INTO `km_member` (`uid`,`pass`,`name`,`gender`,`email`,`hp`,`type`,`zip`,`addr1`,`addr2`,`regip`,`rdate`) VALUES (?,SHA(?,256),?,?,?,?,?,?,?,?,?,NOW())";
	
	//로그인 체크
	public static String SELECT_USER = "SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	
	//약관
	public static String SELECT_TERMS = "SELECT * FROM `km_member_terms`";
}

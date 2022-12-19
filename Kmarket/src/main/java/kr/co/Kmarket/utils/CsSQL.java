package kr.co.Kmarket.utils;


public class CsSQL {
	
	
	/////////// 공지사항 NOTICE /////////////
	
	//글목록
	public static final String SELECT_ARTICLES_NOTICE = "SELECT * FROM `km_cs_notice` ORDER BY `no` DESC";

	public static final String SELECT_ARTICLES_QNA = "SELECT * FROM `km_cs_qna` ORDER BY `no` DESC";
	
	public static final String SELECT_ARTICLES_FAQ = "SELECT * FROM `km_cs_faq` WHERE `cate`=? ORDER BY `no` DESC ";
	
	//글보기
	public static final String SELECT_ARTICLE_NOTICE = "SELECT * FROM `km_cs_notice` WHERE `no`=?";
	
	public static final String SELECT_ARTICLE_QNA = "SELECT * FROM `km_cs_qna` WHERE `no`=?";
	
	public static final String SELECT_ARTICLE_FAQ = "SELECT * FROM `km_cs_faq` WHERE `no`=?";
	
	//글쓰기
	public static final String INSERT_ARITLCE_QNA = "INSERT INTO `km_cs_qna` SET `cate`=?, `title`=?, `content`=?, `uid`=?, `regip`=?, `rdate`=NOW()";
	
}

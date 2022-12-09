package kr.co.Kmarket.utils;


public class CsSQL {
	
	
	// article
	
	public static final String INSERT_ARTICLE = "insert into `km_cs_article` set "
			+ "`cate`=?, "
			+ "`title`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	
	public static final String SELECT_ARTICLE = "";
	
	public static final String SELECT_ARTICLES = "SELECT a.*, b.`nick` FROM `km_cs_article` AS a JOIN `km_member` AS b ON a.uid = b.uid "
			+ "where `parent`=0 and `cate`=? "
			+ "order by `no` desc "
			+ "limit ?,10";
	
	public static final String UPDATE_ARTICLE = "update `km_cs_article` set `title`=?,`content`=?,`rdate`=now() where `no`=?";

	public static final String DELETE_ARTICLE = "DELETE FROM `km_cs_article` WHERE `no`=? or `parent`=?";
	
	
	
	
	
	//comment
	
	public static final String INSERT_COMMENT = "insert into `km_cs_article` set "
			+ "`parent`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	
	public static final String SELECT_COMMENTS = "select a.*,b.nick from `km_cs_article` as a "
			+ "join `km_member` as b using (`uid`) "
			+ "where `parent`=? order by `no` asc";
	
	public static final String UPDATE_COMMENT = "UPDATE `km_cs_article` SET `content`=?, `rdate`=NOW() WHERE `no`=?";
	
	public static final String DELETE_COMMENT = "DELETE FROM `km_cs_article` WHERE `no`=?";
	
	
	
	
}

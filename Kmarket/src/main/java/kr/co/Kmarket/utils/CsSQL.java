package kr.co.Kmarket.utils;


public class CsSQL {
	
	/////////// 공지사항 NOTICE /////////////
		
	//글보기 글쓰기
	public static final String SELECT_CS_ARTICLE_NOTICE = "SELECT * FROM `km_cs_notice`";
	public static final String INSERT_CS_ARTICLE_NOTICE = "insert into `km_cs_notice` set "
			+ "`cate`=?, "
			+ "`title`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	public static final String SELECT_CS_ARTICLES_NOTICE = "SELECT a.*, b.`nick` FROM `km_cs_notice` AS a JOIN `km_member` AS b ON a.uid = b.uid "
			+ "where `parent`=0 and `cate`=? "
			+ "order by `no` desc "
			+ "limit ?,10";
	public static final String UPDATE_CS_ARTICLE_NOTICE = "update `km_cs_notice` set `title`=?,`content`=?,`rdate`=now() where `no`=?";
	public static final String DELETE_CS_ARTICLE_NOTICE = "DELETE FROM `km_cs_notice` WHERE `no`=? or `parent`=?";
	
	
	
	
	
	
	
	//////////// 자주묻는 질문 FAQ //////////////////
	
	//글보기 글쓰기
	public static final String SELECT_CS_ARTICLE_FAQ = "SELECT * FROM `km_cs_faq`";
	public static final String INSERT_CS_ARTICLE_FAQ = "insert into `km_cs_faq` set "
			+ "`cate`=?, "
			+ "`title`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	public static final String SELECT_CS_ARTICLES_FAQ = "SELECT a.*, b.`nick` FROM `km_cs_faq` AS a JOIN `km_member` AS b ON a.uid = b.uid "
			+ "where `parent`=0 and `cate`=? "
			+ "order by `no` desc "
			+ "limit ?,10";
	public static final String UPDATE_CS_ARTICLE_FAQ = "update `km_cs_faq` set `title`=?,`content`=?,`rdate`=now() where `no`=?";
	public static final String DELETE_CS_ARTICLE_FAQ = "DELETE FROM `km_cs_faq` WHERE `no`=? or `parent`=?";
	
	
	
	
	
	
	
	/////////////// 문의하기 QNA ////////////////////
	
	// 글보기 글쓰기
	public static final String SELECT_CS_ARTICLE_QNA = "SELECT * FROM `km_cs_qna`";
	public static final String INSERT_CS_ARTICLE_QNA = "insert into `km_cs_qna` set "
			+ "`parent`=?, "
			+ "`coment`=?, "
			+ "`cate`=?, "
			+ "`title`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	public static final String SELECT_CS_ARTICLES_QNA = "SELECT a.*, b.`nick` FROM `km_cs_qna` AS a JOIN `km_member` AS b ON a.uid = b.uid "
			+ "where `parent`=0 and `cate`=? "
			+ "order by `no` desc "
			+ "limit ?,10";
	public static final String UPDATE_CS_ARTICLE_QNA = "update `km_cs_qna` set `title`=?,`content`=?,`rdate`=now() where `no`=?";
	public static final String DELETE_CS_ARTICLE_QNA = "DELETE FROM `km_cs_qna` WHERE `no`=? or `parent`=?";
	
	
	//comment
	public static final String INSERT_CS_COMMENT_QNA = "insert into `km_cs_qna` set "
			+ "`parent`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	public static final String SELECT_CS_COMMENTS_QNA = "select a.*, b.nick from `km_cs_qna` as a "
			+ "join `km_member` as b using (`uid`) "
			+ "where `parent`=? order by `no` asc";
	public static final String UPDATE_CS_COMMENT_QNA = "UPDATE `km_cs_qna` SET `content`=?, `rdate`=NOW() WHERE `no`=?";
	public static final String DELETE_CS_COMMENT_QNA = "DELETE FROM `km_cs_qna` WHERE `no`=?";
	
}

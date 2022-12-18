package kr.co.Kmarket.utils;


public class CsSQL {
	
	
	/////////// 공지사항 NOTICE /////////////
	
	//글목록
	public static final String SELECT_ARTICLES = "SELECT * FROM `km_cs_notice` ORDER BY `no` DESC";
	
	//글보기
	public static final String SELECT_ARTICLE = "SELECT * FROM `km_cs_notice` WHERE `no`=?";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//글보기 글쓰기
	public static final String SELECT_CS_ARTICLE_NOTICE = "SELECT * FROM `km_cs_notice`";
	public static final String INSERT_CS_ARTICLE_NOTICE = "insert into `km_cs_notice` set "
			+ "`cate`=?, "
			+ "`title`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	
	//게시글수
	public static final String SELECT_CS_COUNT_TOTAL_NOTICE = "SELECT COUNT(`no`) FROM `km_cs_notice` where `parent`=0 and `cate`=?";
		
	
	
	
	
	
	//////////// 자주묻는 질문 FAQ //////////////////
	
	//글보기 글쓰기
	public static final String SELECT_CS_ARTICLE_FAQ = "SELECT * FROM `km_cs_faq`";
	public static final String INSERT_CS_ARTICLE_FAQ = "insert into `km_cs_faq` set "
			+ "`group`=?, "
			+ "`cate`=?, "
			+ "`title`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	public static final String SELECT_CS_ARTICLES_FAQ = "SELECT a.*, b.`uid` FROM `km_cs_faq` AS a JOIN `km_member` AS b ON a.uid = b.uid "
			+ "where `parent`=0 and `cate`=? "
			+ "order by `no` desc "
			+ "limit ?,10";
	public static final String UPDATE_CS_ARTICLE_FAQ = "update `km_cs_faq` set `title`=?,`content`=?,`rdate`=now() where `no`=?";
	public static final String DELETE_CS_ARTICLE_FAQ = "DELETE FROM `km_cs_faq` WHERE `no`=? or `parent`=?";
	public static final String SELECT_CS_MAX_NO_FAQ = "select max(`no`) from `km_cs_faq`";

	
	
	
	
	
	/////////////// 문의하기 QNA ////////////////////
	
	// 글보기 글쓰기
	public static final String SELECT_CS_ARTICLE_QNA = "SELECT * FROM `km_cs_qna`";
	public static final String INSERT_CS_ARTICLE_QNA = "insert into `km_cs_qna` set "
			+ "`parent`=?, "
			+ "`comment`=?, "
			+ "`cate`=?, "
			+ "`title`=?, "
			+ "`content`=?, "
			+ "`uid`=?, "
			+ "`regip`=?, "  
			+ "`rdate`=NOW()";
	public static final String SELECT_CS_ARTICLES_QNA = "SELECT a.*, b.`uid` FROM `km_cs_qna` AS a JOIN `km_member` AS b ON a.uid = b.uid "
			+ "where `parent`=0 and `cate`=? "
			+ "order by `no` desc "
			+ "limit ?,10";
	public static final String UPDATE_CS_ARTICLE_QNA = "update `km_cs_qna` set `title`=?,`content`=?,`rdate`=now() where `no`=?";
	public static final String DELETE_CS_ARTICLE_QNA = "DELETE FROM `km_cs_qna` WHERE `no`=? or `parent`=?";
	public static final String SELECT_CS_MAX_NO_QNA = "select max(`no`) from `km_cs_qna`";
	
	
	
	//게시글수
	public static final String SELECT_CS_COUNT_TOTAL_QNA = "SELECT COUNT(`no`) FROM `km_cs_qna` where `parent`=0 and `cate`=?";
	
	//comment
	public static final String INSERT_CS_COMMENT_QNA = "insert into `km_cs_qna` set "
														+ "`parent`=?, "
														+ "`content`=?, "
														+ "`uid`=?, "
														+ "`regip`=?, "
														+ "`rdate`=NOW()";
	public static final String SELECT_CS_COMMENTS_QNA = "select a.*, b.uid from `km_cs_qna` as a "
			+ "join `km_member` as b using (`uid`) "
			+ "where `parent`=? order by `no` asc";
	public static final String UPDATE_CS_COMMENT_QNA = "UPDATE `km_cs_qna` SET `content`=?, `rdate`=NOW() WHERE `no`=?";
	public static final String DELETE_CS_COMMENT_QNA = "DELETE FROM `km_cs_qna` WHERE `no`=?";
	public static final String SELECT_CS_COMMENT_LATEST_QNA = "SELECT a.*,b.uid FROM `km_cs_qna` AS a "
			+ "JOIN `km_member` AS b USING(`uid`) "
			+ "WHERE `parent`!=0 ORDER BY `no` DESC LIMIT 1";
	public static final String UPDATE_CS_COMMENT_COUNT_PLS_QNA = "UPDATE `km_cs_qna` SET `comment`=`comment`+1 WHERE `no`=?";
}

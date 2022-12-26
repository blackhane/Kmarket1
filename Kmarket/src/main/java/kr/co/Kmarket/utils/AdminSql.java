package kr.co.Kmarket.utils;

public class AdminSql {
	
	public static final String INSERT_PRODUCT = "insert into `km_product` set "
												+ "`cate1`=?,"
												+ "`cate2`=?,"
												+ "`prodName`=?,"
												+ "`descript`=?,"
												+ "`company`=?,"
												+ "`seller`=?,"
												+ "`price`=?,"
												+ "`discount`=?,"
												+ "`point`=?,"
												+ "`stock`=?,"
												+ "`delivery`=?,"
												+ "`thumb1`=?,"
												+ "`thumb2`=?,"
												+ "`thumb3`=?,"
												+ "`detail`=?,"
												+ "`prodNo`=?,"
												+ "`status`=?,"
												+ "`duty`=?,"
												+ "`receipt`=?,"
												+ "`bizType`=?,"
												+ "`brand`=?,"
												+ "`origin`=?,"
												+ "`ip`=?,"
												+ "`rdate`= NOW(), "
												+ "`material`=?,"
												+ "`color`=?,"
												+ "`size`=?,"
												+ "`manufacturer`=?,"
												+ "`country`=?,"
												+ "`precautions`=?,"
												+ "`date`=?,"
												+ "`standard`=?,"
												+ "`as`=?,"
												+ "`delivery_date`=?";

	//파일 넣기
	public static final String INSERT_FILE = "insert into `km_product_file` set "
										+ "`prodNo`=?,"
										+ "`newName`=?,"
										+ "`oriName`=?,"
										+ "`rdate`= NOW()";
	
	//공지사항 입력
	public static final String INSERT_NOTICE = "insert into `km_cs_notice` set "
										+ "`group`=?, "
										+ "`cate`=?, "
										+ "`title`=?, "
										+ "`content`=?, "
										+ "`regip`=?, "
										+ "`rdate`= NOW()";
	
	public static final String INSERT_FAQ = "insert into `km_cs_faq` set "
										+ "`group`=?, "
										+ "`cate`=?, "
										+ "`title`=?, "
										+ "`content`=?, "
										+ "`regip`=?, "
										+ "`rdate`= NOW()";
	
	//공지사항 게시글 수정
	public static final String UPDATE_NOTICE = "UPDATE `km_cs_notice` SET "
											+ "`group`=?, "
											+ "`cate`=?, "
											+ "`title`=?, "
											+ "`content`=?, "
											+ "`rdate`= NOW() "
											+ "WHERE `no` = ?";
	
	
	//공지사항 게시글 삭제
	public static final String DELETE_NOTICE = "delete from `km_cs_notice` WHERE `no`=?";
										
	//상품 리스트

	public static final String SELECT_PRODUCT_ALL = "select * from `km_product` LIMIT ?,10";
	public static final String SELECT_PRODUCT_ALL_SEARCH = "select * from `km_product` WHERE `prodName` LIKE ? LIMIT ?,10";
	public static final String SELECT_PRODUCT = "select * from `km_product` WHERE `company` = ? LIMIT ?,10";
	public static final String SELECT_SEARCH = "select * from `km_product` WHERE `company` = ? AND `prodName` LIKE ? LIMIT ?,10;";
	public static final String SELECT_NOTICE = "select * from `km_cs_notice` WHERE `no`=?";
	public static final String SELECT_NOTICE_VIEW = "select * from `km_cs_notice` WHERE `no`=?";

	public static final String SELECT_FAQ = "select * from `km_cs_faq` WHERE `group`=? AND `cate`=? ORDER BY `no` DESC LIMIT 10";
	public static final String SELECT_FAQ_VIEW = "select * from `km_cs_faq` WHERE `no`=?";
	

	//상품검색(검색기능)
	public static final String SELECT_ARTICLE_BY_KEYWORD = "SELECT * FROM `km_product` WHERE `prodName` LIKE ? ORDER BY `no` DESC";

	
	//게시판관리 -> 자주묻는질문 수정
	public static final String UPDATE_FAQ = "UPDATE `km_cs_faq` SET "
											+ "`group`=?, "
											+ "`cate`=?, "
											+ "`title`=?, "
											+ "`content`=?, "
											+ "`rdate`= NOW() "
											+ "WHERE `no` = ?";
	
	//게시판관리 -> 자주묻는질문 삭제
	public static final String DELETE_FAQ = "delete from `km_cs_faq` WHERE `no`=?";
	//게시판관리 -> 문의하기 삭제
	public static final String DELETE_QNA = "delete from `km_cs_qna` WHERE `no`=? OR `parent`=?";
	//게시판관리 -> 상품 삭제
	public static final String DELETE_PRODUCT = "delete from `km_product` WHERE `prodNo`=?";

	
	//qna 리스트
	public static final String SELECT_QNA = "SELECT * FROM `km_cs_qna` WHERE `group`=? and `cate` =? ORDER BY `no` DESC";
	
	//qna 글보기
	public static final String SELECT_QNA_VIEW = "select * from `km_cs_qna` WHERE `no`=?";

	//답변 보기
	public static final String SELECT_COMMENT = "SELECT * from `km_cs_qna` WHERE `parent` = ?" ;
	//문의 답변하기
	public static final String INSERT_COMMENT = "insert into `km_cs_qna` set "
												+ "`parent`=?, "
												+ "`content`=?, "
												+ "`uid`=?, "
												+ "`rdate`= NOW()";
	
	//댓글+1
	public static final String UPDATE_COMMENT_HIT_UP = "UPDATE `board_article` SET  `comment` = `comment`+1 WHERE `no`= ?";

	//게시물 개수
	public static final String COUNT_PRODUCT = "SELECT COUNT(*) FROM `km_product` WHERE `company` = ?";
	public static final String COUNT_PRODUCT_ALL = "SELECT COUNT(*) FROM `km_product`";
	public static final String COUNT_PRODUCT_ALL_SEARCH = "SELECT COUNT(*) FROM `km_product` WHERE `prodName` LIKE ?";
	public static final String COUNT_PRODUCT_SEARCH = "SELECT COUNT(*) FROM `km_product` WHERE `company` = ? AND `prodName` LIKE ?";
}

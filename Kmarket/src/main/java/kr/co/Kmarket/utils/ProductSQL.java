package kr.co.Kmarket.utils;

public class ProductSQL {

	//카테고리1 이름
	public static String FIND_CATE1 = "SELECT * FROM `km_product_cate1` WHERE `cate1`=?";
	
	//카테고리2 이름
	public static String FIND_CATE2 = "SELECT * FROM `km_product_cate2` WHERE `cate1`=? AND `cate2`=?";
	
	//카테고리2 목록
	public static String FIND_CATE2_LIST = "SELECT * FROM `km_product_cate2` WHERE `cate1`=?";
		
	//상품목록
	public static String SELECT_PRODUCTS_LIST = "SELECT * FROM `km_product` WHERE `cate1`=? AND `cate2`=? ORDER BY `prodNo` DESC";
	
	//상품리뷰
	public static String SELECT_REVIEWS = "SELECT a.*, b.prodName FROM `km_product_review` AS a "
										+ "JOIN `km_product` AS b ON a.prodNo = b.prodNo "
										+ "WHERE a.`prodNo`=? ORDER BY `revNo` DESC LIMIT ?,5";
	
	//상품 전체 개수
	public static String TOTAL_COUNT = "SELECT COUNT(*) FROM `km_product` WHERE `cate1`=? AND `cate2`=?";
	
	//리뷰 전체 개수
	public static String TOTAL_COUNT_REIVEW = "SELECT COUNT(*) FROM `km_product_review` WHERE `prodNo`=?";
	
	//베스트 상품
	public static String BEST_PRODUCT_5 = "SELECT * FROM `km_product` ORDER BY `sold` DESC LIMIT 5";
	
	//히트,추천,최신,인기,할인 상품
	public static String BEST_PRODUCT_8 = "SELECT * FROM `km_product` ORDER BY ? DESC LIMIT 8";

	//상품보기
	public static String SELECT_PPRODUCT = "SELECT * FROM `km_product` WHERE `prodNo`=?";
	
	//상품 조회수 + 1
	public static String PRODUCT_HIT_UP = "UPDATE `km_product` SET `hit`=`hit`+1 WHERE `prodNo`=?";
	
}

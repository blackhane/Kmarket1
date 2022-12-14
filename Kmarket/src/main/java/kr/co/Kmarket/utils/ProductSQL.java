package kr.co.Kmarket.utils;

public class ProductSQL {

	//카테고리1 이름
	public static String FIND_CATE1 = "SELECT * FROM `km_product_cate1` WHERE `cate1`=?";
	
	//카테고리2 이름
	public static String FIND_CATE2 = "SELECT * FROM `km_product_cate2` WHERE `cate1`=? AND `cate2`=?";
	
	//카테고리2 목록
	public static String FIND_CATE2_List = "SELECT * FROM `km_product_cate2` WHERE `cate1`=?";
	
	//상품목록
	public static String SELECT_PRODUCTS_LIST = "SELECT * FROM `km_product` WHERE `cate1`=? AND `cate2`=? ORDER BY `prodNo` DESC";
	
	//베스트 상품
	public static String BEST_PRODUCT_5 = "SELECT * FROM `km_product` ORDER BY `sold` DESC LIMIT 5";
	
	//히트,추천,최신,인기,할인 상품
	public static String BEST_PRODUCT_8 = "SELECT * FROM `km_product` ORDER BY ? DESC LIMIT 8";

	//상품보기
	public static String SELECT_PPRODUCT = "SELECT * FROM `km_product` WHERE `prodNo`=?";

	//장바구니 등록
	public static String INSERT_CART = "INSERT INTO `km_product_cart` VALUES `uid`=?, `prodNo`=?, `count`=?, `price`=?, `discount`=?, `point`=?, `delivery`=?, `total`=? `rdate`=NOW()";
	
	//장바구니 등록
	public static String SELECT_CART_ITEM = "SELECT * FROM `km_product_order_item` WHERE `uid`=?";
	
	//상품 판매 + 1
	public static String PRODUCT_SOLD_UP = "UPDATE `km_product` SET `sold`=`sold`+1 WHERE `prodNo`=?";
	
	//상품 조회수 + 1
	public static String PRODUCT_HIT_UP = "UPDATE `km_product` SET `hit`=`hit`+1 WHERE `prodNo`=?";

}

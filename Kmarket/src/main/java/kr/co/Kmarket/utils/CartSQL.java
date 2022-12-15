package kr.co.Kmarket.utils;

public class CartSQL {
	
	//장바구니 등록
	public static String INSERT_CART = "INSERT INTO `km_product_cart` "
		+ "(`uid`,`prodNo`,`count`,`price`,`discount`,`disPrice`,`point`,`delivery`,`total`,`rdate`) "
		+ "VALUE (?,?,?,?,?,?,?,?,?,NOW())";
	
	//장바구니 목록
	public static String SELECT_CART = "SELECT a.*,b.`prodName`,b.`descript`,b.`thumb1` FROM `km_product_cart` AS a "
		+ "JOIN `km_product` AS b "
		+ "ON a.prodNo = b.prodNo  WHERE `uid`=?";
	
	//장바구니 삭제
	public static String DELETE_CART = "DELETE FROM `km_product_cart` WHERE `cartNo`=?";
			
	//장바구니 합계
	public static String TOTAL_CART = "SELECT SUM(`count`),SUM(`price`*`count`),ROUND(SUM(`disPrice`*`count`)),SUM(`delivery`),SUM(`point`) FROM `km_product_cart` WHERE `uid`=? GROUP BY `uid`";
	
	//주문완료
	public static String INSERT_ORDER = "INSERT INTO `km_product_order` "
		+ "(`ordUid`,`ordCount`,`ordPrice`,`ordDiscount`,`ordDelivery`,`savePoint`,`usedPoint`,`totalPrice`,`recipName`,`recipHp`,`recipZip`,`recipAddr1`,`recipAddr2`,`ordPayment`,`ordDate`) "
		+ "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW())";
	
	//주문번호 검색
	public static String SELECT_ORDNO = "SELECT `ordNo` FROM `km_product_order` WHERE `ordUid`=?  ORDER BY `ordNo` DESC LIMIT 1";
	
	//주문결과
	public static String SELECT_ORDER_LATEST = "SELECT * FROM `km_product_order` WHERE `ordUid`=?  ORDER BY `ordDate` DESC LIMIT 1";
	
	//포인트 적립
	public static String UPDATA_POINT_UP = "UPDATE `km_member` SET `point`=`point`+? WHERE `uid`=?";
	
	//포인트 사용
	public static String UPDATA_POINT_DOWN = "UPDATE `km_member` SET `point`=`point`-? WHERE `uid`=?";
	
	//포인트 기록
	public static String INSERT_POINT = "INSERT INTO `km_member_point` (`uid`,`ordNo`,`point`,`pointDate`) VALUE (?,?,?,NOW())";
	
	//장바구니 비우기
	public static String DELECT_CARTS = "DELETE FROM `km_product_cart` WHERE `uid`=?";
	
	//상품 판매 ++
	public static String PRODUCT_SOLD_UP = "UPDATE `km_product` SET `sold`=`sold`+? WHERE `prodNo`=?";
	
	//상품 재고 --
	public static String PRODUCT_STOCK_DOWN = "UPDATE `km_product` SET `stock`=`stock`-? WHERE `prodNo`=?";
	
	//주문기록
	public static String INSERT_ORDER_ITEM = "INSERT INTO `km_product_order_item` (`prodNo`,`count`,`price`,`discount`,`point`,`delivery`,`total`) VALUE (?,?,?,?,?,?,?)";
}

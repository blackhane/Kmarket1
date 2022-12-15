package kr.co.Kmarket.DAO;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CartVO;
import kr.co.Kmarket.VO.OrderItemVO;
import kr.co.Kmarket.VO.ProductVO;
import kr.co.Kmarket.utils.CartSQL;
import kr.co.Kmarket.utils.DBCP;

public class CartDAO extends DBCP {

	//싱글톤
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	private CartDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//장바구니 등록
	public int insertCart(CartVO vo) {
		int result = 0;
		try {
			logger.info("장바구니 추가");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.INSERT_CART);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getProdNo());
			psmt.setString(3, vo.getCount());
			psmt.setString(4, vo.getPrice());
			psmt.setString(5, vo.getDiscount());
			psmt.setInt(6, vo.getDisPrice());
			psmt.setString(7, vo.getPoint());
			psmt.setString(8, vo.getDelivery());
			psmt.setString(9, vo.getTotal());
			result = psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//장바구니 보기
	public List<CartVO> selectCartItem(String uid) {
		List<CartVO> carts = new ArrayList<>();
		try {
			logger.info("장바구니 보기");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.SELECT_CART);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CartVO vo = new CartVO();
				vo.setCartNo(rs.getString(1));
				vo.setUid(rs.getString(2));
				vo.setProdNo(rs.getString(3));
				vo.setCount(rs.getString(4));
				vo.setPrice(rs.getString(5));
				vo.setDiscount(rs.getString(6));
				vo.setDisPrice(rs.getInt(7));
				vo.setPoint(rs.getString(8));
				vo.setDelivery(rs.getString(9));
				vo.setTotal(rs.getString(10));
				vo.setRdate(rs.getString(11));
				vo.setProdName(rs.getString(12));
				vo.setDescript(rs.getString(12));
				vo.setThumb1(rs.getString(14));
				carts.add(vo);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return carts;
	}
	
	//장바구니 삭제
	public int deleteCart(String cartNo) {
		int result = 0;
		try {
			logger.info("장바구니선택삭제");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.DELETE_CART);
			psmt.setString(1, cartNo);
			result = psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//주문완료
	public int insertOrderItem(OrderItemVO vo) {
		int result = 0;
		try {
			logger.info("주문완료");
			conn = getConnection();
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(CartSQL.INSERT_ORDER);
			psmt.setString(1, vo.getOrdUid());
			psmt.setString(2, vo.getOrdCount());
			psmt.setString(3, vo.getOrdPrice());
			psmt.setString(4, vo.getOrdDiscount());
			psmt.setString(5, vo.getOrdDelivery());
			psmt.setString(6, vo.getSavePoint());
			psmt.setString(7, vo.getUsedPoint());
			psmt.setString(8, vo.getTotalPrice());
			psmt.setString(9, vo.getRecipName());
			psmt.setString(10, vo.getRecipHp());
			psmt.setString(11, vo.getRecipZip());
			psmt.setString(12, vo.getRecipAddr1());
			psmt.setString(13, vo.getRecipAddr2());
			psmt.setString(14, vo.getOrdPayment());
			psmt.executeUpdate();
			
			//ordNo 찾기
			PreparedStatement psmt2 = conn.prepareStatement(CartSQL.SELECT_ORDNO);
			psmt2.setString(1, vo.getOrdUid());
			rs = psmt2.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			conn.commit();
			psmt2.close();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//주문결과창
	public OrderItemVO selectOrderLatest(String uid){
		OrderItemVO vo = new OrderItemVO();
		try {
			logger.info("주문결과");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.SELECT_ORDER_LATEST);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setOrdNo(rs.getString(1));
				vo.setOrdUid(rs.getString(2));
				vo.setOrdCount(rs.getString(3));
				vo.setOrdPrice(rs.getString(4));
				vo.setOrdDiscount(rs.getString(5));
				vo.setOrdDelivery(rs.getString(6));
				vo.setSavePoint(rs.getString(7));
				vo.setUsedPoint(rs.getString(8));
				vo.setTotalPrice(rs.getString(9));
				vo.setRecipName(rs.getString(10));
				vo.setRecipHp(rs.getString(11));
				vo.setRecipZip(rs.getString(12));
				vo.setRecipAddr1(rs.getString(13));
				vo.setRecipAddr2(rs.getString(14));
				vo.setOrdPayment(rs.getString(15));
				vo.setOrdComplete(rs.getString(16));
				vo.setOrdDate(rs.getString(17));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//포인트 적립
	public void updatePointUp(String point,String uid) {
		try {
			logger.info("포인트 적립 : "+ point);
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.UPDATA_POINT_UP);
			psmt.setString(1, point);
			psmt.setString(2, uid);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//포인트 사용
	public void updatePointDown(String point,String uid) {
		try {
			logger.info("포인트 사용 : "+ point);
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.UPDATA_POINT_DOWN);
			psmt.setString(1, point);
			psmt.setString(2, uid);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//포인트 기록
	public void insertPoint(String uid,int ordNo,String point) {
		try {
			logger.info("포인트 기록 : "+ point);
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.INSERT_POINT);
			psmt.setString(1, uid);
			psmt.setInt(2, ordNo);
			psmt.setString(3, point);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//장바구니 비우기
	public int deleteCarts(String uid) {
		int result = 0;
		try {
			logger.info("장바구니비우기");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.DELECT_CARTS);
			psmt.setString(1, uid);
			result = psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//상품판매++
	public void updateProductSoldUp(String prodNo, String sold) {
		try {
			logger.info("상품판매++");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.PRODUCT_SOLD_UP);
			psmt.setString(1, sold);
			psmt.setString(2, prodNo);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//상품재고--
	public void updateProductStockDown(String prodNo, String sold) {
		try {
			logger.info("상품재고--");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.PRODUCT_STOCK_DOWN);
			psmt.setString(1, sold);
			psmt.setString(2, prodNo);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//주문기록
	public void insertOrderItem(ProductVO vo, String sold) {
		int count = Integer.parseInt(sold);
		int price = vo.getPrice()  ;
		int discount = vo.getDiscount();
		discount = price/100*discount;
		int point = vo.getPoint() * count;
		int delivery = vo.getDelivery();
		int total = (price-discount) * count + delivery;
		
		try {
			logger.info("주문기록");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.INSERT_ORDER_ITEM);
			psmt.setInt(1, vo.getProdNo());
			psmt.setString(2, sold);
			psmt.setInt(3, price*count);
			psmt.setInt(4, discount*count);
			psmt.setInt(5, point);
			psmt.setInt(6, delivery);
			psmt.setInt(7, total);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
}

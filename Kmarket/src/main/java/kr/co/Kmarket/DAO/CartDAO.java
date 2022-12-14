package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CartVO;
import kr.co.Kmarket.VO.OrderItemVO;
import kr.co.Kmarket.VO.ProductVO;
import kr.co.Kmarket.utils.CartSQL;
import kr.co.Kmarket.utils.DBCP;
import kr.co.Kmarket.utils.ProductSQL;

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
			psmt.setString(6, vo.getPoint());
			psmt.setString(7, vo.getDelivery());
			psmt.setString(8, vo.getTotal());
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
				vo.setPoint(rs.getString(7));
				vo.setDelivery(rs.getString(8));
				vo.setTotal(rs.getString(9));
				vo.setProdName(rs.getString(11));
				vo.setDescript(rs.getString(12));
				vo.setThumb1(rs.getString(13));
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
	
	//장바구니 합계
	public CartVO selectTotalCart(String uid) {
		CartVO vo = new CartVO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.TOTAL_CART);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setCount(rs.getString(1));
				vo.setPrice(rs.getString(2));
				vo.setDiscount(rs.getString(3));
				vo.setDelivery(rs.getString(4));
				vo.setPoint(rs.getString(5));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//주문완료
	public int insertOrderItem(OrderItemVO vo) {
		int result = 0;
		try {
			logger.info("주문완료");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.INSERT_ORDER);
			psmt.setString(1, vo.getOrdUid());
			psmt.setString(2, vo.getOrdCount());
			psmt.setString(3, vo.getOrdPrice());
			psmt.setString(4, vo.getOrdDiscount());
			psmt.setString(5, vo.getOrdDelivery());
			psmt.setString(6, vo.getSavePoint());
			psmt.setString(7, vo.getUsedPoint());
			psmt.setString(8, vo.getOrdTotPrice());
			psmt.setString(9, vo.getRecipName());
			psmt.setString(10, vo.getRecipHp());
			psmt.setString(11, vo.getRecipZip());
			psmt.setString(12, vo.getRecipAddr1());
			psmt.setString(13, vo.getRecipAddr2());
			psmt.setString(14, vo.getOrdPayment());
			psmt.setString(15, vo.getOrdComplete());
			result = psmt.executeUpdate();
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
				vo.setOrdUid(rs.getString(1));
				vo.setOrdCount(rs.getString(1));
				vo.setOrdPrice(rs.getString(1));
				vo.setOrdDiscount(rs.getString(1));
				vo.setOrdDelivery(rs.getString(1));
				vo.setSavePoint(rs.getString(1));
				vo.setUsedPoint(rs.getString(1));
				vo.setOrdTotPrice(rs.getString(1));
				vo.setRecipName(rs.getString(1));
				vo.setRecipHp(rs.getString(1));
				vo.setRecipZip(rs.getString(1));
				vo.setRecipAddr1(rs.getString(1));
				vo.setRecipAddr2(rs.getString(1));
				vo.setOrdPayment(rs.getString(1));
				vo.setOrdComplete(rs.getString(1));
				vo.setOrdDate(rs.getString(1));
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
			logger.info("포인트 적립");
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
			logger.info("포인트 사용");
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
	
	//상품판매++
	public void updateProductSoldUp(String count,String prodNo) {
		try {
			logger.info("상품판매");
			conn = getConnection();
			psmt = conn.prepareStatement(CartSQL.PRODUCT_SOLD_UP);
			psmt.setString(1, count);
			psmt.setString(2, prodNo);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}

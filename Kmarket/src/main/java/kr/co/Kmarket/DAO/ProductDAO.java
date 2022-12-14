package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.ProductVO;
import kr.co.Kmarket.utils.DBCP;
import kr.co.Kmarket.utils.ProductSQL;

public class ProductDAO extends DBCP {

	//싱글톤
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
		
	//카테고리1 이름
	public String selectCate1Name(String cate1) {
		String cate = null;
		try {
			logger.info("카테고리1");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.FIND_CATE1);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cate = rs.getString(2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate;
	}
	
	//카테고리1 이름
	public String selectCate2Name(String cate1, String cate2) {
		String cate = null;
		try {
			logger.info("카테고리2");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.FIND_CATE2);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cate = rs.getString(2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate;
	}
	
	//상품목록
	public List<ProductVO> selectProducts(String cate1, String cate2, String ls) {
		List<ProductVO> product = new ArrayList<>();
		try {
			switch(Integer.parseInt(ls)) {
				case 0:
					ls = "`prodNo` DESC";
					break;
				case 1:
					ls = "`sold` DESC";
					break;
				case 2:
					ls = "`price`-(`price`/100 * `discount`) ASC";
					break;
				case 3:
					ls = "`price`-(`price`/100 * `discount`) DESC";
					break;
				case 4:
					ls = "`score` DESC";
					break;
				case 5:
					ls = "`review` DESC";
					break;
				case 6:
					ls = "`rdate` DESC";
					break;
			}
			logger.info("상품목록 정렬 : " + ls);
			conn = getConnection();
			String sql = "SELECT * FROM `km_product` WHERE `cate1`=? AND `cate2`=? ORDER BY " + ls;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getString("prodNo"));
				vo.setCate1(rs.getString("cate1"));
				vo.setCate2(rs.getString("cate2"));
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setPrice(rs.getString("price"));
				vo.setDiscount(rs.getString("discount"));
				vo.setSeller(rs.getString("seller"));
				vo.setScore(rs.getInt("score"));
				vo.setReview(rs.getInt("review"));
				vo.setThumb1(rs.getString("thumb1"));
				product.add(vo);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return product;
	}
	
	//메인페이지 상품
	public List<ProductVO> selectProductsBest1() {
		List<ProductVO> product = new ArrayList<>();
		try {
			logger.info("INDEX 페이지 상품목록 : best");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(ProductSQL.BEST_PRODUCT_5);
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getString(1));
				vo.setCate1(rs.getString(2));
				vo.setCate2(rs.getString(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setPrice(rs.getString(8));
				vo.setDiscount(rs.getString(9));
				vo.setDelivery(rs.getString(13));
				vo.setThumb2(rs.getString(18));
				product.add(vo);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return product;
	};
	
	//메인페이지 상품
	public List<ProductVO> selectProductsBest2(String col) {
		List<ProductVO> product = new ArrayList<>();
		try {
			logger.info("INDEX 페이지 상품목록 : " + col);
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `km_product` ORDER BY " + col + " DESC LIMIT 8");
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getString(1));
				vo.setCate1(rs.getString(2));
				vo.setCate2(rs.getString(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setPrice(rs.getString(8));
				vo.setDiscount(rs.getString(9));
				vo.setDelivery(rs.getString(13));
				vo.setThumb2(rs.getString(18));
				product.add(vo);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return product;
	};
	
	//상품보기
	public ProductVO selectProduct(String prodNo) {
		ProductVO vo = new ProductVO();
		try {
			logger.info("상품보기 : " + prodNo);
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PPRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setProdNo(rs.getString("prodNo"));
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setSeller(rs.getString("seller"));
				vo.setPrice(rs.getString("price"));
				vo.setDiscount(rs.getString("discount"));;
				vo.setPoint(rs.getString("point"));;
				vo.setDelivery(rs.getString("delivery"));
				vo.setScore(rs.getInt("score"));
				vo.setReview(rs.getInt("review"));
				vo.setThumb3(rs.getString("thumb3"));
				vo.setDetail1(rs.getString("detail1"));
				vo.setCompany(rs.getString("company"));
				vo.setStatus(rs.getString("status"));
				vo.setDuty(rs.getString("duty"));
				vo.setReceipt(rs.getString("receipt"));
				vo.setBizType(rs.getString("bizType"));
				vo.setOrigin(rs.getString("origin"));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	};
	
	//조회수+1
	public void updateProductHit(String prodNo) {
		try {
			logger.info("조회수+1");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.PRODUCT_HIT_UP);
			psmt.setString(1, prodNo);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
}

package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CateVO;
import kr.co.Kmarket.VO.ProductVO;
import kr.co.Kmarket.VO.ReviewVO;
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
	
	//카테고리2 이름
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
	
	//카테고리2 이름
	public List<CateVO> selectFindCate2 (String cate1) {
		List<CateVO> vo = new ArrayList<>();
		try {
			logger.info("카테고리2리스트");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.FIND_CATE2_LIST);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CateVO cate = new CateVO();
				cate.setCate2(rs.getString(1));
				cate.setC2Name(rs.getString(2));
				vo.add(cate);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
		
	//상품목록
	public List<ProductVO> selectProducts(String cate1, String cate2, String ls, int start) {
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
			String sql = "SELECT * FROM `km_product` WHERE `cate1`=? AND `cate2`=? ORDER BY " + ls + " LIMIT ?, 10";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setInt(3, start);
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
	
	//리스트 페이징
	public int selectCountTotal(String cate1, String cate2) {
		int result = 0;
		try {
			logger.info("페이징 처리");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.TOTAL_COUNT);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
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
				vo.setThumb1(rs.getString(17));
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
				vo.setProdNo(rs.getString(1));
				vo.setCate1(rs.getInt(2));
				vo.setCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
				vo.setOrdNo(rs.getInt(28));
				vo.setBrand(rs.getString(29));
				vo.setMaterial(rs.getString(30));
				vo.setColor(rs.getString(31));
				vo.setSize(rs.getString(32));
				vo.setManufacturer(rs.getString(33));
				vo.setCountry(rs.getString(34));
				vo.setPrecautions(rs.getString(35));
				vo.setDate(rs.getString(36));
				vo.setStandard(rs.getString(37));
				vo.setAs(rs.getString(38));
				vo.setDelivery_date(rs.getString(39));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	};
	
	//상품 리뷰
	public List<ReviewVO> selectReviews(String prodNo, int start) {
		List<ReviewVO> reviews = new ArrayList<>();
		try {
			logger.info("리뷰가져오기");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_REVIEWS);
			psmt.setString(1, prodNo);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setRevNo(rs.getString(1));
				vo.setProdNo(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setUid(rs.getString(4).replaceAll("(?<=.{2})." , "*"));
				vo.setRating(rs.getString(5));
				vo.setRegip(rs.getString(6));
				vo.setRdate(rs.getString(7).substring(0,10));
				vo.setProdName(rs.getString(8));
				reviews.add(vo);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return reviews;
	}
	
	//리뷰 갯수
	public int selectCountReview(String prodNo) {
		int result = 0;
		try {
			logger.info("리뷰개수");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.TOTAL_COUNT_REIVEW);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//주문상품 찾기
	public ProductVO selectOrderProduct(String prodNo, String count) {
		ProductVO vo = new ProductVO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PPRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setProdNo(rs.getString(1));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10)*Integer.parseInt(count));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setCount(count);
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

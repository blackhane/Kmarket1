package kr.co.Kmarket.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.productVO;
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
	public productVO selectProducts(String cate1, String cate2, String ls) {
		productVO vo = new productVO();
		try {
			logger.info("상품목록~");
			conn = getConnection();
			switch(1) {
				case 0:
					ls = "`prodNo` DESC";
				case 1:
					ls = "`sold` DESC";
				case 2:
					ls = "`price` ASC";
				case 3:
					ls = "`price` DESC";
				case 4:
					ls = "`score` DESC";
				case 5:
					ls = "`review` DESC";
				case 6:
					ls = "`rdate` DESC";
			}
			String sql = "SELECT * FROM `km_product` WHERE `cate1`=? AND `cate2`=? ORDER BY " + ls;
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			while(rs.next()) {
				vo.setProdNo(rs.getString("prodNo"));
				vo.setCate1(rs.getString("prodCate1"));
				vo.setCate2(rs.getString("prodCate2"));
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setPrice(rs.getString("price"));
				vo.setDiscount(rs.getString("discount"));
				vo.setSeller(rs.getString("seller"));
				vo.setScore(rs.getInt("score"));
				vo.setThumb1(rs.getString("thumb1"));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//메인페이지 상품
	public productVO selectProductsBest1() {
		productVO vo = new productVO();
		try {
			logger.info("INDEX 페이지 베스트상품");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(ProductSQL.SELECT_PPRODUCTS_BEST1);
			while(rs.next()) {
				vo.setProdNo(rs.getString("prodNo"));
				vo.setCate1(rs.getString("prodCate1"));
				vo.setCate2(rs.getString("prodCate2"));
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setPrice(rs.getString("price"));
				vo.setDiscount(rs.getString("discount"));
				vo.setThumb2(rs.getString("thumb2"));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	};
	
	//메인페이지 상품
	public productVO selectProductsBest2(String col) {
		productVO vo = new productVO();
		try {
			logger.info("INDEX 페이지 추천상품");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PPRODUCTS_BEST2);
			psmt.setString(1, col);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setProdNo(rs.getString("prodNo"));
				vo.setCate1(rs.getString("prodCate1"));
				vo.setCate2(rs.getString("prodCate2"));
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setPrice(rs.getString("price"));
				vo.setDiscount(rs.getString("discount"));
				vo.setThumb2(rs.getString("thumb2"));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	};
	
	//상품보기
	public productVO selectProduct(String prodNo) {
		productVO vo = new productVO();
		try {
			logger.info("상품보기");
			conn = getConnection();
			psmt = conn.prepareStatement(ProductSQL.SELECT_PPRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setProdNo(rs.getString("prodNo"));
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				vo.setSeller(rs.getString("seller"));
				vo.setPrice(rs.getString("price"));
				vo.setDiscount(rs.getString("discount"));;
				vo.setDelivery(rs.getString("delivery"));
				vo.setScore(rs.getInt("score"));
				vo.setThumb3(rs.getString("thumb3"));
				vo.setDetail(rs.getString("detail"));
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
	
}

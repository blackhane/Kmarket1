package kr.co.Kmarket.DAO.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.ProductVO;
import kr.co.Kmarket.utils.DBCP;
import kr.co.Kmarket.utils.Sql_admin;

public class AdminDAO extends DBCP {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	private AdminDAO() {}
	

public void insertProduct(ProductVO vo) {
		
		
		try{
			logger.info("어드민 제품등록...");
			Connection conn = getConnection();
			
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(Sql_admin.INSERT_PRODUCT);
			psmt.setInt(1, vo.getCate1());
			psmt.setInt(2, vo.getCate2());
			psmt.setString(3, vo.getProdName());
			psmt.setString(4, vo.getDescript());
			psmt.setString(5, vo.getCompany());
			psmt.setInt(6, vo.getPrice());
			psmt.setInt(7, vo.getDiscount());
			psmt.setInt(8, vo.getPoint());
			psmt.setInt(9, vo.getStock());
			psmt.setInt(10, vo.getDelivery());
			psmt.setString(11, vo.getThumb1());
			psmt.setString(12, vo.getThumb2());
			psmt.setString(13, vo.getThumb3());
			psmt.setString(14, vo.getDetail());
			psmt.setInt(15, vo.getProdNo());
			psmt.setString(16, vo.getStatus());
			psmt.setString(17, vo.getDuty());
			psmt.setString(18, vo.getReceipt());
			psmt.setString(19, vo.getBizType());
			psmt.setString(20, vo.getBrand());
			psmt.setString(21, vo.getOrigin());
			psmt.setString(22, vo.getMaterial());
			psmt.setString(23, vo.getColor());
			psmt.setString(24, vo.getSize());
			psmt.setString(25, vo.getManufacturer());
			psmt.setString(26, vo.getCountry());
			psmt.setString(27, vo.getPrecautions());
			psmt.setString(28, vo.getDate());
			psmt.setString(29, vo.getStandard());
			psmt.setString(30, vo.getAs());
			psmt.setString(31, vo.getDelivery_date());

			psmt.executeUpdate();
			close();
			
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
	}

public void insertFile(String prodNo, String newName, String fname) {
	try{
		logger.info("파일넣기 start...");
		Connection conn = getConnection();
		PreparedStatement psmt = conn.prepareStatement(Sql_admin.INSERT_FILE);
		psmt.setString(1, prodNo);
		psmt.setString(2, newName);
		psmt.setString(3, fname);
		
		psmt.executeUpdate();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
		logger.error(e.getMessage());
	}
}
	
}

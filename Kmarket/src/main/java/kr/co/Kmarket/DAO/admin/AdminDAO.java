package kr.co.Kmarket.DAO.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsFaqVO;
import kr.co.Kmarket.VO.CsNoticeVO;
import kr.co.Kmarket.VO.CsVO;
import kr.co.Kmarket.VO.ProductVO;
import kr.co.Kmarket.utils.DBCP;
import kr.co.Kmarket.utils.AdminSql;

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
			psmt = conn.prepareStatement(AdminSql.INSERT_PRODUCT);
			psmt.setInt(1, vo.getCate1());
			psmt.setInt(2, vo.getCate2());
			psmt.setString(3, vo.getProdName());
			psmt.setString(4, vo.getDescript());
			psmt.setString(5, vo.getCompany());
			psmt.setString(6, vo.getSeller());
			psmt.setInt(7, vo.getPrice());
			psmt.setInt(8, vo.getDiscount());
			psmt.setInt(9, vo.getPoint());
			psmt.setInt(10, vo.getStock());
			psmt.setInt(11, vo.getDelivery());
			psmt.setString(12, vo.getThumb1());
			psmt.setString(13, vo.getThumb2());
			psmt.setString(14, vo.getThumb3());
			psmt.setString(15, vo.getDetail());
			psmt.setInt(16, vo.getProdNo());
			psmt.setString(17, vo.getStatus());
			psmt.setString(18, vo.getDuty());
			psmt.setString(19, vo.getReceipt());
			psmt.setString(20, vo.getBizType());
			psmt.setString(21, vo.getBrand());
			psmt.setString(22, vo.getOrigin());
			psmt.setString(23, vo.getIp());
			psmt.setString(24, vo.getMaterial());
			psmt.setString(25, vo.getColor());
			psmt.setString(26, vo.getSize());
			psmt.setString(27, vo.getManufacturer());
			psmt.setString(28, vo.getCountry());
			psmt.setString(29, vo.getPrecautions());
			psmt.setString(30, vo.getDate());
			psmt.setString(31, vo.getStandard());
			psmt.setString(32, vo.getAs());
			psmt.setString(33, vo.getDelivery_date());
//			psmt.setInt(23, vo.getRdate());
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
			PreparedStatement psmt = conn.prepareStatement(AdminSql.INSERT_FILE);
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

	public void insertNotice(CsVO vo) {
		try{
			logger.info("공지사항 등록.");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.INSERT_NOTICE);
			psmt.setString(1, vo.getGroup());
			psmt.setString(2, vo.getCate());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getContent());
			psmt.setString(5, vo.getRegip());
			psmt.executeUpdate();
			close();
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	
	public void insertFaq(CsVO vo) {
		try{
			logger.info("자주묻는질문 등록");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.INSERT_FAQ);
			psmt.setString(1, vo.getGroup());
			psmt.setString(2, vo.getCate());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getContent());
			psmt.setString(5, vo.getRegip());
			
			psmt.executeUpdate();
			close();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

	//모든 상품 리스트
	public List<ProductVO> selectProduct(int start) {
		List<ProductVO> product = new ArrayList<>();
		try{
			logger.info("상품불러오기 start...");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.SELECT_PRODUCT_ALL);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				product.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return product;
	}
	
	//모든 상품 검색기능 추가
	public List<ProductVO> selectProduct1(String search, String keyword, int start) {
		List<ProductVO> product = new ArrayList<>();
		try{
			logger.info("상품불러오기 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product` WHERE `"+search+"` LIKE ? LIMIT ?,10");
			psmt.setString(1, "%"+keyword+"%");
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				product.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return product;
	}

	// 판매자 상품리스트 select
	public List<ProductVO> selectProduct(String company, int start) {
		List<ProductVO> product = new ArrayList<>();
		try{
			logger.info("상품불러오기 start...");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.SELECT_PRODUCT);
			psmt.setString(1, company);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				product.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return product;
	}
	
	//판매자 상품리스트 검색기능추가
	public List<ProductVO> selectProduct(String search, String company, String keyword, int start) {
		List<ProductVO> product = new ArrayList<>();
		try{
			logger.info("상품검색 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product` WHERE `company` =? AND `"+search+"` LIKE ? LIMIT ?,10");
			psmt.setString(1, company);
			psmt.setString(2, "%"+keyword+"%");
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
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
				product.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return product;
	}
	

	//상품리스트 페이징 all
	public int selectCountTotal() {
		int result = 0;
		try {
			logger.info("페이징 처리");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.COUNT_PRODUCT_ALL);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//상품리스트 페이징 all +기능추가
	public int selectCountTotal1(String keyword) {
		int result = 0;
		try {
			logger.info("페이징 처리");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.COUNT_PRODUCT_ALL_SEARCH);
			psmt.setString(1, "%"+keyword+"%");
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//상품리스트 페이징
	public int selectCountTotal(String company) {
		int result = 0;
		try {
			logger.info("페이징 처리");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.COUNT_PRODUCT);
			psmt.setString(1, company);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//상품리스트 검색기능 추가
	public int selectCountTotal(String company, String keyword) {
		int result = 0;
		try {
			logger.info("페이징 처리");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.COUNT_PRODUCT_SEARCH);
			psmt.setString(1, company);
			psmt.setString(2, "%"+keyword+"%");
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	// 공지사항 불러오기
	public List<CsNoticeVO> selectNotice(String cate,int start) {
		List<CsNoticeVO> notice = new ArrayList<>();
		try{			
			logger.info("공지사항 리스트");
			conn = getConnection();
			String sql = "";
			
			switch(cate) {
			case "전체보기":
				sql = "SELECT * FROM `km_cs_notice` ORDER BY `no` DESC LIMIT ?,10";
				break;
			case "고객 서비스":
				sql = "SELECT * FROM `km_cs_notice` where `cate`='고객 서비스'  ORDER BY `no` DESC LIMIT ?,10";
				break;
			case "안전거래":
				sql = "SELECT * FROM `km_cs_notice` where `cate`='안전거래'  ORDER BY `no` DESC LIMIT ?,10";
				break;
			case "위해상품":
				sql = "SELECT * FROM `km_cs_notice` where `cate`='위해상품'  ORDER BY `no` DESC LIMIT ?,10";
				break;
			case "이벤트 당첨":
				sql = "SELECT * FROM `km_cs_notice` where `cate`='이벤트 당첨'  ORDER BY `no` DESC LIMIT ?,10";
				break;
			}
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNo(rs.getString(1));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setHit(rs.getString(7));
				vo.setRdate(rs.getString(11).substring(0,10));
				notice.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return notice;
	}
	
	public int selectNoticeTotal() {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_cs_notice`");
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	public int selectNoticeTotal(String cate) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_cs_notice` WHERE `cate`=?");
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public List<CsNoticeVO> selectNotice() {
		List<CsNoticeVO> notice = new ArrayList<>();
		try{			
			logger.info("공지사항 인덱스 리스트");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_cs_notice` ORDER BY `no` DESC LIMIT 5");
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNo(rs.getString(1));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setHit(rs.getString(7));
				vo.setRdate(rs.getString(11).substring(2,10));
				notice.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return notice;
	}
	
	public List<CsVO> selectQna() {
		List<CsVO> notice = new ArrayList<>();
		try{			
			logger.info("공지사항 인덱스 리스트");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_cs_qna` WHERE `parent`=0 ORDER BY `no` DESC LIMIT 5");
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setUid(rs.getString(9).replaceAll("(?<=.{2}).", "*"));
				vo.setRdate(rs.getString(11).substring(2,10));
				notice.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return notice;
	}
	
	public CsNoticeVO NoticeView(String no) {
		CsNoticeVO vo = null;
		try{			
			logger.info("공지사항 보기");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.SELECT_NOTICE_VIEW);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsNoticeVO();
				vo.setNo(rs.getString(1));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setContent(rs.getString(8));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return vo;
	}

	// 공지사항 카테고리
	public List<CsNoticeVO> NoticeView(String group, String cate) {
		List<CsNoticeVO> notice = new ArrayList<>();
		try{			
			logger.info("공지사항 카테고리");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.SELECT_NOTICE);
			psmt.setString(1, group);
			psmt.setString(2, cate);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setHit(rs.getString(7));
				vo.setRdate(rs.getString(11).substring(0,10));
				notice.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return notice;
	}
	
	//Admin 자주묻는질문
	public List<CsFaqVO> selectFaq(String group, String cate) {
		List<CsFaqVO> faq = new ArrayList<>();
		try{			
			logger.info("자주묻는질문 카테고리");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.SELECT_FAQ);
			psmt.setString(1, group);
			psmt.setString(2, cate);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsFaqVO vo = new CsFaqVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setHit(rs.getString(7));
				vo.setRdate(rs.getString(11).substring(0,10));
				faq.add(vo);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return faq;
	}
	
	
	//어드민 자주묻는질문 페이징
	public int countTotalFaq() {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_cs_faq`");
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	public int countTotalFaq(String group) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_cs_faq` WHERE `group`=?");
			psmt.setString(1, group);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	public int countTotalFaq(String group, String cate) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_cs_faq` WHERE `group`=? AND `cate`=?");
			psmt.setString(1, group);
			psmt.setString(2, cate);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public CsFaqVO FaqView(String no) {
		CsFaqVO vo = null;
		try {
			logger.info("자주묻는질문 보기");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.SELECT_FAQ_VIEW);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsFaqVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setHit(rs.getString(7));
				vo.setContent(rs.getString(8));
				vo.setRdate(rs.getString(11));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	
	//delete
	
	/*
	 * public String deleteFile(String parent) {
	 * 
	 * String newName = null;
	 * 
	 * try { Connection conn = getConnection();
	 * 
	 * conn.setAutoCommit(false);
	 * 
	 * PreparedStatement psmt1 = conn.prepareStatement(Sql.SELECT_FILE_WITH_PARENT);
	 * PreparedStatement psmt2 = conn.prepareStatement(Sql.DELETE_FILE);
	 * psmt1.setString(1, parent); psmt2.setString(1, parent);
	 * 
	 * ResultSet rs = psmt1.executeQuery(); psmt2.executeUpdate();
	 * 
	 * conn.commit();
	 * 
	 * if(rs.next()) { newName = rs.getString(3); }
	 * 
	 * psmt1.close(); psmt2.close(); conn.close(); }catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return newName; }
	 */
	
	//글수정 업데이트
	public void updateNotice(String no, String group, String cate, String title, String content) {
		try {
			logger.info("공지수정 : " + group);
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.UPDATE_NOTICE);
			psmt.setString(1, group);
			psmt.setString(2, cate);
			psmt.setString(3, title);
			psmt.setString(4, content);
			psmt.setString(5, no);
			psmt.executeUpdate();
			close();
			logger.debug("공지수정" + no);
		}catch(Exception e){	
			logger.error(e.getMessage());
		}
	}

	
	
	//글삭제
	public int deleteNotice(String no) {
		int result = 0;
		try {
			logger.info("공지삭제 start...");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.DELETE_NOTICE);	
			psmt.setString(1, no);		
			result = psmt.executeUpdate();
			close();
		}catch(Exception e){	
			logger.error(e.getMessage());
		}
		return result;
	}

	//자주묻는질문 수정
	public void updateFaq(String no, String group, String cate, String title, String content) {
		try {
			logger.info("자주묻는질문 수정 start...");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.UPDATE_FAQ);
			psmt.setString(1, group);
			psmt.setString(2, cate);
			psmt.setString(3, title);
			psmt.setString(4, content);
			psmt.setString(5, no);
			psmt.executeUpdate();
			close();
			logger.debug("자주묻는질문 수정" + no);
		}catch(Exception e){	
			logger.error(e.getMessage());
		}
	}
	
	// 자주묻는질문 글 삭제
	public int deleteFaq(String no) {
		int result = 0;
		try {
			logger.info("자주묻는질문 삭제");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.DELETE_FAQ);	
			psmt.setString(1, no);		
			result = psmt.executeUpdate();
			close();
		}catch(Exception e){	
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//상품 삭제
	public int deleteProduct(String prodNo) {
		int result = 0;
		try {
			logger.info("상품삭제 start...");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.DELETE_PRODUCT);	
			psmt.setString(1, prodNo);		
			result = psmt.executeUpdate();
			close();
		}catch(Exception e){	
			logger.error(e.getMessage());
		}
		return result;
	}

//	vo.setProdNo(rs.getString(1));
//	vo.setCate1(rs.getInt(2));
//	vo.setCate2(rs.getInt(3));
//	vo.setProdName(rs.getString(4));
//	vo.setDescript(rs.getString(5));
//	vo.setCompany(rs.getString(6));
//	vo.setSeller(rs.getString(7));
//	vo.setPrice(rs.getInt(8));
//	vo.setDiscount(rs.getInt(9));
//	vo.setPoint(rs.getInt(10));
//	vo.setStock(rs.getInt(11));
//	vo.setSold(rs.getInt(12));
//	vo.setDelivery(rs.getInt(13));
//	vo.setHit(rs.getInt(14));
//	vo.setScore(rs.getInt(15));
//	vo.setReview(rs.getInt(16));
//	vo.setThumb1(rs.getString(17));
//	vo.setThumb2(rs.getString(18));
//	vo.setThumb3(rs.getString(19));
//	vo.setDetail(rs.getString(20));
//	vo.setStatus(rs.getString(21));
//	vo.setDuty(rs.getString(22));
//	vo.setReceipt(rs.getString(23));
//	vo.setBizType(rs.getString(24));
//	vo.setOrigin(rs.getString(25));
//	vo.setIp(rs.getString(26));
//	vo.setRdate(rs.getInt(27));
//	vo.setOrdNo(rs.getInt(28));
//	vo.setBrand(rs.getString(29));
//	vo.setMaterial(rs.getString(30));
//	vo.setColor(rs.getString(31));
//	vo.setSize(rs.getString(32));
//	vo.setManufacturer(rs.getString(33));
//	vo.setCountry(rs.getString(34));
//	vo.setPrecautions(rs.getString(35));
//	vo.setDate(rs.getString(36));
//	vo.setStandard(rs.getString(37));
//	vo.setAs(rs.getString(38));
//	vo.setDelivery_date(rs.getString(39));
}

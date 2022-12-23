package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsVO;
import kr.co.Kmarket.utils.CsSQL;
import kr.co.Kmarket.utils.DBCP;

public class CsFaqDAO extends DBCP{
	
	//싱글톤
	private static CsFaqDAO instance = new CsFaqDAO();
	public static CsFaqDAO getInstance() {
		return instance;
	}
	private CsFaqDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//카테고리
	public List<String> searchCate(String group) {
		List<String> cate = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SEARCH_CATE_FAQ);
			psmt.setString(1, group);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String str = "";
				str = rs.getString(1);
				cate.add(str);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate;
	}
	
	//글목록
	public List<CsVO> selectArticles(String group) {
		List<CsVO> articles = new ArrayList<>();
		try {
			logger.info("자주묻는질문 글목록");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLES_FAQ);
			psmt.setString(1, group);
			rs= psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				articles.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	//글보기
	public CsVO selectArticle(String no) {
		logger.info("자주묻는질문 글보기");
		CsVO vo = new CsVO();
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLE_FAQ);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()){
				vo.setNo(rs.getString(1));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setContent(rs.getString(8));
				vo.setUid(rs.getString(9).replaceAll("(?<=.{2}).", "*"));
				vo.setRdate(rs.getString(11).substring(0,10));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//조회수
	public void updateArticleHit(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.UPDATE_HIT_UP);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
}

	

	
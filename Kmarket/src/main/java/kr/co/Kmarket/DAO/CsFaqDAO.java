package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsFaqVO;
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
	
	

	
	
	//자주하는 질문
	public CsFaqVO faq_selectArticle(String no) {
		logger.info("faq_selectArticle start...");
		CsFaqVO article= null;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLE_FAQ);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				article = new CsFaqVO();
				article.setNo(rs.getString(1));
				article.setGroup(rs.getString(2));
				article.setCate(rs.getString(3));
				article.setTitle(rs.getString(4));
				article.setContent(rs.getString(5));
				article.setRegip(rs.getString(6));
				article.setRdate(rs.getString(7));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return article;
	}
	
	public List<CsFaqVO> faq_selectArticles(String group, String cate) {
		List<CsFaqVO> articles = new ArrayList<>();
		try {
			logger.info("faq_selectArticles start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLES_FAQ);
			psmt.setString(1, group);
			psmt.setString(2, cate);
			rs= psmt.executeQuery();
			while(rs.next()) {
				CsFaqVO vo = new CsFaqVO();
				vo = new CsFaqVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setCate(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setRegip(rs.getString(6));
				vo.setRdate(rs.getString(7));
				
				articles.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	public int faq_insertArticle(CsFaqVO article) {
		int parent = 0;
		try {
			logger.info("faq_insertArticle start...");
			conn = getConnection();
			conn.setAutoCommit(false); // 트렌젝션 시작
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(CsSQL.INSERT_CS_ARTICLE_FAQ);
			
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setString(5, article.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(CsSQL.SELECT_CS_MAX_NO_FAQ);
			
			conn.commit();			// 트렌젝션 끝 All or Nothing
			
			if(rs.next()) {
				parent = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return parent;
	}
	
	public int faq_updateArticle(String title, String group, String content, String no) {
		logger.info("faq_updateArticle start...");
		int result = 0;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSQL.UPDATE_CS_ARTICLE_FAQ);
			psmt.setString(1, title);
			psmt.setString(2, group);
			psmt.setString(3, content);
			psmt.setString(4, no);
			result = psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return result;
	}
	public void faq_deleteArticle(String no) {
		logger.info("faq_deleteArticle start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.DELETE_CS_ARTICLE_FAQ);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
	
	
}

	

	
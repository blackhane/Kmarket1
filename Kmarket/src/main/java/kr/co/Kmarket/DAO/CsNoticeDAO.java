package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsNoticeVO;
import kr.co.Kmarket.utils.CsSQL;
import kr.co.Kmarket.utils.DBCP;

public class CsNoticeDAO extends DBCP{
	
	//싱글톤
	private static CsNoticeDAO instance = new CsNoticeDAO();
	public static CsNoticeDAO getInstance() {
		return instance;
	}
	private CsNoticeDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	
	//공지사항
	public CsNoticeVO notice_selectArticle(String no) {
		logger.info("notice_selectArticle start...");
		CsNoticeVO article= null;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLE_NOTICE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				article = new CsNoticeVO();
				article.setNo(rs.getString(1));
				article.setCate(rs.getString(2));
				article.setTitle(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setRegip(rs.getString(5));
				article.setRdate(rs.getString(6));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return article;
	}
	
	public List<CsNoticeVO> notice_selectArticles(int start, String cate) {
		List<CsNoticeVO> articles = new ArrayList<>();
		try {
			logger.info("notice_selectArticles start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLES_NOTICE);
			psmt.setInt(1, start);
			psmt.setString(2, cate);
			rs= psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo = new CsNoticeVO();
				vo.setNo(rs.getString(1));
				vo.setCate(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setRegip(rs.getString(5));
				vo.setRdate(rs.getString(6));
				
				articles.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	public int notice_insertArticle(CsNoticeVO article) {
		int parent = 0;
		try {
			logger.info("notice_insertArticle start...");
			conn = getConnection();
			conn.setAutoCommit(false); // 트렌젝션 시작
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(CsSQL.INSERT_CS_ARTICLE_NOTICE);
			
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setString(5, article.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(CsSQL.SELECT_CS_MAX_NO_NOTICE);
			
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
	
	public int notice_updateArticle(String title, String content, String no) {
		logger.info("notice_updateArticle start...");
		int result = 0;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSQL.UPDATE_CS_ARTICLE_NOTICE);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, no);
			result = psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return result;
	}
	public void notice_deleteArticle(String no) {
		logger.info("notice_deleteArticle start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.DELETE_CS_ARTICLE_NOTICE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
	// 전체 게시글 카운트
		public int notice_selectCountTotal(String cate) {
			int total = 0;
			try {
				logger.info("notice_selectCountTotal start...");
				conn = getConnection();
				psmt = conn.prepareStatement(CsSQL.SELECT_CS_COUNT_TOTAL_NOTICE);
				psmt.setString(1, cate);
				rs = psmt.executeQuery();
				if(rs.next()) {
					
				}
			}catch(Exception e) {
				
			}
			return total;
		}
	
	
}

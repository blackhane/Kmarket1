package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsNoticeVO;
import kr.co.Kmarket.utils.CsSQL;
import kr.co.Kmarket.utils.DBCP;

public class CsQnaDAO extends DBCP{
	
	//싱글톤
	private static CsQnaDAO instance = new CsQnaDAO();
	public static CsQnaDAO getInstance() {
		return instance;
	}
	private CsQnaDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	
	
	//문의하기
	public CsNoticeVO qna_selectArticle(String no) {
		logger.info("qna_selectArticle start...");
		CsNoticeVO article= null;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLE_QNA);
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
	
	public List<CsNoticeVO> qna_selectArticles(int start) {
		List<CsNoticeVO> articles = new ArrayList<>();
		try {
			logger.info("qna_selectArticles start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLES_QNA);
			psmt.setInt(1, start);
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
	////@@ 막힘
	public int qna_insertArticle(CsNoticeVO article) {
		int parent = 0;
		try {
			logger.info("qna_insertArticle start...");
			conn = getConnection();
			conn.setAutoCommit(false); // 트렌젝션 시작
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(CsSQL.INSERT_CS_ARTICLE_QNA);
			
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setString(5, article.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(CsSQL.SELECT_MAX_NO);
			
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
	///////////
	
	public int qna_updateArticle(String title, String content, String no) {
		logger.info("qna_updateArticle start...");
		int result = 0;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSQL.UPDATE_CS_ARTICLE_QNA);
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
	public void qna_deleteArticle(String no) {
		logger.info("notice_deleteArticle start...");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.DELETE_CS_ARTICLE_QNA);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	public void qna_insertComment() {}	
	public void qna_selectComment() {}	
	public void qna_deleteComment() {}
	
	
}

package kr.co.Kmarket.DAO;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsQnaVO;
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
	public CsQnaVO qna_selectArticle(String no) {
		logger.info("qna_selectArticle start...");
		CsQnaVO article= null;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLE_QNA);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				article = new CsQnaVO();
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
	
	public List<CsQnaVO> qna_selectArticles(int start) {
		List<CsQnaVO> articles = new ArrayList<>();
		try {
			logger.info("qna_selectArticles start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_ARTICLES_QNA);
			psmt.setInt(1, start);
			rs= psmt.executeQuery();
			while(rs.next()) {
				CsQnaVO vo = new CsQnaVO();
				vo = new CsQnaVO();
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
	
	public int qna_insertArticle(CsQnaVO article) {
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
			rs = stmt.executeQuery(CsSQL.SELECT_CS_MAX_NO_QNA);
			
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
	
	
	
	// 전체 게시글 카운트
	public int qna_selectCountTotal(String cate) {
		int total = 0;
		try {
			logger.info("qna_selectCountTotal start...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_COUNT_TOTAL_QNA);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			if(rs.next()) {
				
			}
		}catch(Exception e) {
			
		}
		return total;
	}
	
	
	
	////// 댓글 //////
	
	public CsQnaVO qna_insertComment(CsQnaVO comment) {
		CsQnaVO article = null;
		try{
			logger.info("insertComment start...");
			conn = getConnection();
			conn.setAutoCommit(false); // 트렌젝션 시작
			
			psmt = conn.prepareStatement(CsSQL.INSERT_CS_COMMENT_QNA);
			PreparedStatement psmt2 = conn.prepareStatement(CsSQL.UPDATE_CS_COMMENT_COUNT_PLS_QNA);
			Statement stmt = conn.createStatement();
			
			psmt.setString(1, comment.getParent());
			psmt.setString(2, comment.getContent());
			psmt.setString(3, comment.getUid());
			psmt.setString(4, comment.getRegip());
			
			psmt2.setString(1, comment.getParent());
			
			psmt.executeUpdate();
			psmt2.executeUpdate();
			rs = stmt.executeQuery(CsSQL.SELECT_CS_COMMENT_LATEST_QNA);
			
			conn.commit();			// 트렌젝션 끝 All or Nothing
			
			if(rs.next()) {
				article = new CsQnaVO();
				article.setNo(rs.getString(1));
				article.setParent(rs.getString(2));
				article.setContent(rs.getString(6));
				article.setRdate(rs.getString(9).substring(2,10));
				article.setUid(rs.getString(10));
			}
			//uid ***로 바꾸는 작업 하기
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return article;
	}
	
	public List<CsQnaVO> qna_selectComments(String parent) {
		logger.info("selectComments start...");
		List<CsQnaVO> comments = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_CS_COMMENTS_QNA);
			psmt.setString(1, parent);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsQnaVO comment = new CsQnaVO();
				comment.setNo(rs.getString(1));
				comment.setParent(rs.getString(2));
				comment.setComment(rs.getString(3));
				comment.setCate(rs.getString(4));
				comment.setTitle(rs.getString(5));
				comment.setContent(rs.getString(6));
				comment.setUid(rs.getString(7));
				comment.setRegip(rs.getString(8));
				comment.setRdate(rs.getString(9).substring(2,10));
			
				comments.add(comment);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return comments;
	}
	
	
}

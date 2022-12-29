package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsVO;
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
	
	//글목록
	public List<CsVO> selectArticles(int start) {
		List<CsVO> articles = new ArrayList<>();
		try {
			logger.info("공지사항 글목록");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLES_NOTICE);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setComment(rs.getString(4));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setContent(rs.getString(8));
				vo.setRdate(rs.getString(11).substring(2,10));
				articles.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	//전체 글 개수
	public int selectCountTotal() {
		int result = 0;
		try {
			logger.info("전체 글 개수");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.COUNT_TOTAL_LIST_NOTICE_ALL);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public int selectCountTotal(String group) {
		int result = 0;
		try {
			logger.info("전체 글 개수");
			psmt = conn.prepareStatement(CsSQL.COUNT_TOTAL_LIST_NOTICE);
			psmt.setString(1, group);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//글목록 카테고리
	public List<CsVO> selectArticles(String group, int start) {
		List<CsVO> articles = new ArrayList<>();
		try {
			logger.info("공지사항 글목록 카테고리");
			conn = getConnection();
			String sql = "SELECT * FROM `km_cs_notice` WHERE `group`=?  ORDER BY `no` DESC LIMIT ?,10";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, group);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setComment(rs.getString(4));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setContent(rs.getString(8));
				vo.setRdate(rs.getString(11).substring(2,10));
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
		CsVO vo = new CsVO();
		try {
			logger.info("공지사항 글보기");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLE_NOTICE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setNo(rs.getString(1));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setContent(rs.getString(8));
				vo.setRdate(rs.getString(11).substring(0,10));
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//조회수
	public void updateArticleHit(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.UPDATE_HIT_UP_NOTICE);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}

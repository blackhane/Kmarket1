package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsNoticeVO;
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
	public List<CsVO> selectArticles() {
		List<CsVO> articles = new ArrayList<>();
		try {
			logger.info("공지사항 글목록");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLES);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
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
	
	//글목록 카테고리
	public List<CsVO> selectArticles(String group) {
		List<CsVO> articles = new ArrayList<>();
		try {
			logger.info("공지사항 글목록 카테고리");
			conn = getConnection();
			String sql = "SELECT * FROM `km_cs_notice` WHERE `group`=?  ORDER BY `no` DESC";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, group);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
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
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
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
}

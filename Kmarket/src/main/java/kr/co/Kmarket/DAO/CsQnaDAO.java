package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsVO;
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
	
	//글목록
	public List<CsVO> selectArticles(String group, int start) {
		List<CsVO> articles = new ArrayList<>();
		try {
			logger.info("문의하기 글목록");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLES_QNA);
			psmt.setString(1, group);
			psmt.setInt(2, start);
			rs= psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setComment(rs.getString(4));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setUid(rs.getString(9).replaceAll("(?<=.{2}).", "*"));
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
	public int selectCountTotal(String group) {
		int result = 0;
		try {
			logger.info("전체 글 개수");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.COUNT_TOTAL_LIST_QNA);
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
	
	//글보기
	public CsVO selectArticle(String no) {
		logger.info("문의하기 글보기");
		CsVO vo = new CsVO();
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.SELECT_ARTICLE_QNA);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()){
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setContent(rs.getString(8));
				vo.setUid(rs.getString(9).replaceAll("(?<=.{2}).", "*"));
				vo.setRdate(rs.getString(11).substring(2,10));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	//글쓰기
	public void insertArticle(CsVO vo) {
		logger.info("문의하기 글쓰기");
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(CsSQL.INSERT_ARITLCE_QNA);
			psmt.setString(1, vo.getCate());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getUid());
			psmt.setString(5, vo.getRegip());
			psmt.setString(6, vo.getGroup());
			psmt.executeUpdate();
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
}

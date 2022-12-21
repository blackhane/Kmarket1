package kr.co.Kmarket.DAO.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsNoticeVO;
import kr.co.Kmarket.VO.CsQnaVO;
import kr.co.Kmarket.VO.CsVO;
import kr.co.Kmarket.utils.AdminSql;
import kr.co.Kmarket.utils.CsSQL;
import kr.co.Kmarket.utils.DBCP;

public class AdminQnaDAO extends DBCP {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static AdminQnaDAO instance = new AdminQnaDAO();
	public static AdminQnaDAO getInstance() {
		return instance;
	};
	
	private AdminQnaDAO() {}
	
	//글목록
	public List<CsVO> selectQna(String group, String cate) {
		List<CsVO> qna = new ArrayList<>();
		try {
			logger.info("문의하기 글목록");
			conn = getConnection();
			psmt = conn.prepareStatement(AdminSql.SELECT_QNA);
			psmt.setString(1, group);
			psmt.setString(2, cate);
			rs= psmt.executeQuery();
			while(rs.next()) {
				CsVO vo = new CsVO();
				vo.setNo(rs.getString(1));
				vo.setGroup(rs.getString(2));
				vo.setCate(rs.getString(5));
				vo.setTitle(rs.getString(6));
				vo.setUid(rs.getString(9).replaceAll("(?<=.{2}).", "*"));
				vo.setRdate(rs.getString(11).substring(2,10));
				qna.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("문의하기 입력" + qna.size());
		return qna;
	}
		
		//문의보기	
		public CsQnaVO QnaView(String no) {
			CsQnaVO vo = null;
			try{			
				logger.info("문의보기 start...");
				conn = getConnection();
				psmt = conn.prepareStatement(AdminSql.SELECT_QNA_VIEW);
				psmt.setString(1, no);
				rs = psmt.executeQuery();
				if(rs.next()) {
					vo = new CsQnaVO();
					vo.setNo(rs.getString(1));
					vo.setGroup(rs.getString(2));
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
	
		
		//댓글쓰기
		public int insertComment(String parent, String content, String uid, String regip) {
			int result = 0;
			try {
				logger.info("insertComment start");
				conn = getConnection();
				psmt = conn.prepareStatement(AdminSql.INSERT_COMMENT);
				psmt.setString(1, parent);
				psmt.setString(2, content);
				psmt.setString(3, uid);
				psmt.setString(4, regip);
				result = psmt.executeUpdate();
				close();
			}catch(Exception e) {
				logger.error(e.getMessage());
			}
			logger.debug("result : " + result);
			return result;
		}
	
		//댓글수
		public void updateCommentHit(String no) {
			try {
				logger.info("updateCommentHit start");
				conn = getConnection();
				psmt = conn.prepareStatement(AdminSql.UPDATE_COMMENT_HIT_UP);
				psmt.setString(1, no);
				psmt.executeUpdate();
				close();
			}catch(Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		//문의하기 댓글목록
		public List<ArticleVO> selectComment(String no) {
			List<ArticleVO> articles = new ArrayList<>();
			try {
				logger.info("selectComment start");
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.SELECT_COMMENTS);
				psmt.setString(1, no);
				rs = psmt.executeQuery();
				while(rs.next()) {
					ArticleVO vo = new ArticleVO();
					vo.setNo(rs.getInt(1));
					vo.setParent(rs.getInt(2));
					vo.setComment(rs.getInt(3));
					vo.setCate(rs.getString(4));
					vo.setTitle(rs.getString(5));
					vo.setContent(rs.getString(6));
					vo.setFile(rs.getInt(7));
					vo.setHit(rs.getInt(8));
					vo.setUid(rs.getString(9));
					vo.setRegip(rs.getString(10));
					vo.setRdate(rs.getString(11).substring(2,10));
					vo.setNick(rs.getString(12));
					articles.add(vo);
				}
				close();
			}catch(Exception e) {
				logger.error(e.getMessage());
			}
			return articles;
		}
	
}


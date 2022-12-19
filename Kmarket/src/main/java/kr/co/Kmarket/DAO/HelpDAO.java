package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsVO;
import kr.co.Kmarket.utils.DBCP;

public class HelpDAO extends DBCP{

		//싱글톤
		private static HelpDAO instance = new HelpDAO();
		public static HelpDAO getInstance() {
			return instance;
		}
		private HelpDAO() {}
		
		//로그
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		//메인페이지 글
		public List<CsVO> selectListNotice(){
			List<CsVO> articles = new ArrayList<>();
			try {
				logger.info("최신 글 보기 NOTICE");
				conn = getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT * FROM `km_cs_notice`  WHERE `parent`=0 ORDER BY `no` DESC LIMIT 5";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					CsVO vo = new CsVO();
					vo.setNo(rs.getString(1));
					vo.setGroup(rs.getString(2));
					vo.setCate(rs.getString(5));
					vo.setTitle(rs.getString(6));
					vo.setContent(rs.getString(8));
					vo.setUid(rs.getString(9));
					vo.setRdate(rs.getString(11).substring(2,10));
					articles.add(vo);
				}
				close();
			}catch(Exception e) {
				logger.error(e.getMessage());
			}
			return articles;
		}
		public List<CsVO> selectListQna(){
			List<CsVO> articles = new ArrayList<>();
			try {
				logger.info("최신 글 보기 QNA");
				conn = getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT * FROM `km_cs_qna`  WHERE `parent`=0 ORDER BY `no` DESC LIMIT 5";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					CsVO vo = new CsVO();
					vo.setNo(rs.getString(1));
					vo.setCate(rs.getString(5));
					vo.setTitle(rs.getString(6));
					vo.setContent(rs.getString(8));
					vo.setUid(rs.getString(9).replaceAll("(?<=.{2}).", "*"));
					vo.setRdate(rs.getString(11).substring(2,10));
					articles.add(vo);
				}
				close();
			}catch(Exception e) {
				logger.error(e.getMessage());
			}
			return articles;
		}
}

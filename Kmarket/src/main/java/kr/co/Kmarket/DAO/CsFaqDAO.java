package kr.co.Kmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.VO.CsNoticeVO;
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
	public void faq_selectArticle() {}
	public void faq_selectArticles() {}
	public void faq_insertArticle() {}
	public void faq_updateArticle() {}
	public void faq_deleteArticle() {}	
	public void faq_insertComment() {}	
	public void faq_selectComment() {}	
	public void faq_deleteComment() {}
	

	
}

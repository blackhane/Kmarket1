package kr.co.Kmarket.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.utils.DBCP;

public class CSArticleDAO extends DBCP{
	
	//싱글톤
	private static CSArticleDAO instance = new CSArticleDAO();
	public static CSArticleDAO getInstance() {
		return instance;
	}
	private CSArticleDAO() {}
	
	//로그
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	//기본 CRUD
	public void selectArticle() {}
	public void selectArticles(){}
	public void insertArticle() {}
	public void updateArticle() {}	
	public void deleteArticle() {}	
	public void insertComment() {}	
	public void selectComment() {}	
	public void deleteComment() {}
	
	
}

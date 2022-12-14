package kr.co.Kmarket.service;

import java.util.List;

import kr.co.Kmarket.DAO.CsFaqDAO;
import kr.co.Kmarket.DAO.CsNoticeDAO;
import kr.co.Kmarket.DAO.CsQnaDAO;
import kr.co.Kmarket.VO.CsFaqVO;
import kr.co.Kmarket.VO.CsNoticeVO;
import kr.co.Kmarket.VO.CsQnaVO;

public enum CsService {
INSTANCE;
	
	// FAQ
	private CsFaqDAO Faqdao = CsFaqDAO.getInstance();
	public int faq_insertArticle(CsFaqVO article) {
		return Faqdao.faq_insertArticle(article);		
	}
	public CsFaqVO faq_selectArticle(String no) {
		return Faqdao.faq_selectArticle(no);
	}
	public List<CsFaqVO> faq_selectArticles(String group,String cate) {
		return Faqdao.faq_selectArticles(group, cate);
	}
	//public void updateArticle() {}
	//public void deleteArticle() {}
	
	
	
	
	// NOTICE
		private CsNoticeDAO Noticedao = CsNoticeDAO.getInstance();
		public int notice_insertArticle(CsNoticeVO article) {
			return Noticedao.notice_insertArticle(article);		
		}
		public int notice_selectCountTotal(String cate) {
			return Noticedao.notice_selectCountTotal(cate);
		}
		public CsNoticeVO selectArticle(String no) {
			return Noticedao.notice_selectArticle(no);
		}
		public List<CsNoticeVO> selectArticles(int start, String cate) {
			return Noticedao.notice_selectArticles(start, cate);
		}
		public void updateArticle() {}
		public void deleteArticle() {}
		
		
	
	
	// QNA
		private CsQnaDAO Qnadao = CsQnaDAO.getInstance();
		public int qna_insertArticle(CsQnaVO article) {
			return Qnadao.qna_insertArticle(article);		
		}
		public int qna_selectCountTotal(String cate) {
			return Qnadao.qna_selectCountTotal(cate);
		}
		public CsQnaVO qna_selectArticle(String no) {
			return Qnadao.qna_selectArticle(no);
		}
		public List<CsQnaVO> qna_selectArticles(String cate, int start) {
			return Qnadao.qna_selectArticles(cate, start);
		}
		
		public int getLastPageNum(int total) {
			
			int lastPageNum = 0;
			
			if(total % 10 == 0){
				lastPageNum = total / 10;
			}else{
				lastPageNum = total / 10 + 1;
			}
			return lastPageNum;
		}
		
		public int[] getPageGroupNum(int currentPage, int lastPageNum) {
			int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
			int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
			int pageGroupEnd = currentPageGroup * 10;
			
			if(pageGroupEnd > lastPageNum){
				pageGroupEnd = lastPageNum;
			}
			int[] result = {pageGroupStart, pageGroupEnd};
			return result;
		}
		
		public int getPageStartNum(int total, int currentPage) {
			int start = (currentPage - 1) * 10;
			return total - start;
		}
		
		public int getCurrentPage(String pg) {
			int currentPage = 1;
			
			if(pg != null){
				currentPage = Integer.parseInt(pg);	
			}
			return currentPage;
		}
		
		public int getStartNum(int currentPage) {
			return (currentPage - 1) * 10;
		}
		
	}


package kr.co.Kmarket.service.cs;

import kr.co.Kmarket.DAO.CsQnaDAO;
import kr.co.Kmarket.VO.CsQnaVO;

public enum CsQnaService {
	
	INSTANCE;
	private CsQnaDAO dao = CsQnaDAO.getInstance();
	
	public int qna_insertArticle(CsQnaVO article) {
		return dao.qna_insertArticle(article);
	}
	
	public int select

}

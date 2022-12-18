package kr.co.Kmarket.VO;

import java.util.List;

public class ReplyPage {

	List<ReviewVO> reply;
	
	private int pg;

	public List<ReviewVO> getReply() {
		return reply;
	}

	public void setReply(List<ReviewVO> reply) {
		this.reply = reply;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}
	
}

package kr.co.Kmarket.DAO.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.Kmarket.controller.utils.DBCP;

public class AdminDAO extends DBCP {

public void insertComment() {
		
		
		try{
			Connection conn = getConnection();
			
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
			Statement stmt = conn.createStatement();
			
			psmt.setInt(1, comment.getParent());
			psmt.setString(2, comment.getContent());
			psmt.setString(3, comment.getUid());
			psmt.setString(4, comment.getRegip());
			
			psmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_COMMENT_LATEST);
			
			// 작업확정
			conn.commit();
			
			if(rs.next()) {
				article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setContent(rs.getString(6));
				article.setRdate(rs.getString(11).substring(2, 10));
				article.setNick(rs.getString(12));
			}
			
			rs.close();
			stmt.close();			
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}

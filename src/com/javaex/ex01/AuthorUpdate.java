package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AuthorUpdate {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/choijungphil/jungphil/Wallet_webdb";
		String userid = "admin";
		String pwd = "^^65Rhcemdtla";
		
		PreparedStatement pstmt = null;

		// 드라이버 로딩
		try {
			// oracle DB연결 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");//
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// DBMS와 연결
		try {
			System.out.println("데이터베이스 연결 준비......");
			Connection conn = DriverManager.getConnection(url, userid, pwd);
			//SQL문 준비
			String query = "";
			query += "update author";
			query += "set	author_name = ?, ";
			query += "		author_desc = ?";
			query += "where author_id = ?";
			
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "최문열");
			pstmt.setString(2, "서울특별시");
			pstmt.setInt(3, 1);
			
			//실행
			int count = pstmt.executeUpdate();
			
			//결과처리
			System.out.println(count+"건 수정 되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			///// 1. JDBC 드라이버 (Oracle) 로딩 /////
			Class.forName("oracle.jdbc.driver.OracleDriver");

			///// 2. Connection 얻어오기 /////
			String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/choijungphil/jungphil/Wallet_webdb";
			conn = DriverManager.getConnection(url, "admin", "^^65Rhcemdtla");

			///// 3. SQL문 준비 / 바인딩 / 실행 /////
			// SQL문 준비
			String query = "";
			query += " select book_id,";
			query += "		  title,";
			query += "		  pubs";
			query += "		  pub_date";
			query += "		  from book";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			///// 4.결과처리 /////
			while (rs.next()) {
				// int bookId = rs.getInt("book_id");
				// String bookName = rs.getString("book_name");
				// String bookDesc = rs.getString("book_desc");

				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String bookDesc = rs.getString(3);

				System.out.println(bookId + ", " + bookName + ", " + bookDesc);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}


	}

}

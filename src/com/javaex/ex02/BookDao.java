package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {

	// 필드
	private int count;

	// 생성자
	// 메소드 - gs
	// 메소드 - 일반
	public int bookInsert(String title, String pubs, String pubDate, int authorId) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null;

		try {
			///// 1. JDBC 드라이버 (Oracle) 로딩 /////
			Class.forName("oracle.jdbc.driver.OracleDriver");

			///// 2. Connection 얻어오기 /////
			String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/choijungphil/jungphil/Wallet_webdb";
			conn = DriverManager.getConnection(url, "admin", "^^65Rhcemdtla");

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " insert into book ";
			query += " values(seq_book_id.nextval, ?, ?, ?, ?) ";

			// 바인딩
			pstmt = conn.prepareStatement(query);  // 문자열 쿼리로 만들기
			pstmt.setString(1, title);          // ?(물음표) 중 1번째 -->순서중요
			pstmt.setString(2, pubs);       // ?(물음표) 중 2번째 -->순서중요
			pstmt.setString(3, pubDate);       // ?(물음표) 중 3번째 -->순서중요
			pstmt.setInt(4, authorId);       // ?(물음표) 중 4번째 -->순서중요

			// 실행
			count = pstmt.executeUpdate();                 // 쿼리문실행 -->성공갯수 리턴

			// 4.결과처리
			System.out.println(count + "건이 등록 되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				/*
				if (rs != null) {
				    rs.close();
				} 
				*/
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
		return count;
	}

	public void bookDelete() {

	}

	public void bookUpdate() {

	}

	public void bookSelect() {

	}

}

package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**********************************
 * Dao(Data Access Object)
 * DataBase(오라클) 관련된 일을 하는 클래스
 * 
 **********************************/
public class AuthorDao {
	// 필드
	private int count;

	// 생성자

	// 메소드 - gs

	// 메소드 - 일반
	// 작가 등록 메소드
	public int authorInsert(String authorName, String authordesc) {

		int count = -1;

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
			query += " insert into author ";
			query += " values(seq_author_id.nextval, ?, ?) ";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);  // 문자열 쿼리로 만들기
			pstmt.setString(1, authorName);          // ?(물음표) 중 1번째 -->순서중요
			pstmt.setString(2, authordesc);       // ?(물음표) 중 2번째 -->순서중요

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

	public int authorDelete(int authorId) {
		int count = -1;

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

			///// 3. SQL문 준비 / 바인딩 / 실행 /////
			// SQL문 준비
			String query = "";
			query += " delete from author ";
			query += " where author_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, authorId);

			// 실행
			count = pstmt.executeUpdate();

			///// 4.결과처리 /////
			System.out.println(count + "건이 삭제 되었습니다");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			///// 5. 자원정리 /////
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

	// 작가 수정 메소드
	public int authorUpdate(int authorId, String authorName, String authordesc) {
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

			///// 3. SQL문 준비 / 바인딩 / 실행 /////
			// SQL문 준비
			String query = "";
			query += " update author ";
			query += " set author_name = ?, ";
			query += "     author_desc = ? ";
			query += " where author_id = ? ";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			pstmt.setString(2, authordesc);
			pstmt.setInt(3, authorId);

			// 실행
			count = pstmt.executeUpdate();

			///// 4.결과처리 /////
			System.out.println(count + "건 수정 되었습니다");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			///// 5. 자원정리 /////
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

	// 작가 전체리스트 가져오기 메소트
	public List<AuthorVo> authorSelect() {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리스트로 만들기
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();

		try {
			///// 1. JDBC 드라이버 (Oracle) 로딩 /////
			Class.forName("oracle.jdbc.driver.OracleDriver");

			///// 2. Connection 얻어오기 /////
			String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/choijungphil/jungphil/Wallet_webdb";
			conn = DriverManager.getConnection(url, "admin", "^^65Rhcemdtla");

			///// 3. SQL문 준비 / 바인딩 / 실행 /////
			// SQL문 준비
			String query = "";
			query += " select author_id,";
			query += "		  author_name,";
			query += "		  author_desc";
			query += "		  from author";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			// ResultSet 가져오기
			rs = pstmt.executeQuery();

			///// 4.결과처리 ////

			// 반복문으로 VO 만들어 List에 추가하기
			while (rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");

				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);

				authorList.add(authorVo);

				// 리스트를 출력해보기
				//System.out.println(authorList.toString());

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
		return authorList;

	}
}

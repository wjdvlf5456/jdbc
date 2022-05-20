package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;

/* 오라클 접속 테스트 */
public class AuthorInsert {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/choijungphil/jungphil/Wallet_webdb";
		String userid = "admin";
		String pwd = "^^65Rhcemdtla";

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
			Connection con = DriverManager.getConnection(url, userid, pwd);
			if (con != null) {
				System.out.println("데이터베이스 연결 성공...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
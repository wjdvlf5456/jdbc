package com.javaex.ex02;

public class BookApp {

	public static void main(String[] args) {

		BookDao bookAdo = new BookDao();

		bookAdo.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookAdo.bookInsert("삼국지", "민음사", "2002-03-01", 1);

	}

}

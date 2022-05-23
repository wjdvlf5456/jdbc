package com.javaex.ex02;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		BookDao bookAdo = new BookDao();

		
		/*bookAdo.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		bookAdo.bookInsert("삼국지", "민음사", "2002-03-01", 1);
		bookAdo.bookInsert("토지", "마로니에북스", "2012-08-15", 2);
		bookAdo.bookInsert("유시민의 글쓰기 특강", "생각의 길", "2015-04-01", 3);
		bookAdo.bookInsert("패션왕", "중앙북스(books)", "2012-02-22", 4);
		bookAdo.bookInsert("순정만화", "재미주의", "2011-08-03", 5);
		bookAdo.bookInsert("오직두사람", "문학동네", "2017-05-04", 6);
		bookAdo.bookInsert("26년", "재미주의", "2012-02-04", 5);
		
		
		bookAdo.bookDelete(2);
		bookAdo.bookDelete(3);
		bookAdo.bookDelete(4);*/
		
		List<BookVo> bookList = bookAdo.bookSelect();
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(
					bookList.get(i).getBookId() + ", " + bookList.get(i).getTitle() + ", " + bookList.get(i).getPubs()
							+ ", " + bookList.get(i).getPubDate() + ", " + bookList.get(i).getAuthorId());
		}
		;

		/////////////////////////////////////////////////////////

	}

}

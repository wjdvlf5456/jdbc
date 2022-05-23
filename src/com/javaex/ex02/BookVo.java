package com.javaex.ex02;

public class BookVo {

	// 필드
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private int authorId;

	// 생성자
	public BookVo() {

	}

	public BookVo(int bookId, String title, String pubs, String pubDate, int authorId) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
	}

	// 메소드 - gs
	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getPubs() {
		return pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	// 메소드 - 일반
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate
				+ ", authorId=" + authorId + "]";
	}

}

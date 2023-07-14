package bitedu.bipa.test.vo;

import java.sql.Timestamp;

public class BookVo {
	private int bookSeq;
	private String isbn;
	private String title;
	private String author;
	private Timestamp publishDate;
	private String bookPosition;
	private String bookStatus;
	
	public BookVo(int bookSeq, String isbn, String title, String author, Timestamp publishDate,
			String bookPosition, String bookStatus) {
		super();
		this.bookSeq = bookSeq;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.bookPosition = bookPosition;
		this.bookStatus = bookStatus;
	}

	public int getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(int bookSeq) {
		this.bookSeq = bookSeq;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public String getBookPosition() {
		return bookPosition;
	}

	public void setBookPosition(String bookPosition) {
		this.bookPosition = bookPosition;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return "BookVo [bookSeq=" + bookSeq + ", isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", publishDate=" + publishDate + ", bookPosition=" + bookPosition + ", bookStatus=" + bookStatus
				+ "]";
	}
	
	
}

package bitedu.bipa.PEB.vo;

import com.google.protobuf.Timestamp;

public class BookVO {
	private String isbn;
	private String title;
	private String author;
	private Timestamp publishDate;
	
	public BookVO() {}

	public BookVO(String isbn, String title, String author, Timestamp publishDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
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

	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publishDate=" + publishDate
				+ "]";
	}

	

}

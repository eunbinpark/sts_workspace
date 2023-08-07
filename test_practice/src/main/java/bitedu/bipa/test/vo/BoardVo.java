package bitedu.bipa.test.vo;

import java.sql.Timestamp;

public class BoardVo {

	public BoardVo() {}
	
	private int seq;
	private String title;
	private String content;
	private String writer;
	private int readCount;
	private Timestamp createDate;
	private String password;
	private String attatchData;
	
	public BoardVo(int seq, String title, String content, String writer, int readCount, Timestamp createDate,
			String password, String attatchData) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.readCount = readCount;
		this.createDate = createDate;
		this.password = password;
		this.attatchData = attatchData;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAttatchData() {
		return attatchData;
	}
	public void setAttatchData(String attatchData) {
		this.attatchData = attatchData;
	}

	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", readCount=" + readCount + ", createDate=" + createDate + ", password=" + password
				+ ", attatchData=" + attatchData + "]";
	}
	
	
}

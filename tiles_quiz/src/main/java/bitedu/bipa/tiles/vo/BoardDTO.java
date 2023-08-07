package bitedu.bipa.tiles.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDTO {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private int readCount;
	private Timestamp createDate;
	private ArrayList<String> attatchData;
	
	public BoardDTO() {}

	public BoardDTO(int seq, String title, String content, String writer, int readCount, Timestamp createDate,
			String attatchImg, ArrayList<String> attatchData) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.readCount = readCount;
		this.createDate = createDate;
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

	public ArrayList<String> getAttatchData() {
		return attatchData;
	}

	public void setAttatchData(ArrayList<String> attatchData) {
		this.attatchData = attatchData;
	}

	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", readCount=" + readCount + ", createDate=" + createDate + ", attatchData=" + attatchData + "]";
	}

	
	
}

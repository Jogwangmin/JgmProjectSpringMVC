package kr.co.jgm.board.domain;

import java.sql.Timestamp;

public class Board {
	private int boardNo;
	private String boardSubject;
	private String boardContent;
	private String boardWriter;
	private Timestamp boardDate;
	private int viewCount;
	private int likeCount;
	private String boardFileName;
	private String BoardFilePath;
	private long boardFileLength;
	
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getBoardSubject() {
		return boardSubject;
	}
	
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	public String getBoardWriter() {
		return boardWriter;
	}
	
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	public Timestamp getBoardDate() {
		return boardDate;
	}
	
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
	
	public int getViewCount() {
		return viewCount;
	}
	
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	public int getLikeCount() {
		return likeCount;
	}
	
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
	public String getBoardFileName() {
		return boardFileName;
	}

	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}

	public String getBoardFilePath() {
		return BoardFilePath;
	}

	public void setBoardFilePath(String boardFilePath) {
		BoardFilePath = boardFilePath;
	}

	public long getBoardFileLength() {
		return boardFileLength;
	}

	public void setBoardFileLength(long boardFileLength) {
		this.boardFileLength = boardFileLength;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardSubject=" + boardSubject + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", boardDate=" + boardDate + ", viewCount=" + viewCount
				+ ", likeCount=" + likeCount + ", boardFileName=" + boardFileName + ", BoardFilePath=" + BoardFilePath
				+ ", boardFileLength=" + boardFileLength + "]";
	}

	
	
}

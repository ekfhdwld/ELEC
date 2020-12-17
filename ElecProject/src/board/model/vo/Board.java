package board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int boardNo;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int boardGrade;
	private String prodSerialCode;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, String boardWriter, String boardContent, Date boardDate, int boardGrade,
			String prodSerialCode) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardGrade = boardGrade;
		this.prodSerialCode = prodSerialCode;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardGrade() {
		return boardGrade;
	}
	public void setBoardGrade(int boardGrade) {
		this.boardGrade = boardGrade;
	}
	public String getProdSerialCode() {
		return prodSerialCode;
	}
	public void setProdSerialCode(String prodSerialCode) {
		this.prodSerialCode = prodSerialCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardWriter=" + boardWriter + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardGrade=" + boardGrade + ", prodSerialCode=" + prodSerialCode
				+ "]";
	}
	
}

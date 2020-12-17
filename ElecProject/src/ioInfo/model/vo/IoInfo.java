package ioInfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class IoInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ioNo;
	private String prodSerialCode;
	private int amount;
	private Date ioDate;
	private String status;
	public IoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IoInfo(int ioNo, String prodSerialCode, int amount, Date ioDate, String status) {
		super();
		this.ioNo = ioNo;
		this.prodSerialCode = prodSerialCode;
		this.amount = amount;
		this.ioDate = ioDate;
		this.status = status;
	}
	public int getIoNo() {
		return ioNo;
	}
	public void setIoNo(int ioNo) {
		this.ioNo = ioNo;
	}
	public String getProdSerialCode() {
		return prodSerialCode;
	}
	public void setProdSerialCode(String prodSerialCode) {
		this.prodSerialCode = prodSerialCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getIoDate() {
		return ioDate;
	}
	public void setIoDate(Date ioDate) {
		this.ioDate = ioDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "IoiInfo [ioNo=" + ioNo + ", prodSerialCode=" + prodSerialCode + ", amount=" + amount + ", ioDate="
				+ ioDate + ", status=" + status + "]";
	}
	
	

}

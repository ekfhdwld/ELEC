package payInfo.model.vo;

import java.io.Serializable;

public class PayInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int orderNo;
	private String memberId;
	private String payment;
	private String address;
	private String recipient;
	private String recipientPhone;
	public PayInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PayInfo(int orderNo, String memberId, String payment, String address, String recipient,
			String recipientPhone) {
		super();
		this.orderNo = orderNo;
		this.memberId = memberId;
		this.payment = payment;
		this.address = address;
		this.recipient = recipient;
		this.recipientPhone = recipientPhone;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PayInfo [orderNo=" + orderNo + ", memberId=" + memberId + ", payment=" + payment + ", address="
				+ address + ", recipient=" + recipient + ", recipientPhone=" + recipientPhone + "]";
	}
	
	
}

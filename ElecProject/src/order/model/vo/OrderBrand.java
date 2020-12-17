package order.model.vo;

import java.sql.Date;

public class OrderBrand {

	private int orderNo;
	private Date orderDate;
	private String memberId;
	private String recipient;
	private String recipientPhone;
	private String address;
	public OrderBrand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderBrand(int orderNo, Date orderDate, String memberId, String recipient, String recipientPhone,
			String address) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.memberId = memberId;
		this.recipient = recipient;
		this.recipientPhone = recipientPhone;
		this.address = address;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderBrand [orderNo=" + orderNo + ", orderDate=" + orderDate + ", memberId=" + memberId + ", recipient="
				+ recipient + ", recipientPhone=" + recipientPhone + ", address=" + address + "]";
	}

	
	
}

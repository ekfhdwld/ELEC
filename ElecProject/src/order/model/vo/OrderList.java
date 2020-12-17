package order.model.vo;

import java.sql.Date;

public class OrderList {

	private int orderNo;
	private int orderTotal;
	private String memberId;
	private Date orderDate;
	private String address;
	private String recipient;
	private String recipientPhone;
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderList(int orderNo, int orderTotal, String memberId, Date orderDate, String address, String recipient,
			String recipientPhone) {
		super();
		this.orderNo = orderNo;
		this.orderTotal = orderTotal;
		this.memberId = memberId;
		this.orderDate = orderDate;
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
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	@Override
	public String toString() {
		return "OrderList [orderNo=" + orderNo + ", orderTotal=" + orderTotal + ", memberId=" + memberId
				+ ", orderDate=" + orderDate + ", address=" + address + ", recipient=" + recipient + ", recipientPhone="
				+ recipientPhone + "]";
	}
	
	
	
	
}

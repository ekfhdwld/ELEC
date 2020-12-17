package order.model.vo;

import java.sql.Date;

public class OrderListSeller {

	private int order_no;
	private String serialCode;
	private int amount;
	private String brand;
	private String memberId;
	private String recipient;
	private String recipientPhone;
	private String productImg;
	public OrderListSeller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderListSeller(int order_no, String serialCode, int amount, String brand, String memberId, String recipient,
			String recipientPhone, String productImg) {
		super();
		this.order_no = order_no;
		this.serialCode = serialCode;
		this.amount = amount;
		this.brand = brand;
		this.memberId = memberId;
		this.recipient = recipient;
		this.recipientPhone = recipientPhone;
		this.productImg = productImg;
	}

	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getSerialCode() {
		return serialCode;
	}
	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "OrderListSeller [order_no=" + order_no + ", serialCode=" + serialCode + ", amount=" + amount
				+ ", brand=" + brand + ", memberId=" + memberId + ", recipient=" + recipient + ", recipientPhone="
				+ recipientPhone + ", productImg=" + productImg + "]";
	}
	
	
	
	
}

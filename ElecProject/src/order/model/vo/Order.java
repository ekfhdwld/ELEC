package order.model.vo;

import java.io.Serializable;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderNo;
	private String orderSerialCode;
	private String orderQuantityList;
	private String orderTotal;
	private String memberId;
	private String orderDate;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderNo, String orderSerialCode, String orderQuantityList, String orderTotal, String memberId,
			String orderDate) {
		super();
		this.orderNo = orderNo;
		this.orderSerialCode = orderSerialCode;
		this.orderQuantityList = orderQuantityList;
		this.orderTotal = orderTotal;
		this.memberId = memberId;
		this.orderDate = orderDate;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderSerialCode() {
		return orderSerialCode;
	}
	public void setOrderSerialCode(String orderSerialCode) {
		this.orderSerialCode = orderSerialCode;
	}
	public String getOrderQuantityList() {
		return orderQuantityList;
	}
	public void setOrderQuantityList(String orderQuantityList) {
		this.orderQuantityList = orderQuantityList;
	}
	public String getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", orderSerialCode=" + orderSerialCode + ", orderQuantityList="
				+ orderQuantityList + ", orderTotal=" + orderTotal + ", memberId=" + memberId + ", orderDate="
				+ orderDate + "]";
	}
	
}

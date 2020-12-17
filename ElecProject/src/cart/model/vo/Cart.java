package cart.model.vo;

import java.io.Serializable;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int cartNo;
	private String memberId;
	private String prodSerialCode;
	private int amount;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartNo, String memberId, String prodSerialCode, int amount) {
		super();
		this.cartNo = cartNo;
		this.memberId = memberId;
		this.prodSerialCode = prodSerialCode;
		this.amount = amount;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", memberId=" + memberId + ", prodSerialCode=" + prodSerialCode + ", amount="
				+ amount + "]";
	}
	
	
	
	
}

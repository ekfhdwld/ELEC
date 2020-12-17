package product.model.vo;

import java.io.Serializable;

public class ProductL implements Serializable{
	
	private String prodSerialCode;
	private String productName;
	private String inch;
	private String colorName;
	private int amount;
	private int discountRate;
	private int price;
	private String capacity;
	private String productImg;
	
	public ProductL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductL(String prodSerialCode, String productName, String inch, String colorName, int amount,
			int discountRate, int price, String capacity, String productImg) {
		super();
		this.prodSerialCode = prodSerialCode;
		this.productName = productName;
		this.inch = inch;
		this.colorName = colorName;
		this.amount = amount;
		this.discountRate = discountRate;
		this.price = price;
		this.capacity = capacity;
		this.productImg = productImg;
	}

	public String getProdSerialCode() {
		return prodSerialCode;
	}

	public void setProdSerialCode(String prodSerialCode) {
		this.prodSerialCode = prodSerialCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getInch() {
		return inch;
	}

	public void setInch(String inch) {
		this.inch = inch;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "CartInfo [prodSerialCode=" + prodSerialCode + ", productName=" + productName + ", inch=" + inch
				+ ", colorName=" + colorName + ", amount=" + amount + ", discountRate=" + discountRate + ", price="
				+ price + ", capacity=" + capacity + ", productImg=" + productImg + "]";
	}

	
	
	
	
	

	
	
}

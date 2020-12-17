package product.model.vo;

import java.io.Serializable;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String prodSerialCode;
	private String prodCode;
	private String category;
	private String color;
	private String inch;
	private String capacity;
	private int stock;
	private int price;
	private int discountRate;
	private String prodDelete;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String prodSerialCode, String prodCode, String category, String color, String inch, String capacity,
			int stock, int price, int discountRate, String prodDelete) {
		super();
		this.prodSerialCode = prodSerialCode;
		this.prodCode = prodCode;
		this.category = category;
		this.color = color;
		this.inch = inch;
		this.capacity = capacity;
		this.stock = stock;
		this.price = price;
		this.discountRate = discountRate;
		this.prodDelete = prodDelete;
	}
	public String getProdSerialCode() {
		return prodSerialCode;
	}
	public void setProdSerialCode(String prodSerialCode) {
		this.prodSerialCode = prodSerialCode;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getInch() {
		return inch;
	}
	public void setInch(String inch) {
		this.inch = inch;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public String getProdDelete() {
		return prodDelete;
	}
	public void setProdDelete(String prodDelete) {
		this.prodDelete = prodDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Product [prodSerialCode=" + prodSerialCode + ", prodCode=" + prodCode + ", category=" + category
				+ ", color=" + color + ", inch=" + inch + ", capacity=" + capacity + ", stock=" + stock + ", price="
				+ price + ", discountRate=" + discountRate + ", prodDelete=" + prodDelete + "]";
	}
	
	
	

}

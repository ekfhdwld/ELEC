package productCategory.model.vo;

import java.io.Serializable;

public class ProductCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productCode;
	private String brand;
	private String productName;
	private String productDesc;
	private String productImg;
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCategory(String productCode, String brand, String productName, String productDesc,
			String productImg) {
		super();
		this.productCode = productCode;
		this.brand = brand;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productImg = productImg;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProductCategory [productCode=" + productCode + ", brand=" + brand + ", productName=" + productName
				+ ", productDesc=" + productDesc + ", productImg=" + productImg + "]";
	}
	
	
	
	

}

package product.model.vo;

public class ProductInfo {

	private String productCode;
	private String productName;
	private String inch;
	private String productDesc;
	private String productImg;
	private double productGrade;
	private int price;
	private int discountRate;
	
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfo(String productCode, String productName, String inch, String productDesc, String productImg,
			double productGrade, int price, int discountRate) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.inch = inch;
		this.productDesc = productDesc;
		this.productImg = productImg;
		this.productGrade = productGrade;
		this.price = price;
		this.discountRate = discountRate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public double getProductGrade() {
		return productGrade;
	}

	public void setProductGrade(double productGrade) {
		this.productGrade = productGrade;
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

	@Override
	public String toString() {
		return "ProductInfo [productCode=" + productCode + ", productName=" + productName + ", inch=" + inch
				+ ", productDesc=" + productDesc + ", productImg=" + productImg + ", productGrade=" + productGrade
				+ ", price=" + price + ", discountRate=" + discountRate + "]";
	}

	
	
}

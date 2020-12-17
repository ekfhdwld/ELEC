package order.model.vo;

public class OrderListInfo {
	private int orderNo;
	private String productCode;
	private String productName;
	private String inch;
	private String colorName;
	private String capacity;
	private int price;
	private int discountRate;
	private int amount;
	private String productImg;
	
	public OrderListInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderListInfo(int orderNo, String productCode, String productName, String inch, String colorName,
			String capacity, int price, int discountRate, int amount, String productImg) {
		super();
		this.orderNo = orderNo;
		this.productCode = productCode;
		this.productName = productName;
		this.inch = inch;
		this.colorName = colorName;
		this.capacity = capacity;
		this.price = price;
		this.discountRate = discountRate;
		this.amount = amount;
		this.productImg = productImg;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "OrderListInfo [orderNo=" + orderNo + ", productCode=" + productCode + ", productName=" + productName
				+ ", inch=" + inch + ", colorName=" + colorName + ", capacity=" + capacity + ", price=" + price
				+ ", discountRate=" + discountRate + ", amount=" + amount + ", productImg=" + productImg + "]";
	}
	
	
}


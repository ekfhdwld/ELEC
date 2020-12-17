package productState.model.vo;

import java.io.Serializable;

public class ProductState implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String brand;
	private int count;
	private int percent;
	public ProductState() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductState(String brand, int count, int percent) {
		super();
		this.brand = brand;
		this.count = count;
		this.percent = percent;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProductStatus [brand=" + brand + ", count=" + count + ", percent=" + percent + "]";
	}
	
	
	
	

}

package productState.model.vo;

import java.io.Serializable;

public class ProductRankState implements Serializable {
	private String productName;
	private int count;
	private int rank;
	public ProductRankState() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductRankState(String productName, int count, int rank) {
		super();
		this.productName = productName;
		this.count = count;
		this.rank = rank;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "ProductRankState [productName=" + productName + ", count=" + count + ", rank=" + rank + "]";
	}
	
	
	
}

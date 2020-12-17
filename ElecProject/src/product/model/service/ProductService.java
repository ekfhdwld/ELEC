package product.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import board.model.vo.Board;
import product.model.dao.ProductDAO;
import product.model.vo.Product;
import product.model.vo.ProductInfo;
import product.model.vo.ProductL;

public class ProductService {
	private ProductDAO productDAO = new ProductDAO();

	public List<String> selectCapaOption(String prodCode, String inch) {
		Connection conn = getConnection();
		List<String> list = productDAO.selectCapaOption(conn, prodCode, inch);
		System.out.println("list@service = " + list);
		close(conn);
		return list;
	}

	public ProductInfo getProductInfo(String prodCode, String inch) {
		Connection conn = getConnection();
		ProductInfo productInfo = productDAO.getProductInfo(conn, prodCode, inch);
		double grade = productDAO.getProductGrade(conn, prodCode);
		productInfo.setProductGrade(grade);
		System.out.println("productInfo@service = " + productInfo);
		close(conn);
		return productInfo;
	}

	public List<ProductInfo> getOtherProducts(String prodCode, String inch) {
		Connection conn = getConnection();
		List<ProductInfo> list = productDAO.getOtherProducts(conn, prodCode, inch);
		System.out.println("list@service = " + list);
		close(conn);
		return list;
	}



	public Map<String, String> selectColorOption(String prodCode, String inch) {
		Connection conn = getConnection();
		Map<String, String> colorMap = productDAO.selectColorOption(conn, prodCode, inch);
		System.out.println("map@service = " + colorMap);
		close(conn);
		return colorMap;
	}



	public List<Board> getReviewBoard(String prodCode) {
		Connection conn = getConnection();
		List<Board> list = productDAO.getReviewBoard(conn, prodCode);
		System.out.println("list@service = " + list);
		close(conn);
		return list;
	}
	
	
	public int insertProduct(List<Product> list) {
		Connection conn = getConnection();
		int result = productDAO.insertProduct(conn, list);
		if(result>0)	commit(conn);
		else	rollback(conn);
		close(conn);
		return result;
	}
	
	public List<Product> selectProduct(String memberId) {
		Connection conn = getConnection();
		List<Product> list = productDAO.selectProduct(conn, memberId);
		close(conn);
		
		return list;
	}

	public List<ProductL> selectProductL(String memberId) {
		
		Connection conn =getConnection();
		List<ProductL> list = productDAO.selectProductL(conn, memberId);
		close(conn);
		
		return list;
	}

	public int updateAmount(String code, int amount) {
	
		Connection conn = getConnection();
		int result = productDAO.updateAmount(conn, code, amount);
		close(conn);
		
		return result;
	}

	public int deleteProduct(String[] serialArr) {
		
		Connection conn = getConnection();
		int result = 0;
		
		for(int i = 0; i<serialArr.length ;i++) {	
			
			result = productDAO.deleteProduct(conn, serialArr[i]);
			
			if(result>0)
				commit(conn);
			else
				rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int selectProductCount(String memberId) {
		
		Connection conn = getConnection();
		int cnt = productDAO.selectProductCount(conn, memberId);
		close(conn);
		return cnt;
	}

	public List<ProductL> selectProductList(String brand, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<ProductL> list = productDAO.selectProductList(conn, brand, cPage, numPerPage);
		close(conn);
		return list;
	}

	public List<ProductL> selectAllProduct(String category) {
		Connection conn = getConnection();
		List<ProductL> list = productDAO.selectAllProduct(conn, category);
		close(conn);
		return list;
	}

	public List<ProductL> selectCategory(String brand) {
		Connection conn = getConnection();
		List<ProductL> list = productDAO.selectCategory(conn, brand);
		close(conn);
		return list;
	}
	
}

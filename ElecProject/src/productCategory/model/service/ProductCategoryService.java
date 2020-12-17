package productCategory.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;



import static common.JDBCTemplate.*;

import productCategory.model.dao.ProductCategoryDAO;
import productCategory.model.vo.ProductCategory;

public class ProductCategoryService {
	
	private ProductCategoryDAO ProductCategoryDAO = new ProductCategoryDAO();


	public int getTotalContents(Map<String, Object> param) {
		Connection conn = getConnection();
		int totalContents = ProductCategoryDAO.getTotalContents(conn, param);
		close(conn);
		System.out.println("@gettotalConets@Service" +totalContents);
		return totalContents;
	}


	public List<ProductCategory> searchProduct(Map<String, Object> param) {
		Connection conn = getConnection();
		List<ProductCategory> list = ProductCategoryDAO.searchProduct(conn, param); 
		close(conn);
		System.out.println("List@SERIVVICE"+list);
		return list;
	}


	public int insertProductCategory(ProductCategory pc) {
		Connection conn = getConnection();
		int result = ProductCategoryDAO.insertProductCategory(conn, pc);
		System.out.println("servi="+result);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);

		return result;
	}

	public String findCodeCount(String category) {
		Connection conn = getConnection();
		String productCode = ProductCategoryDAO.findCodeCount(conn, category);
		close(conn);
		
		return productCode;
	}

	public List<ProductCategory> selectProductCategory(String memberId) {
		Connection conn = getConnection();
		List<ProductCategory> list = ProductCategoryDAO.selectProductCategory(conn, memberId);
		close(conn);
		return list;
	}
	

}

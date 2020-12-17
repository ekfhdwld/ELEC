package productState.model.service;

import java.sql.Connection;
import java.util.List;

import productState.model.dao.ProductStateDAO;
import productState.model.vo.ProductRankState;
import productState.model.vo.ProductState;

import static common.JDBCTemplate.*;

public class ProductStateService {

	
	public List<ProductState> selectAll() {
		Connection conn = getConnection();
		
		//판매율가져오기
		List<ProductState> list = ProductStateDAO.selectAll(conn);
		
		close(conn);
//		System.out.println("list@service = " + list);
		return list;
	}

	public List<ProductRankState> selectRankListAll() {
		Connection conn = getConnection();
		
		//판매율가져오기
		List<ProductRankState> rankList = ProductStateDAO.selectRankListAll(conn);
		
		close(conn);
		System.out.println("list@service = " + rankList);
		return rankList;
	}

}

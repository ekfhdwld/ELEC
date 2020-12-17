package color.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import color.model.vo.Color;
import productCategory.model.dao.ProductCategoryDAO;
import static common.JDBCTemplate.*;

public class ColorDAO {
	
	
	private Properties prop = new Properties();

	public ColorDAO() {
			try {
				String fileName = ProductCategoryDAO.class.getResource("/sql/color/color.properties").getPath();
				prop.load(new FileReader(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public List<Color> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		List<Color> list = new ArrayList<Color>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Color color = new Color();
				color.setColorCode(rset.getString("color_code"));
				color.setColorName(rset.getString("color_name"));
				color.setColorRGB(rset.getString("color_rgb"));
				list.add(color);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

}

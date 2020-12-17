package color.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import color.model.dao.ColorDAO;
import color.model.vo.Color;

public class ColorService {

	ColorDAO colorDAO = new ColorDAO();
	public ColorService() {
		super();
	}

	public List<Color> selectAll() {
		Connection conn = getConnection();
		
		List<Color> list = colorDAO.selectAll(conn);
		close(conn);
		return list;
	}
	
	

}

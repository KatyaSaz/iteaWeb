package wb.service;

import wb.service.DAOFactory;
import wb.service.mySQL.MySqlDAOFactory;

public abstract class DAOFactory {
	
	public final static int MY_SQL = 1;
	
	public abstract UserDAO getUserDAO();
	public abstract ProductDAO getProductDAO();
	
	public static DAOFactory getInstance(int sourceType) {
		switch (sourceType) {
		case MY_SQL: 
			return new MySqlDAOFactory();
		default:
			return null;
		}
	}
}

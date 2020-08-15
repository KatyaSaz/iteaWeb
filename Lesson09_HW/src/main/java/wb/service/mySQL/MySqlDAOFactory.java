package wb.service.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import wb.service.DAOFactory;
import wb.service.ProductDAO;
import wb.service.UserDAO;

public class MySqlDAOFactory extends DAOFactory {

	public MySqlDAOFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
	
	@Override
	public UserDAO getUserDAO() {
		return new MySqlUserDAO(this);
	}
	@Override
	public ProductDAO getProductDAO() {
		return new MySqlProductDAO(this);
	}

}

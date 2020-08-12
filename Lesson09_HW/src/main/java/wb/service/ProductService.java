package wb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import wb.model.Product;

public class ProductService extends Connector{
	
	private final String SELECT_ALL_PRODUCTS = "SELECT * FROM `products`;";
	private final String SELECT_BY_CATEGORY = "SELECT * FROM `products` WHERE `CATEGORY` = ?;";
	private final String SELECT_BY_ID = "SELECT * FROM `products` WHERE `ID` = ?;";


	public ProductService() {
		super();
	}

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();

		Connection con = getConnection();
		try (Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery(SELECT_ALL_PRODUCTS);
			while(rs.next()) {
				Product prod = new Product()
						.setId(rs.getInt("ID"))
						.setDescription(rs.getString("DESCRIPTION"))
						.setName(rs.getString("NAME"))
						.setPrice(rs.getFloat("PRICE"))
						.setCategory(rs.getInt("CATEGORY"));
				products.add(prod);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
	
	public List<Product> getProductsByCategory(int catId) {
		List<Product> products = new ArrayList<Product>();

		Connection con = getConnection();
		try (PreparedStatement ps = con.prepareStatement(SELECT_BY_CATEGORY);) {
			ps.setInt(1, catId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product prod = new Product()
						.setId(rs.getInt("ID"))
						.setDescription(rs.getString("DESCRIPTION"))
						.setName(rs.getString("NAME"))
						.setPrice(rs.getFloat("PRICE"))
						.setCategory(rs.getInt("CATEGORY"));
				products.add(prod);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
	
	public Product getProductsByID(int Id) {
		Product prod = null;
		Connection con = getConnection();
		try (PreparedStatement ps = con.prepareStatement(SELECT_BY_ID);) {
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				prod = new Product()
						.setId(rs.getInt("ID"))
						.setDescription(rs.getString("DESCRIPTION"))
						.setName(rs.getString("NAME"))
						.setPrice(rs.getFloat("PRICE"))
						.setCategory(rs.getInt("CATEGORY"));
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prod;
	}
}

package wb.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import wb.model.Product;

public class ProductService {
	
	private final String SELECT_ALL_PRODUCTS = "SELECT * FROM `products`;";
	private Connector connector;

	public ProductService() {
		connector = new Connector();
	}

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();

		Connection con = connector.getConnection();
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
}

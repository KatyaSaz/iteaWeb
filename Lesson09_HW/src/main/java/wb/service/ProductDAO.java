package wb.service;

import java.util.List;

import wb.model.Product;

public interface ProductDAO {

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(int catId);

	Product getProductsByID(int Id);
}

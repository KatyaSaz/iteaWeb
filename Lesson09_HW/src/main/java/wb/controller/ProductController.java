package wb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wb.model.Product;
import wb.service.ProductService;

public class ProductController extends HttpServlet {

	private static final String PRODUCT_FORM = "WEB-INF/views/productView.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher(PRODUCT_FORM);
		ProductService prodService = new ProductService();
		String categoryId = req.getParameter("catId");
		List<Product> productList = new ArrayList<>();
		if (categoryId != null) {
			productList = prodService.getProductsByCategory(Integer.valueOf(categoryId));
		} else {
			productList = prodService.getProducts();
		}
		req.setAttribute("products", productList);
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}

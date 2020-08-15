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
import wb.service.DAOFactory;
import wb.service.ProductDAO;

public class ProductController extends HttpServlet {

	private static final String PRODUCT_FORM = "WEB-INF/views/productView.jsp";

	public static final int MY_SQL = 1;
	private DAOFactory daoFactory;
	private ProductDAO prodDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(PRODUCT_FORM);

		daoFactory = DAOFactory.getInstance(MY_SQL);
		prodDAO = daoFactory.getProductDAO();

		String categoryId = req.getParameter("catId");
		List<Product> productList = new ArrayList<>();
		if (categoryId != null) {
			productList = prodDAO.getProductsByCategory(Integer.valueOf(categoryId));
		} else {
			productList = prodDAO.getAllProducts();
		}
		req.setAttribute("products", productList);
		rd.forward(req, resp);

	}
}

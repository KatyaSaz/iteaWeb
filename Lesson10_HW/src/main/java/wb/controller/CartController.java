package wb.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wb.service.DAOFactory;
import wb.service.ProductDAO;
import wb.model.Product;

public class CartController extends HttpServlet {

	private static final String CART_FORM = "WEB-INF/views/cartView.jsp";
	private static final String PRODUCT_FORM = "WEB-INF/views/productView.jsp";

	public static final int MY_SQL = 1;
	private DAOFactory daoFactory;
	private ProductDAO prodDAO;

	public CartController() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(CART_FORM);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String productId = req.getParameter("prodId");
		
		String deleteId = req.getParameter("deleteId");
		String amount = req.getParameter("amount");
		HttpSession session = req.getSession();
		Map<Product, Integer> products = new HashMap<>();

		if (session.getAttribute("cart") != null) {
			products = (Map<Product, Integer>) session.getAttribute("cart");
		}
		daoFactory = DAOFactory.getInstance(MY_SQL);
		prodDAO = daoFactory.getProductDAO();
		Product tmpProd = null;
		if (productId != null) {
			int amountInt = Integer.valueOf(amount);
			tmpProd = prodDAO.getProductsByID(Integer.valueOf(productId));
			if (products.get(tmpProd) != null) {
				amountInt = products.get(tmpProd) + 1;
			}
			products.put(tmpProd, amountInt);
			session.setAttribute("cart", products);
			resp.sendRedirect("./products");
		}

		if (deleteId != null) {
			Map<Product, Integer> prod = (Map<Product, Integer>) session.getAttribute("cart");
			prod.keySet().stream().filter(p -> p.getId() == Integer.valueOf(deleteId)).findFirst()
			.ifPresent(p -> prod.remove(p));
			session.setAttribute("cart", prod);
			resp.sendRedirect("./cart");
		}
	}
}

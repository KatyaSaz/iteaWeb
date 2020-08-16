package wb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		HttpSession session = req.getSession();
		List<Product> products = new ArrayList<>();

		if (session.getAttribute("cart") != null) {
			products = (List<Product>) session.getAttribute("cart");
		}

		if (productId != null) {
			daoFactory = DAOFactory.getInstance(MY_SQL);
			prodDAO = daoFactory.getProductDAO();
			products.add(prodDAO.getProductsByID(Integer.valueOf(productId)));
			session.setAttribute("cart", products);
			resp.sendRedirect("./products");
		}

		if (deleteId != null) {
			List<Product> prod = (List<Product>) session.getAttribute("cart");
			prod.stream().filter(p -> p.getId() == Integer.valueOf(deleteId)).findFirst()
					.ifPresent(p -> prod.remove(p));
			session.setAttribute("cart", prod);
			resp.sendRedirect("./cart");
		}
	}
}

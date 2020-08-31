package wb.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		PrintWriter out = resp.getWriter();
		String productId = req.getParameter("prodId");
		String deleteId = req.getParameter("deleteId");
		String amountStr = req.getParameter("amount");
		HttpSession session = req.getSession();
		Map<Product, Integer> products = new HashMap<>();
		int allQuantity = 0;

		if (session.getAttribute("cart") != null) {
			products = (Map<Product, Integer>) session.getAttribute("cart");
			allQuantity = (int) session.getAttribute("allQuantity");
		}
		daoFactory = DAOFactory.getInstance(MY_SQL);
		prodDAO = daoFactory.getProductDAO();
		Product tmpProd = null;
		int amount = 0;
		if (productId != null) {
			amount = Integer.valueOf(amountStr);
			allQuantity += amount;
			tmpProd = prodDAO.getProductsByID(Integer.valueOf(productId));
			if (products.get(tmpProd) != null) {
				amount = products.get(tmpProd) + amount;
			}
			products.put(tmpProd, amount);
			session.setAttribute("cart", products);
			session.setAttribute("allQuantity", allQuantity);
			out.write(String.valueOf(allQuantity));
		}

		if (deleteId != null) {
			System.out.println("delId: " + deleteId);

			tmpProd = prodDAO.getProductsByID(Integer.valueOf(deleteId));
			Map<Product, Integer> prod = (Map<Product, Integer>) session.getAttribute("cart");
			amount = prod.get(tmpProd);
			allQuantity -= amount;
			System.out.println("amount: " + amount);
			
			prod.keySet().stream().filter(p -> p.getId() == Integer.valueOf(deleteId)).findFirst()
					.ifPresent(p -> prod.remove(p));
			session.setAttribute("cart", prod);
			System.out.println("allQuantity: " + allQuantity);
			session.setAttribute("allQuantity", allQuantity);
			out.write(String.valueOf(allQuantity));
			resp.sendRedirect("./cart");
		}
	}
}

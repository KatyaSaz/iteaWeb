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

import wb.model.Product;
import wb.service.ProductService;

public class CartController extends HttpServlet {

	private static final String CART_FORM = "WEB-INF/views/cartView.jsp";
	private static final String PRODUCT_FORM = "WEB-INF/views/productView.jsp";

	public CartController() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(CART_FORM);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(PRODUCT_FORM);
		String productId = req.getParameter("prodId");
		String deleteId = req.getParameter("deleteId");
		HttpSession session = req.getSession();
		List<Product> products = new ArrayList<>();
		if (session.getAttribute("cart") != null) {
			products = (List<Product>) session.getAttribute("cart");
		}
		if(productId!=null) {
			ProductService prodServ = new ProductService();
			products.add(prodServ.getProductsByID(Integer.valueOf(productId)));
			session.setAttribute("cart", products);
			resp.sendRedirect("./products");
		}
		
//		if(deleteId!=null) {
//			System.out.println("deleteId: "+ deleteId);
//			products.remove(Integer.valueOf(deleteId));
//			session.setAttribute("cart", products);
//			if(products.size()>0) {
//				rd = req.getRequestDispatcher(CART_FORM);
//			}
//			rd.forward(req, resp);
//		}
		
		
	}
}

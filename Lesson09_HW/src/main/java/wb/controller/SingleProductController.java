package wb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wb.model.Product;
import wb.service.DAOFactory;
import wb.service.ProductDAO;

public class SingleProductController extends HttpServlet {

	private static final String PRODUCT_FORM = "WEB-INF/views/singleProductView.jsp";

	public static final int MY_SQL = 1;
	private DAOFactory daoFactory;
	private ProductDAO prodDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(PRODUCT_FORM);

		daoFactory = DAOFactory.getInstance(MY_SQL);
		prodDAO = daoFactory.getProductDAO();

		String itemId = req.getParameter("itemId");
		Product product = prodDAO.getProductsByID(Integer.valueOf(itemId));
		req.setAttribute("product", product);
		rd.forward(req, resp);

	}
}
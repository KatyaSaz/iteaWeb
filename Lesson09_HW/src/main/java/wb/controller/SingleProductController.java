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

public class SingleProductController extends HttpServlet {

	private static final String PRODUCT_FORM = "WEB-INF/views/singleProductView.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher(PRODUCT_FORM);
		ProductService prodService = new ProductService();
		String itemId = req.getParameter("itemId");
		Product product = prodService.getProductsByID(Integer.valueOf(itemId));
		req.setAttribute("product", product);
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
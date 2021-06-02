package order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import order.model.service.OrderService;
import product.model.vo.Product;

@WebServlet("/order/searchPname")
public class SearchProductNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchProductNameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pCode = request.getParameter("pCode");
		pCode = pCode.toUpperCase();

		List<Product> pList = new OrderService().searchProducts(pCode);

		response.setContentType("application/json; charset=utf-8");

		new Gson().toJson(pList, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

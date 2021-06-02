package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.model.vo.Transfer;
import product.model.service.StockService;
import product.model.vo.Product;
import product.model.vo.StockToTransfer;
import sales.model.vo.Shop;

@WebServlet("/stock/stockDetailForm")
public class StockDetailFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StockDetailFormServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tCode = request.getParameter("tCode");
		Transfer t = new StockService().selectOneStockToTransfer(tCode);
		request.setAttribute("t", t);
		request.getRequestDispatcher("/WEB-INF/views/product/stockToTransferForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

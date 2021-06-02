package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.utill.Utils;
import product.model.service.StockService;
import product.model.vo.Stock;

@WebServlet("/product/stk")
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StockService stockService = new StockService();

	public StockServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numPerPage = 10;
		int cPage = 1;

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
		}

		String[] searchArr = new String[] { "", "", "", "", "", "" };

		List<Stock> list = stockService.selectStockList(cPage, numPerPage);

		int totalContents = stockService.selectStockCount();
		String searchArrStr = "?";

		for (int i = 0; i < 6; i++) {
			searchArrStr += "&search=" + searchArr[i];
		}

		String url = request.getRequestURI() + searchArrStr + "&";

		String pageBar = Utils.getPageBarHTML(cPage, numPerPage, totalContents, url);

		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/WEB-INF/views/product/stock.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

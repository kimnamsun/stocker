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

@WebServlet("/product/stockSearch")
public class StockSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StockSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] searchArr = request.getParameterValues("search");

		int numPerPage = 10;
		int cPage = 1;

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
		}

		List<Stock> list = new StockService().searchStock(searchArr, cPage, numPerPage);
		int totalContents = new StockService().selectTotalContents(searchArr);
		String searchArrStr = "";

		for (int i = 0; i < 4; i++)
			searchArrStr += "?search=" + searchArr[i];

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

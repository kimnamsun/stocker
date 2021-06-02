package order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.model.service.OrderService;
import order.model.vo.Order;
import order.model.vo.PageInfo;

@WebServlet("/order/searchCompleteOrder")
public class SerchCompleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SerchCompleteOrder() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] search = request.getParameterValues("search");

		int totalList = new OrderService().getSearchListCount(search);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 5;
		int listLimit = 5;
		int maxPage = (int) Math.ceil((double) totalList / listLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pi = new PageInfo(totalList, currentPage, startPage, endPage, maxPage, pageLimit, listLimit);

		List<Order> orderList = new OrderService().searchOrder(pi, search);

		request.setAttribute("pi", pi);
		request.setAttribute("orderList", orderList);
		request.setAttribute("search", search);
		request.getRequestDispatcher("/WEB-INF/views/order/order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

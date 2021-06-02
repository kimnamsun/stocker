package order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import approval.model.service.ApprovalService;
import common.utill.Utils;
import order.model.service.TransferService;
import order.model.vo.Transfer;
import product.model.service.ProductService;
import product.model.vo.Product;

@WebServlet("/order/transfer")

public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TransferService transferService = new TransferService();

	public TransferServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numPerPage = 5;
		int cPage = 1;

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
		}

		String[] searchArr = new String[] { "", "", "", "", "", "" };

		List<Transfer> transferList = transferService.selectTransferList(cPage, numPerPage);

		int totalContents = transferService.selectTransferCount();
		String searchArrStr = "?";

		for (int i = 0; i < 6; i++) {
			searchArrStr += "&search=" + searchArr[i];
		}

		String url = request.getRequestURI() + searchArrStr + "&";
		String pageBar = Utils.getPageBarHTML(cPage, numPerPage, totalContents, url);

		request.setAttribute("transferList", transferList);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/WEB-INF/views/order/transfer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
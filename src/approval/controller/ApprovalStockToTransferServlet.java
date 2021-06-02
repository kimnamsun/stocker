package approval.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import approval.model.service.ApprovalService;
import order.model.vo.Order;
import order.model.vo.PageInfo;
import order.model.vo.Transfer;

@WebServlet("/approval/stt")
public class ApprovalStockToTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApprovalStockToTransferServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Transfer> tList = null;

		int totalList = new ApprovalService().getListCount();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 5;
		int listLimit = 5;
		int maxPage = (int) Math.ceil((double) totalList / listLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pi = new PageInfo(totalList, currentPage, startPage, endPage, maxPage, pageLimit, listLimit);

		tList = new ApprovalService().selectWaitingStockTransfer(pi);

		request.setAttribute("pi", pi);
		request.setAttribute("tList", tList);
		request.getRequestDispatcher("/WEB-INF/views/approval/approval.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package approval.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import approval.model.service.ApprovalService;
import member.model.vo.Employee;
import order.model.vo.Order;
import order.model.vo.PageInfo;
import order.model.vo.Transfer;

@WebServlet("/approval")
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApprovalServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Order> list = null;
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

		HttpSession session = request.getSession();
		Employee memberLoggedIn = ((Employee) session.getAttribute("empLoggedIn"));
		if (memberLoggedIn.geteDept().equals("발주")) {
			list = new ApprovalService().selectWaitingOrder(pi);
		}

		else if (memberLoggedIn.geteDept().equals("경기물류") || memberLoggedIn.geteDept().equals("대구물류")) {
			list = new ApprovalService().selectWaitingStockOrder(pi);

		} else if (memberLoggedIn.geteDept().equals("이송")) {
			tList = new ApprovalService().selectWaitingStockTransfer(pi);
		}
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("tList", tList);
		request.getRequestDispatcher("/WEB-INF/views/approval/approval.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

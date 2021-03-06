package order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.EmpService;
import member.model.vo.Employee;
import order.model.service.OrderService;
import order.model.vo.Order;
import product.model.vo.Product;
import sales.model.vo.Shop;

@WebServlet("/order/orderDetailForm")
public class OrderDetailFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderDetailFormServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oCode = request.getParameter("oCode");
		Order order = new OrderService().selectOneOrder(oCode);
		Employee emp = new EmpService().selctOne(order.getWriter());
		Product product = new OrderService().selectOneProduct(order.getpCode());
		Shop shop = new OrderService().selectOneShop(order.getsCode());

		HttpSession session = request.getSession();
		Employee memberLoggedIn = ((Employee) session.getAttribute("empLoggedIn"));

		if ((memberLoggedIn == null)
				|| !("관리자".equals(memberLoggedIn.geteDept()) || "발주".equals(memberLoggedIn.geteDept()))) {
			session.setAttribute("msg", "발주 담당자만 접근 가능합니다.");

		}

		request.setAttribute("emp", emp);
		request.setAttribute("order", order);
		request.setAttribute("product", product);
		request.setAttribute("shop", shop);
		request.getRequestDispatcher("/WEB-INF/views/order/orderForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

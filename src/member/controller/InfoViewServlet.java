package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.EmpService;
import member.model.vo.Employee;

@WebServlet("/member/infoView")
public class InfoViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int eCode = Integer.parseInt(request.getParameter("eCode"));
		Employee emp = new EmpService().selectOne(eCode);

		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/WEB-INF/views/member/infoView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

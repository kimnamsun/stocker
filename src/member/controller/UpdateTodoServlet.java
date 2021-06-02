package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.EmpService;

@WebServlet("/todo/change")
public class UpdateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateTodoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int m_code = Integer.parseInt(request.getParameter("m_code"));
		String m_status = request.getParameter("m_status");
		int result = new EmpService().updateTodo(m_code, m_status);

		PrintWriter out = response.getWriter();
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

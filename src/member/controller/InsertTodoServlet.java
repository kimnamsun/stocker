package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.EmpService;

@WebServlet("/todo/insert")
public class InsertTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertTodoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ecode = Integer.parseInt(request.getParameter("ecode"));
		String mcoments = request.getParameter("mcoments");

		int result = new EmpService().insertTodo(ecode, mcoments);

		PrintWriter out = response.getWriter();
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

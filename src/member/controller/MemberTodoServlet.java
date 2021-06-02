package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.model.service.EmpService;
import member.model.vo.Todo;

@WebServlet("/member/todo")
public class MemberTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberTodoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ecode = Integer.parseInt(request.getParameter("ecode"));

		List<Todo> todo = new EmpService().selectTodo(ecode);

		response.setContentType("application/json; charset=utf-8");

		Gson gson = new Gson();
		gson.toJson(todo, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

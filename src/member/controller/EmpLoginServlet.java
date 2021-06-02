package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.utill.Utils;
import member.model.service.EmpService;
import member.model.vo.Employee;

@WebServlet("/member/login")
public class EmpLoginServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int eCode = Integer.parseInt(request.getParameter("eCode"));
		String ePassword = request.getParameter("ePassword");

		Cookie boardCookie2 = new Cookie("boardCookie", "");
		boardCookie2.setPath(request.getContextPath());
		boardCookie2.setMaxAge(0);
		response.addCookie(boardCookie2);

		if (Utils.isEmpty(eCode)) {

			request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		} else {

			ePassword = Utils.getEncryptedPassword(ePassword);
			String saveId = request.getParameter("saveId");
			Employee emp = new EmpService().selectOne(eCode);
			String view = "";

			if (emp != null && eCode == emp.geteCode() && ePassword.equals(emp.getePassword())) {

				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(30 * 60);

				session.setAttribute("empLoggedIn", emp);

				String eCodeCookie = String.valueOf(eCode);
				Cookie c = new Cookie("saveId", eCodeCookie);
				c.setPath(request.getContextPath());
				if (saveId != null) {
					c.setMaxAge(7 * 24 * 60 * 60);
				} else {
					c.setMaxAge(0);
				}
				response.addCookie(c);

				view = "/index.jsp";
				request.setAttribute("emp", emp);
			} else {
				view = "/WEB-INF/views/common/msg.jsp";
				String msg = "사번 또는 비밀번호가 일치하지 않습니다.";
				String loc = "/";
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
			}
			request.getRequestDispatcher(view).include(request, response);
		}
	}
}

package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.utill.Utils;
import member.model.service.EmpService;
import member.model.vo.Employee;

@WebServlet("/member/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService empService = new EmpService();

	public UpdatePasswordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/updatePassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int eCode = Integer.parseInt(request.getParameter("eCode"));
		String password = Utils.getEncryptedPassword(request.getParameter("password"));
		String encryptedNewPassword = Utils.getEncryptedPassword(request.getParameter("newPassword"));
		Employee emp = empService.selectOne(eCode);
		String msg = "";
		String loc = "/";

		if (emp != null && password.equals(emp.getePassword())) {

			int result = empService.updatePassword(eCode, encryptedNewPassword);
			if (result > 0) {
				msg = "비밀번호 변경 성공!";
				loc = "/member/logout";
			} else {
				msg = "비밀번호 변경 실패!";
			}
		} else {
			msg = "비밀번호를 잘못 입력하셨습니다.";
			loc = "/member/updatePassword?eCode=" + eCode;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}
}

package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import common.mail.EmailDto;
import common.mail.Emailer;
import common.utill.Utils;
import member.model.service.EmpService;
import member.model.vo.Employee;

@WebServlet("/member/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService empService = new EmpService();

	public ResetPasswordServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int eCode = Integer.parseInt(request.getParameter("eCode"));
		String eEmail = request.getParameter("eEmail");
		String subject = "STOCKer :: 새 비밀번호";
		String newPassword = RandomStringUtils.randomAlphabetic(5);
		String encryptedNewPassword = Utils.getEncryptedPassword(newPassword);
		String content = "새로운 비밀번호입니다: " + newPassword + "\n";
		content += "로그인 후 비밀번호를 변경해주세요";
		String msg = "";
		String loc = "/";

		Employee emp = empService.selectOne(eCode);

		if (emp != null && eEmail.equals(emp.geteEmail())) {
			int result = empService.updatePassword(eCode, encryptedNewPassword);
			EmailDto dto = new EmailDto();
			dto.setMailTo(eEmail);
			dto.setPassword(newPassword);
			dto.setTitle(subject);
			dto.setContent(content);
			Emailer emailer = new Emailer(eEmail);

			try {
				emailer.sendMail(dto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				msg = "메일 발송 오류:" + e.getMessage();
			} finally {
				msg = "새 비밀번호를 해당 메일로 전송했습니다.";
				request.setAttribute("script", "self.close();");
			}
		} else {
			msg = "이메일을 잘못 입력하셨습니다.";
			loc = "/member/passwordFinder";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}
}

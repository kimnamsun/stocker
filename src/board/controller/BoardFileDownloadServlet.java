package board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/fileDownload")
public class BoardFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardFileDownloadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oname = request.getParameter("oname");
		String rname = request.getParameter("rname");

		String saveDirectory = getServletContext().getRealPath("/upload/board");
		FileInputStream fis = new FileInputStream(new File(saveDirectory, rname));
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

		boolean isIE = request.getHeader("user-agent").indexOf("MSIE") > -1
				|| request.getHeader("user-agent").indexOf("Trident") > -1;

		if (isIE) {
			oname = URLEncoder.encode(oname, "utf-8").replaceAll("\\+", "%20	");
		} else {
			oname = new String(oname.getBytes("utf-8"), "iso-8859-1");

		}

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + oname);

		int read = -1;
		while ((read = bis.read()) != -1) {
			bos.write(read);
		}

		bos.close();
		bis.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

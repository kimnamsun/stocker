package product.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ProjectConfig;

@WebServlet("/ProductFileServlet")
public class ProductFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductFileServlet() {
		super();
	}

	private static final int DEFAULT_BUFFER_SIZE = 1024 * 10;

	private String filePath;

	public void init() throws ServletException {
		this.filePath = ProjectConfig.PRODUCT_UPLOAD_LOCATION;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedFile = request.getPathInfo();

		if (requestedFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
			return;
		}

		File file = new File(filePath, URLDecoder.decode(requestedFile, "UTF-8"));

		if (!file.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
			return;
		}

		String contentType = getServletContext().getMimeType(file.getName());

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bis = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
			bos = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, length);
			}
		} finally {
			close(bis);
			close(bos);
		}
	}

	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

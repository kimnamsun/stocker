package order.controller;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import approval.model.service.ApprovalService;
import common.ProjectConfig;
import common.utill.Utils;
import order.model.service.TransferService;
import order.model.vo.Transfer;
import product.model.service.ProductService;
import product.model.vo.Product;

@WebServlet("/order/productDetail")

public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

	public ProductDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pCode = request.getParameter("pCode").trim();
		Product product = productService.selectOne(pCode);
		String qrValue = ProjectConfig.PRODUCT_QR_PREFIX_URL + pCode;
		String qrImageUrl = ProjectConfig.PRODUCT_UPLOAD_LOCATION + "\\" + pCode + "_QR.png";

		try {
			Utils.generateQRCodeImage(qrValue, 150, 150, qrImageUrl);
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}

		product.setpImage(request.getContextPath() + "/ProductFile/" + pCode + ".jpg");
		product.setpQrImage(request.getContextPath() + "/ProductFile/" + pCode + "_QR.png");

		String json = new Gson().toJson(product);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
package common.utill;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Utils {

	public static String getEncryptedPassword(String password) {
		String encryptedPassword = null;

		byte[] bytes = null;
		try {
			bytes = password.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("sha-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		md.update(bytes);
		byte[] encryptedBytes = md.digest();

		Base64.Encoder encoder = Base64.getEncoder();
		encryptedPassword = encoder.encodeToString(encryptedBytes);

		return encryptedPassword;
	}

	public static boolean isEmpty(String s) {
		return ((null == s) || s.equals(""));
	}

	public static String getPageBarHTML(int cPage, int numPerPage, int totalContents, String url) {
		String pageBar = "";
		int pageBarSize = 5;
		int totalPage = (int) Math.ceil((double) totalContents / numPerPage);
		int pageStart = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		int pageEnd = pageStart + pageBarSize - 1;
		int pageNo = pageStart;

		if (pageNo == 1) {
		} else {
			pageBar += "<a href='" + url + "cPage=" + (pageNo - 1)
					+ "style='color:b66dff'><i class='mdi mdi-chevron-left' style='color:#b66dff'></i></a>";
		}

		while (pageNo <= pageEnd && pageNo <= totalPage) {
			if (pageNo == cPage) {
				pageBar += "<span class='cPage' style='color:#b66dff'>" + pageNo + "</span>";
			} else {
				pageBar += "<a href='" + url + "cPage=" + pageNo + "' style='color:#b66dff'>" + pageNo + "</a>";
			}
			pageNo++;
		}

		if (pageNo > totalPage) {

		} else {
			pageBar += "<a href='" + url + "cPage=" + pageNo
					+ "' style='color:#b66dff'><i class='mdi mdi-chevron-right' style='color:#b66dff'></i></a>";
		}

		return pageBar;
	}

	public static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	public static boolean isEmpty(int i) {
		String s = String.valueOf(i);
		return ((null == s) || s.equals(""));
	}
}

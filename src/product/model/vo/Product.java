package product.model.vo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;

public class Product implements Serializable {

	private String pCode;
	private String pTheme;
	private String pCategory;
	private String pName;
	private String pColor;
	private String pPrice;
	private String pImage;
	private String pQrImage;

	public Product() {
		super();
	}

	public Product(String pCode, String pTheme, String pCategory, String pName, String pColor, String pPrice) {
		super();
		this.pCode = pCode;
		this.pTheme = pTheme;
		this.pCategory = pCategory;
		this.pName = pName;
		this.pColor = pColor;
		this.pPrice = pPrice;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpTheme() {
		return pTheme;
	}

	public void setpTheme(String pTheme) {
		this.pTheme = pTheme;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getpQrImage() {
		return pQrImage;
	}

	public void setpQrImage(String pQrImage) {
		this.pQrImage = pQrImage;
	}

	@Override
	public String toString() {
		return "Product [pCode=" + pCode + ", pTheme=" + pTheme + ", pCategory=" + pCategory + ", pName=" + pName
				+ ", pColor=" + pColor + ", pPrice=" + pPrice + ", pImage=" + pImage + ", pQrImage=" + pQrImage + "]";
	}
}

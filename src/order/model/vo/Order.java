package order.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

public class Order implements Serializable {
	private String oCode;
	private String cCode;
	private String pCode;
	private int oAmount;
	private String sCode;
	private Date oDate;
	private String oStatus;
	private int writer;
	private String oTitle;
	private String oComment;

	public Order() {
		super();
	}

	public Order(String oCode, String cCode, String pCode, int oAmount, String sCode, Date oDate, String oStatus,
			int writer, String oTitle, String oComment) {
		super();
		this.oCode = oCode;
		this.cCode = cCode;
		this.pCode = pCode;
		this.oAmount = oAmount;
		this.sCode = sCode;
		this.oDate = oDate;
		this.oStatus = oStatus;
		this.writer = writer;
		this.oTitle = oTitle;
		this.oComment = oComment;
	}

	public String getoCode() {
		return oCode;
	}

	public void setoCode(String oCode) {
		this.oCode = oCode;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getoAmount() {
		return oAmount;
	}

	public void setoAmount(int oAmount) {
		this.oAmount = oAmount;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public Date getoDate() {
		return oDate;
	}

	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}

	public String getoStatus() {
		return oStatus;
	}

	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getoTitle() {
		return oTitle;
	}

	public void setoTitle(String oTitle) {
		this.oTitle = oTitle;
	}

	public String getoComment() {
		return oComment;
	}

	public void setoComment(String oComment) {
		this.oComment = oComment;
	}

	@Override
	public String toString() {
		return "Order [oCode=" + oCode + ", cCode=" + cCode + ", pCode=" + pCode + ", oAmount=" + oAmount + ", sCode="
				+ sCode + ", oDate=" + oDate + ", oStatus=" + oStatus + ", writer=" + writer + ", oTitle=" + oTitle
				+ ", oComment=" + oComment + "]";
	}

}

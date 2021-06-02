package product.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class StockToTransfer implements Serializable {

	private String pCode;
	private int tAmount;
	private Date tDate;
	private String departureCode;
	private String destinationCode;
	private String tStatus;
	private String tTitle;
	private String tWriter;

	public StockToTransfer() {
		super();
	}

	public StockToTransfer(String pCode, int tAmount, Date tDate, String departureCode, String destinationCode,
			String tStatus, String tTitle, String tWriter) {
		super();
		this.pCode = pCode;
		this.tAmount = tAmount;
		this.tDate = tDate;
		this.departureCode = departureCode;
		this.destinationCode = destinationCode;
		this.tStatus = tStatus;
		this.tTitle = tTitle;
		this.tWriter = tWriter;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int gettAmount() {
		return tAmount;
	}

	public void settAmount(int tAmount) {
		this.tAmount = tAmount;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public String getDepartureCode() {
		return departureCode;
	}

	public void setDepartureCode(String departureCode) {
		this.departureCode = departureCode;
	}

	public String getDestinationCode() {
		return destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	public String gettStatus() {
		return tStatus;
	}

	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}

	public String gettTitle() {
		return tTitle;
	}

	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}

	public String gettWriter() {
		return tWriter;
	}

	public void settWriter(String tWriter) {
		this.tWriter = tWriter;
	}

	@Override
	public String toString() {
		return "StockToTransfer [pCode=" + pCode + ", tAmount=" + tAmount + ", tDate=" + tDate + ", departureCode="
				+ departureCode + ", destinationCode=" + destinationCode + ", tStatus=" + tStatus + ", tTitle=" + tTitle
				+ ", tWriter=" + tWriter + "]";
	}

}

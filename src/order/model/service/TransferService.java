package order.model.service;

import java.sql.Connection;
import java.util.List;
import static common.JDBCTemplate.*;

import order.model.dao.TransferDAO;
import order.model.vo.Transfer;
import product.model.vo.Product;

public class TransferService {
	private TransferDAO transferDAO = new TransferDAO();

	public List<Transfer> selectTransferList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Transfer> transferlist = transferDAO.selectTransferList(conn, cPage, numPerPage);
		close(conn);
		return transferlist;
	}

	public int selectTransferCount() {
		Connection conn = getConnection();
		int totalConetents = transferDAO.selectTransferCount(conn);
		close(conn);
		return totalConetents;
	}

	public int selectTotalContents(String[] searchArr) {
		Connection conn = getConnection();
		int totalContents = transferDAO.selectTotal(conn, searchArr);
		close(conn);
		return totalContents;
	}

	public List<Transfer> searchTransfer(String[] searchArr, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Transfer> tList = transferDAO.searchTransfer(conn, searchArr, cPage, numPerPage);
		return tList;
	}

	public Transfer selectOne(String tCode) {
		Connection conn = getConnection();
		Transfer transfer = transferDAO.transferSelectOne(conn, tCode);
		return transfer;
	}

}

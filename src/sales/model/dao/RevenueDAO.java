package sales.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class RevenueDAO {

	private Properties prop = new Properties();

	public RevenueDAO() {
		String fileName = RevenueDAO.class.getResource("/sql/sales/sales-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, Integer> AnnualRevenue1(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("annualRevenue");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "GG");
			pstmt.setInt(2, thisYear);
			pstmt.setInt(3, thisYear - 1);
			pstmt.setInt(4, thisYear - 2);
			pstmt.setInt(5, thisYear - 3);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("year"), rset.getInt("sum(revenue)"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public HashMap<Integer, Integer> AnnualRevenue2(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("annualRevenue");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "TK");
			pstmt.setInt(2, thisYear);
			pstmt.setInt(3, thisYear - 1);
			pstmt.setInt(4, thisYear - 2);
			pstmt.setInt(5, thisYear - 3);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("year"), rset.getInt("sum(revenue)"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public HashMap<Integer, Integer> MonthlyRevenue1(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("monthlyRevenue");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("month"), rset.getInt("sum(rev)"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public HashMap<Integer, Integer> MonthlyRevenue2(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("monthlyRevenue");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear - 1);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("month"), rset.getInt("sum(rev)"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public HashMap<String, Integer> DailyRevenue1(Connection conn) {
		HashMap<String, Integer> result = new HashMap<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("dailyRevenue");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "GG");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result.put(rset.getString("getdate"), rset.getInt("sum(rev)"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public HashMap<String, Integer> DailyRevenue2(Connection conn) {
		HashMap<String, Integer> result = new HashMap<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("dailyRevenue");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "TK");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result.put(rset.getString("getdate"), rset.getInt("sum(rev)"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int TodayRevenue(Connection conn) {
		Integer result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("todayRevenue");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = rset.getInt("sum(rev)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

}

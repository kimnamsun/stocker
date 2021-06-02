package sales.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import sales.model.vo.MostSoldProduct;
import sales.model.vo.RankedShop;
import sales.model.vo.RankedTransfer;

public class SalesDAO {

	private Properties prop = new Properties();

	public SalesDAO() {
		String fileName = SalesDAO.class.getResource("/sql/sales/sales-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int CountInbound(Connection conn, int thisYear, int thisMonth) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("countInbound");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			pstmt.setInt(2, thisMonth);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result = rset.getInt("sum");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int CountOutbound(Connection conn, int thisYear, int thisMonth) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("countOutbound");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			pstmt.setInt(2, thisMonth);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				result = rset.getInt("sum");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public List<RankedShop> RankingShop(Connection conn, int thisYear) {
		List<RankedShop> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("rankingShop");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			list = new ArrayList<>();
			rset = pstmt.executeQuery();

			while (rset.next()) {
				RankedShop s = new RankedShop();
				s.setRank(rset.getInt("rownum"));
				s.setS_code(rset.getString("s_code"));
				s.setS_name(rset.getString("s_name"));
				s.setTotalsum(rset.getInt("totalsum"));
				s.setS_tel(rset.getString("s_tel"));
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<MostSoldProduct> mostSoldProducts(Connection conn, int thisYear) {
		List<MostSoldProduct> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("mostSoldProducts");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			list = new ArrayList<>();
			rset = pstmt.executeQuery();

			while (rset.next()) {
				MostSoldProduct m = new MostSoldProduct();
				m.setQuantity(rset.getInt("quantity"));
				m.setP_name(rset.getString("p_name"));
				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public List<RankedTransfer> RankTransfer1(Connection conn, int thisYear) {
		List<RankedTransfer> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("rankingTransfer");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "GG");
			pstmt.setInt(2, thisYear);
			list = new ArrayList<>();
			rset = pstmt.executeQuery();

			int i = 0;
			while (rset.next()) {
				RankedTransfer t = new RankedTransfer();
				i++;
				t.setRnum(i);
				t.setT_amount(rset.getInt("tsum"));
				t.setP_code(rset.getString("p_code"));
				t.setP_name(rset.getString("p_name"));
				list.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public List<RankedTransfer> RankTransfer2(Connection conn, int thisYear) {
		List<RankedTransfer> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("rankingTransfer");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "TK");
			pstmt.setInt(2, thisYear);
			list = new ArrayList<>();
			rset = pstmt.executeQuery();
			int i = 0;
			while (rset.next()) {
				RankedTransfer t = new RankedTransfer();
				i++;
				t.setRnum(i);
				t.setT_amount(rset.getInt("tsum"));
				t.setP_code(rset.getString("p_code"));
				t.setP_name(rset.getString("p_name"));
				list.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public HashMap<String, Integer> StockCategory(Connection conn) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		PreparedStatement pstmt = null;
		String query = prop.getProperty("countCategory");
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getString("p_category"), rset.getInt("sum(s_amount)"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;

	}

	public HashMap<String, Integer> StockTheme(Connection conn) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		PreparedStatement pstmt = null;
		String query = prop.getProperty("countTheme");
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getString("p_theme"), rset.getInt("sum(s_amount)"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;

	}

	public HashMap<Integer, Integer> AnnualInbound1(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

		PreparedStatement pstmt = null;
		String query = prop.getProperty("countAnnualInbound");
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			pstmt.setInt(2, thisYear - 1);
			pstmt.setInt(3, thisYear - 2);
			pstmt.setInt(4, thisYear - 3);

			pstmt.setString(5, "GG");
			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("year"), rset.getInt("sum"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public HashMap<Integer, Integer> AnnualInbound2(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<>();

		PreparedStatement pstmt = null;
		String query = prop.getProperty("countAnnualInbound");
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			pstmt.setInt(2, thisYear - 1);
			pstmt.setInt(3, thisYear - 2);
			pstmt.setInt(4, thisYear - 3);
			pstmt.setString(5, "TK");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("year"), rset.getInt("sum"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public HashMap<Integer, Integer> AnnualOutbound1(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<>();

		PreparedStatement pstmt = null;
		String query = prop.getProperty("countAnnualOutbound");
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			pstmt.setInt(2, thisYear - 1);
			pstmt.setInt(3, thisYear - 2);
			pstmt.setInt(4, thisYear - 3);
			pstmt.setString(5, "GG");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("year"), rset.getInt("sum"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public HashMap<Integer, Integer> AnnualOutbound2(Connection conn, int thisYear) {
		HashMap<Integer, Integer> result = new HashMap<>();

		PreparedStatement pstmt = null;
		String query = prop.getProperty("countAnnualOutbound");
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, thisYear);
			pstmt.setInt(2, thisYear - 1);
			pstmt.setInt(3, thisYear - 2);
			pstmt.setInt(4, thisYear - 3);
			pstmt.setString(5, "TK");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				result.put(rset.getInt("year"), rset.getInt("sum"));
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

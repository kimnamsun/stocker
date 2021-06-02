package sales.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sales.model.service.RevenueService;
import sales.model.service.SalesService;
import sales.model.vo.MainStat;

@WebServlet("/stat")
public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StatisticsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR);
		int thisMonth = cal.get(Calendar.MONTH) + 1;

		int countInbound = new SalesService().CountInbound(thisYear, thisMonth);
		int countOutbound = new SalesService().CountOutbound(thisYear, thisMonth);
		int todayRevenue = new RevenueService().TodayRevenue();

		MainStat mstat = new MainStat(String.valueOf(thisYear), String.valueOf(thisMonth), countInbound, countOutbound,
				todayRevenue);

		response.setContentType("application/json; charset=utf-8");

		Gson gson = new Gson();
		gson.toJson(mstat, response.getWriter());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

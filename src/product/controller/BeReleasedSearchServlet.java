package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.utill.Utils;
import product.model.service.BeReleasedService;
import product.model.vo.BeReleased;

@WebServlet("/beReleased/search")
public class BeReleasedSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BeReleasedSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] searchArr = request.getParameterValues("search");

		int numPerPage = 5;
		int cPage = 1;

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
		}

		List<BeReleased> list = new BeReleasedService().searchBeReleased(searchArr, cPage, numPerPage);

		int totalContents = new BeReleasedService().selectTotalContents(searchArr);
		String searchArrStr = "?";

		for (int i = 0; i < 6; i++)
			searchArrStr += "&search=" + searchArr[i];

		String url = request.getRequestURI() + searchArrStr + "&";
		String pageBar = Utils.getPageBarHTML(cPage, numPerPage, totalContents, url);

		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);

		request.getRequestDispatcher("/WEB-INF/views/product/beReleased.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

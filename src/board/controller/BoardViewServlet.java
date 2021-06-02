package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.BoardComment;

@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		Cookie[] cookies = request.getCookies();
		String boardCookieVal = "";
		boolean hasRead = false;

		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();

				if ("boardCookie".equals(name)) {
					boardCookieVal = value;

					if (value.contains("[" + boardNo + "]"))
						hasRead = true;

				}
			}
		}
		if (!hasRead) {
			Cookie boardCookie = new Cookie("boardCookie", boardCookieVal + "[" + boardNo + "]");
			boardCookie.setPath(request.getContextPath());
			boardCookie.setMaxAge(365 * 24 * 60 * 60);
			response.addCookie(boardCookie);
		}

		Board board = new BoardService().selectOne(boardNo, hasRead);

		String boardContentWithBr = board.getBoardContent().replaceAll("\\n", "<br/>");
		board.setBoardContent(boardContentWithBr);

		List<BoardComment> commentList = new BoardService().selectCommentList(boardNo);
		for (BoardComment bc : commentList) {
			String bcBr = bc.getBoardCommentContent().replaceAll("\\n", "<br/>");

			bc.setBoardCommentContent(bcBr);
		}

		request.setAttribute("board", board);
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("/WEB-INF/views/board/boardView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

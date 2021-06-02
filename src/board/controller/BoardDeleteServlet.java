package board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardDeleteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String rname = request.getParameter("rname");

		if (!"".equals(rname)) {
			String saveDirectory = getServletContext().getRealPath("/upload/board");
			File delFile = new File(saveDirectory, rname);
			boolean delOK = delFile.delete();
		}

		int result = new BoardService().deleteBoard(boardNo);

		String msg = result > 0 ? "게시글이 삭제되었습니다." : "게시글 삭제 실패!";
		String loc = "/board/boardList";

		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);

	}
}

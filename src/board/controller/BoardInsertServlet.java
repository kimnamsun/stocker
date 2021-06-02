package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import board.model.exception.BoardException;
import board.model.service.BoardService;
import board.model.vo.Board;
import common.utill.MvcFileRenamePolicy;

@WebServlet("/board/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardInsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request))
			throw new BoardException("파일업로드 enctype 속성 미적용! : " + request.getRequestURI());

		String saveDirectory = getServletContext().getRealPath("/") + "/upload/board";

		int maxPostSize = 1024 * 1024 * 10;

		FileRenamePolicy policy = new MvcFileRenamePolicy();

		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxPostSize, "utf-8", policy);

		String boardTitle = multipartRequest.getParameter("boardTitle");
		String boardWriter = multipartRequest.getParameter("boardWriter");
		String boardContent = multipartRequest.getParameter("boardContent");
		boardContent = boardContent.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

		String boardOriginalFileName = multipartRequest.getOriginalFileName("upFile");
		String boardRenamedFileName = multipartRequest.getFilesystemName("upFile");

		Board board = new Board(0, boardTitle, boardWriter, boardContent, boardOriginalFileName, boardRenamedFileName,
				null, 0, null);

		int result = new BoardService().insertBoard(board);

		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = result > 0 ? "게시글이 등록되었습니다." : "게시판 등록 실패!";
		String loc = "/board/boardView?boardNo=" + board.getBoardNo();

		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

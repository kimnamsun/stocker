package board.controller;

import java.io.File;
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

@WebServlet("/board/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNo;
		try {
			boardNo = Integer.parseInt(request.getParameter("boardNo"));
		} catch (NumberFormatException e) {
			throw new BoardException("유효하지 않은 게시글입니다.");
		}
		Board b = new BoardService().selectOne(boardNo);

		request.setAttribute("board", b);
		request.getRequestDispatcher("/WEB-INF/views/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new BoardException("enctype 오류!");
		}

		String saveDirectory = getServletContext().getRealPath("/upload/board");
		int maxPostSize = 1024 * 1024 * 10;
		String encoding = "utf-8";
		FileRenamePolicy policy = new MvcFileRenamePolicy();

		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);

		int boardNo = Integer.parseInt(multipartRequest.getParameter("boardNo"));
		String boardTitle = multipartRequest.getParameter("boardTitle");
		String boardWriter = multipartRequest.getParameter("boardWriter");
		String boardContent = multipartRequest.getParameter("boardContent");
		String boardOriginalFileName = multipartRequest.getOriginalFileName("upFile");
		String boardRenamedFileName = multipartRequest.getFilesystemName("upFile");
		String oldOriginalFileName = multipartRequest.getParameter("oldOriginalFileName");
		String oldRenamedFileName = multipartRequest.getParameter("oldRenamedFileName");
		String delFile = multipartRequest.getParameter("delFile");

		Board board = new Board(boardNo, boardTitle, boardWriter, boardContent, boardOriginalFileName,
				boardRenamedFileName, null, 0, null);

		if (!"".equals(oldOriginalFileName)) {
			if (boardOriginalFileName == null && delFile == null) {
				board.setBoardOriginalFileName(oldOriginalFileName);
				board.setBoardRenamedFileName(oldRenamedFileName);
			} else {
				File f = new File(saveDirectory, oldRenamedFileName);
				f.delete();
			}
		}

		int result = new BoardService().updateBoard(board);

		String msg = result > 0 ? "게시글이 수정되었습니다." : "게시글 수정 실패!";
		String loc = "/board/boardView?boardNo=" + boardNo;
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		;
	}
}

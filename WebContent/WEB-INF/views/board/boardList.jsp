<%@page import="board.model.vo.BoardComment"%>
<%@page import="board.model.vo.BoardForList"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Board> list = (List<Board>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/meta.jsp"%>
<title>게시판</title>
<%@ include file="../common/header.jsp"%>

<style>
div#pageBar {
	text-align: center;
}

div#pageBar span.cPage {
	font-weight: bold;
	color: #b66dff;
	margin-right: 5px;
	font-size: 15px
}

div#pageBar a {
	margin-right: 5px;
	font-size: 15px
}

th {
	text-align: center;
}

.board-btn {
	float: right;
	margin-top: 20px;
}

.board-btn:hover {
	opacity: 50%;
}
</style>
</head>

<body>
	<div class="container-scroller">
		<%@ include file="../common/navbar.jsp"%>
		<div class="container-fluid page-body-wrapper">
			<%@ include file="../common/sidebar.jsp"%>
			<div class="main-panel">
				<div class="content-wrapper">
					<i class="mdi mdi-close" id="bannerClose" style="display: none;"></i>
					<div class="page-header">
						<h3 class="page-title kor">
							<span class="page-title-icon bg-gradient-primary text-white mr-2">
								<i class="mdi mdi-bulletin-board"
								style="text-decoration: none; color: #fff;"></i>
							</span> 게시판
						</h3>
					</div>
					<div class="col-lg-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body" style="padding-bottom: 0px;">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>번호</th>
											<th>제목</th>
											<th>작성자</th>
											<th>작성일</th>
											<th>첨부파일</th>
											<th>조회수</th>
										</tr>

										<% if(list == null || list.isEmpty()) {%>
										<tr>
											<th colspan="6">조회된 행이 없습니다.</th>
										</tr>
										<% } 
							else { 
								for(Board b : list){
						%>
										<tr>
											<td style="text-align: center;"><%= b.getBoardNo() %></td>
											<td><a
												href="<%= request.getContextPath() %>/board/boardView?boardNo=<%= b.getBoardNo() %>"><%= b.getBoardTitle() %></a>
												<% if(((BoardForList)b).getCommentCnt()>0){ %> &emsp; <i
												class="mdi mdi-plus" style="color: #b66dff"><%= ((BoardForList)b).getCommentCnt() %></i>
												<%} %></td>

											<td style="text-align: center;"><%= b.getBoardWriter() %></td>

											<td style="text-align: center;"><%= b.getBoardDate() %></td>

											<td style="text-align: center;">
												<% if(b.getBoardOriginalFileName() != null) { %>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
												class="mdi mdi-file"></i> <% } else { %>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
												class="mdi mdi-file-hidden"></i> <% } %>
											</td>

											<td style="text-align: center;"><%= b.getBoardReadCount() %></td>
										</tr>
										<%
								}
							} 
						%>
									</thead>
									<tbody>

									</tbody>
								</table>

								<% if(empLoggedIn != null) { %>

								<button type="button" value="글쓰기" id="btn-add"
									onclick="location.href='<%= request.getContextPath() %>/board/boardForm';"
									class="btn btn-link board-btn" style="padding-left: 0px;">
									<i class="mdi mdi-lead-pencil" style="font-size: 22px"></i>
								</button>
								<% } %>
								<button type="button"
									onclick="location.href='<%= request.getContextPath() %>/board/boardList'"
									class="btn btn-link board-btn">
									<i class="mdi mdi-format-list-bulleted"
										style="font-size: 22px;"></i>
								</button>
							</div>
							<div id='pageBar' style="margin-bottom: 20px;">
								<%= pageBar %>
							</div>
						</div>
					</div>


				</div>
				<%@ include file="../common/footer.jsp"%>
			</div>
		</div>
	</div>
	<%@ include file="../common/footerScript.jsp"%>
</body>
</html>
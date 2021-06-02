<%@page import="member.model.vo.Employee"%>
<%@page import="order.model.vo.Transfer"%>
<%@page import="order.model.vo.Order"%>
<%@page import="product.model.vo.StockToTransfer"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
String msg = (String) session.getAttribute("msg");

StockToTransfer stock = (StockToTransfer) request.getAttribute("stock");
Order order = (Order) request.getAttribute("order");
Transfer t = (Transfer) request.getAttribute("t");

Employee user = (Employee) session.getAttribute("empLoggedIn");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
Date now = new Date();
String today = sdf.format(now);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/meta.jsp"%>
<title>이송요청서</title>
<%@ include file="../common/header.jsp"%>
<style>
input {
	background-color: white !important;
}
</style>
<script>
	$(function(){
		var message = "<%=msg%>";
		if(message != "null"){
			alert(message);
			<%session.removeAttribute("msg");%>
		}
	});
</script>
</head>
<body>
	<%
	if (msg != null && !msg.equals("")) {
	%>
	<script>
			alert("<%=msg%>
		");
		self.close();
	</script>
	<%
	session.removeAttribute("msg");
	}
	%>
	<div class="container-fluid page-body-wrapper">
		<div class="main-panel" style="width: 100%;">
			<div class="content-wrapper">
				<i class="mdi mdi-close" id="bannerClose" style="display: none;"></i>
				<div style="padding-right: 20px;">
					<div
						style="float: left; display: inline-block; margin-top: 48px; margin-left: 26px;">
						<h1 class="display-1 kor">이송요청서</h1>
					</div>
					<div class="card"
						style="display: inline-block; margin-top: 26px; width: 148px; float: right">
						<div class="card-body">
							<table style="border-spacing: 10px; text-align: center">
								<tr>
									<th class="kor"><strong>이송 담당</strong></th>
								</tr>
								<tr>
									<td><input type="checkbox" disabled></td>
								</tr>
							</table>
						</div>
					</div>
				</div>


				<form class="forms-sample" name="stockFrom" id="stockForm"
					action="<%=contextPath%>/product/stockForm" method="post">

					<div class="col-lg-12 grid-margin stretch-card"
						style="margin-top: 30%">
						<div class="card">
							<div class="card-body">
								<table class="table">
									<thead>

										<tr>
											<th class="kor"><strong>품의 제목</strong></th>
											<th><input type="text" name="tTitle" id="tTitle"
												class="form-control kor" placeholder="제목을 입력하세요." required /></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th><strong>발주 내용</strong></th>
											<th>

												<div class="form-group">
													<label style="padding-top: 3%;">상품코드</label> <input
														type="text" class="form-control" name="pCode" id="pCode"
														style="width: 20%; margin-left: 10%; display: inline-block;"
														placeholder="" />
												</div>
												<div class="form-group">
													<label style="padding-top: 3%;">요청수량</label> <input
														type="text" class="form-control" name="tAmount"
														id="tAmount"
														style="width: 20%; margin-left: 10%; display: inline-block;"
														placeholder="" />
												</div>
												<div class="form-group">
													<label for="departure">출발센터(요청할 센터)</label> <select
														class="form-control" name="departureCode"
														id="departureCode" onchange="selectCenter();" required>
														<option disabled selected>출발지</option>
														<%
														if (user.geteDept().equals("대구물류")) {
														%>
														<option value="GG">경기광주센터</option>
														<%
														} else if (user.geteDept().equals("경기물류")) {
														%>
														<option value="TK">대구센터</option>
														<%
														}
														%>
													</select>
												</div>
												<div class="form-group">
													<label for="destination">도착센터(본인 담당 센터)</label> <select
														class="form-control" name="destinationCode"
														id="destinationCode" onchange="selectCenter();" required>
														<option disabled selected>도착지</option>
														<%
														if (user.geteDept().equals("대구물류")) {
														%>
														<option value="TK">대구센터</option>
														<%
														} else if (user.geteDept().equals("경기물류")) {
														%>
														<option value="GG">경기광주센터</option>
														<%
														}
														%>
													</select>
												</div>
											</th>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="card-body" style="text-align: right;">
						<h6 class="kor">
							<strong style="margin-right: 20px;">작성인 : </strong>
							<%=user.geteDept()%>
							<span><%=user.geteName()%></span>
						</h6>
						<input type="hidden" name="tWriter" value="<%=user.geteName()%>" />
						<h6 class="kor"><%=today%></h6>
						<br />
						<button type="submit"
							class="btn btn-gradient-primary btn-icon-text kor"
							style="float: right;" onsubmit="submitApproval();">
							<i class="mdi mdi-file-check btn-icon-prepend"></i> 이송요청
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../common/footerScript.jsp"%>
</body>
</html>

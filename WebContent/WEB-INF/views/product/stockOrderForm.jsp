<%@page import="member.model.vo.Employee"%>
<%@page import="product.model.vo.BeReleased"%>
<%@page import="sales.model.vo.Shop"%>
<%@page import="product.model.vo.Product"%>
<%@page import="order.model.vo.Order"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
Order order = (Order) request.getAttribute("order");
Product product = (Product) request.getAttribute("product");
Shop shop = (Shop) request.getAttribute("shop");
BeReleased br = (BeReleased) request.getAttribute("br");
String cName = order != null ? ((order.getcCode()).equals("GG") ? "경기센터" : "대구센터") : "";

Employee user = (Employee) session.getAttribute("empLoggedIn");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
Date now = new Date();
String today = sdf.format(now);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/meta.jsp"%>
<title>발주서 상세보기</title>
<%@ include file="../common/header.jsp"%>
<style>
input {
	background-color: white !important;
}
</style>

</head>
<body>
	<div class="container-fluid page-body-wrapper">
		<div class="main-panel" style="width: 100%;">
			<div class="content-wrapper">
				<i class="mdi mdi-close" id="bannerClose" style="display: none;"></i>
				<div style="padding-right: 20px;">
					<div
						style="float: left; display: inline-block; margin-top: 48px; margin-left: 26px;">
						<h1 class="display-1 kor">발주서</h1>
					</div>
					<div class="card"
						style="display: inline-block; margin-top: 26px; width: 148px; float: right">
						<div class="card-body">
							<table style="border-spacing: 10px; text-align: center">
								<tr>
									<th class="kor"><strong>재고 담당</strong></th>
								</tr>
								<tr>
									<td><input type="checkbox"
										<%=order != null ? (order.getoStatus().equals('C') ? "checked" : "") : ""%>
										disabled></td>
								</tr>
							</table>
						</div>
					</div>
				</div>


				<form class="forms-sample" name="stockOrderForm" id="stockOrderForm"
					action="<%=contextPath%>/product/stockOrderToBRSubmit"
					method="post">

					<div class="col-lg-12 grid-margin stretch-card"
						style="margin-top: 30%">
						<div class="card">
							<div class="card-body">
								<table class="table">
									<thead>
										<tr>
											<th class="kor"><strong>품의 제목</strong></th>
											<th><input type="text" name="title" id="title"
												class="form-control kor" placeholder="제목을 입력하세요."
												value="<%=order.getoTitle()%>" required disabled /></th>
										</tr>
										<tr>
											<th class="kor"><strong>발주 코드</strong></th>
											<th><input type="text" name="oCode" id="oCode"
												class="form-control kor" placeholder="제목을 입력하세요."
												value="<%=order.getoCode()%>" " readonly="readonly"
												required style="width: 30%" />
										</tr>
									</thead>
									<tbody>
										<tr>
											<div class="form-group">
												<div class="form-group">
													<tr>
														<th class="kor"><strong>상품 코드</strong></th>
														<th><input type="text" name="pCode" id="pCode"
															class="form-control kor" placeholder="제목을 입력하세요."
															value="<%=order.getpCode()%>" readonly="readonly"
															required style="width: 30%" /></th>
													</tr>

													<tr>
														<th class="kor"><strong>상품명</strong></th>
														<th><input type="text" name="pName" id="pName"
															class="form-control kor" placeholder="제목을 입력하세요."
															value="<%=product.getpName()%>" readonly="readonly"
															required style="width: 50%" /></th>
													</tr>


													<tr>
														<th class="kor"><strong>수량</strong></th>
														<th><input type="text" name="oAmount" id="oAmount"
															class="form-control kor" placeholder="제목을 입력하세요."
															value="<%=order.getoAmount()%>" readonly="readonly"
															required style="width: 20%" /></th>
													</tr>
													<tr>
														<th class="kor"><strong>주문매장</strong></th>

														<th><input type="text" class="form-control kor"
															value="<%=shop.getsName()%>" disabled
															style="width: 50%"></th>
													</tr>
													<tr>
														<th class="kor"><strong>출고센터</strong></th>

														<th><input type="text" class="form-control"
															style="width: 50%" value="<%=cName%>" readonly></th>
													</tr>
												</div>
												<tbody>

												</tbody>
											</div>
											</th>
										</tr>

										<tr>
											<th class="kor"><strong>비고</strong></th>
											<td><textarea class="form-control" name="comment"
													id="comment" cols="30" rows="10" placeholder="메모를 입력하세요."
													disabled> <%=order.getoComment() == null ? "" : order.getoComment()%> </textarea></td>

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
						<h6 class="kor"><%=sdf.format(order.getoDate())%></h6>
						<br />

						<%
						if ((order.getcCode()).equals("GG")) {
						%>
						<%
						if (user.geteDept().equals("경기물류")) {
						%>
						<button type="submit"
							class="btn btn-gradient-primary btn-icon-text kor"
							style="float: right;">
							<i class="mdi mdi-file-check btn-icon-prepend"></i> 결재
						</button>
						<%
						} else {
						%>
						<button type="submit"
							class="btn btn-gradient-primary btn-icon-text kor"
							style="float: right;" disabled="disabled">
							<i class="mdi mdi-file-check btn-icon-prepend"></i> 결재
						</button>
						<br />
						<br />
						<br />
						<strong>본인 담당센터에 대한 발주가 아닙니다</strong>
						<%
						}
						%>
						<%
						}
						if ((order.getcCode()).equals("TK")) {
						%>
						<%
						if (user.geteDept().equals("대구물류")) {
						%>
						<button type="submit"
							class="btn btn-gradient-primary btn-icon-text kor"
							style="float: right;">
							<i class="mdi mdi-file-check btn-icon-prepend"></i> 결재
						</button>
						<%
						} else {
						%>
						<button type="submit"
							class="btn btn-gradient-primary btn-icon-text kor"
							style="float: right;" disabled="disabled">
							<i class="mdi mdi-file-check btn-icon-prepend"></i> 결재
						</button>
						<br />
						<br />
						<br />
						<strong>본인 담당센터에 대한 발주가 아닙니다</strong>
						<% } } %>

					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../common/footerScript.jsp"%>
</body>
</html>

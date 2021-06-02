<%@page import="product.model.vo.Stock"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	List<Stock> list = (List<Stock>)request.getAttribute("list");
	String pageBar = (String) request.getAttribute("pageBar");
	String msg = (String)session.getAttribute("msg");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/meta.jsp"%>
<title>재고</title>
<%@ include file="../common/header.jsp"%>
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

						<div style="display: inline-block; text-align: left;">
							<h3 class="page-title kor"
								style="display: inline-block; margin-right: 25px;">
								<span
									class="page-title-icon bg-gradient-primary text-white mr-2">
									<i class="mdi mdi-basket"></i>
								</span> 재 고
							</h3>
						</div>
						<button
							class="add btn btn-gradient-primary font-weight-bold todo-list-add-btn"
							id="stock-submit-btn"
							style="display: inline-block; margin-right: 40px; text-align: right !important;"
							onclick="window.open('<%=contextPath%>/product/stockForm?eCode=<%=empLoggedIn.geteCode()%>','_blank', 'top=1,left=500,width=1000,height=700')  ">
							이송요청 <i class="mdi mdi-file-check"></i>
						</button>


						<style>
.stock-tr {
	font-weight: bold;
}
</style>
						<script>
	$(function(){
		var message = "<%=msg%>";
		if(message != "null"){
			alert(message);
			<% session.removeAttribute("msg"); %>
		}
	});
</script>
					</div>
					<div class="stock-main">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<form action="<%=contextPath %>/product/stockSearch"
										id="searchForm" class="form-sample">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label stock-tr">상품명</label>
													<div class="col-sm-9" id="search-pName">
														<input type="text" class="form-control" name="search"
															id="search_pname" />
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label stock-tr">상품코드</label>
													<div class="col-sm-9" id="search-pCode">
														<input type="text" class="form-control" name="search"
															id="search_pcode" />
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label stock-tr">테마</label>
													<div class="col-sm-9" id="search-pTheme">
														<input type="text" class="form-control" name="search"
															id="search_ptheme" />
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label stock-tr">종류</label>
													<div class="col-sm-9" id="search-pCategory">
														<input type="text" class="form-control" name="search"
															id="search_pcategory" />
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<button type="button" class="btn btn-inverse-info btn-fw"
													style="float: left; font-weight: bold"
													onclick="location.href='<%= contextPath %>/product/stk'">전체보기</button>
											</div>
											<div class="col-md-6">
												<button type="submit" class="btn btn-inverse-primary btn-fw"
													style="float: right">Search</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="col-12 grid-margin" style="margin-top: 26px">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">재고 리스트</h4>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<style>
#stock-tr {
	font-weight: bold;
}
</style>
												<tr>
													<th id="stock-tr">센터</th>
													<th id="stock-tr">테마</th>
													<th id="stock-tr">종류</th>
													<th id="stock-tr">상품명</th>
													<th id="stock-tr">상품코드</th>
													<th id="stock-tr">안전재고량</th>
													<th id="stock-tr">재고량</th>
												</tr>
											</thead>
											<tbody>
												<%
                   			for(Stock s : list) {
                  		 %>
												<tr>
													<td data-toggle="tooltip">
														<% if(s.getcCode().equals("GG")){ %> <label
														class="badge badge-gradient-danger">경기광주</label> <% } else { %>
														<label class="badge badge-gradient-info">대구</label> <% } %>
													</td>
													<td><%= s.getpTheme() %></td>
													<td><%= s.getpCategory() %></td>
													<td><%= s.getpName() %></td>
													<td><a href="javascript:void(0)"
														class="btn_popup_open"> <%= s.getpCode() %>
													</a></td>
													<td><%= s.getsCapa() %></td>
													<% if(s.getsCapa()>s.getsAmount()){ %>
													<td style="color: red"><%= s.getsAmount() %></td>
													<% } else { %>
													<td style="color: blue"><%= s.getsAmount() %></td>
													<% } %>
												</tr>
												<% }%>

											</tbody>
										</table>
										<div id='pageBar'>
											<%= request.getAttribute("pageBar") %>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="popup_panel">
						<div class="popup_bg"></div>
						<div class="popup_contents" style="float: left;">
							<img id="p_image" src="" alt="" />
							<div class="popup_contents2">
								<span id="p_theme"> </span> <span id="p_category"> </span> <span
									id="p_name"> </span>
								<hr />
								<span id="p_price" style="float: right"> </span>
								<div id="qrDiv" style="float: right; margin-top: 40px">
									<img id="p_qr_image" src="" alt=""
										style="width: 130px; margin-right: -60px;" />
								</div>
							</div>
						</div>
					</div>
					<style>
.popup_panel {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 100;
}

.popup_panel div.popup_bg {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
}

.popup_panel div.popup_contents {
	position: absolute;
	top: 30%;
	left: 50%;
	width: 600px;
	hight: 800px;
	border: 2px solid #b66dff;
	background-color: #fff;
}

.popup_contents2 {
	display: inline;
	float: right;
	margin: 30px;
	margin-top: 63px;
	margin-right: 38px;
}

input {
	background-color: white !important;
}

div#pageBar {
	margin-top: 20px;
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
</style>

					<script>
$(document).ready(function() {
	var searchs = [
		 'search_pname'
		,'search_pcode'
		,'search_ptheme'
		,'search_pcategory'
		];
	
	var url = unescape(location.href); 
    var paramArr = (url.substring(url.indexOf("?")+1,url.length)).split("&");
    for(var i = 0 ; i < paramArr.length ; i++){
        var temp = paramArr[i].split("=");
        $("#"+searchs[i]).val(temp[1]);
    }
    var $panel = $(".popup_panel");
    var $panelContents = $panel.find(".popup_contents");
    
    $(".btn_popup_open").on("click", function(e) {
    	var pCode = $(this).text();
		var params = {pCode : pCode};
		console.log("request post="+"<%=contextPath%>/order/productDetail");
		$.post('<%=contextPath%>/order/productDetail', $.param(params), function(responseJson){

			var obj = $.parseJSON(JSON.stringify(responseJson));

			$("#p_image").attr("src", obj.pImage); 
			$("#p_theme").text("[" + obj.pTheme + "]");
			$("#p_category").html("[" + obj.pCategory + "]" + "<br>");
			
			$("#p_name").text(obj.pName);
			$("#p_price").text((obj.pPrice).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")); 
			$("#p_qr_image").attr("src", obj.pQrImage);
			
			
		});
        if ($panelContents.outerWidth() < $(document).width()) {
            $panelContents.css("margin-left", "-" + $panelContents.outerWidth() / 2 + "px");
        } else {
            $panelContents.css("left", "0px");
        }

        if ($panelContents.outerHeight() < $(document).height()) {
            $panelContents.css("margin-top", "-" + $panelContents.outerHeight() / 2 + "px");
        } else {
            $panelContents.css("top", "0px");
        }
        $panel.fadeIn();
        
    });
    $("#btn_popup_close").on("click", popupClose);

    $panel.find(".popup_bg").on("click", popupClose);

function popupClose(e) {
    $panel.fadeOut();
    e.preventDefault();
}

});

</script>
				</div>
				<%@ include file="../common/footer.jsp"%>
			</div>
		</div>
	</div>
	<%@ include file="../common/footerScript.jsp"%>
</body>
</html>
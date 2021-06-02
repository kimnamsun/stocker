<%@ page import="java.util.*"%>
<%@ page import="order.model.vo.Transfer"%>
<%@ page import="product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	
	List<Transfer> transferList = (List<Transfer>) request.getAttribute("transferList");
	Product product = (Product) request.getAttribute("product");
	String pageBar = (String) request.getAttribute("pageBar");
	String msg = (String) session.getAttribute("msg");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="<%=contextPath %>/js/jquery.qrcode.js"></script>
<script src="<%=contextPath %>/js/qrcode.js"></script>
<%@ include file="../common/meta.jsp"%>
<title>이송</title>
<%@ include file="../common/header.jsp"%>
<style type="text/css">
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

td, th, tr {
	text-align: center;
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

.stock-tr {
	font-family: "고딕";
	font-weight: bold;
}

a {
	color: #b66dff;
}
</style>
</head>
<body>
	<%
  	if(msg != null && !msg.equals(""))
  	{
  %>
	<script>
			alert("<%= msg %>"); 
		</script>
	<%
  		session.removeAttribute("msg");
  	}
  %>
	<div class="container-scroller">
		<%@ include file="../common/navbar.jsp"%>
		<div class="container-fluid page-body-wrapper">
			<%@ include file="../common/sidebar.jsp"%>
			<div class="main-panel">
				<div class="content-wrapper">
					<i class="mdi mdi-close" id="bannerClose" style="display: none;"></i>
					<div class="page-header" style="width: 100%">
						<div style="display: inline-block; width: 50%; text-align: left;">
							<h3 class="page-title kor"
								style="display: inline-block; margin-right: 25px;">
								<span
									class="page-title-icon bg-gradient-primary text-white mr-2">
									<i class="mdi mdi-car"></i>
								</span> 이 송
							</h3>
						</div>
					</div>
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<form action="<%=contextPath %>/order/transferSearch"
									id="searchForm" class="form-sample">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group row">
												<label class="col-sm-3 col-form-label stock-tr">이송코드</label>
												<div class="col-sm-9" id="search-tCode">
													<input type="text" class="form-control" name="search"
														id="search_tcode" />
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
												<label class="col-sm-3 col-form-label stock-tr">출발센터</label>
												<div class="col-sm-9" id="search-depCode">
													<select class="form-control center-name" name="search"
														form="searchForm" id="dep_name">
														<option selected></option>
														<option value="GG">광주센터</option>
														<option value="TK">대구센터</option>
													</select>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group row">
												<label class="col-sm-3 col-form-label stock-tr">도착센터</label>
												<div class="col-sm-9" id="search-depCode">
													<select class="form-control center-name" name="search"
														form="searchForm" id="des_name">
														<option selected></option>
														<option value="GG">광주센터</option>
														<option value="TK">대구센터</option>
													</select>

												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group row">
												<label class="col-sm-3 col-form-label stock-tr">기간</label>
												<div class="col-sm-9">
													<input type="date" class="form-control" name="search"
														id="search_sdate" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group row">
												<label class="col-sm-3 col-form-label stock-tr"
													style="text-align: center"> - </label>
												<div class="col-sm-9">
													<input type="date" class="form-control" name="search"
														id="search_edate" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<button type="button" class="btn btn-inverse-info btn-fw"
												style="float: left; font-weight: bold"
												onclick="location.href='<%= contextPath %>/order/transfer'">전체보기</button>
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
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th><strong>이송코드</strong></th>
												<th><strong>상품코드</strong></th>
												<th><strong>출고센터</strong></th>
												<th></th>
												<th><strong>입고센터</strong></th>
												<th><strong>이송수량 (개)</strong></th>
												<th><strong>이송일</strong></th>
											</tr>
										</thead>
										<%if(transferList == null || transferList.isEmpty()) { %>
										<tr>
											<th colspan="7" style="text-align: center">조회된 행이 없습니다.</th>
										</tr>
										<%} else { 
                   		for(Transfer t : transferList) {
                   %>
										<tr>
											<td><a href="#"
												onclick="window.open('<%= contextPath %>/order/transferView?tCode=<%=t.gettCode() %>',
		            			'_blank','top=1,left=500,width=1000,height=700')"><%= t.gettCode() %></a></td>
											<td><a href="javascript:void(0)" class="btn_popup_open">
													<%=t.getpCode() %>
											</a></td>

											<td data-toggle="tooltip" data-placement="top"
												title=<%=t.getDepartureCode().equals("TK") ? "대구센터" : "경기"+"광주센터" %>>

												<%if(t.getDepartureCode().equals("TK")) {%> <label
												class="badge badge-gradient-info">대구</label> <%} else { %> <label
												class="badge badge-gradient-danger">경기광주</label> <% } %>
											</td>
											<td><i class="mdi mdi-chevron-double-right"></i></td>
											<td data-toggle="tooltip" data-placement="top"
												title=<%=t.getDestinationCode().equals("TK") ? "대구센터" : "경기"+"광주센터" %>>

												<%if(t.getDestinationCode().equals("TK")) {%> <label
												class="badge badge-gradient-info">대구</label> <%} else { %> <label
												class="badge badge-gradient-danger">경기광주</label> <% } %>
											</td>

											<td><%=t.gettAmount()%></td>
											<td><%=t.gettDate() %></td>
										</tr>
										</tbody>

										<% }
}%>
									</table>
									<div id='pageBar'>
										<%= request.getAttribute("pageBar") %>
									</div>
								</div>
							</div>
						</div>
					</div>
					</form>

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
					<%@ include file="../common/footer.jsp"%>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="../common/footerScript.jsp"%>
</body>

<script>


$(document).ready(function() {
	
	var searchs = [
		 'search_tcode'
		,'search_pcode'
		,'dep_name'
		,'des_name'
		,'search_sdate'
		,'search_edate'
		];
	
	var url = unescape(location.href);
    var paramArr = (url.substring(url.indexOf("?")+1,url.length)).split("&"); 
    
    for(var i = 0 ; i < paramArr.length ; i++){
        var temp = paramArr[i].split("=");
        $("#"+searchs[i]).val(temp[1]); 
    }

    $('[data-toggle="tooltip"]').tooltip();
	
    var $panel = $(".popup_panel");
    var $panelContents = $panel.find(".popup_contents");
    
    $(".btn_popup_open").on("click", function(e) {
    	var pCode = $(this).text();
		var params = {pCode : pCode};
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

$(".center-name").change(function(){
	if($("#dep_name option:selected").val() == $("#des_name option:selected").val()) {
		alert('출발센터와 도착센터를 같은 곳으로 지정할 수 없습니다.');
		$(this).find("option:eq(0)").prop("selected", true);
	}
});


});
</script>
</html>
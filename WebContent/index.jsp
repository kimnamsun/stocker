<%@page import="member.model.vo.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
int eCode = 0;

if (session.getAttribute("empLoggedIn") == null || session.getAttribute("empLoggedIn").equals("")) {
	response.sendRedirect(contextPath + "/member/login");
} else
	eCode = ((Employee) session.getAttribute("empLoggedIn")).geteCode();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ include file="/WEB-INF/views/common/meta.jsp"%>
<title>STOCKer</title>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ include file="/WEB-INF/views/common/calendar.jsp"%>
</head>
<body>
	<div class="container-scroller">
		<%@ include file="/WEB-INF/views/common/navbar.jsp"%>
		<div class="container-fluid page-body-wrapper"
			style="padding-top: 25px;">
			<%@ include file="/WEB-INF/views/common/sidebar.jsp"%>
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
								</span> 메 인
							</h3>
						</div>
					</div>
					<%@ include file="/WEB-INF/views/common/stat.jsp"%>
					<div class="row">
						<div class="col-md-7 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<div class="clearfix">
										<h4 class="card-title float-left kor"
											style="font-weight: bold;">사내 일정</h4>
									</div>
									<div id="calendar" class="mt-4"></div>
								</div>
							</div>
						</div>
						<div class="col-md-5 grid-margin stretch-card"
							style="display: block;">
							<div class="card" style="height: 55%">
								<div class="card-body">
									<h4 class="card-title">Todo</h4>
									<div class="add-items d-flex" style="margin-top: 9%;">
										<input type="text" class="form-control todo-list-input"
											placeholder="할 일을 입력하세요">
										<button
											class="add btn btn-gradient-primary font-weight-bold todo-list-add-btn"
											id="add-task">Add</button>
									</div>
									<div class="list-wrapper">
										<ul
											class="d-flex flex-column-reverse todo-list todo-list-custom"
											id="todolist">
										</ul>
									</div>
								</div>
							</div>
							<div class="card" style="margin-top: 32px;">
								<div class="card-body" style="padding: 1.0rem 0rem;">
									<div class="card" style="text-align: center;">
										<div class="card-body" style="padding: 0px 15px 30px 10px;">
											<div style="float: left;">
												<table width="150">
													<tr height="150">
														<td id="GG-icon"></td>
														<td id="GG-temp"></td>
													</tr>
												</table>
											</div>
											<div style="float: right;">
												<table width="150">
													<tr height="150">
														<td id="TK-icon"></td>
														<td id="TK-temp"></td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%@ include file="/WEB-INF/views/common/footer.jsp"%>
			</div>
		</div>
</body>
<%@ include file="/WEB-INF/views/common/footerScript.jsp"%>
<script>
    $('.todo-list-add-btn').on("click", function(event) {
    	let ecode =<%=eCode%>;
		let mcoments = $(this).prevAll('.todo-list-input').val();
		
		if (mcoments) {
			$.ajax({
				url:"todo/insert",
				type:"get",
				data:{ecode:ecode,
					  mcoments:mcoments},
				success:function(result){
				},error:function(){
				}
			}); 
		}
		else
			alert("내용을 입력하세요.");
    });

    $('.todo-list').on('click', '.remove', function() {
		let m_code = $(this).siblings().children().children('input.m_code').val();
		
       	$.ajax({
			url:"todo/delete",
			type:"get",
			data:{m_code:m_code},
			success:function(result){
			},error:function(){
			}
		}); 
    });
	
	$('.todo-list').on('change', '.checkbox', function() {
		let m_code = $(this).next().next().val();
		let m_status = $(this).next().next().next().val();
		
		$.ajax({
			url:"todo/change",
			type:"get",
			data:{m_code:m_code,
				  m_status:m_status},
			success:function(result){
			},error:function(){
			}
		});
		
    });
	
	$(function () {
		let ecode =<%=eCode%>;
		$.ajax({
			url:"<%=request.getContextPath()%>
	/member/todo",
					type : "get",
					data : {
						ecode : ecode
					},
					success : function(list) {

						let result = "";
						for (let i = 0; i < list.length; i++) {
							result += "<li "
									+ (list[i].m_status == "C" ? "class='completed'"
											: "")
									+ ">"
									+ "<div class='form-check'>"
									+ "<label class='form-check-label'>"
									+ "<input type='checkbox' class='form-check-input checkbox' "
									+ (list[i].m_status == "C" ? "checked" : "")
									+ "> "
									+ list[i].m_contents
									+ "<i class='input-helper'></i>"
									+ "<input type='hidden' class='m_code' value=" + list[i].m_code + ">"
									+ "<input type='hidden' value=" + list[i].m_status + ">"
									+ " </label>"
									+ "</div>"
									+ "<i class='remove mdi mdi-close-circle-outline'></i>"
									+ "</li>";
						}
						;

						$("ul#todolist").append(result);

					},
					error : function() {
					}
				});
	})

	$(function() {
		var apiURI = "http://api.openweathermap.org/data/2.5/weather?lat=37.382172&lon=127.244410&appid=7241f75fcb9e39fc8f06aa3d7c5d71d6";
		$
				.ajax({
					url : apiURI,
					method : 'GET',
					success : function(data) {
						var temp = temp_cal(data.main.temp);
						var temp_max = temp_cal(data.main.temp_max).substring(
								0, 2);
						var temp_min = temp_cal(data.main.temp_min).substring(
								0, 2); 
						
						$('#GG-icon')
								.append(
										"<img src='http://openweathermap.org/img/wn/" + data.weather[0].icon + "@2x.png'><br>");
						$('#GG-icon')
								.append(
										"<i class='mdi mdi-map-marker' style='color:#b66dff'></i>&nbsp;<strong>경기 광주</strong>");
						$('#GG-temp').append(
								'<br><br><h1>' + temp + "°" + '</h1><br>');
						$('#GG-temp').append(
								'<span> 최고 ' + temp_max + "°" + '<br></span>');
						$('#GG-temp').append(
								'<span> 최저 ' + temp_min + "°" + '</span><br>');
					},
					error : function() {
					}
				});
	});

	$(function() {
		var apiURI = "http://api.openweathermap.org/data/2.5/weather?lat=35.847900&lon=128.486511&appid=7241f75fcb9e39fc8f06aa3d7c5d71d6";
		$
				.ajax({
					url : apiURI,
					method : 'GET',
					success : function(data) {
						var temp = temp_cal(data.main.temp);
						var temp_max = temp_cal(data.main.temp_max).substring(
								0, 2); 
						var temp_min = temp_cal(data.main.temp_min).substring(
								0, 2); 

						$('#TK-icon')
								.append(
										"<img src='http://openweathermap.org/img/wn/" + data.weather[0].icon + "@2x.png'><br>");
						$('#TK-icon')
								.append(
										"<i class='mdi mdi-map-marker' style='color:#b66dff'></i>&nbsp;<strong>대구 </strong><br>");
						$('#TK-temp').append(
								'<br><br><h1>' + temp + "°" + '</h1><br>');
						$('#TK-temp').append(
								'<span> 최고 ' + temp_max + "°" + '<br></span>');
						$('#TK-temp').append(
								'<span> 최저 ' + temp_min + "°" + '</span><br>');
					},
					error : function() {
					}
				});
	});

	function temp_cal(temp) {
		return String((temp - 273.15).toFixed(1));
	}
</script>
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-07-18 14:37:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Employee;
import order.model.vo.Transfer;
import order.model.vo.Order;
import product.model.vo.StockToTransfer;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class stockForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/product/../common/footerScript.jsp", Long.valueOf(1594450848000L));
    _jspx_dependants.put("/WEB-INF/views/product/../common/meta.jsp", Long.valueOf(1593265000000L));
    _jspx_dependants.put("/WEB-INF/views/product/../common/header.jsp", Long.valueOf(1593330696000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("order.model.vo.Transfer");
    _jspx_imports_classes.add("order.model.vo.Order");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("member.model.vo.Employee");
    _jspx_imports_classes.add("product.model.vo.StockToTransfer");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String contextPath = request.getContextPath();
	String msg = (String)session.getAttribute("msg");

	StockToTransfer stock = (StockToTransfer) request.getAttribute("stock");
	Order order = (Order)request.getAttribute("order");
	Transfer t = (Transfer) request.getAttribute("t");
	
	Employee user = (Employee) session.getAttribute("empLoggedIn");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	Date now = new Date();
	String today = sdf.format(now);
	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("\t ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- Required meta tags -->\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
      out.write("\r\n");
      out.write("\t <title>이송요청서</title>\r\n");
      out.write("\t ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- plugins:css -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/vendors/mdi/css/materialdesignicons.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/vendors/css/vendor.bundle.base.css\">\r\n");
      out.write("<!-- endinject -->\r\n");
      out.write("<!-- Plugin css for this page -->\r\n");
      out.write("<!-- End plugin css for this page -->\r\n");
      out.write("<!-- inject:css -->\r\n");
      out.write("<!-- endinject -->\r\n");
      out.write("<!-- Layout styles -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/css/style.css\">\r\n");
      out.write("<!-- End layout styles -->\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/images/favicon.png\" />\r\n");
      out.write("<!-- font 적용-->\r\n");
      out.write("<!-- 한글 폰트 적용 : 해당 태그 클래스에 'kor' 기입 -->\r\n");
      out.write("<!-- font-family: 'Noto Sans KR', sans-serif; -->\r\n");
      out.write("<!-- font-weight은 100, 300, 400(default), 500, 700, 900 가능합니다. -->\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("\t.kor {\r\n");
      out.write("\t\tfont-family: 'Noto Sans KR', sans-serif;\r\n");
      out.write("\t\tcolor: #343A40;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<script  src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("input {\r\n");
      out.write(" background-color: white !important;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tvar message = \"");
      out.print(msg);
      out.write("\";\r\n");
      out.write("\t\t// var message = \"회원가입 성공!!\"; // \"null\"\r\n");
      out.write("\t\tif(message != \"null\"){\r\n");
      out.write("\t\t\talert(message);\r\n");
      out.write("\t\t\t");
 session.removeAttribute("msg"); 
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    ");

  	if(msg != null && !msg.equals(""))
  	{
  
      out.write("\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\talert(\"");
      out.print( msg );
      out.write("\"); \r\n");
      out.write("\t\t\tself.close();\r\n");
      out.write("\t\t</script>\r\n");
      out.write("  ");

  		session.removeAttribute("msg");
  	}
  
      out.write("\r\n");
      out.write("<!--     <div class=\"container-scroller\"> -->\r\n");
      out.write("      <!-- partial -->\r\n");
      out.write("      <div class=\"container-fluid page-body-wrapper\">\r\n");
      out.write("        <!-- partial -->\r\n");
      out.write("        <div class=\"main-panel\" style=\"width: 100%;\">\r\n");
      out.write("          <div class=\"content-wrapper\">\r\n");
      out.write("              <i class=\"mdi mdi-close\" id=\"bannerClose\" style=\"display: none;\"></i>\r\n");
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("          ");
      out.write("\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          <div style=\"padding-right: 20px;\">\r\n");
      out.write("\t          <div style=\"float:left; display: inline-block; margin-top: 48px; margin-left: 26px;\"><h1 class=\"display-1 kor\"> 이송요청서 </h1></div>\r\n");
      out.write("\t\t\t  <div class=\"card\" style=\"display: inline-block; margin-top: 26px; width:148px; float:right\" >\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t<table style=\"border-spacing:10px; text-align:center\">\r\n");
      out.write("\t\t\t\t\t\t<tr><th class=\"kor\"><strong>이송 담당</strong></th></tr>\r\n");
      out.write("\t\t\t\t\t\t<tr><td><input type=\"checkbox\" disabled></td></tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t <form class=\"forms-sample\" name=\"stockFrom\" id=\"stockForm\" action=\"");
      out.print( contextPath );
      out.write("/product/stockForm\" method=\"post\">\r\n");
      out.write("\t\t  \r\n");
      out.write("          <div class=\"col-lg-12 grid-margin stretch-card\" style=\"margin-top: 30%\">\r\n");
      out.write("\t\t\t  <div class=\"card\">\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t  <table class=\"table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t<th class=\"kor\"><strong>품의 제목</strong></th>\r\n");
      out.write("\t\t\t\t\t\t<th><input type=\"text\" name=\"tTitle\" id=\"tTitle\" class=\"form-control kor\" \r\n");
      out.write("\t\t\t\t\t\t\t\t   placeholder=\"제목을 입력하세요.\" required/></th>\r\n");
      out.write("\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t  ");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t\t\t<th><strong>발주 내용</strong></th>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\t\r\n");
      out.write("\t\t\t\t\t\t\t<label style=\"padding-top: 3%;\">상품코드</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"pCode\" id=\"pCode\" style=\"width: 20%; margin-left: 10%; display: inline-block;\" placeholder=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <button type=\"button\" class=\"btn btn-inverse-info btn-rounded btn-icon\" id=\"addProductBtn\" style=\"float: right; margin-bottom: 4%; margin-right:6.5%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"mdi mdi-library-plus\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <table class=\"table product\" id=\"addProductTable\">\r\n");
      out.write("\t\t\t\t\t\t\t\t   <thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"border-color: white;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <th style=\"width: 11%;\"> <input type=\"checkbox\" id=\"selectAll\" onclick=\"selectAllCheckBox();\"/> </th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <th> 상품코드 </th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <th style=\"width: 21%;\"> 상품명 </th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <th> 수량 / 단위:box(x개) </th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <th><button type=\"button\" class=\"btn btn-inverse-danger btn-rounded btn-icon\" id=\"deleteItem\" onclick=\"deleteCheckedItem();\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"mdi mdi-delete-forever\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button></th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t   </thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t   <tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t\t\t   </tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label style=\"padding-top: 3%;\">요청수량</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"tAmount\" id=\"tAmount\" style=\"width: 20%; margin-left: 10%; display: inline-block;\" placeholder=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t  \t  <div class=\"form-group\"> \r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"departure\">출발센터(요청할 센터)</label>\r\n");
      out.write("\t\t\t\t\t\t\t  <select class=\"form-control\" name=\"departureCode\" id=\"departureCode\" onchange=\"selectCenter();\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option disabled selected>출발지</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
if(user.geteDept().equals("대구물류")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"GG\">경기광주센터</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
} else if (user.geteDept().equals("경기물류")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"TK\">대구센터</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"destination\">도착센터(본인 담당 센터)</label>\r\n");
      out.write("\t\t\t\t\t\t\t  <!-- <select class=\"form-control\" name=\"departure\" id=\"center2\" required> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<select class=\"form-control\" name=\"destinationCode\" id=\"destinationCode\" onchange=\"selectCenter();\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option disabled selected>도착지</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
if(user.geteDept().equals("대구물류")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"TK\">대구센터</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
} else if (user.geteDept().equals("경기물류")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"GG\">경기광주센터</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t\t  <!-- <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t  <label style=\"padding-top: 3%;\">요청일</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" name=\"tDate\" id=\"tDate\" readonly/>\r\n");
      out.write("<script>\r\n");
      out.write("  document.getElementById('tDate').valueAsDate = new Date();\r\n");
      out.write("</script>\r\n");
      out.write("\t\t\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t  </tr>\r\n");
      out.write("\t\t\t\t\t <!--  <tr>\r\n");
      out.write("\t\t\t\t\t\t<th class=\"kor\"><strong>비고</strong></th>\r\n");
      out.write("\t\t\t\t\t\t<td><textarea class=\"form-control\" name=\"comment\" id=\"comment\" cols=\"30\" rows=\"10\" placeholder=\"메모를 입력하세요.\"></textarea></td>\r\n");
      out.write("\t\t\t\t\t  </tr> -->\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t  </table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\" style=\"text-align: right;\">\r\n");
      out.write("\t\t\t  <h6 class=\"kor\"><strong style=\"margin-right: 20px;\">작성인 : </strong> ");
      out.print(user.geteDept() );
      out.write(" <span>");
      out.print(user.geteName() );
      out.write("</span></h6>\r\n");
      out.write("\t\t\t  <input type=\"hidden\" name=\"tWriter\" value=\"");
      out.print(user.geteName() );
      out.write("\"/>\r\n");
      out.write("\t\t\t  <h6 class=\"kor\">");
      out.print( today );
      out.write("</h6>\r\n");
      out.write("\t\t\t  <br />\r\n");
      out.write("\t\t\t   <button type=\"submit\" class=\"btn btn-gradient-primary btn-icon-text kor\" style=\"float: right;\"\r\n");
      out.write("\t\t\t   \t\t   onsubmit=\"submitApproval();\">\r\n");
      out.write("\t\t\t\t<i class=\"mdi mdi-file-check btn-icon-prepend\" ></i> 이송요청 </button>\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("          <!-- content-wrapper ends -->\r\n");
      out.write("          <!-- partial -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- main-panel ends -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- page-body-wrapper ends -->\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <!-- container-scroller -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- plugins:js -->\r\n");
      out.write("<script src=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/vendors/js/vendor.bundle.base.js\"></script>\r\n");
      out.write("<!-- endinject -->\r\n");
      out.write("<!-- Plugin js for this page -->\r\n");
      out.write("<script src=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/vendors/chart.js/Chart.min.js\"></script>\r\n");
      out.write("<!-- End plugin js for this page -->\r\n");
      out.write("<!-- inject:js -->\r\n");
      out.write("<script src=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/js/off-canvas.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/js/hoverable-collapse.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/js/misc.js\"></script>\r\n");
      out.write("<!-- endinject -->\r\n");
      out.write("<!-- Custom js for this page -->\r\n");
      out.write("<script src=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/js/dashboard.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(  request.getContextPath() );
      out.write("/resources/bootstrap/js/todolist.js\"></script>\r\n");
      out.write("  <script>\r\n");
      out.write("  var topEle = $('#topBtn');\r\n");
      out.write("  var delay = 1000;\r\n");
      out.write("  \r\n");
      out.write("  topEle.on('click', function() {\r\n");
      out.write("    $('html, body').stop().animate({scrollTop: 0}, delay);\r\n");
      out.write("  });\r\n");
      out.write("  </script>\r\n");
      out.write("<!-- End custom js for this page -->");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write(" \r\n");
      out.write("    \r\n");
      out.write("    /* 출발센터 선택 시 자동으로 도착센터가 정해짐 */\r\n");
      out.write("/*     function selectCenter() {\r\n");
      out.write("    \tlet $departureCode = $(\"#departureCode\").val();\r\n");
      out.write("    \tlet departureCodeNum =parseInt($departureCode.substring(1, 4));\r\n");
      out.write("    \t\r\n");
      out.write("    \tif(departureCodeNum == 1)\r\n");
      out.write("    \t\t$(\"#destinationCode\").val(\"대구센터\");\r\n");
      out.write("    \telse\r\n");
      out.write("    \t\t$(\"#destinationCode\").val(\"경기광주센터\");\r\n");
      out.write("    } */\r\n");
      out.write("    /* 수량체크 */\r\n");
      out.write("   /*  function numCheck(e){\r\n");
      out.write("    \tif(e.value == 0) {\r\n");
      out.write("    \t\tif(document.activeElement != e) {\r\n");
      out.write("    \t\t\talert(\"수량을 입력하세요.\");\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\te.select();\r\n");
      out.write("    \t}\r\n");
      out.write("    \telse if(e.value > 100){\r\n");
      out.write("    \t\talert(\"수량은 100박스 이하로 입력해주세요.\");\r\n");
      out.write("    \t\treturn false;\r\n");
      out.write("    \t}\r\n");
      out.write("    } */\r\n");
      out.write("    \r\n");
      out.write("    /* 발주서 작성 완료 */\r\n");
      out.write("/*   \tfunction submitApproval() {\r\n");
      out.write("    \tlet $tTitle = $(\"input[name='tTitle']\");\r\n");
      out.write("    \tlet $pCode = $(\"input[name='pCode']\");\r\n");
      out.write("    \tlet $tAmount = $(\"input[name='tAmount']\");\r\n");
      out.write("    \tlet $departureCode = $(\"input[name='departureCode']\");\r\n");
      out.write("    \tlet $detinationCode = $(\"input[name='detinationCode']\");\r\n");
      out.write("    \tlet $tDate= $(\"input[name='tDate']\");\r\n");
      out.write("\t\t\r\n");
      out.write("    \tfor(let i = 0; i<$tAmount.length; i++) {\r\n");
      out.write("    \t\tif($tAmount[i].value == \"\") {\r\n");
      out.write("    \t\t\talert(\"수량을 입력하세요.\");\r\n");
      out.write("    \t\t\t$tAmount[i].select();\r\n");
      out.write("    \t\t\treturn false;\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t$(\"#stockForm\").submit();\r\n");
      out.write("    }; */\r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("    <script>\r\n");
      out.write("  /*   $(function(){\r\n");
      out.write("\t$(\"[name=stockFrom]\").submit(function(){\r\n");
      out.write("\r\n");
      out.write("\t\tlet $tTitle = $(\"#tTitle\"); \r\n");
      out.write("\t\tlet $pCode = $(\"#pCode\");\r\n");
      out.write("\t\tlet $tAmount = $(\"#tAmount\");\r\n");
      out.write("\t\tlet $departureCode = $(\"#departureCode\");\r\n");
      out.write("\t\tlet $destinationCode = $(\"#destinationCode\");\r\n");
      out.write("\t\tlet $tDate = $(\"#tDate\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write(" */\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("\t\t");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

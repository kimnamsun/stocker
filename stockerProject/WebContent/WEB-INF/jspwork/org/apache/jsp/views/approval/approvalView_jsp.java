/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-07-09 01:36:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.approval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import approval.model.vo.Approval;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class approvalView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/views/approval/../common/meta.jsp", Long.valueOf(1593265000000L));
    _jspx_dependants.put("/views/approval/../common/footerScript.jsp", Long.valueOf(1593265640000L));
    _jspx_dependants.put("/views/approval/../common/header.jsp", Long.valueOf(1593330696000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("approval.model.vo.Approval");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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

	String contextPath = request.getContextPath();
	Approval a = (Approval) request.getAttribute("approval");
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	String str = sdf.format(today);

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
      out.write("\t <title>품의서 상세보기</title>\r\n");
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
      out.write("\t \r\n");
      out.write("<style>\r\n");
      out.write("input {\r\n");
      out.write(" background-color: white !important;\r\n");
      out.write("}\r\n");
      out.write(".footer1 {\r\n");
      out.write(" background-color: #f2edf3 !important;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--     <div class=\"container-scroller\"> -->\r\n");
      out.write("    <!-- partial -->\r\n");
      out.write("    <div class=\"container-fluid page-body-wrapper\">\r\n");
      out.write("      <!-- partial -->\r\n");
      out.write("      <div class=\"main-panel\" style=\"background-color: #f2edf3\">\r\n");
      out.write("        <div class=\"content-wrapper\">\r\n");
      out.write("            <i class=\"mdi mdi-close\" id=\"bannerClose\" style=\"display: none;\"></i>\r\n");
      out.write("          <div class=\"page-header\">\r\n");
      out.write("            <h3 class=\"page-title kor\">\r\n");
      out.write("          </div>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <p class=\"mb-0\"><h1 class=\"display-1\" style=\"text-align:center\">품의서</h1>\r\n");
      out.write("        <h2 style=\"text-align:center\"><small class=\"text-muted\">(이송요청 품의서)</small></h2>\r\n");
      out.write("        </p>\r\n");
      out.write("        <div class=\"col-lg-12 grid-margin stretch-card\"\r\n");
      out.write("        \t\t\tstyle=\"margin-top: 26px; width:300px; float:right\" >\r\n");
      out.write("\t\t  <div class=\"card\">\r\n");
      out.write("\t\t    <div class=\"card-body\">\r\n");
      out.write("\t\t    <table style=\"border-spacing:10px; text-align:center\">\r\n");
      out.write("\t\t            <th><strong>재고 담당</strong></th>\r\n");
      out.write("\t\t            <th><strong>이송 담당</strong></th>\r\n");
      out.write("\t\t            <th><strong>입고 담당</strong></th>\r\n");
      out.write("\t\t            <th><strong>출고 담당</strong></th>\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t          <td><input type=\"checkbox\" disabled checked></td>\r\n");
      out.write("\t\t          <td><input type=\"checkbox\" disabled checked></td>\r\n");
      out.write("\t\t          <td><input type=\"checkbox\" disabled checked></td>\r\n");
      out.write("\t\t          <td><input type=\"checkbox\" disabled checked></td>\r\n");
      out.write("\t\t    </table>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("        <div class=\"col-lg-12 grid-margin stretch-card\" style=\"margin-top: 26px\">\r\n");
      out.write("\t\t  <div class=\"card\">\r\n");
      out.write("\t\t    <div class=\"card-body\">\r\n");
      out.write("\t\t      <table class=\"table\">\r\n");
      out.write("\t\t        <thead>\r\n");
      out.write("\t\t        <h5>수신</h5>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("\t\t            <th><strong>부서</strong></th>\r\n");
      out.write("\t\t            <th>재고관리부서</th>\r\n");
      out.write("\t\t            <th><strong>성명</strong></th>\r\n");
      out.write("\t\t            <th>");
      out.print( a.getaRecipient());
      out.write("</th>\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t        </thead>\r\n");
      out.write("\t\t        <tbody>\r\n");
      out.write("\t\t        </tbody>\r\n");
      out.write("\t\t      </table>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("        <div class=\"col-lg-12 grid-margin stretch-card\" style=\"margin-top: 26px\">\r\n");
      out.write("\t\t  <div class=\"card\">\r\n");
      out.write("\t\t    <div class=\"card-body\">\r\n");
      out.write("\t\t      <table class=\"table\">\r\n");
      out.write("\t\t        <thead>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("\t\t            <th><strong>품의 코드</strong></th>\r\n");
      out.write("\t\t            <th>");
      out.print(a.getaCode() );
      out.write("</th>\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("\t\t            <th><strong>품의 제목</strong></th>\r\n");
      out.write("\t\t            <th>");
      out.print(a.getaTitle() );
      out.write("</th>\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t        </thead>\r\n");
      out.write("\t\t        <tbody>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("\t\t            <th><strong>품의 내용</strong></th>\r\n");
      out.write("\t\t            <th>\r\n");
      out.write("\t\t             <form class=\"forms-sample\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                      <label for=\"exampleInputUsername1\">상품코드</label>\r\n");
      out.write("                      <input type=\"text\" class=\"form-control\" value=\"");
      out.print(a.getaContentPcode() );
      out.write("\" readonly>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                      <label for=\"exampleInputUsername1\">수량</label>\r\n");
      out.write("                      <input type=\"text\" class=\"form-control\" value=\"");
      out.print(a.getaContentAmount() );
      out.write("\" readonly>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                      <label for=\"exampleInputUsername1\">출발센터</label>\r\n");
      out.write("                      <input type=\"text\" class=\"form-control\" value=\"");
      out.print( a.getaContentDeparture().equals("DG") ? "대구센터" : "경기광주 센터" );
      out.write("\" readonly>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                      <label for=\"exampleInputUsername1\">도착센터</label>\r\n");
      out.write("                      <input type=\"text\" class=\"form-control\" value=\"대구\" readonly>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </form>\r\n");
      out.write("\t\t            </th>\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("\t\t            <th><strong>비고</strong></th>\r\n");
      out.write("\t\t            <th><strong></strong></th>\r\n");
      out.write("\t\t          </tr>\r\n");
      out.write("\t\t        </tbody>\r\n");
      out.write("\t\t      </table>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t\t  <br />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-lg-12 grid-margin stretch-card footer1\" style=\"margin-top: -95px\">\r\n");
      out.write("\t\t  <div class=\"card\">\r\n");
      out.write("\t\t    <div class=\"card-body footer1\">\r\n");
      out.write("\t\t      <h6>위와 같은 사유로 품의서를 제출하오니 허가하여 주시기 바랍니다.</h6>\r\n");
      out.write("\t\t       <div class=\"card-body footer1\" style=\"text-align: right;\">\r\n");
      out.write("\t\t\t  <h6 class=\"kor\"><strong style=\"margin-right: 20px;\">작성인 : </strong> 재고담당 <span>김ㅇㅇ</span></h6>\r\n");
      out.write("\t\t\t  <h6 class=\"kor\">");
      out.print( str );
      out.write("</h6>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("\t\t      <!-- 결재완료 전에만 보이게 -->\r\n");
      out.write("\t\t       <div class=\"card-body footer1\" >\r\n");
      out.write("\t\t\t   <button type=\"button\" class=\"btn btn-gradient-primary btn-icon-text kor submitApproval\"\r\n");
      out.write("\t\t\t   \t\t\tstyle=\"margin-left:40%\" onclick=confirm()>\r\n");
      out.write("\t\t\t\t<i class=\"mdi mdi-file-check btn-icon-prepend\" ></i> 결재하기 </button>\t\t\r\n");
      out.write("\t\t      <button type=\"button\" class=\"btn btn-gradient-primary btn-rounded btn-icon\"\r\n");
      out.write("\t\t      style=\"float:right\" onclick=\"window.print()\">\r\n");
      out.write("                 <i class=\"mdi mdi-printer btn-icon-append\"></i></button>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- 결재완료 버튼 끝 -->\r\n");
      out.write("        <!-- content-wrapper ends -->\r\n");
      out.write("        <!-- partial -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- main-panel ends -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- page-body-wrapper ends -->\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- container-scroller -->\r\n");
      out.write("  ");
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
      out.write("<!-- End custom js for this page -->");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("function confirm(){\r\n");
      out.write(" alert(\"결재 완료 되었습니다.\")\r\n");
      out.write(" window.close();\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
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

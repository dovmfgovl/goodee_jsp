/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2023-12-15 03:47:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gym_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/include/gym_footer.jsp", Long.valueOf(1702261267768L));
    _jspx_dependants.put("/include/gym_header.jsp", Long.valueOf(1702429024391L));
    _jspx_dependants.put("/common/bootstrap_common.jsp", Long.valueOf(1702261267661L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>여기내GYM</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/main.css\" />\r\n");
      out.write("    <script src=\"https://developers.kakao.com/sdk/js/kakao.min.js\"></script>\r\n");
      out.write("    <script\r\n");
      out.write("      type=\"text/javascript\"\r\n");
      out.write("      src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=c5dd04594745b1c49f203dcc785c3dc5\"\r\n");
      out.write("    ></script>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"> \r\n");
      out.write("<script src=\"	https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function getLoc() {\r\n");
      out.write("            //insert here\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <!--================================================================  -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-sm bg-light navbar-light\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"\">여기내GYM</a>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\">\r\n");
      out.write("      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"#\">로그인</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("        <!-- \r\n");
      out.write("        확장자가 jsp이면 서블릿을 경유하지 않는다. - 목록에 보여줄 데이터가 없다?\r\n");
      out.write("        조회버튼 -> /notice/noticeList.gd요청하자 -  오라클 서버를 경유함\r\n");
      out.write("        확장자가 .gd이면 오라클 서버를 경유하니까 조회결과를 쥐고 있다.\r\n");
      out.write("        쥔다 - request.setAttribute() - 화면 출력하기\r\n");
      out.write("         -->\r\n");
      out.write("          <a class=\"nav-link active\" href=\"/notice/noticeList.gd\">공지사항</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"/board/boardList.jsp\">게시판</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"#\">회원관리</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"#\">QnA게시판</a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("    <!--================================================================  -->\r\n");
      out.write("    <!--================================================================  -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"main_header\"></div>\r\n");
      out.write("      <div class=\"main\">\r\n");
      out.write("        <div>이벤트존</div>\r\n");
      out.write("        <hr style=\"height: 2px\" />\r\n");
      out.write("        <div class=\"mapwrap\">\r\n");
      out.write("          <div class=\"map\" id=\"map\" style=\"width: 500px; height: 400px\">\r\n");
      out.write("            여기\r\n");
      out.write("          </div>\r\n");
      out.write("          <script type=\"text/javascript\">\r\n");
      out.write("            const container = document.getElementById(\"map\");\r\n");
      out.write("            const positions = [\r\n");
      out.write("              {\r\n");
      out.write("                content: '<div style=\"padding:5px;\">구디아카데미</div>',\r\n");
      out.write("                latlng: new kakao.maps.LatLng(37.476773, 126.879959),\r\n");
      out.write("              },\r\n");
      out.write("            ];\r\n");
      out.write("            const options = {\r\n");
      out.write("              center: positions[0].latlng,\r\n");
      out.write("              level: 4,\r\n");
      out.write("            };\r\n");
      out.write("            const map = new kakao.maps.Map(container, options);\r\n");
      out.write("          </script>\r\n");
      out.write("\r\n");
      out.write("          <input class=\"btnGeoloc\" type=\"button\" value=\"현재위치\" onclick=\"geoLoc()\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr style=\"height: 2px\" />\r\n");
      out.write("        <table class=\"table\" style=\"minwidth: 700px\">\r\n");
      out.write("          <tbody style=\"border: 1px solid lightgray\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td style=\"borderright: 1px solid lightgray\">주소</td>\r\n");
      out.write("              <td>\r\n");
      out.write("                서울특별시 금천구 가산디지털2로 95 KM타워 3층 (T: 02-818-7950)\r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td style=\"borderright: 1px solid lightgray\">버스</td>\r\n");
      out.write("              <td>\r\n");
      out.write("                디지털3단지 사거리 정류장<br />\r\n");
      out.write("                지선 5536/5714 간선 503/504 일반 21\r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td style=\"borderright: 1px solid lightgray\">지하철</td>\r\n");
      out.write("              <td>지하철 1, 7호선 가산디지털단지역 5번출구 200m</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"footer\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--================================================================  -->\r\n");
      out.write("    <!--================================================================  -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write(" <div class=\"navbar navbar-expand-sm bg-dark justify-content-center\">\r\n");
      out.write("    <a class=\"navbar-brand\"  style=\"color:white\"  href=\"#\">여기내GYM Copyright &copy; 2023</a>\r\n");
      out.write(" </div>");
      out.write("\r\n");
      out.write("    <!--================================================================  -->\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>IDEACRM</title>
    <%@ include file="/WEB-INF/views/includ/link.jsp"%>
    <!-- FooTable -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- orris -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
</head>
<style>
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox">
        <div class="ibox-title">
            <h5>고객 조회</h5>
        </div>
        <div class="ibox-content">
           <div class="row">
               <div class="col-lg-12">
                   <form:form>
                       <div class="row">
                           <div class="col-lg-4">
                               <input type="text" class="form-control form-control-sm">
                           </div>
                           <div class="col-lg-3">
                               <button type="button" class="btn btn-primary">검색</button>
                           </div>
                       </div>
                   </form:form>
               </div>
               <div class="col-lg-12">
                   <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                       <thead>
                       <tr>
                           <th>Rendering engine</th>
                           <th>Browser</th>
                           <th data-hide="phone,tablet">Platform(s)</th>
                           <th data-hide="phone,tablet">Engine version</th>
                           <th data-hide="phone,tablet">CSS grade</th>
                       </tr>
                       </thead>
                       <tbody>
                       <tr class="gradeX">
                           <td>Trident</td>
                           <td>Internet
                               Explorer 4.0
                           </td>
                           <td>Win 95+</td>
                           <td class="center">4</td>
                           <td class="center">X</td>
                       </tr>
                       <tr class="gradeC">
                           <td>Trident</td>
                           <td>Internet
                               Explorer 5.0
                           </td>
                           <td>Win 95+</td>
                           <td class="center">5</td>
                           <td class="center">C</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Trident</td>
                           <td>Internet
                               Explorer 5.5
                           </td>
                           <td>Win 95+</td>
                           <td class="center">5.5</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Gecko</td>
                           <td>Netscape Navigator 9</td>
                           <td>Win 98+ / OSX.2+</td>
                           <td class="center">1.8</td>
                           <td class="center">A</td>
                       </tr>

                       <tr class="gradeA">
                           <td>Webkit</td>
                           <td>Safari 1.3</td>
                           <td>OSX.3</td>
                           <td class="center">312.8</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Webkit</td>
                           <td>Safari 2.0</td>
                           <td>OSX.4+</td>
                           <td class="center">419.3</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Webkit</td>
                           <td>Safari 3.0</td>
                           <td>OSX.4+</td>
                           <td class="center">522.1</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Webkit</td>
                           <td>OmniWeb 5.5</td>
                           <td>OSX.4+</td>
                           <td class="center">420</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Webkit</td>
                           <td>iPod Touch / iPhone</td>
                           <td>iPod</td>
                           <td class="center">420.1</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Webkit</td>
                           <td>S60</td>
                           <td>S60</td>
                           <td class="center">413</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera 7.0</td>
                           <td>Win 95+ / OSX.1+</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera 7.5</td>
                           <td>Win 95+ / OSX.2+</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera 8.0</td>
                           <td>Win 95+ / OSX.2+</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera 8.5</td>
                           <td>Win 95+ / OSX.2+</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera 9.0</td>
                           <td>Win 95+ / OSX.3+</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera 9.2</td>
                           <td>Win 88+ / OSX.3+</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera 9.5</td>
                           <td>Win 88+ / OSX.3+</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Opera for Wii</td>
                           <td>Wii</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Nokia N800</td>
                           <td>N800</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Presto</td>
                           <td>Nintendo DS browser</td>
                           <td>Nintendo DS</td>
                           <td class="center">8.5</td>
                           <td class="center">C/A<sup>1</sup></td>
                       </tr>
                       <tr class="gradeC">
                           <td>KHTML</td>
                           <td>Konqureror 3.1</td>
                           <td>KDE 3.1</td>
                           <td class="center">3.1</td>
                           <td class="center">C</td>
                       </tr>
                       <tr class="gradeA">
                           <td>KHTML</td>
                           <td>Konqureror 3.3</td>
                           <td>KDE 3.3</td>
                           <td class="center">3.3</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeA">
                           <td>KHTML</td>
                           <td>Konqureror 3.5</td>
                           <td>KDE 3.5</td>
                           <td class="center">3.5</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeX">
                           <td>Tasman</td>
                           <td>Internet Explorer 4.5</td>
                           <td>Mac OS 8-9</td>
                           <td class="center">-</td>
                           <td class="center">X</td>
                       </tr>
                       <tr class="gradeC">
                           <td>Tasman</td>
                           <td>Internet Explorer 5.1</td>
                           <td>Mac OS 7.6-9</td>
                           <td class="center">1</td>
                           <td class="center">C</td>
                       </tr>
                       <tr class="gradeC">
                           <td>Tasman</td>
                           <td>Internet Explorer 5.2</td>
                           <td>Mac OS 8-X</td>
                           <td class="center">1</td>
                           <td class="center">C</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Misc</td>
                           <td>NetFront 3.1</td>
                           <td>Embedded devices</td>
                           <td class="center">-</td>
                           <td class="center">C</td>
                       </tr>
                       <tr class="gradeA">
                           <td>Misc</td>
                           <td>NetFront 3.4</td>
                           <td>Embedded devices</td>
                           <td class="center">-</td>
                           <td class="center">A</td>
                       </tr>
                       <tr class="gradeX">
                           <td>Misc</td>
                           <td>Dillo 0.8</td>
                           <td>Embedded devices</td>
                           <td class="center">-</td>
                           <td class="center">X</td>
                       </tr>
                       <tr class="gradeX">
                           <td>Misc</td>
                           <td>Links</td>
                           <td>Text only</td>
                           <td class="center">-</td>
                           <td class="center">X</td>
                       </tr>
                       <tr class="gradeX">
                           <td>Misc</td>
                           <td>Lynx</td>
                           <td>Text only</td>
                           <td class="center">-</td>
                           <td class="center">X</td>
                       </tr>
                       <tr class="gradeC">
                           <td>Misc</td>
                           <td>IE Mobile</td>
                           <td>Windows Mobile 6</td>
                           <td class="center">-</td>
                           <td class="center">C</td>
                       </tr>
                       <tr class="gradeC">
                           <td>Misc</td>
                           <td>PSP browser</td>
                           <td>PSP</td>
                           <td class="center">-</td>
                           <td class="center">C</td>
                       </tr>
                       <tr class="gradeU">
                           <td>Other browsers</td>
                           <td>All others</td>
                           <td>-</td>
                           <td class="center">-</td>
                           <td class="center">U</td>
                       </tr>
                       </tbody>
                       <tfoot>
                       <tr>
                           <td colspan="5">
                               <ul class="pagination float-right"></ul>
                           </td>
                       </tr>
                       </tfoot>
                   </table>
               </div>
           </div>
        </div>
    </div>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('#daterange').daterangepicker();
        $('#daterange2').daterangepicker();
    });
</script>
</body>
</html>

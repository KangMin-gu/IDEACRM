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
    .footable > tbody > tr > td{
        cursor:pointer;
    }
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
                   <button class="btn btn-default pull-right" onclick="makeCustAddBtn();">추가</button>
                   <div id="filter-form-container"></div>
                   <table class="searchCust footable table table-striped">
                       <thead>
                       <tr>
                           <th data-visible="false" data-name="CUSTNO">고객번호</th>
                           <th data-name="CUSTNAME" >고객명</th>
                           <th data-name="MOBILE">핸드폰</th>
                           <th data-name="HOMTEL">집전화</th>
                           <th data-name="WRKTEL">직장전화</th>
                           <th data-name="HOMADDR">주소</th>
                       </tr>
                       </thead>
                       <tfoot>
                       <tr>
                           <td>
                               <select class="form-control" id="paging" style="width:80px">
                                   <c:forEach var="paging" items="${PAGING}">
                                       <option vale="${paging.codeval}">${paging.codename}</option>
                                   </c:forEach>
                               </select>
                           </td>
                           <td colspan="4">
                               <ul class="pagination pull-right"></ul>
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
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<!-- api js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>

<script>
    $(document).ready(function() {
        footableSearchList('/voc/pop/custsearch', $('.searchCust') );
    });
</script>
</body>
</html>

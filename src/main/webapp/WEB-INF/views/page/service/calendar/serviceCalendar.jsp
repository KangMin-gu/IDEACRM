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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/fullcalendar.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/fullcalendar.print.css" rel='stylesheet' media='print'>
</head>
<style>
</style>
<body>
<c:set var="menuactive" value='serviceCallendar'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>서비스 일정</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>서비스 일정</strong>
                    </li>
                </ol>
            </div>
        </div>


        <div class="wrapper wrapper-content">
            <div class="row animated fadeInDown">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>서비스 일정</h5>
                        </div>
                        <div class="ibox-content">
                            <input type="hidden" id="schList" name="schList" value='${schList }'/>
                            <div id="calendar"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- Full Calendar -->
<script src="${pageContext.request.contextPath}/resources/js/fullcalendar.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/service_calendar.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script>
    $(document).ready(function() {


    });

</script>
</body>
</html>

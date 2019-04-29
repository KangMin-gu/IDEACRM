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
            <h5>SMS 발송</h5>
        </div>
        <div class="ibox-content">
            <div class="table-responsive">
                <table class="table table-bordered" style="white-space:nowrap;">
                    <colgroup>
                        <col width="20%">
                        <col width="30%">
                        <col width="20%">
                        <col width="30%">
                    </colgroup>
                    <tr>
                        <th>고객명</th>
                        <td>강민구</td>
                        <th>고객번호</th>
                        <td>01071203655</td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea name="need" id="" class="form-control" style="resize: none;" rows="10"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>글자수</th>
                        <td colspan="3">10/90</td>
                    </tr>
                </table>
                <button type="button" class="btn btn-default pull-left">취소</button>
                <button type="button" class="btn btn-default pull-right" >발송</button>
            </div>
        </div>
    </div>



            <div class="tabs-container">
                <ul class="nav nav-tabs" role="tablist">
                    <li><a class="nav-link active" data-toggle="tab" href="#tab-1">자주쓰는 멘트</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" id="tab-1" class="tab-pane active">
                        <div class="panel-body">
                            <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                                <thead>
                                <tr>
                                    <th>템플릿명</th>
                                    <th data-hide="phone,tablet">내용</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="gradeA">
                                    <td>Presto</td>
                                    <td>Opera for Wii</td>
                                </tr>
                                <tr class="gradeA">
                                    <td>Presto</td>
                                    <td>Nokia N800</td>
                                </tr>
                                <tr class="gradeA">
                                    <td>KHTML</td>
                                    <td>Konqureror 3.3</td>
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
    });
</script>
</body>
</html>
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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-12">
            <button type="button" style="margin-left:5px;" class="btn btn-default pull-right" id="passDiv">수동분배</button>
            <button type="button" style="margin-left:5px;" class="btn btn-default pull-right" id="autoDiv">자동분배</button>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 ibox-left">
            <div class="ibox">
                <div class="ibox-title">
                    <h5>콜백 리스트</h5>
                </div>
                <div class="ibox-content">

                    <div class="row">
                        <div class="col-lg-8"></div>
                        <div class="col-lg-4">
                            <div class="input-group">
                                <!-- /btn-group -->
                                <input type="text" class="form-control reset" placeholder="콜백 번호" autocomplete="off" name="callback" id="callback" value="${search.callback }">
                                <span class="input-group-btn">
                            <button id="leftSearch" class="btn btn-primary" style="height: 35px;">검색</button>
                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped ibox-left" style="white-space:nowrap;">
                            <colgroup>
                                <col width="5%">
                                <col width="5%">
                                <col width="10%">
                                <col width="5%">
                            </colgroup>
                            <thead>
                            <tr>
                                <th><input type="checkbox" class="i-checks icheckAll" id="call"/></th>
                                <th>발신번호</th>
                                <th>사용자 ID</th>
                                <th>콜백번호</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>

                            </tr>
                            </tbody>
                            <tfoot>
                            </tfoot>

                        </table>
                    </div>
                    <div class="m-auto">
                        <ul class="pagination" style="margin-top: 8px;">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-6 ibox-right">
            <div class="ibox">
                <div class="ibox-title">
                    <h5>사용자 리스트</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-lg-8"></div>
                        <div class="col-lg-4">
                            <div class="input-group owner" id="owner_">
                                <!-- /btn-group -->
                                <input type="text" class="form-control reset" readonly autocomplete="off" name="owner_" value="${search.owner_ }">
                                <input type="hidden" class="reset" name="owner" id="owner" value="${search.owner }">
                                <span class="input-group-btn">
                                <button  class="btn btn-primary" style="height: 35px;">검색</button>
                        </span>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-striped ibox-right cti-user-list" style="white-space:nowrap;">
                            <colgroup>
                                <col width="5%">
                                <col width="5%">
                                <col width="10%">
                                <col width="5%">
                            </colgroup>
                            <thead>
                            <tr>
                                <th><input type="checkbox" class="i-checks icheckAll" id="user"/></th>
                                <th>사용자명</th>
                                <th>사용자 ID</th>
                                <th>할당 콜백수</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>

                            </tr>
                            </tbody>
                            <tfoot>
                            </tfoot>
                        </table>
                    </div>
                    <div class="m-auto">
                        <ul class="pagination" style="margin-top: 8px;">
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/includ/popJs.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script> <!-- radioBox-->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc_callback_div.js"></script>

<script>
    $(document).ready(function () {
        //footableSearchList('/cust', $('.callList'));
        //footableSearchList('/service', $('.userList'));
        callBackList(1);
        ctiUserList(1);
    });

</script>
</body>
</html>
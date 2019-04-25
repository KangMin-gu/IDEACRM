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
    <link href="${pageContext.request.contextPath}/resources/css/footable.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
</head>
<style>
</style>
<body>

<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <c:set var="urls" value="${requestScope['javax.servlet.forward.request_uri']}" />
                <h2>서비스 관리</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <c:choose>
                        <c:when test="${fn:substring(urls, 0, 17) eq '/service/delivery' }">
                            <li class="breadcrumb-item active">
                                <strong>서비스 이관 목록</strong>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="breadcrumb-item active">
                                <strong>서비스 목록</strong>
                            </li>
                        </c:otherwise>
                    </c:choose>

                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-content" >
                            <div class="table-responsive">
                                <table style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="10%">
                                        <col width="5%">
                                        <col width="10%">
                                        <col width="5%">
                                        <col width="10%">
                                        <col width="5%">
                                        <col width="10%">
                                        <col width="5%">
                                        <col width="10%">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>접수일</th>
                                        <td>
                                            <div class="input-group" style="width:230px;">
                                                <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                <input class="form-control form-control-sm daterange searchparam" autocomplete="off" name="receptiondate" id="receptiondate" type="text" />
                                            </div>
                                        </td>
                                        <th>접수구분</th>
                                        <td>
                                            <select class="form-control searchparam" name="servicetype" id="servicetype" style="width: 150px;">
                                                <option value="">선택</option>
                                                <c:forEach var="serviceType" items="${SERVICETYPE}">
                                                    <option value="${serviceType.codeval}">${serviceType.codename}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <th>접수유형</th>
                                        <td colspan="1">
                                            <div style="display: inline-block">
                                                <select class="form-control searchparam" name="servicecode1" id="servicecode1" style="width: 100px;">
                                                    <option value="">선택</option>
                                                    <c:forEach var="serviceCode1" items="${SERVICECODE1}">
                                                        <option value="${serviceCode1.codeval}">${serviceCode1.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <select class="form-control searchparam" name="servicecode2" id="servicecode2" upper ="servicecode1" style="width: 100px;">
                                                    <option value="">선택</option>
                                                </select>
                                            </div>
                                        </td>
                                        <c:choose>
                                            <c:when test="${sessionScope.CHKAUTH eq 20 or sessionScope.CHKAUTH eq 30}">
                                                <th>접수자</th>
                                                <td class="input-group" id="serviceowner_" style="width: 150px;">
                                                    <input class="form-control form-control-sm searchparam" name="serviceowner_" type="text">
                                                    <input type="hidden" class="searchparam" name="serviceowner" id="serviceowner" value="${search.serviceowner }">
                                                    <span class="input-group-addon owner" id="serviceowner_">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <th>접수자</th>
                                                <td class="input-group" id="serviceowner_" style="width: 150px;">
                                                    <input class="form-control form-control-sm searchparam" disabled name="serviceowner_" type="text" value="">
                                                    <input type="hidden" class="searchparam" name="serviceowner" id="serviceowner" value="">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>

                                        <td>
                                            <button type="button" id="search" class="btn btn-w-m btn-primary">검색</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>서비스명</th>
                                        <td colspan="1">
                                            <input class="form-control form-control-sm searchparam" type="text" id="servicename" name="servicename" style="width: 230px;">
                                        </td>
                                        <th>고객명</th>
                                        <td>
                                            <div class="input-group" style="width: 150px;">
                                                <input type="text" class="form-control searchparam" autocomplete="off" name="custno_" value="">
                                                <input type="hidden" class="searchparam" name="custno" id="custno" value="">
                                                <span class="input-group-addon cust" id="custno_">
                                                    <a><i class="fa fa-search"></i></a>
                                                </span>
                                            </div>
                                        </td>
                                        <th>처리상태</th>
                                        <td>
                                            <select class="form-control searchparam" name="servicestep" id="servicestep" style="width: 203px;">
                                                <option value="">선택</option>
                                                <c:forEach var="serviceStep" items="${SERVICESTEP}">
                                                    <option value="${serviceStep.codeval}">${serviceStep.codename}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <c:choose>
                                            <c:when test="${sessionScope.CHKAUTH eq 20 or sessionScope.CHKAUTH eq 30}">
                                                <th>담당자</th>
                                                <td>
                                                    <div class="input-group" style="width: 150px;">
                                                        <input type="text" class="form-control searchparam" autocomplete="off" name="owner_" value="">
                                                        <input type="hidden" class="searchparam" name="owner" id="owner" value="">
                                                        <span class="input-group-addon owner" id="owner_">
                                                    <a><i class="fa fa-search"></i></a>
                                                </span>
                                                    </div>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <th>담당자</th>
                                                <td>
                                                    <div class="input-group" style="width: 150px;">
                                                        <input type="text" class="form-control searchparam" autocomplete="off" name="owner_" value="${sessionScope.USERNAME}">
                                                        <input type="hidden" class="searchparam" name="owner" id="owner" value="${sessionScope.USERNO}">
                                                        <span class="input-group-addon">
                                                    <a><i class="fa fa-search"></i></a>
                                                </span>
                                                    </div>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>

                                        <td>
                                            <button type="button" id="reset" class="btn btn-w-m btn-default">초기화</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>서비스 목록</h5>
                        </div>
                        <div class="ibox-content">
                            <div>
                                <div style="display: inline-block;">
                                    <select class="form-control" id="paging" style="width:80px;margin-left: 10px;">
                                        <c:forEach var="paging" items="${PAGING}">
                                            <option vale="${paging.codeval}">${paging.codename}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="pull-right" style="display: inline-block;">
                                    <a href="/service/input" class="btn btn-default pull-right" style="margin-left: 5px;">추가</a>
                                </div>
                                <div class="pull-right"  style="display: inline-block;">
                                    <c:choose>
                                        <c:when test="${fn:substring(urls, 0, 17)  eq '/service/delivery' }">
                                            <a href="/serviceexcel?servicestep1=5,6" class="btn btn-default"><i class="fa fa-file-excel-o"></i></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/serviceexcel" class="btn btn-default "><i class="fa fa-file-excel-o"></i></a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <table class="footable table table-striped">
                                <thead>
                                <tr>
                                    <th data-visible="false" data-name="NO">서비스번호</th>
                                    <th data-visible="false" data-name="URL">URL</th>
                                    <th data-name="SERVICENAME_" data-formatter="serviceformatter">서비스명</th>
                                    <th data-name="SERVICETYPE_" data-breakpoints="xs sm">접수구분</th>
                                    <th data-name="SERVICECODE_" data-breakpoints="xs sm">접수유형</th>
                                    <th data-name="CUSTNAME_" data-breakpoints="xs sm">고객명</th>
                                    <th data-name="RECEPTIONDATE_" data-breakpoints="xs sm" data-sorted="true" data-direction="DESC" >접수일</th>
                                    <th data-name="SERVICEOWNER_" data-breakpoints="xs sm">접수자</th>
                                    <th data-name="OWNER_" data-breakpoints="xs sm">담당자</th>
                                    <th data-name="SERVICESTEP_">처리상태</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <td>
                                        <div class="footable-pagination-wrapper">
                                            <ul class="pagination"></ul>
                                        </div>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
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

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- api js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/crud/service.js"></script>
<script>
    $(document).ready(function() {
        var url = window.location.pathname;
        if(url != '/service'){
            url = '/service?servicestep1=5,6';
        }

        $('#search').click(function(e){
            var bool = dateRangeError();
            if(bool){
                footableSearchList(url);
            }
        });
        footableSearchList(url);
    });
</script>
</body>
</html>
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
                <h2>사용자 목록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>사용자 목록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">

                        <div class="ibox-content">
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
                                            <col width="5%">
                                            <col width="10%">
                                        </colgroup>
                                        <tbody>
                                        <tr>
                                            <th>이름</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <input class="form-control form-control-sm searchparam" type="text" id="username" name="username"  />
                                                </div>
                                            </td>
                                            <th>ID</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="userid" name="userid">
                                            </td>
                                            <th>직책</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="userduty" name="userduty">
                                            </td>

                                            <td>
                                                <button type="button" id="search" class="btn btn-w-m btn-primary">검색</button>
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
                            <h5>사용자 목록</h5>
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
                                    <a href="/company/user/input" class="btn btn-default pull-right">추가</a>
                                </div>
                            </div>
                            <table class="footable table table-striped" >
                                <thead>
                                <tr>
                                    <th data-visible="false" data-name="NO">고객번호</th>
                                    <th data-visible="false" data-name="URL">URL</th>
                                    <th data-name="USERNAME" data-formatter="formatter">사용자명</th>
                                    <th data-name="USERID" data-breakpoints="xs sm">사용자ID</th>
                                    <th data-name="MOBILE" data-breakpoints="xs sm">전화번호</th>
                                    <th data-name="EMAIL" data-breakpoints="xs sm">이메일</th>
                                    <th data-name="USERDUTY" data-breakpoints="xs sm">직책</th>
                                    <th data-name="FREGDATE_" data-breakpoints="xs sm">입사일자</th>
                                    <th data-name="CHKAUTH_" data-breakpoints="xs sm">사용자권한</th>
                                    <th data-name="REGDATE" data-breakpoints="xs sm" data-sorted="true" data-direction="DESC">등록일자</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
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
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script>
    $(document).ready(function() {
        $('#search').click(function(e){
            footableSearchList('/company/user')
        });
        footableSearchList('/company/user')
    });
</script>
</body>
</html>

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
                                            <th>등록일</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                    <input class="form-control form-control-sm" type="text" id="daterange"  />
                                                </div>
                                            </td>
                                            <th>ID</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="width: 150px;">
                                            </td>
                                            <th>이름</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="width: 150px;">
                                            </td>
                                            <th>활성상태</th>
                                            <td>
                                                <select class="form-control" style="width:100px;">
                                                    <option value="Bahamas">활성</option>
                                                    <option value="Bahrain">비활성</option>
                                                </select>
                                            </td>
                                            <th>직책</th>
                                            <td>
                                                <select class="form-control" style="width:100px;">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </td>
                                            <td>
                                                <button type="button" id="search" class="btn btn-w-m btn-primary">검색</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>전화번호</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="width: 150px;">
                                            </td>
                                            <th>휴대전화</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="width: 150px;">
                                            </td>
                                            <th>이메일</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="width: 150px;">
                                            </td>
                                            <th>CTI번호</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="width: 150px;">
                                            </td>
                                            <th>활성상태</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="width: 150px;">
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-w-m btn-default">초기화</button>
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
                            <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
                            <a href="/company/user/input" class="btn btn-default pull-right">추가</a>
                            <table class="footable table table-stripped"  data-paging="true">
                                <thead>
                                <tr>
                                    <th data-visible="false" data-sorted="true" data-direction="DESC" data-name="NO">고객번호</th>
                                    <th data-visible="false" data-name="URL">URL</th>
                                    <th data-name="USERNAME" data-formatter="formatter">사용자명</th>
                                    <th data-name="USERID" data-breakpoints="xs sm">사용자ID</th>
                                    <th data-name="USERDUTY" data-breakpoints="xs sm">직책</th>
                                    <th data-name="FREGDATE_" data-breakpoints="xs sm">입사일자</th>
                                    <th data-name="ISDELETE_" data-breakpoints="xs sm">사용자상태</th>
                                    <th data-name="REGDATE_" data-breakpoints="xs sm">등록일시</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
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
            var bool = dateRangeError();
            if(bool){
                footableSearchList('/company/user');
            }
        });
        footableSearchList('/company/user');
    });
</script>
</body>
</html>

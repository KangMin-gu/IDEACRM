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
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
</head>
<style>
</style>
<body>
<c:set var="menuactive" value='vocnoticeM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>콜센터 공지사항</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>공지사항 목록</strong>
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

                        <div class="ibox-content" >
                            <form:form id="noticeListSearchFrom" action="/voc/notice">
                                <div class="table-responsive">
                                    <table style="white-space:nowrap;">
                                        <colgroup>
                                            <col width="5%">
                                            <col width="20%">
                                            <col width="5%">
                                            <col width="20%">
                                            <col width="5%">
                                            <col width="20%">
                                            <col width="5%">
                                            <col width="20%">
                                        </colgroup>
                                        <tbody>
                                        <tr>
                                            <th>등록일</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                    <input class="form-control form-control-sm daterange searchparam" type="text" id="regdate" name="regdate" />
                                                </div>
                                            </td>
                                            <th>제목</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" id="title" name="title" style="width: 150px;">
                                            </td>
                                            <th>글쓴이</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" id="writer" name="writer" style="width: 150px;">
                                            </td>
                                            <th>말머리</th>
                                            <td>
                                                <select class="form-control searchparam" style="width:100px;" id="tag" name="tag">
                                                        <option value="">선택</option>
                                                    <c:forEach var="tag" items="${TAG}">
                                                        <option value="${tag.codeval}">${tag.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-w-m btn-primary" id="noticeListSearch">검색</button>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-w-m btn-default" id="reset">초기화</button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>공지사항</h5>
                            <div class=" pull-right" style="margin-bottom: 0px;top: 9px;right: 15px;bottom: 0px;">
                                <c:if test="${CHKAUTH eq 20 || CHKAUTH eq 30}">
                                 <a class="btn btn-default" href="/voc/notice/input">추가</a>
                                </c:if>
                            </div>
                        </div>
                        <div class="ibox-content">
                                <table class="footable table table-striped vocNotice">
                                    <thead>
                                    <tr>
                                        <th data-name="NTNUM" data-visible="false">
                                        <th data-name="TAGNAME" data-filterable="true">말머리</th>
                                        <th data-name="TITLE" data-formatter="vocNoticeListFormatter" data-filterable="true">제목</th>
                                        <th data-name="WRITER" data-filterable="true">글쓴이</th>
                                        <th data-name="REGDATE" data-filterable="true">날짜</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
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
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/notice.js"></script>
<script>
   $(document).ready(function() {
        var url = window.location.pathname;
        var bool = dateRangeError();
        if(bool)  footableSearchList(url, $('.vocNotice'));

        $('#noticeListSearch').click(function(e){
            footableSearchList(url, $('.vocNotice'));
        });
    });
</script>
</body>
</html>

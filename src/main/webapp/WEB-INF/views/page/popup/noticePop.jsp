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
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox">

                <div class="ibox-content" >
                    <form:form id="noticeListSearchFrom" action="/pop/notice">
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
                </div>
                <div class="ibox-content">
                    <div style="margin-left: 8px;">
                        <div style="display: inline-block;">
                            <select class="form-control" id="paging" style="width:80px">
                                <c:forEach var="paging" items="${PAGING}">
                                    <option vale="${paging.codeval}">${paging.codename}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                        <table class="footable table table-striped popNotice">
                            <thead>
                            <tr>
                                <th data-name="NTNUM" data-visible="false" data-filterable="true">
                                <th data-name="TAGNAME" data-filterable="true">말머리</th>
                                <th data-name="TITLE" data-formatter="popNoticeListFormatter" data-filterable="true">제목</th>
                                <th data-name="WRITER" data-filterable="true">글쓴이</th>
                                <th data-name="REGDATE" data-filterable="true" data-direction="DESC">날짜</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <td>
                                    <div class="footable-pagination-wrapper" style="text-align:center;">
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

</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/popJs.jsp"%>
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
        if(bool)  footableSearchList(url, $('.popNotice'));

        $('#noticeListSearch').click(function(e){
            footableSearchList(url, $('.popNotice'));
        });
    });
</script>
</body>
</html>

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
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
</head>
<style>
</style>
<body>
<c:set var="menuactive" value='formatM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>서식 목록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>서식 목록</strong>
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
                            <form:form>
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
                                            <th>서식명</th>
                                            <td>
                                                <input class="form-control form-control searchparam" id="formatname" name="formatname" type="text" style="width: 200px;">
                                            </td>
                                            <th>사용메뉴</th>
                                            <td>
                                                <select class="form-control searchparam" id="usemenu" name="usemenu" style="width:100px;">
                                                    <option value="">선택</option>
                                                    <c:forEach var="license" items="${license}">
                                                        <option value="${license.LICENSENO}">${license.LICENSENAME}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <th>발송매체</th>
                                            <td>
                                                <select class="form-control searchparam" id="sendtype" name="sendtype" style="width:100px;">
                                                    <option value="">선택</option>
                                                    <c:forEach var="formType" items="${FORMTYPE}">
                                                        <option value="${formType.codeval}">${formType.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td>
                                                <button type="button" id="search" class="btn btn-w-m btn-primary">검색</button>
                                            </td>
                                            <td>
                                                <button type="button" id="reset" class="btn btn-w-m btn-default">초기화</button>
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
                            <h5>서식 목록</h5>
                            <div class=" pull-right" style="margin-bottom: 0px;top: 9px;right: 15px;bottom: 0px;">
                                <a class="btn btn-default" href="/company/format/input">추가</a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <table class="footable table table-striped formatList">
                                <thead>
                                <tr>
                                    <th data-visible="false" data-name="NO">서식번호</th>
                                    <th data-visible="false" data-name="URL">URL</th>
                                    <th data-name="FORMATNAME" data-formatter="formatter">서식명</th>
                                    <th data-name="USEMENU_">사용메뉴</th>
                                    <th data-name="SENDTYPE_">발송매체</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
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

<!--js includ  ssss-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!-- api js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script>
    $(document).ready(function() {
        footableSearchList('/company/format', $('.formatList'));

        $('#search').click(function(e){
            footableSearchList('/company/format', $('.formatList'));
        });
    });
</script>
</body>
</html>

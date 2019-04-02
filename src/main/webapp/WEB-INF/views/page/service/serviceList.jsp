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
                <h2>서비스 목록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>서비스 목록</strong>
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
                            <form:form action="/service/list" method="get">
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
                                                    <input class="form-control form-control-sm daterange searchparam" name="RECEIPTDATEN" type="text" />
                                                </div>
                                            </td>
                                            <th>접수구분</th>
                                            <td>
                                                <select class="form-control searchparam" name="servicetype" id="servicetype" style="width: 100px;">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </td>
                                            <th>접수유형</th>
                                            <td colspan="1">
                                                <div style="display: inline-block">
                                                    <select class="form-control searchparam" name="servicecode1" id="servicecode1" style="width: 100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control searchparam" name="servicecode2" id="servicecode2" style="width: 100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                            </td>
                                            <th>접수자</th>
                                            <td class="input-group owner" id="serviceowner_">
                                                <input class="form-control form-control-sm searchparam" name="serviceowner_" type="text" style="width: 100px;">
                                                <input type="hidden" class="reset" name="serviceowner" id="serviceowner" value="${search.serviceowner }">
                                                <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                            </td>
                                            <td>
                                                <button type="button" id="search" class="btn btn-w-m btn-primary">검색</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>서비스명</th>
                                            <td colspan="1">
                                                <input class="form-control form-control-sm searchparam" type="text" id="servicename" name="servicename" style="width: 150px;">
                                            </td>
                                            <th>거래처명</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;">
                                            </td>
                                            <th>고객명</th>
                                            <td>
                                                <div class="input-group custno_" style="width:180px;">
                                                    <span class="input-group-addon" style="height:31px;"><i class="fa fa-search fa-sm"></i></span>
                                                    <input class="form-control form-control-sm daterange searchparam" name="custno_" type="text" />
                                                    <input class="form-control form-control-sm daterange searchparam" name="custno" id="custno" type="text" />
                                                </div>
                                            </td>
                                            <th>담당자</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;">
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-w-m btn-default">초기화</button>
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
                            <h5>서비스 목록</h5>
                            <div class="ibox-tools">
                                <a href="/servicedetail">디테일화면1</a>
                                <a href="/serviceinsert">입력화면</a>
                                <a href="/servicedetail">담당자팝업테스트</a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
                            <table class="footable table table-stripped" data-sorting="true">
                                <thead>
                                <tr>
                                    <th data-visible="false" data-name="SERVICENO">서비스번호</th>
                                    <th data-visible="false" data-name="URL">URL</th>
                                    <th data-name="SERVICENAME_" data-formatter="formatter">서비스명</th>
                                    <th data-name="SERVICETYPE_" data-breakpoints="xs sm">접수구분</th>
                                    <th data-name="SERVICECODE_" data-breakpoints="xs sm">접수유형</th>
                                    <th data-name="CUSTNAME_" data-breakpoints="xs sm">고객명</th>
                                    <th data-name="CLINAME_" data-breakpoints="xs sm">거래처명</th>
                                    <th data-name="RECEPTIONDATE_" data-breakpoints="xs sm">접수일</th>
                                    <th data-name="SERVICEOWNER_" data-breakpoints="xs sm">접수자</th>
                                    <th data-name="OWNER_" data-breakpoints="xs sm">담당자</th>
                                    <th data-name="SERVICESTEP_">처리상태</th>
                                </tr>
                                </thead>
                                <tbody class="test">

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

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- common js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script>
    $(document).ready(function() {

        $('.footable').on("after.ft.breakpoints",function(e,ft,row){
           var test = row.value.SERVICENO;
           var RowElement = $(row.$el)
            if(test){
            }
        });
        $('#search').click(function(e){

            footableSearchList('/service/list');

        });

        footableSearchList('/service/list');
    });


</script>
</body>
</html>

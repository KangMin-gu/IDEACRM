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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/jsTree/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<style>
    .jstree-open > .jstree-anchor > .fa-folder:before {
        content: "\f07c";
    }

    .jstree-default .jstree-icon.none {
        width: 0;
    }
</style>
<body>
<c:set var="menuactive" value='orderM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>주문 관리</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>주문 관리</strong>
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
                            <form:form id="orderListSerchForm" action="/orderlist">
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
                                            <th>구매일</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                    <input class="form-control form-control-sm daterange searchparam" type="text" id="regdate" name="regdate" />
                                                </div>
                                            </td>
                                            <th>결제일</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                    <input class="form-control form-control-sm daterange searchparam" type="text" id="paydate" name="paydate" />
                                                </div>
                                            </td>
                                            <th>주문번호</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 230px;" id="ordernum" name="ordernum" data-filterable="true">
                                            </td>
                                            <td colspan="2">
                                                <button type="button" class="btn btn-w-m btn-primary" id="custListSearch">검색</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>구매자</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="custname" name="custname" data-filterable="true">
                                            </td>
                                            <th>수신자</th>
                                            <td><input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="deliveryname" name="deliveryname" data-filterable="true"></td>
                                            <th>휴대전화</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="mobile" name="mobile" data-filterable="true">
                                            </td>
                                            <td >
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
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>회원사 고객 목록</h5>
                        <div class=" pull-right" style="margin-bottom: 0px;top: 9px;right: 15px;bottom: 0px;">
                            <form id="orderExcel" action="/orderexcel" method="get">
                                <input type="hidden" id="orderdate" name="orderdate">
                                <button class="btn btn-default" type="submit"><i class="fa fa-file-excel-o"></i></button>
                            </form>
                  <!--          <form id="orderExcels" action="/test" method="get">
                                <input type="hidden" id="orderdates" name="orderdates">
                                <button class="btn btn-default" type="submit"><i class="fa fa-file-excel-o"> 엑셀test</i></button>
                            </form>-->
                        </div>
                    </div>
                    <div class="ibox-content">
                            <table class="footable table table-striped orderList">
                                <thead>
                                <tr>
                                    <th data-name="BUYNO" data-breakpoints="xs sm">주문번호</th>
                                    <th data-name="PRDNAME" data-breakpoints="xs sm">제품명</th>
                                    <th data-name="PRDEA" data-breakpoints="xs sm">수량</th>
                                    <th data-name="PRDVALUE" data-breakpoints="xs sm">제품코드</th>
                                    <th data-name="ERPNO" data-breakpoints="xs sm">회사코드</th>
                                    <th data-name="PRDPRICE" data-breakpoints="xs sm">결제금액</th>
                                    <th data-name="REGDATE" data-breakpoints="xs sm">결제일</th>
                                    <th data-name="CUSTNAME">구매자</th>
                                    <th data-name="DELIVERYNAME" data-breakpoints="xs sm">수신자</th>
                                    <th data-name="MOBILE" data-breakpoints="xs sm">휴대폰</th>
                                    <th data-name="HOMTEL" data-breakpoints="xs sm">자택전화</th>
                                    <th data-name="ADDR" data-breakpoints="xs sm">주소</th>
                                </tr>
                                </thead>
                                <tfoot>
                                </tfoot>
                            </table>
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
<script src="${pageContext.request.contextPath}/resources/js/crud/orderList.js.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function() {
        var bool = dateRangeError();
        if(bool)  footableSearchList('/orderlist', $('.orderList'));

    });


    $('#custListSearch').click(function(e){
        footableSearchList('/orderlist', $('.orderList'));
    });

    $('#regdate').change(function(){
       $('#orderdate').val($('#regdate').val());
        $('#orderdates').val($('#regdate').val());
    });

    $('#orderExcel').on('submit', function(){
        if($('#regdate').val() == ""){
            alert("기간을 선택해주세요.");
            return false;
        }
    });

    $('#orderExcels').on('submit', function(){
        if($('#regdate').val() == ""){
            alert("기간을 선택해주세요.");
            return false;
        }
    });
</script>
</body>
</html>

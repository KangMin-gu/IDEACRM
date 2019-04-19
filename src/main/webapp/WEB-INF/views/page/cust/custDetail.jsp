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
    <link href="${pageContext.request.contextPath}/resources/css/footable.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<style>
    th{
        background-color: #f5f6f7;
    }
    .denny{
        background-color: #f3f1f0;
    }
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
                <h2>고객 상세정보</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/cust">고객 목록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>고객 정보</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <form:form id="command" method="POST" action="/cust/del">
            <div class="row">
                <div class="col-lg-12">
                    <a href="/cust" class="btn btn-default pull-left">목록</a>
                    <a href="#" class="btn btn-default insideNoticeBtn" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                    <button type="submit" class="btn btn-default pull-right">삭제</button>
                    <a class="btn btn-default pull-right" href="/cust/modified/${custDetail.CUSTNO}">수정</a>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>고객 정보</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">

                                    <input type="hidden" class="searchparam" name="custno" value="${custDetail.CUSTNO}"/>

                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="15%">
                                        <col width="5%">
                                        <col width="15%">
                                        <col width="5%">
                                        <col width="15%">
                                        <col width="5%">
                                        <col width="15%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>고객명</th>
                                            <td><input class="searchparam" type="hidden" id="custno" name="custno" value="${custDetail.CUSTNO}">
                                                <span id="custname">${custDetail.CUSTNAME}</span>
                                            </td>
                                            <th>성별</th>
                                            <td>${custDetail.SEX_}</td>
                                            <th>생년월일</th>
                                            <td>${custDetail.BIRTH}</td>
                                            <th>담당자</th>
                                            <td>${custDetail.OWNER_}</td>
                                        </tr>
                                        <tr>
                                            <th>결혼여부</th>
                                            <td>${custDetail.MARRIED_}</td>
                                            <th>결혼기념일</th>
                                            <td>${custDetail.WEDDINGDAY}</td>
                                            <th>직업</th>
                                            <td>${custDetail.JOB}</td>
                                            <th>취미</th>
                                            <td>${custDetail.HOBBY}</td>
                                        </tr>
                                        <tr>
                                            <th>휴대전화</th>
                                            <td>
                                                <span id="mobile">${custDetail.MOBILE}</span>
                                                <c:if test="${!empty custDetail.MOBILE}">
                                                    <a style="color: #676a6c;" class="smsBtn pull-right" href=""><i class="fa fa-mobile fa-lg"></i></a>
                                                </c:if>
                                            </td>
                                            <th>자택전화</th>
                                            <td>${custDetail.HOMTEL}</td>
                                            <th>이메일</th>
                                            <td>
                                                <span id="email">${custDetail.EMAIL}</span>
                                                <c:if test="${!empty custDetail.EMAIL}">
                                                    <a style="color: #676a6c;" class="emailBtn pull-right" href=""><i class="fa fa-envelope"></i></a>
                                                </c:if>
                                            </td>
                                            <th>자택 주소</th>
                                            <td>${custDetail.HOMADDR1} <span id="homaddr">${custDetail.HOMADDR2} ${custDetail.HOMADDR3}</span></td>
                                        </tr>
                                        <tr>
                                            <th>자택 위치</th>
                                            <td colspan="8"><div id="map" style="width:100%;height:200px;"></div></td>
                                        </tr>
                                        </tbody>
                                </table>
                            </div>

                            <div class="table-responsive">
                                <table class="table table-bordered" >
                                    <colgroup>
                                    <col width="6.5%">
                                    <col width="94%;">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>메모</th>
                                        <td>${custDetail.MEMO}</td>
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
                    <div class="ibox collapsed">
                        <div class="ibox-title">
                            <h5>직장 정보</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up" id="custDetailWrkContentBtn"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content" id="custDetailWrkContentDiv">
                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <tbody>
                                    <tr>
                                        <th>직장명</th>
                                        <td><span id="cliname">${custDetail.CLINAME}</span></td>
                                        <th>부서</th>
                                        <td>${custDetail.DEPTNAME}</td>
                                        <th>직책</th>
                                        <td>${custDetail.DUTY}</td>
                                        <th>홈페이지</th>
                                        <td>${custDetail.WRKURL}</td>
                                    </tr>
                                    <tr>
                                        <th>직장 전화</th>
                                        <td>${custDetail.WRKTEL_}</td>
                                        <th>직장 팩스</th>
                                        <td>${custDetail.WRKFAX_}</td>
                                        <th>직장 주소</th>
                                        <td colspan="3">${custDetail.WRKADDR1} <span id="wrkaddr"> ${custDetail.WRKADDR2} ${custDetail.WRKADDR3}</span></td>
                                    </tr>
                                    <tr>
                                        <th>직장 위치</th>
                                        <td colspan="8"><div id="map2" style="width:100%;height:200px;"></div></td>
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
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>부가 정보</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="15%">
                                        <col width="5%">
                                        <col width="15%">
                                        <col width="5%">
                                        <col width="15%">
                                        <col width="5%">
                                        <col width="15%">
                                        <col width="5%">
                                        <col width="15%">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>회원 구분</th>
                                        <td>${custDetail.CUSTGUBUN_}</td>
                                        <th>고객 등급</th>
                                        <td>${custDetail.CUSTGRADE_}</td>
                                        <th>활동 등급</th>
                                        <td>${custDetail.ACTGRADE_}</td>
                                        <th>발송처</th>
                                        <td>${custDetail.MAILTO_}</td>
                                        <th>정보 활용</th>
                                        <td>${custDetail.INFOAGREE_}</td>
                                    </tr>
                                    <tr>
                                        <th rowspan="6">수신 거부</th>
                                        <th class="denny" colspan="1">EMAIL</th>
                                        <td colspan="8">
                                            <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYMAILNOMAL}"  >&nbsp; 일반</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYMAILSURVEY}"  >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYMAILSEMINAR}"  >&nbsp; 세미나</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYMAILAD}"  >&nbsp; 광고</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="denny" colspan="1">SMS</th>
                                        <td colspan="8">
                                            <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYSMSNOMAL}"  >&nbsp; 일반</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYSMSSURVEY}"  >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYSMSSEMINAR}"  >&nbsp; 세미나</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYSMSAD}"  >&nbsp; 광고</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="denny" colspan="1">KAKAO</th>
                                        <td colspan="8">
                                            <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAONOMAL}"  >&nbsp; 일반</label>&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAOSURVEY}"  >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAOSEMINAR}"  >&nbsp; 세미나</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAOAD}"  >&nbsp; 광고</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="denny" colspan="1">DM</th>
                                        <td colspan="8">
                                            <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYDMNOMAL}"  >&nbsp; 일반</label>&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMSURVEY}"  >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMSEMINAR}"  >&nbsp; 세미나</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMAD}"  >&nbsp; 광고</label>
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMNEWS}"  >&nbsp; 뉴스레터</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="denny" colspan="1">전화</th>
                                        <td colspan="8">
                                            <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYTELAD}"  >&nbsp; 광고</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYTELSURVEY }"  >&nbsp; 해피콜</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="denny" colspan="1">기타</th>
                                        <td colspan="8">
                                            <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYFAX}"  >&nbsp; FAX</label>&nbsp;&nbsp;
                                            <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYVISIT }"  >&nbsp; 방문</label>
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
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>고객 관련 정보</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="tabs-container">
                                        <ul class="nav nav-tabs detail" role="tablist">
                                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">서비스</a></li>
                                            <c:if test="${sessionScope.CHKAUTH eq '30' }">
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-2">영업</a></li>
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-3">접촉</a></li>
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-4">캠페인</a></li>
                                            </c:if>
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-5">메일</a></li>
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-6">문자</a></li>
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-7">카카오</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" id="tab-1" class="tab-pane active" url="/service" >
                                                <div class="panel-body">
                                                    <table class="tabfootable table table-stripped">
                                                        <thead>
                                                        <tr>
                                                            <th data-visible="false" data-name="SERVICENO">서비스번호</th>
                                                            <th data-name="SERVICENAME_">서비스명</th>
                                                            <th data-name="SERVICETYPE_">접수유형</th>
                                                            <th data-name="SERVICECHANNEL_">접수매체</th>
                                                            <th data-name="CUSTNAME_">고객명</th>
                                                            <th data-name="CLINAME_">거래처명</th>
                                                            <th data-name="RECEPTIONDATE_">접수일</th>
                                                            <th data-name="SERVICEOWNER_">접수자</th>
                                                            <th data-name="OWNER_">담당자</th>
                                                            <th data-name="SERVICESTEP_">처리상태</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>  </tbody>
                                                        <tfoot>
                                                        <tr>
                                                            <td colspan="10" style="text-align:right;">
                                                                <ul class="pagination pull-right"></ul>
                                                            </td>
                                                        </tr>
                                                        </tfoot>
                                                    </table>
                                                </div>
                                            </div>

                                            <c:if test="${sessionScope.CHKAUTH eq '30' }">
                                            <div role="tabpanel" id="tab-2" class="tab-pane">
                                                <div class="panel-body">
                                                    <table class="footable2 table table-stripped" data-page-size="8" data-filter=#filter>
                                                        <thead>
                                                        <tr>
                                                            <th>Rendering engine</th>
                                                            <th>Browser</th>
                                                            <th data-hide="phone,tablet">Platform(s)</th>
                                                            <th data-hide="phone,tablet">Engine version</th>
                                                            <th data-hide="phone,tablet">CSS grade</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr class="gradeX">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 4.0
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">4</td>
                                                            <td class="center">X</td>
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
                                            <div role="tabpanel" id="tab-3" class="tab-pane">
                                                <div class="panel-body">
                                                    <table class="footable3 table table-stripped" data-page-size="8" data-filter=#filter>
                                                        <thead>
                                                        <tr>
                                                            <th>Rendering engine</th>
                                                            <th>Browser</th>
                                                            <th data-hide="phone,tablet">Platform(s)</th>
                                                            <th data-hide="phone,tablet">Engine version</th>
                                                            <th data-hide="phone,tablet">CSS grade</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr class="gradeX">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 4.0
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">4</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 5.0
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">5</td>
                                                            <td class="center">C</td>
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
                                            <div role="tabpanel" id="tab-4" class="tab-pane">
                                                <div class="panel-body">
                                                    <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
                                                    <table class="footable4 table table-stripped" data-page-size="8" data-filter=#filter>
                                                        <thead>
                                                        <tr>
                                                            <th>Rendering engine</th>
                                                            <th>Browser</th>
                                                            <th data-hide="phone,tablet">Platform(s)</th>
                                                            <th data-hide="phone,tablet">Engine version</th>
                                                            <th data-hide="phone,tablet">CSS grade</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr class="gradeX">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 4.0
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">4</td>
                                                            <td class="center">X</td>
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
                                            </c:if>

                                            <div role="tabpanel" id="tab-4" class="tab-pane" url="/cust/tab/mail/${custDetail.CUSTNO}">
                                                <div class="panel-body">
                                                    <table class="footable4 table table-stripped" data-page-size="8" data-filter=#filter>
                                                        <thead>
                                                        <tr>
                                                            <th>Rendering engine</th>
                                                            <th>Browser</th>
                                                            <th data-hide="phone,tablet">Platform(s)</th>
                                                            <th data-hide="phone,tablet">Engine version</th>
                                                            <th data-hide="phone,tablet">CSS grade</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                        <tfoot>
                                                        <tr>
                                                            <td colspan="10" style="text-align:right;">
                                                                <ul class="pagination pull-right"></ul>
                                                            </td>
                                                        </tr>
                                                        </tfoot>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" id="tab-4" class="tab-pane">
                                                <div class="panel-body">
                                                    <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
                                                    <table class="footable4 table table-stripped" data-page-size="8" data-filter=#filter>
                                                        <thead>
                                                        <tr>
                                                            <th>Rendering engine</th>
                                                            <th>Browser</th>
                                                            <th data-hide="phone,tablet">Platform(s)</th>
                                                            <th data-hide="phone,tablet">Engine version</th>
                                                            <th data-hide="phone,tablet">CSS grade</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr class="gradeX">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 4.0
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">4</td>
                                                            <td class="center">X</td>
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
                                            <div role="tabpanel" id="tab-4" class="tab-pane">
                                                <div class="panel-body">
                                                    <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
                                                    <table class="footable4 table table-stripped" data-page-size="8" data-filter=#filter>
                                                        <thead>
                                                        <tr>
                                                            <th>Rendering engine</th>
                                                            <th>Browser</th>
                                                            <th data-hide="phone,tablet">Platform(s)</th>
                                                            <th data-hide="phone,tablet">Engine version</th>
                                                            <th data-hide="phone,tablet">CSS grade</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr class="gradeX">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 4.0
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">4</td>
                                                            <td class="center">X</td>
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
                            </div>
                        </div>
                    </div>
                </div>
                </form:form>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <a href="/cust" class="btn btn-default pull-left">목록</a>
                    <a href="#" class="btn btn-default insideNoticeBtn" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                    <button type="submit" class="btn btn-default pull-right">삭제</button>

                    <a class="btn btn-default pull-right" href="/cust/modified/${custDetail.CUSTNO}">수정</a>
                </div>
            </div>

            <br/>

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
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- daum map -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=60c1fc75825cf6619b0ff66b5aca7161&libraries=services"></script>
<!-- crud -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/cust.js"></script>
<script>
    $(document).ready(function() {
        drawMap('map','homaddr','custname');
        $('#custDetailWrkContentBtn').click(function(){
            iboxDrawMap('map2','wrkaddr','cliname','custDetailWrkContentDiv');
        });
    });

    iCheckClick(true);

</script>
</body>
</html>

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
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<style>
    th{
        background-color: #f5f6f7;
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
                <h2>거래처 정보</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/cust">거래처 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>거래처 정보</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">목록</button>
                    <a href="#" class="btn btn-default" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-mobile fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-comment fa-lg"></i></a>
                    <button type="button" class="btn btn-default pull-right">삭제</button>
                    <button type="button" class="btn btn-default pull-right">수정</button>
                </div>
            </div>

            <br/>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>거래처 정보</h5>
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
                                            <th>거래처명</th>
                                            <td></td>
                                            <th>거래처 호칭</th>
                                            <td></td>
                                            <th>담당자</th>
                                            <td></td>
                                            <th>중요도</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>법인 번호</th>
                                            <td></td>
                                            <th>사업자 번호</th>
                                            <td></td>
                                            <th>대표자명</th>
                                            <td></td>
                                            <th>규모</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>업태</th>
                                            <td></td>
                                            <th>업종</th>
                                            <td></td>
                                            <th>종목</th>
                                            <td></td>
                                            <th>국내/국외</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>대표 전화</th>
                                            <td></td>
                                            <th>FAX</th>
                                            <td></td>
                                            <th>휴대 전화</th>
                                            <td></td>
                                            <th>Email</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>주소</th>
                                            <td colspan="5"></td>
                                            <th>밀착도</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>메모</th>
                                            <td colspan="7"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="90%">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>거래처 위치</th>
                                        <td>
                                        <div id="map" style="width:100%;height:200px;"></div>
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
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">관련고객</a></li>
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-2">영업</a></li>
                                            <li><a class="nav-link" data-toggle="tab" href="#tab-3">고객 접촉</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" id="tab-1" class="tab-pane active">
                                                <div class="panel-body">
                                                    <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
                                                    <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
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
                                                        <tr class="gradeA">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 5.5
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">5.5</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Gecko</td>
                                                            <td>Netscape Navigator 9</td>
                                                            <td>Win 98+ / OSX.2+</td>
                                                            <td class="center">1.8</td>
                                                            <td class="center">A</td>
                                                        </tr>

                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 1.3</td>
                                                            <td>OSX.3</td>
                                                            <td class="center">312.8</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 2.0</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">419.3</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 3.0</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">522.1</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>OmniWeb 5.5</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">420</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>iPod Touch / iPhone</td>
                                                            <td>iPod</td>
                                                            <td class="center">420.1</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>S60</td>
                                                            <td>S60</td>
                                                            <td class="center">413</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 7.0</td>
                                                            <td>Win 95+ / OSX.1+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 7.5</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 8.0</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 8.5</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.0</td>
                                                            <td>Win 95+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.2</td>
                                                            <td>Win 88+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.5</td>
                                                            <td>Win 88+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera for Wii</td>
                                                            <td>Wii</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Nokia N800</td>
                                                            <td>N800</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Nintendo DS browser</td>
                                                            <td>Nintendo DS</td>
                                                            <td class="center">8.5</td>
                                                            <td class="center">C/A<sup>1</sup></td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.1</td>
                                                            <td>KDE 3.1</td>
                                                            <td class="center">3.1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.3</td>
                                                            <td>KDE 3.3</td>
                                                            <td class="center">3.3</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.5</td>
                                                            <td>KDE 3.5</td>
                                                            <td class="center">3.5</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 4.5</td>
                                                            <td>Mac OS 8-9</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 5.1</td>
                                                            <td>Mac OS 7.6-9</td>
                                                            <td class="center">1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 5.2</td>
                                                            <td>Mac OS 8-X</td>
                                                            <td class="center">1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Misc</td>
                                                            <td>NetFront 3.1</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Misc</td>
                                                            <td>NetFront 3.4</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Dillo 0.8</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Links</td>
                                                            <td>Text only</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Lynx</td>
                                                            <td>Text only</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Misc</td>
                                                            <td>IE Mobile</td>
                                                            <td>Windows Mobile 6</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Misc</td>
                                                            <td>PSP browser</td>
                                                            <td>PSP</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeU">
                                                            <td>Other browsers</td>
                                                            <td>All others</td>
                                                            <td>-</td>
                                                            <td class="center">-</td>
                                                            <td class="center">U</td>
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
                                            <div role="tabpanel" id="tab-2" class="tab-pane">
                                                <div class="panel-body">
                                                    <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
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
                                                        <tr class="gradeA">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 5.5
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">5.5</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Gecko</td>
                                                            <td>Netscape Navigator 9</td>
                                                            <td>Win 98+ / OSX.2+</td>
                                                            <td class="center">1.8</td>
                                                            <td class="center">A</td>
                                                        </tr>

                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 1.3</td>
                                                            <td>OSX.3</td>
                                                            <td class="center">312.8</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 2.0</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">419.3</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 3.0</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">522.1</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>OmniWeb 5.5</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">420</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>iPod Touch / iPhone</td>
                                                            <td>iPod</td>
                                                            <td class="center">420.1</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>S60</td>
                                                            <td>S60</td>
                                                            <td class="center">413</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 7.0</td>
                                                            <td>Win 95+ / OSX.1+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 7.5</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 8.0</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 8.5</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.0</td>
                                                            <td>Win 95+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.2</td>
                                                            <td>Win 88+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.5</td>
                                                            <td>Win 88+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera for Wii</td>
                                                            <td>Wii</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Nokia N800</td>
                                                            <td>N800</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Nintendo DS browser</td>
                                                            <td>Nintendo DS</td>
                                                            <td class="center">8.5</td>
                                                            <td class="center">C/A<sup>1</sup></td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.1</td>
                                                            <td>KDE 3.1</td>
                                                            <td class="center">3.1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.3</td>
                                                            <td>KDE 3.3</td>
                                                            <td class="center">3.3</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.5</td>
                                                            <td>KDE 3.5</td>
                                                            <td class="center">3.5</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 4.5</td>
                                                            <td>Mac OS 8-9</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 5.1</td>
                                                            <td>Mac OS 7.6-9</td>
                                                            <td class="center">1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 5.2</td>
                                                            <td>Mac OS 8-X</td>
                                                            <td class="center">1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Misc</td>
                                                            <td>NetFront 3.1</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Misc</td>
                                                            <td>NetFront 3.4</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Dillo 0.8</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Links</td>
                                                            <td>Text only</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Lynx</td>
                                                            <td>Text only</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Misc</td>
                                                            <td>IE Mobile</td>
                                                            <td>Windows Mobile 6</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Misc</td>
                                                            <td>PSP browser</td>
                                                            <td>PSP</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeU">
                                                            <td>Other browsers</td>
                                                            <td>All others</td>
                                                            <td>-</td>
                                                            <td class="center">-</td>
                                                            <td class="center">U</td>
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
                                            <div role="tabpanel" id="tab-3" class="tab-pane">
                                                <div class="panel-body">
                                                    <button type="button" class="btn btn-sm"><i class="fa fa-file-excel-o"></i></button>
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
                                                        <tr class="gradeA">
                                                            <td>Trident</td>
                                                            <td>Internet
                                                                Explorer 5.5
                                                            </td>
                                                            <td>Win 95+</td>
                                                            <td class="center">5.5</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Gecko</td>
                                                            <td>Netscape Navigator 9</td>
                                                            <td>Win 98+ / OSX.2+</td>
                                                            <td class="center">1.8</td>
                                                            <td class="center">A</td>
                                                        </tr>

                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 1.3</td>
                                                            <td>OSX.3</td>
                                                            <td class="center">312.8</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 2.0</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">419.3</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>Safari 3.0</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">522.1</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>OmniWeb 5.5</td>
                                                            <td>OSX.4+</td>
                                                            <td class="center">420</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>iPod Touch / iPhone</td>
                                                            <td>iPod</td>
                                                            <td class="center">420.1</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Webkit</td>
                                                            <td>S60</td>
                                                            <td>S60</td>
                                                            <td class="center">413</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 7.0</td>
                                                            <td>Win 95+ / OSX.1+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 7.5</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 8.0</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 8.5</td>
                                                            <td>Win 95+ / OSX.2+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.0</td>
                                                            <td>Win 95+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.2</td>
                                                            <td>Win 88+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera 9.5</td>
                                                            <td>Win 88+ / OSX.3+</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Opera for Wii</td>
                                                            <td>Wii</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Nokia N800</td>
                                                            <td>N800</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Presto</td>
                                                            <td>Nintendo DS browser</td>
                                                            <td>Nintendo DS</td>
                                                            <td class="center">8.5</td>
                                                            <td class="center">C/A<sup>1</sup></td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.1</td>
                                                            <td>KDE 3.1</td>
                                                            <td class="center">3.1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.3</td>
                                                            <td>KDE 3.3</td>
                                                            <td class="center">3.3</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>KHTML</td>
                                                            <td>Konqureror 3.5</td>
                                                            <td>KDE 3.5</td>
                                                            <td class="center">3.5</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 4.5</td>
                                                            <td>Mac OS 8-9</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 5.1</td>
                                                            <td>Mac OS 7.6-9</td>
                                                            <td class="center">1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Tasman</td>
                                                            <td>Internet Explorer 5.2</td>
                                                            <td>Mac OS 8-X</td>
                                                            <td class="center">1</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Misc</td>
                                                            <td>NetFront 3.1</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeA">
                                                            <td>Misc</td>
                                                            <td>NetFront 3.4</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">A</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Dillo 0.8</td>
                                                            <td>Embedded devices</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Links</td>
                                                            <td>Text only</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeX">
                                                            <td>Misc</td>
                                                            <td>Lynx</td>
                                                            <td>Text only</td>
                                                            <td class="center">-</td>
                                                            <td class="center">X</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Misc</td>
                                                            <td>IE Mobile</td>
                                                            <td>Windows Mobile 6</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeC">
                                                            <td>Misc</td>
                                                            <td>PSP browser</td>
                                                            <td>PSP</td>
                                                            <td class="center">-</td>
                                                            <td class="center">C</td>
                                                        </tr>
                                                        <tr class="gradeU">
                                                            <td>Other browsers</td>
                                                            <td>All others</td>
                                                            <td>-</td>
                                                            <td class="center">-</td>
                                                            <td class="center">U</td>
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
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">목록</button>
                    <a href="#" class="btn btn-default" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-mobile fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-comment fa-lg"></i></a>
                    <button type="button" class="btn btn-default pull-right">삭제</button>
                    <button type="button" class="btn btn-default pull-right">수정</button>
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
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- daum map -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=60c1fc75825cf6619b0ff66b5aca7161&libraries=services"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
        $('.footable3').footable();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 지도를 표시하는 div 크기를 변경하는 함수입니다
    function resizeMap() {
        var mapContainer = document.getElementById('map');
        mapContainer.style.width = '650px';
        mapContainer.style.height = '650px';
    }

    function relayout() {

        // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
        // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다
        // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
        map.relayout();
    }

    var geocoder = new daum.maps.services.Geocoder();

    //var accountAddr = "${cliDetail.CLIADDR2 }${cliDetail.CLIADDR3 }";
    //var accountName = "${cliDetail.CLINAME }";
    var accountAddr = "서울시 서대문구 홍제3동 유원하나아파트";
    var accountName = "강민구고객집";
    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(accountAddr, function(result, status) {

        // 정상적으로 검색이 완료됐으면
        if (status === daum.maps.services.Status.OK) {

            var coords = new daum.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new daum.maps.Marker({
                map: map,
                position: coords
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new daum.maps.InfoWindow({
                content: "<div style='width:150px;text-align:center;padding:6px 0;''>"+accountName+"</div>"
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        }
    });
</script>
</body>
</html>

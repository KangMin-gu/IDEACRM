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
    <link href="${pageContext.request.contextPath}/resources/css/crud/voc.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<body>


<div id="wrapper" class="gray-bg">
    <div id="page-wrapper">
        <div class="ibox-top">
            <div class="ibox">
                <div class="ibox-content clearfix">
                    <ul class="top-btn">
                        <li><input type="text" class="form-control"></li>
                        <li class="liBtn"><button class="btn btn-primary btn-sm">걸기 <i class="fa fa-phone"></i></button></li>
                        <li class="liBtn"><button class="btn btn-primary btn-sm">당겨받기 <i class="fa fa-phone"></i></button></li>
                        <li class="liBtn"><button class="btn btn-primary btn-sm">호전환</button></li>
                        &nbsp; |&nbsp;
                        <li class="liBtn"><button class="btn btn-primary btn-sm">대기 <i class="fa fa-spinner"></i></button></li>
                        <li class="liBtn"><button class="btn btn-primary btn-sm">휴식 <i class="fa fa-coffee"></i></button></li>
                        <li class="liBtn"><button class="btn btn-primary btn-sm">후처리 <i class="fa fa-phone"></i></button></li>
                        &nbsp; | &nbsp;
                        <li>00 : 00 : 12</li>
                        &nbsp; | &nbsp;
                        <li class=""><input type="text" class="form-control"></li>
                        <li class=" liBtn2"><button class="btn btn-default btn-sm">호전환</button></li>
                        <li class=" liBtn2"><button class="btn btn-default btn-sm">OB연결</button></li>
                        <li class=" mr-2 ml-2"><strong>고객대기 <span>7</span></strong></li>
                        <li class="float-right">
                            <ul class="top-ul03">
                                <li>
                                    <i class="fa fa-bell"></i>
                                    <span class="li-text">3</span>
                                </li>
                                <li>
                                    <i class="fa fa-envelope"></i>
                                    <span class="li-text">3</span>
                                </li>
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:white;">
                                        <i class="fa fa-bars" style=""></i>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="">분배</a></li>
                                        <li><a href="">운영관리</a></li>
                                        <li><a href="">콜통계</a></li>
                                        <li><a href="">콜이력</a></li>
                                    </ul>
                                </li>
                                <li><i class="fa fa-power-off"></i></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>


        <div class="wrapper wrapper-content">

            <div style="width: 1680px; margin: auto;">
                <div class="ibox-left" style="padding-bottom: 45px;">
                    <div class="ibox clearfix">
                        <div class="ibox-content">
                            <form:form>
                                <div class="table-responsive">
                                    <table class="table table-bordered" style="white-space:nowrap;">
                                        <colgroup>
                                            <col width="10%">
                                            <col width="40%">
                                            <col width="10%">
                                            <col width="40%">
                                        </colgroup>
                                        <tbody>
                                        <tr>
                                            <th>유입번호</th>
                                            <td class="p-xxs">
                                                <input class="form-control form-control-sm" type="search" id="searchNumber" style="height: 30px;">
                                            </td>
                                            <th>고객명</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <input class="form-control form-control-sm" type="text" id="daterange"  />
                                                    <span class="input-group-addon" style="height:30px;"><a href="#" onclick="custDetail()"><i class="fa fa-user-circle fa-sm"></i></a></span>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>휴대전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="" id="" style="width: 70px; height: 30px;">
                                                    <option value="">010</option>
                                                    <option value="">011</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                <input class="form-control form-control-sm" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                            </td>
                                            <th>자택전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control form-control-sm" name="" id="" style="width: 70px; height: 30px;">
                                                        <option value="">02</option>
                                                        <option value="">031</option>
                                                        <option value="">017</option>
                                                        <option value="">018</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>고객구분</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </td>
                                            <th>관련고객</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>이메일</th>
                                            <td>
                                                <input class="form-control form-control-sm" type="text" style="height: 30px;">
                                            </td>
                                            <th>등급</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>주소</th>
                                            <td colspan="3">
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </form:form>
                            <br/>
                            <div class="row">
                                <div class="col-lg-12">
                                    <button type="button" class="btn btn-default pull-left" style="margin-right: 9px;">수신거부상태</button>
                                    <button type="button" class="btn btn-default pull-left" style="margin-right: 9px;">블랙해제</button>
                                    <button type="button" class="btn btn-default pull-left" style="margin-right: 9px;">고객수정</button>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content bot-cont">
                            <div class="tabs-container">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li><a class="nav-link active" data-toggle="tab" href="#tab-1">서비스</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-2">강성이력</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-3">콜백이력</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-4">SMS</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-5">MMS</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-6">LMS</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-7">KAKAO</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-8">EMAIL</a></li>
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
                                                    <th>Platform(s)</th>
                                                    <th>Engine version</th>
                                                    <th>CSS grade</th>
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
                        <div class="ibox-content bot-cont">
                            <div class="tabs-container">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li><a class="nav-link active" data-toggle="tab" href="#tab-5">콜백 목록</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div role="tabpanel" id="tab-5" class="tab-pane active">
                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <table class="table" style="white-space:nowrap;">
                                                    <tr>
                                                        <th>접수일시</th>
                                                        <th>콜백번호</th>
                                                        <th>발신번호</th>
                                                        <th>통화</th>
                                                        <th>메모</th>
                                                        <th>처리</th>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asdfasdfasdf</td>
                                                        <td>fasdfasdfasdfasdfasdfasdfasdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                        <td>asdf</td>
                                                    </tr>

                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="ibox-right">
                    <div class="ibox clearfixt ml-0">
                        <div class="ibox-content" style="padding-bottom: 45px;">
                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="10%">
                                        <col width="90%">
                                    </colgroup>
                                    <tr>
                                        <th>접수구분</th>
                                        <td>
                                            <div class="i-checks">
                                                <label>
                                                    <input type="radio" value="option1" name="a" checked> <i></i> 일반
                                                </label>
                                                <label>
                                                    <input type="radio" checked="" value="option2" name="a"> <i></i> 문의
                                                </label>
                                                <label>
                                                    <input type="radio" checked="" value="option2" name="a"> <i></i> A/S
                                                </label>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수유형</th>
                                        <td>
                                            <div style="display: inline-block;">
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px; width: 100px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px; width: 100px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수제품</th>
                                        <td>
                                            <div style="display: inline-block;">
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px; width: 100px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px; width: 100px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px; width: 100px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <button class="btn btn-primary btn-sm">추가</button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수내용</th>
                                        <td>
                                            <textarea name="need" id="" class="form-control" style="resize: none;" rows="2"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>상담 템플릿</th>
                                        <td>
                                            <select class="form-control form-control-sm" name="" id="" style="height: 30px; width: 100px;">
                                                <option value="">02</option>
                                                <option value="">031</option>
                                                <option value="">017</option>
                                                <option value="">018</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>상담내용</th>
                                        <td>
                                            <textarea id="mytextarea"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>상담결과</th>
                                        <td>
                                            <div class="i-checks">
                                                <label>
                                                    <input type="radio" value="option1" name="a"> <i></i> 처리
                                                </label>
                                                <label>
                                                    <input type="radio" checked="" value="option2" name="a"> <i></i> 담당자이관
                                                </label>
                                                <label>
                                                    <input type="radio" checked="" value="option2" name="a"> <i></i> 상급자이관
                                                </label>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>메모</th>
                                        <td>
                                            <textarea name="need" id="" class="form-control" style="resize: none;" rows="4"></textarea>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="col-lg-12">
                                    <button type="button" id="emailTemp" class="btn btn-default pull-left" style="margin-right: 9px;">EMAIL발송</button>
                                    <button type="button" id="smsTemp" class="btn btn-default pull-left" style="margin-right: 9px;">SMS발송</button>
                                    <button type="button" id="kakaoTemp" class="btn btn-default pull-left">KAKAO발송</button>

                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 9px;">초기화</button>
                                    <button type="button" class="btn btn-primary pull-right">저장</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="ibox-bottom">
            <div class="ibox">
                <div class="ibox-content clearfix">
                    <h3 class="float-left">개인전광판</h3>
                    <ul class="call-option float-left">
                        <li class="call-tit">평균통화</li>
                        <li class="yellow"><strong>00:01:30</strong></li>
                        <li class="call-tit">평균대기</li>
                        <li><strong>00:01:30</strong></li>
                        <li class="call-tit">응대율</li>
                        <li><strong>89%</strong></li>
                        <li class="call-tit">누적통화시간</li>
                        <li class="yellow"><strong>00:01:30</strong></li>
                        <li class="call-tit">CB</li>
                        <li><strong>20</strong></li>
                        <li class="call-tit">CB완료</li>
                        <li><strong>3</strong></li>
                        <li class="call-tit">미처리</li>
                        <li><strong>0</strong></li>
                        <li class="call-tit">통화분배시도</li>
                        <li><strong>0</strong></li>
                        <li class="call-tit">통화분배연결</li>
                        <li><strong>0</strong></li>
                        <li class="call-tit">IB시도</li>
                        <li><strong>0</strong></li>
                        <li class="call-tit">IB연결</li>
                        <li><strong>0</strong></li>
                        <li class="call-tit">OB시도</li>
                        <li><strong>0</strong></li>
                        <li class="call-tit">OB연결</li>
                        <li><strong>0</strong></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=qiomflc75y0odisulm50wv2jdwxsbp5opxqrombuvtzoqm4p"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
        $('.footable3').footable();
        $('.footable4').footable();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
        tinymce.init({
            selector: '#mytextarea',
            height : 400,
            language:'ko_KR'
        });
    });
</script>
<script>
    $('#searchNumber').keydown(function(key){
        if(key.keyCode == 13){
            searchNumber();
        }
    });
    searchNumber = function(){
        //ajax 검색후 중복이아닐시 바로 바인딩 여러명검색시 팝업착작동
        window.open("/voc/custsearch", "고객검색","width=1000px, height=500px");
    };
    custDetail = function(){
        window.open("/voc/custdetail", "고객상세정보","width=1100px, height=600px");
    };
    $('#smsTemp').click(function(){
        window.open("/voc/sms", "고객상세정보","width=400px, height=600px");
    });
    $('#emailTemp').click(function(){
        window.open("/voc/email", "고객상세정보","width=1200px, height=900px");
    });
    $('#kakaoTemp').click(function(){
        window.open("/voc/kakao", "고객상세정보","width=400px, height=600px");
    });
</script>
</body>
</html>

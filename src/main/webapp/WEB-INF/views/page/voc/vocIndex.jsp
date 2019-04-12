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
                    <div class="cti" style="display:none">
                        서버아이피: <input type="text" name="cti_server_ip" id="cti_server_ip" value="127.0.0.1">
                        웹소켓아이피: <input type="text" name="cti_server_socket_ip" id="cti_server_socket_ip" value="203.239.159.133">
                        서버포트: <input type="text" name="cti_server_port" id="cti_server_port" value="7070">
                        <input type="button" value="웹소켓접속" onclick="webSocketGo();">
                        <input type="button" value="웹소켓끊기" onclick="func_logout();goWebSocketDisconnect();">
                        <br/>
                        아이디 : <input type="text" name="cti_login_id" id="cti_login_id" value="crud01">
                        비밀번호 : <input type="text" name="cti_login_pwd" id="cti_login_pwd" value="0000">
                        전화번호 : <input type="text" name="cti_login_ext" id="cti_login_ext" value="07042622864">
                        <input type="hidden" name="checkGroupValue" id="checkGroupValue" value="N">
                        <input type="hidden" name="checkGroupValue2" id="checkGroupValue2" value="N">
                        <span id="outCallNum">07042622883</span>
                        <input type="hidden" id="ctitelno" name="ctitelno" value="07042622883" />
                        <input type="checkbox" class="check" id="did" onclick="javascript:didCheck();">
                        <div>
                            <textarea id="messages" cols="150" rows="10"></textarea>
                            <input type="button" value="로그초기화" onclick="javascript:document.getElementById('messages').value='';">
                            <select name="callGroup" id="callGroup" style="width:131px;" onchange="javascrpt:changeGroup();"></select>
                        </div>
                        <input type="hidden" id="userno" value="${sessionScope.USERNO }">
                        <input type="hidden" id="chkauth" value="${sessionScope.CHKAUTH }" />
                        <input type="hidden" id="trunk" value="07042622883" /><!-- 동적으로변경 -->
                        <input type="hidden" id="reqno" name="reqno" value="" /><!-- 서비스랑 연결할 REQNO -->
                    </div>
                    <ul class="top-btn">
                        <li class="ctibtn"><input type="text" id="makeCallNum" class="form-control" value="" style="color:black"></li>
                        <li class="liBtn ctibtn"><button onclick="javascript:func_answer();" class="btn btn-primary btn-sm" id="answerBtn">받기 <i class="fa fa-phone"></i></button></li>
                        <li class="liBtn ctibtn"><button onclick="javascript:func_pickup();" class="btn btn-primary btn-sm" id="pickupBtn">당겨받기 <i class="fa fa-phone"></i></button></li>
                        <li class="liBtn ctibtn"><button onclick="javascript:func_hangup();" class="btn btn-primary btn-sm" id="hangUpBtn">끊기 <i class="fa fa-phone"></i></button></li>
                        <li class="liBtn ctibtn"><button onClick="javascript:func_hold();" class="btn btn-primary btn-sm status" id="delayBtn">보류 <i class="fa fa-times-circle"></i></button></li>
                        <li class="liBtn ctibtn"><button onClick="javascript:func_unhold();" class="btn btn-primary btn-sm status" id="delayCancelBtn">보류해제 <i class="fa fa-times-circle-o"></i></button></li>
                        <li class="ctibtn">
                        &nbsp; |&nbsp;
                        </li>
                        <li class="liBtn ctibtn"><button onClick="javascript:func_changeTellerStatus('0300');"class="btn btn-primary btn-sm status" id="waitingBtn">대기 <i class="fa fa-spinner"></i></button></li>
                        <li class="liBtn ctibtn"><button onClick="javascript:func_changeTellerStatus('R001');" class="btn btn-primary btn-sm status" id="restBtn">휴식 <i class="fa fa-coffee"></i></button></li>
                        <li class="liBtn ctibtn"><button onClick="javascript:func_changeTellerStatus('W004');" class="btn btn-primary btn-sm status" id="postCleaningBtn">후처리 <i class="fa fa-phone"></i></button></li>
                        <li class="ctibtn">
                        &nbsp; | &nbsp;
                        </li>
                        <li class="ctibtn"><span id="timer">00 : 00</span></li>
                        <li class="ctibtn">
                        &nbsp; | &nbsp;
                        </li>
                        <li class="ctibtn"><input type="text" id="blindCall" class="form-control"></li>
                        <li class="liBtn2 ctibtn"><button onclick="javascript:didCheckMakeCall();" class="btn btn-default btn-sm">OB연결</button></li>
                        <li class=" liBtn2 ctibtn"><button onClick="javascript:func_blindTransfer(document.getElementById('blindCall').value,'');" class="btn btn-primary btn-sm status" id="transferBtn">호전환</button></li>
                        <li class="liBtn ctibtn"><button onClick="javascript:func_threeWayCall();" class="btn btn-primary btn-sm status" id="threeWayBtn">3자 통화</button></li>
                        <li class=" mr-2 ml-2 ctibtn"><strong>고객대기 <span id="cti_waitting_cnt">0</span></strong></li>
                        <li>
                            <input type="hidden" id="tellerStatus" name="tellerStatus"/>
                            <input type="hidden" id="status" name="status"/>
                        </li>
                        <li class="float-right">
                            <ul class="top-ul03">
                                <li class="ctibtn">
                                    <i class="fa fa-bell"></i>
                                    <span class="li-text">3</span>
                                </li>
                                <li class="ctibtn">
                                    <i class="fa fa-envelope"></i>
                                    <span class="li-text">3</span>
                                </li>
                                <li class="dropdown ctibtn">
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
                                <li>
                                    <span id="vocLogInSpan"><i class="fa fa-power-off" style="color:#d11507 ;" id="vocLogInBtn" onclick="vocLoginGo();"></i></span>
                                    <span id="vocLogOutSpan" style="display:none;"><i class="fa fa-power-off" style="color: #75bc63;" id="vocLogOutBtn" onclick="func_logout();"></i></span>
                                </li>
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
                                                    <input class="form-control form-control-sm" id="custname" name="custname" type="text"/>
                                                    <input type="hidden" class="form-control" id="custno" name="custno" value="1"/>
                                                    <span class="input-group-addon" style="height:30px;"><a href="#" onclick="
                                                    ()"><i class="fa fa-user-circle fa-sm"></i></a></span>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>휴대전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="mobile1" id="mobile1" style="width: 70px; height: 30px;">
                                                    <option value="">010</option>
                                                    <option value="">011</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" type="text" name="mobile2" id="mobile2" style="width: 70px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                <input class="form-control form-control-sm" type="text" name="mobile3" id="mobile3" style="width: 70px; height: 30px;">
                                                </div>
                                            </td>
                                            <th>자택전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control form-control-sm" name="homtel1" id="homtel1" style="width: 70px; height: 30px;">
                                                        <option value="">02</option>
                                                        <option value="">031</option>
                                                        <option value="">017</option>
                                                        <option value="">018</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" name="homtel2" id="homtel2" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" name="homtel3" id="homtel3" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>고객구분</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="custgubun" id="custgubun" style="height: 30px;">
                                                    <option value="">02</option>
                                                    <option value="">031</option>
                                                    <option value="">017</option>
                                                    <option value="">018</option>
                                                </select>
                                            </td>
                                            <th>관련고객</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="relcustname" id="relcustname" style="height: 30px;">
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
                                                <input class="form-control form-control-sm" name="email" id="email" type="text" style="height: 30px;">
                                            </td>
                                            <th>등급</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="custgrade" id="custgrade" style="height: 30px;">
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
                                                    <input class="form-control form-control-sm" name="homaddr1" id="homaddr1" type="text" style="width: 70px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" name="homaddr2" id="homaddr2" type="text" style="width: 200px; height: 30px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm" name="homaddr3" id="homaddr3" type="text" style="width: 200px; height: 30px; ">
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
                                                <c:forEach var="serviceType" items="${SERVICETYPE}">
                                                    <label><input type="radio" class="" value="${serviceType.codeval}" name="servicetype"> <i></i>&nbsp;${serviceType.codename}</label>&nbsp;&nbsp;
                                                </c:forEach>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수유형</th>
                                        <td>
                                            <div style="display: inline-block;">
                                                <select class="form-control form-control-sm" name="servicecode1" id="servicecode1">
                                                    <option value="">선택</option>
                                                    <c:forEach var="serviceCode1" items="${SERVICECODE1}">
                                                        <option label="${serviceCode1.codename}" value="${serviceCode1.codeval}"></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="servicecode2" id="servicecode2" upper="servicecode1">
                                                    <option value="">선택</option>
                                                </select>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수제품</th>
                                        <td>
                                            <div class="product">
                                                <div style="display: inline-block">
                                                    <select id="product11" name="product11" class="form-control" style="width: 150px";>
                                                        <option value="">선택</option>
                                                        <c:forEach var="productB" items="${productB }">
                                                            <option label="${productB.prdname }" value="${productB.prdno }"/>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control " name="product12" id="product12" style="width: 250px;">
                                                        <option value="">선택</option>

                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control " name="product13" id="product13" style="width: 300px;">
                                                        <option value="">선택</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <button type="button" class="btn btn-default plus">추가</button>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수내용</th>
                                        <td>
                                            <textarea name="servicename" id="servicenmae" class="form-control" style="resize: none;" rows="2"></textarea>
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
                                            <textarea class="tinymce" id="servicedesc" name="servicedesc"></textarea>
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
                        <li class="yellow"><strong><span id="avgCall">00:00:00</span></strong></li>
                        <li class="call-tit">평균대기</li>
                        <li><strong><span id="avgWait">0</span></strong></li>
                        <li class="call-tit">응대율</li>
                        <li><strong><span id="ResponseRate">0%</span></strong></li>
                        <li class="call-tit">누적통화시간</li>
                        <li class="yellow"><strong><span id="sumCall">0</span></strong></li>
                        <li class="call-tit">CB</li>
                        <li><strong><span id="callbackCnt"></span>0</strong></li>
                        <li class="call-tit">CB완료</li>
                        <li><strong><span id="successCallback">0</span></strong></li>
                        <li class="call-tit">미처리</li>
                        <li><strong>0</strong></li>
                        <li class="call-tit">통화분배시도</li>
                        <li><strong><span id="transferTryCnt">0</span></strong></li>
                        <li class="call-tit">통화분배연결</li>
                        <li><strong><span id="transferConnectCnt">0</span></strong></li>
                        <li class="call-tit">IB시도</li>
                        <li><strong><span id="ibTryCnt">0</span></strong></li>
                        <li class="call-tit">IB연결</li>
                        <li><strong><span id="ibConnectCnt">0</span></strong></li>
                        <li class="call-tit">OB시도</li>
                        <li><strong><span id="obTryCnt">0</span></strong></li>
                        <li class="call-tit">OB연결</li>
                        <li><strong><span id="obConnectCnt">0</span></strong></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- cti js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/cti.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc_socket.js
"></script>
<!-- tinymce -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/product.js"></script>
<script>
    $(document).ready(function(){

        $('.ctibtn').hide();

    });
</script>

<script>
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

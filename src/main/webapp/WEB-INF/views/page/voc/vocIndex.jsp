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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet"><!-- Sweet Alert -->

</head>
<body>

<div id="wrapper" class="gray-bg">
    <div id="page-wrapper">
        <div class="ibox-top">
            <div class="ibox">
                <div class="ibox-content clearfix">
                    <div class="cti" style="display:none">
                        서버아이피: <input type="text" name="cti_server_ip" id="cti_server_ip" value="${ctiInfo.IP}">
                        웹소켓아이피: <input type="text" name="cti_server_socket_ip" id="cti_server_socket_ip" value="${ctiInfo.SOCKETIP}">
                        서버포트: <input type="text" name="cti_server_port" id="cti_server_port" value="${ctiInfo.PORT}">
                        <input type="button" value="웹소켓접속" onclick="webSocketGo();">
                        <input type="button" value="웹소켓끊기" onclick="func_logout();goWebSocketDisconnect();">
                        <br/>
                        아이디 : <input type="text" name="cti_login_id" id="cti_login_id" value="${ctiUserInfo.CTIID}">
                        비밀번호 : <input type="text" name="cti_login_pwd" id="cti_login_pwd" value="${ctiUserInfo.CTIPASS}">
                        전화번호 : <input type="text" name="cti_login_ext" id="cti_login_ext" value="${ctiUserInfo.CTITELNO}">
                        <input type="hidden" name="checkGroupValue" id="checkGroupValue" value="N">
                        <input type="hidden" name="checkGroupValue2" id="checkGroupValue2" value="N">
                        <span id="outCallNum">${ctiInfo.TELNO}</span>
                        <input type="hidden" id="ctitelno" name="ctitelno" value="${ctiInfo.TELNO}" class="searchparam"/>
                        <input type="checkbox" class="check" id="did" onclick="javascript:didCheck();">
                        <div>
                            <textarea id="messages" cols="150" rows="10"></textarea>
                            <input type="button" value="로그초기화" onclick="javascript:document.getElementById('messages').value='';">
                            <select name="callGroup" id="callGroup" style="width:131px;" onchange="javascrpt:changeGroup();"></select>
                        </div>
                        <input type="hidden" id="userno" value="${sessionScope.USERNO }">
                        <input type="hidden" id="chkauth" value="${sessionScope.CHKAUTH }" />
                        <input type="hidden" id="trunk" value="${ctiInfo.TELNO}" /><!-- 동적으로변경 -->
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
                                    <span class="li-text isnVal"></span>
                                </li>
                                <!--<li class="dropdown">
                                    <a id="ins" class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                        <i class="fa fa-envelope"></i>  <span class="label label-warning isnVal"></span>
                                    </a>
                                    <ul id="insNotRead" class="dropdown-menu dropdown-messages"></ul>
                                </li>-->
                                <li class="dropdown ctibtn">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:white;">
                                        <i class="fa fa-bars" style=""></i>
                                    </a>
                                    <c:if test="${sessionScope.CHKAUTH eq 20 or sessionScope.CHKAUTH eq 30}">
                                    <ul class="dropdown-menu">
                                        <li><a href="#" id="callDivide">분배</a></li>
                                        <li><a href="#">운영관리</a></li>
                                        <li><a href="#">콜통계</a></li>
                                        <li><a href="#">콜이력</a></li>
                                    </ul>
                                    </c:if>
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
                                            <!--고객 관련 hidden -->
                                            <input class="vocCustInput" type="hidden" id="blackcnt" name="blackcnt"/>
                                            <!-- 녹취 키값  -->
                                            <input type="hidden" id="nucIdx"  name="nucIdx" value="" />

                                            <th>유입번호</th>
                                            <td class="p-xxs">
                                                <input class="form-control form-control-sm" type="search" id="searchNumber" style="height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                                            </td>
                                            <th>고객명 </th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <input class="form-control form-control-sm vocCustInput" id="custname" name="custname" type="text"/>
                                                    <input type="hidden" class="form-control vocCustInput searchparam" id="custno" name="custno" value=""/>
                                                    <span class="input-group-addon" style="height:30px;"><a href="#" onclick="vocCustDetail()"><i class="fa fa-user-circle fa-sm"></i></a></span>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>휴대전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control form-control-sm vocCustInput" name="mobile1" id="mobile1" style="width: 80px;height: 30px;padding-top: 2.5px;">
                                                        <option value="">선택</option>
                                                        <c:forEach var="mobile" items="${MOBILE}">
                                                            <option value="${mobile.codeval}">${mobile.codename}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm vocCustInput" type="text" name="mobile2" id="mobile2" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm vocCustInput" type="text" name="mobile3" id="mobile3" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                                </div>
                                            </td>
                                            <th>자택전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control form-control-sm vocCustInput" name="homtel1" id="homtel1" style="width: 80px;height: 30px;padding-top: 2.5px;">
                                                        <option value="">선택</option>
                                                        <c:forEach var="phone" items="${PHONE}">
                                                            <option value="${phone.codeval}">${phone.codename}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm vocCustInput" name="homtel2" id="homtel2" type="text" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input class="form-control form-control-sm vocCustInput" name="homtel3" id="homtel3" type="text" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>고객구분</th>
                                            <td>
                                               <select class="form-control form-control-sm vocCustInput" name="custgubun" id="custgubun" >
                                                    <option value="0">선택</option>
                                                    <c:forEach var="custgubun" items="${CUSTGUBUN}">
                                                        <option value="${custgubun.codeval}">${custgubun.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <th>관련고객</th>
                                            <td>
                                                <div class="input-group cust" id="relcustname">
                                                    <input type="text" class="form-control form-control-sm vocCustInput"  autocomplete="off" name="relcustname" readonly>
                                                    <input type="hidden" class="vocCustInput" name="relcustno" id="relcustno" value="0">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </div>

                                            </td>
                                        </tr>
                                        <tr>
                                            <th>이메일</th>
                                            <td>
                                                <input class="form-control form-control-sm vocCustInput" name="email" id="email" type="text" style="height: 30px;">
                                            </td>
                                            <th>등급</th>
                                            <td>
                                                <select class="form-control form-control-sm vocCustInput" name="custgrade" id="custgrade">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="custgrade" items="${CUSTGRADE}">
                                                        <option value="${custgrade.codeval}">${custgrade.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>주소</th>
                                            <td colspan="3">
                                                <div class="col-sm-12">
                                                    <div class="row">
                                                        <div class="col-md-2"><input type="text" class="form-control form-control-sm vocCustInput" id="homaddr1" name="homaddr1" readonly></div>
                                                        <div class="col-md-4"><input type="text" class="form-control form-control-sm vocCustInput" id="homaddr2" name="homaddr2" readonly></div>
                                                        <div class="col-md-4"><input type="text" class="form-control form-control-sm vocCustInput" id="homaddr3" name="homaddr3"></div>
                                                        <div class="col-md-2"><button class="btn btn-white btn-sm daumzip" type="button" id="homaddr">주소 검색</button></div>
                                                    </div>
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
                                    <button type="button" class="btn btn-default pull-left" style="margin-right: 9px;" data-toggle="collapse" data-target="#denyfield">수신거부상태</button>
                                    <span id="blackSpan"><button type="button" class="btn btn-default pull-left" style="margin-right: 9px;" onclick="addBlackPop();">블랙추가</button></span>
                                    <span id="custRegSpan"><button type='button' class='btn btn-default pull-left' style='margin-right: 9px;' onClick='goCustInsert()'>고객추가</button></span>
                                </div>
                            </div>

                            <div class="collapse" id="denyfield" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-md">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="float-left" style="width:100px;"><label for="denymailnomal"><b>일반</b></label></div>
                                                <div class="checkbox float-left">
                                                    <input id="denymailnomal" name="denymailnomal" type="checkbox" class=" vocCustInput" value="1">
                                                    <label for="denymailnomal">이메일 거부</label>
                                                </div>
                                                <div class="checkbox float-left">
                                                    <input id="denysmsnomal" name="denysmsnomal" type="checkbox" class="vocCustInput" value="1">
                                                    <label for="denysmsnomal">SMS 거부</label>
                                                </div>
                                                <div class="checkbox float-left">
                                                    <input id="denydmnomal" name="denydmnomal" type="checkbox" class="vocCustInput" value="1">
                                                    <label for="denydmnomal">DM 거부</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="float-left" style="width:100px;"><label for="denymailnomal"><b>해피콜</b></label></div>
                                                <div class="checkbox float-left">
                                                    <input id="denymailsurvey" name="denymailsurvey" type="checkbox" class="vocCustInput" value="1">
                                                    <label for="denymailsurvey">이메일 거부</label>
                                                </div>
                                                <div class="checkbox float-left">
                                                    <input id="denysmssurvey" name="denysmssurvey" type="checkbox" class="vocCustInput" value="1">
                                                    <label for="denysmssurvey">SMS 거부</label>
                                                </div>
                                                <div class="checkbox float-left">
                                                    <input id="denydmsurvey" name="denydmsurvey" type="checkbox" class="vocCustInput" value="1">
                                                    <label for="denydmsurvey">DM 거부</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content bot-cont">
                            <div class="tabs-container">
                                <ul class="nav nav-tabs vocTabDetail" role="tablist">
                                    <li><a class="nav-link active" data-toggle="tab" href="#vocSvTab" name="vocSvTabBtn">서비스</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#vocBlackTab">강성이력</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#vocCallbackHistTab">콜백이력</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-4">SMS</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-5">MMS</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-6">LMS</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-7">KAKAO</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#tab-8">EMAIL</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div role="tabpanel" id="vocSvTab" class="tab-pane active" url="/voc/tab/sv">
                                        <div class="panel-body">
                                            <table class="tabfootable table table-striped" data-paging="true" data-sorting="true">
                                                <thead>
                                                <tr>
                                                    <th data-visible="false" data-name="NO">서비스번호</th>
                                                    <th data-name="SERVICENAME_" data-formatter="vocSvTabFormatter">서비스명</th>
                                                    <!--<th data-name="SERVICENAME_">서비스명</th>-->
                                                    <th data-name="SERVICETYPE_">접수유형</th>
                                                    <th data-name="CUSTNAME_">고객명</th>
                                                    <th data-name="RECEPTIONDATE_" data-sorted="true" data-direction="DESC">접수일</th>
                                                    <th data-name="SERVICEOWNER_">접수자</th>
                                                    <th data-name="OWNER_">담당자</th>
                                                    <th data-name="SERVICESTEP_">처리상태</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <td colspan="7" style="text-align:center">
                                                        <ul class="pagination float-center"></ul>
                                                    </td>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                    <div role="tabpanel" id="vocBlackTab" class="tab-pane" url="/voc/tab/black">
                                        <div class="panel-body">
                                            <table class="tabfootable table table-striped" data-paging="true" data-filter=#filter data-sorting="true" data-page-size="5">
                                                <thead>
                                                <tr>
                                                    <th data-visible="false" data-name="BCUSTNO">블랙번호</th>
                                                    <th data-name="REGDATE_" data-sorted="true" data-direction="DESC">접수일시</th>
                                                    <th data-name="BLACKTYPE_">유형</th>
                                                    <th data-name="MEMO_">접수사유</th>
                                                    <th data-name="USERNAME">접수자</th>
                                                    <th data-name="ISDELETE_">현재상태</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <td colspan="5" style="text-align:center">
                                                        <ul class="pagination float-center"></ul>
                                                    </td>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                    <div role="tabpanel" id="vocCallbackHistTab" class="tab-pane" url="/voc/tab/callbackhist">
                                        <div class="panel-body">

                                            <table class="tabfootable table table-striped" data-paging="true" data-filter=#filter data-sorting="true" data-page-size="5">
                                                <thead>
                                                <tr>
                                                    <th data-visible="false" data-name="CALLBACKHISTNO"></th>
                                                    <th data-visible="false" data-name="RECDATE_"></th>
                                                    <th data-visible="false" data-name="RECEXT"></th>
                                                    <th data-visible="false" data-name="RECFILENAME"></th>
                                                    <th data-visible="false" data-name="REQNO"></th>
                                                    <th data-name="REGDATE_" data-sorted="true" data-direction="DESC">통화일시</th>
                                                    <th data-name="CALLBACK">콜백번호</th>
                                                    <th data-name="CALLER">발신자번호</th>
                                                    <th data-name="USERNAME">상담원</th>
                                                    <th data-name="MEMO_">메모</th>
                                                    <th data-name="CALLSTATUS_">상태</th>
                                                    <th data-formatter="callbackHistFormatter">녹취</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <td colspan="7" style="text-align:center">
                                                        <ul class="pagination float-center"></ul>
                                                    </td>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                    <div role="tabpanel" id="tab-4" class="tab-pane">
                                        <div class="panel-body">

                                            <table class="footable4 table table-striped" data-page-size="8" data-filter=#filter>
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
                                <ul class="nav nav-tabs detail" role="tablist">
                                    <li><a class="nav-link active" data-toggle="tab" href="#callbackBottomTab" name="callbackBottomTab">콜백 목록</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div role="tabpanel" id="callbackBottomTab" class="tab-pane active" url="/voc/tab/callback">
                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <table class="tabfootable table table-striped" style="white-space:nowrap;">
                                                    <thead>
                                                    <tr>
                                                        <th data-visible="false" data-name="TRUNK"></th>
                                                        <th data-visible="false" data-name="CALLCOUNT"></th>
                                                        <th data-visible="false" data-name="CALLBACKNO"></th>
                                                        <th data-visible="false" data-formatter="callBackHiddenFormatter"></th>
                                                        <th data-name="RECEIVEDATE_" data-sorted="true" data-direction="ASC">접수일시</th>
                                                        <th data-name="CALLBACK">콜백번호</th>
                                                        <th data-name="CALLER">발신번호</th>
                                                        <th data-formatter="callBtnFormatter">통화</th>
                                                        <!--<th>메모</th>-->
                                                        <th data-formatter="processBtnFormatter">처리</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    </tbody>
                                                    <tfoot>
                                                    <tr>
                                                        <td colspan="6" style="text-align:center">
                                                            <ul class="pagination float-center"></ul>
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
                                            <div class="i-checks servicetype voc">
                                                <c:forEach var="serviceType" items="${SERVICETYPE}">
                                                    <label><input class="i-checks " type="radio" value="${serviceType.codeval}" id="servicetype" name="servicetype"> <i></i>&nbsp;${serviceType.codename}</label>&nbsp;&nbsp;
                                                </c:forEach>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수유형</th>
                                        <td>
                                            <div style="display: inline-block;">
                                                <select class="form-control form-control-sm vocSvInput voc" name="servicecode1" id="servicecode1">
                                                    <option value="">선택</option>
                                                    <c:forEach var="serviceCode1" items="${SERVICECODE1}">
                                                        <option label="${serviceCode1.codename}" value="${serviceCode1.codeval}"></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm vocSvInput voc" name="servicecode2" id="servicecode2" upper="servicecode1">
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
                                                    <select id="product11" name="product11" class="form-control voc" style="width: 150px";>
                                                        <option value="">선택</option>
                                                        <c:forEach var="productB" items="${productB }">
                                                            <option label="${productB.prdname }" value="${productB.prdno }"/>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control vocSvInput voc" name="product12" id="product12" style="width: 200px;">
                                                        <option value="">선택</option>

                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control vocSvInput voc" name="product13" id="product13" style="width: 200px;">
                                                        <option value="">선택</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <button type="button" class="btn btn-default voc plus" disabled="disabled">추가</button>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>접수내용</th>
                                        <td>
                                            <textarea name="servicename" id="servicename" class="form-control vocSvInput voc" style="resize: none;" rows="2"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>상담 템플릿</th>
                                        <td>
                                            <select class="form-control form-control-sm vocSvInput voc" name="" id="" style=" width: 100px;">
                                                <option value="">선택</option>
                                                <option value="">031</option>
                                                <option value="">017</option>
                                                <option value="">018</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>상담내용</th>
                                        <td>
                                            <textarea class="tinymce vocSvInput voc" id="servicedesc" name="servicedesc"></textarea>
                                        </td>
                                    </tr>
                                    <tr class="as">
                                        <th>방문일시</th>
                                        <td>
                                            <div class="input-group voc" data-autoclose="true">
                                                <span class="input-group-addon voc">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <input type="text" class="form-control voc vocSvInput"  readOnly="true" name="visitdate" id="visitdate" value="">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="as">
                                        <th>방문 기사</th>
                                        <td>
                                            <div class="input-group asowner" id="asowner_">
                                                <input type="text" class="form-control voc vocSvInput" autocomplete="off" name="asowner_" value="">
                                                <input type="hidden" name="asowner" class="voc vocSvInput" id="asowner" value="">
                                                <span class="input-group-addon">
                                        	<a><i class="fa fa-search"></i></a>
                                        </span>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="as">
                                        <th>방문지 주소</th>
                                        <td>
                                            <div class="col-sm-12">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" class="form-control form-control-sm voc vocSvInput" id="visitaddr1" name="visitaddr1" readonly></div>
                                                    <div class="col-md-4"><input type="text" class="form-control form-control-sm voc vocSvInput" id="visitaddr2" name="visitaddr2" readonly></div>
                                                    <div class="col-md-4"><input type="text" class="form-control form-control-sm voc vocSvInput" id="visitaddr3" name="visitaddr3"></div>
                                                    <div class="col-md-2"><button class="btn btn-white btn-sm daumzip voc" type="button" id="visitaddr">주소 검색</button></div>
                                                </div>
                                                <div class="row" style="margin-top: 10px;margin-left: 0px;">
                                                    <input type="checkbox" class="i-checks voc" value="1" id="addrsame" name="addrsame">
                                                    &nbsp;<label>고객주소와 동일</label>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="result">
                                        <th>상담결과</th>
                                        <td>
                                            <div class="i-checks voc">
                                                <label>
                                                    <input class="check i-checks" type="radio" id="vocstep3" name="vocstep" value="3" > <i></i> 처리
                                                </label>
                                                <label>
                                                    <input class="check i-checks" type="radio" id="vocstep5" name="vocstep" value="5" > <i></i> 담당자이관
                                                </label>
                                                <label>
                                                    <input class="check i-checks" type="radio" id="vocstep6" name="vocstep" value="6" > <i></i> 상급자이관
                                                </label>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="convey">
                                        <th>이관 담당자 </th>
                                        <td>
                                            <div class="input-group vocowner voc" id="nextowner_">
                                                <input type="text" class="form-control voc vocSvInput" autocomplete="off" name="nextowner_" value="">
                                                <input type="hidden" name="nextowner voc vocSvInput" id="nextowner" value="">
                                                <span class="input-group-addon">
                                        	    <a><i class="fa fa-search"></i></a>
                                                </span>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="convey">
                                        <th>이관 사유</th>
                                        <td>
                                            <select class="form-control voc vocSvInput" id="conveyreason" name="conveyreason">
                                                <option label="선택" value="0"/>
                                                <c:forEach var="conveyReason" items="${CONVEYREASON }">
                                                    <option label="${conveyReason.codename }" value="${conveyReason.codeval }"/>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr class="convey">
                                        <th>비고</th>
                                        <td>
                                            <textarea class="form-control voc vocSvInput" name="conveydesc" cols="80" rows="3"></textarea>
                                        </td>
                                    </tr>
                                    <!--<tr class="adminconvey">
                                        <th>상급 담당자 </th>
                                        <td>
                                            <div class="input-group adminowner vocowner" id="nextadminowner_">
                                                <input type="text" class="form-control voc vocSvInput" autocomplete="off" name="nextadminowner_" value="">
                                                <input type="hidden" name="nextadminowner voc vocSvInput" id="nextadminowner" value="">
                                                <span class="input-group-addon">
                                        	<a><i class="fa fa-search"></i></a>
                                        </span>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="adminconvey">
                                        <th>이관 사유</th>
                                        <td>
                                            <select class="form-control voc vocSvInput" name="conveyreason">
                                                <option label="선택" value=""/>
                                                <c:forEach var="conveyReason" items="${CONVEYREASON }">
                                                    <option label="${conveyReason.codename }" value="${conveyReason.codeval }"/>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr class="adminconvey">
                                        <th>비고</th>
                                        <td>
                                            <textarea disabled class="form-control voc vocSvInput" name="conveydesc" cols="80" rows="3"></textarea>
                                        </td>
                                    </tr>
                                    -->
                                    <tr class="reservation">
                                        <th>예약 전화번호
                                        <td>
                                            <input type="text" class="form-control voc vocSvInput" autocomplete="off" id="reservphone" name="reservphone" value="">
                                        </td>
                                    </tr>
                                    <tr class="reservation">
                                        <th>예약 일시
                                        <td>
                                            <div class="input-group date" data-autoclose="true">
                            			<span class="input-group-addon">
                                    		<span class="fa fa-calendar"></span>
                                		</span>
                                                <input type="text"  class="form-control date voc vocSvInput" name="reservdate" id="reservdate" value="">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="reservation"><!--테스트필요 -->
                                        <th>예약 시간
                                        <td>
                                            <div style="display: inline-block">
                                                <select class="form-control voc" name="visitapm" id="visitapm" style="width:80px;">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="apm" items="${APM}">
                                                        <option value="${apm.codeval}">${apm.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <select class="form-control voc vocSvInput" name="visithour" id="visithour" style="width:70px;">
                                                    <option value="">선택</option>
                                                    <c:forEach var="hour" items="${HOUR}">
                                                    <option value="${hour.codeval}">${hour.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <span style="display: inline-block">시</span>
                                            <div style="display: inline-block">
                                                <select class="form-control voc vocSvInput" name="visitminute" id="visitminute" style="width:70px;">
                                                    <option value="">선택</option>
                                                    <c:forEach var="minute" items="${MINUTE}">
                                                    <option value="${minute.codeval}">${minute.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <span style="display: inline-block">분</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>메모</th>
                                        <td>
                                            <textarea name="memo" id="memo" class="form-control voc vocSvInput" style="resize: none;" rows="4"></textarea>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="col-lg-12">
                                    <button type="button" class="btn btn-default pull-left vocEmailBtn" style="margin-right: 9px;">EMAIL발송</button>
                                    <button type="button" class="btn btn-default pull-left vocSmsBtn" style="margin-right: 9px;">SMS발송</button>
                                    <button type="button" class="btn btn-default pull-left vocKakaoBtn">KAKAO발송</button>

                                    <button id="create" class="btn btn-default pull-right" style="margin-left: 9px;">추가</button>
                                    <button type="button" class="btn btn-primary pull-right" id="vocSave" style="margin-left: 9px;">저장</button>
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 9px;" id="vocReset">초기화</button>

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
                        <li><strong><span id="callbackCnt"></span></strong></li>
                        <li class="call-tit">CB완료</li>
                        <li><strong><span id="successCallback"></span></strong></li>
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
<!-- daumAPI -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/sweetalert/custom-sweetalert.min.js"></script><!-- Sweet alert -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/product.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/vocRec.js"></script>
<script>
    $(document).ready(function(){
        $('.ctibtn').hide();
        vocServiceFieldReset();
        voc_send_message();
        setTimeout(function(){
            $('[name="callbackBottomTab"]').trigger('click');
        },700);
    });
</script>
</body>
</html>
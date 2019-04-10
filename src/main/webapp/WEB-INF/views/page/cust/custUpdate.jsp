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
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
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
                <h2>고객 수정</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/cust">고객 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/cust/${custUpdate.CUSTNO}">고객 상세정보</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>고객 수정</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left save">등록</button>
                    <a href="/cust/${custUpdate.CUSTNO}" class="btn btn-default pull-right">취소</a>
                </div>
            </div>

            <br/>

            <div class="row ">
                <div class="col-lg-12">
                    <div class="tabs-container">
                        <ul class="nav nav-tabs" role="tablist">
                            <li><a class="nav-link input-tab-link active" data-toggle="tab" href="#tab-1">고객 정보</a></li>
                            <li><a class="nav-link input-tab-link" data-toggle="tab" href="#tab-2">직장 정보</a></li>
                            <li><a class="nav-link input-tab-link" data-toggle="tab" href="#tab-3">부가 정보</a></li>
                        </ul>
                        <form:form id="command" action="/cust/modified/${custUpdate.CUSTNO}" method="post">
                            <div class="tab-content">
                                <div role="tabpanel" id="tab-1" class="tab-pane active">
                                    <div class="panel-body">

                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">고객명</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm name" id="custname" name="custname" value="${custUpdate.CUSTNAME}">
                                            </div>
                                            <label class="col-sm-2 col-form-label">성별</label>
                                            <div class="radio-inline i-checks">
                                                <c:forEach var="sex" items="${SEX}">
                                                    <label><input type="radio" value="${sex.codeval}" name="sex" ${custUpdate.SEX eq sex.codeval ? "checked" :"" }> <i></i>&nbsp;${sex.codename}</label>&nbsp;&nbsp;
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">생년월일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm date" id="birth" name="birth" value="${custUpdate.BIRTH}" readonly>
                                            </div>
                                            <label class="col-sm-2 col-form-label">이메일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm email" id="email" name="email" value="${custUpdate.EMAIL}">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">휴대전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="mobile1" name="mobile1" required="required">
                                                            <option value="">선택</option>
                                                        <c:forEach var="mobile" items="${MOBILE}">
                                                            <option value="${mobile.codeval}" ${custUpdate.MOBILE1 eq mobile.codeval ? "selected" :"" }>${mobile.codename}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm req-phone" id="mobile2" name="mobile2" value="${custUpdate.MOBILE2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm req-phone" id="mobile3" name="mobile3" value="${custUpdate.MOBILE3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                </div>
                                                <div class="row">
                                                    <label class="error" for="mobile1"></label><label class="error" for="mobile2"></label><label class="error" for="mobile3"></label>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">자택전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="homtel1" name="homtel1">
                                                            <option value="">선택</option>
                                                            <c:forEach var="phone" items="${PHONE}">
                                                                <option value="${phone.codeval}" ${custUpdate.HOMTEL1 eq phone.codeval ? "selected" :"" }>${phone.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="homtel2" name="homtel2" value="${custUpdate.HOMTEL2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="homtel3" name="homtel3" value="${custUpdate.HOMTEL3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">결혼여부</label>
                                            <div class="col-sm-4">
                                                <div class="radio-inline i-checks">
                                                    <select class="form-control m-b" id="married" name="married">
                                                        <option value="0">선택</option>
                                                        <c:forEach var="married" items="${MARRIED}">
                                                            <option value="${married.codeval}" ${custUpdate.MARRIED eq married.codeval ? "selected" :"" }>${married.codename}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <!--<label><input type="radio" value="option1" name="a"> <i></i>&nbsp;미혼</label>&nbsp;&nbsp;
                                                    <label class="radio-inline"><input type="radio" value="option2" name="a"> <i></i>&nbsp;기혼</label>-->
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">결혼기념일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm date" id="weddingday" name="weddingday" value="${custUpdate.WEDDINGDAY}"  readonly>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직업</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm" id="job" name="job" value="${custUpdate.JOB}">
                                            </div>
                                            <label class="col-sm-2 col-form-label">취미</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm" id="hobby" name="hobby" value="${custUpdate.HOBBY}">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">주소</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" class="form-control form-control-sm" id="homaddr1" name="homaddr1" value="${custUpdate.HOMADDR1}" readonly></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm" id="homaddr2" name="homaddr2" value="${custUpdate.HOMADDR2}" readonly></div>
                                                    <div class="col-md-4"><input type="text" class="form-control form-control-sm" id="homaddr3" name="homaddr3" value="${custUpdate.HOMADDR3}"></div>
                                                    <div class="col-md-3"><button class="btn btn-white btn-sm daumzip" type="button" id="homaddr">주소 검색</button></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div role="tabpanel" id="tab-2" class="tab-pane">
                                    <div class="panel-body">

                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">직장명</label>
                                            <div class="col-sm-4 input-group client" id="cliname" >
                                                <input type="text" class="form-control form-control-sm searchparam"  autocomplete="off" name="cliname" value="${custUpdate.CLINAME}" readonly>
                                                <input type="hidden" class="searchparam" name="clino" id="clino" value="${custUpdate.CLINO}">
                                                <span class="input-group-addon" style="height:31px;"> <a><i class="fa fa-search"></i></a> </span>
                                            </div>
                                            <label class="col-sm-2 col-form-label">홈페이지</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm url" id="wrkurl" name="wrkurl" value="${custUpdate.WRKURL}">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">소속 부서</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="deptname" name="deptname" value="${custUpdate.DEPTNAME}">
                                            </div>
                                            <label class="col-sm-2 col-form-label">직책</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="duty" name="duty" value="${custUpdate.DUTY}">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직장 전화</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="wrktel1" name="wrktel1">
                                                            <option value="">선택</option>
                                                            <c:forEach var="phone" items="${PHONE}">
                                                                <option value="${phone.codeval}" ${custUpdate.WRKTEL1 eq phone.codeval ? "selected" : "" }>${phone.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrktel2" name="wrktel2" value="${custUpdate.WRKTEL2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrktel3" name="wrktel3" value="${custUpdate.WRKTEL3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">직장 FAX</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="wrkfax1" name="wrkfax1">
                                                            <option value="">선택</option>
                                                            <c:forEach var="fax" items="${FAX}">
                                                                <option value="${fax.codeval}" ${custUpdate.WRKFAX1 eq fax.codeval ? "selected":"" }>${fax.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrkfax2" name="wrkfax2" value="${custUpdate.WRKFAX2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrkfax3" name="wrkfax3" value="${custUpdate.WRKFAX3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직장 주소</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" class="form-control form-control-sm" id="wrkaddr1" name="wrkaddr1" value="${custUpdate.WRKADDR1}" readonly></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm" id="wrkaddr2" name="wrkaddr2" value="${custUpdate.WRKADDR2}" readonly></div>
                                                    <div class="col-md-4"><input type="text" class="form-control form-control-sm" id="wrkaddr3" name="wrkaddr3" value="${custUpdate.WRKADDR3}"> </div>
                                                    <div class="col-md-3"><button class="btn btn-white btn-sm daumzip" type="button" id="wrkaddr">주소 검색</button></div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div role="tabpanel" id="tab-3" class="tab-pane">
                                    <div class="panel-body" style="margin-bottom: 20px;">
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">회원구분</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="custgubun" name="custgubun">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="custgubun" items="${CUSTGUBUN}">
                                                        <option value="${custgubun.codeval}" ${custUpdate.CUSTGUBUN eq custgubun.codeval ? "selected":""}>${custgubun.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">고객등급</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="custgrade" name="custgrade">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="custgrade" items="${CUSTGRADE}">
                                                        <option value="${custgrade.codeval}" ${custUpdate.CUSTGRADE eq custgrade.codeval ? "selected":""}>${custgrade.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">활동등급</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="actgrade" name="actgrade">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="actgrade" items="${ACTGRADE}">
                                                        <option value="${actgrade.codeval}" ${custUpdate.ACTGRADE eq actgrade.codeval ? "selected":""}>${actgrade.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">발송처</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="mailto" name="mailto">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="mailto" items="${MAILTO}">
                                                        <option value="${mailto.codeval}" ${custUpdate.MAILTO eq mailto.codeval ? "selected":""}>${mailto.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">담당자</label>
                                            <!--<div class="col-sm-2">
                                                <input type="hidden" id="owner" name="owner" value="${custUpdate.OWNER}">
                                                <input type="text" class="form-control form-control-sm" id="owner_" name="owner_" value="${custUpdate.OWNER_}">
                                            </div>-->
                                            <div class="col-sm-2 input-group owner" id="owner_" >
                                                <input type="text" class="form-control form-control-sm searchparam"  autocomplete="off" name="owner_" value="${custUpdate.OWNER_}" readonly>
                                                <input type="hidden" class="searchparam" name="owner" id="owner" value="${custUpdate.OWNER}">
                                                <span class="input-group-addon" style="height:31px;"> <a><i class="fa fa-search"></i></a> </span>
                                            </div>
                                            <label class="col-sm-2 col-form-label">정보활용</label>
                                            <div class="col-sm-2">
                                                <div class="radio-inline i-checks">
                                                    <c:forEach var="infoagree" items="${INFOAGREE}">
                                                        <label><input type="radio" value="${infoagree.codeval}" name="infoagree" ${custUpdate.INFOAGREE eq infoagree.codeval ? "checked":""}> <i></i>&nbsp;${infoagree.codename}</label>&nbsp;&nbsp;
                                                    </c:forEach>
                                                    <!--<label><input type="radio" value="option1" name="a"> <i></i>&nbsp;동의</label>&nbsp;&nbsp;
                                                    <label class="radio-inline"><input type="radio" value="option2" name="a"> <i></i>&nbsp;거부</label>-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <div class="col-sm-2">수신거부</div>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">EMAIL</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denymailnomal" name="denymailnomal" ${custUpdate.DENYMAILNOMAL eq "1" ? "checked":""}>&nbsp; 일반</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denymailsurvey" name="denymailsurvey" ${custUpdate.DENYMAILSURVEY eq "1" ? "checked":""}>&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denymailseminar" name="denymailseminar" ${custUpdate.DENYMAILSEMINAR eq "1" ? "checked":""}>&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denymailad" name="denymailad" ${custUpdate.DENYMAILAD eq "1" ? "checked":""}>&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">SMS</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denysmsnomal" name="denysmsnomal" ${custUpdate.DENYSMSNOMAL eq "1" ? "checked":""}>&nbsp; 일반</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denysmssurvey" name="denysmssurvey" ${custUpdate.DENYSMSSURVEY eq "1" ? "checked":""}>&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denysmsseminar" name="denysmsseminar" ${custUpdate.DENYSMSSEMINAR eq "1" ? "checked":""}>&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denysmsad" name="denysmsad" ${custUpdate.DENYSMSAD eq "1" ? "checked":""}>&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">KAKAO</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denykakaonomal" name="denykakaonomal" ${custUpdate.DENYKAKAONOMAL eq "1" ? "checked":""}>&nbsp; 일반</label>&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denykakaosurvey" name="denykakaosurvey" ${custUpdate.DENYKAKAONOMAL eq "1" ? "checked":""}>&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denykakaoseminar" name="denykakaoseminar" ${custUpdate.DENYKAKAONOMAL eq "1" ? "checked":""}>&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denykakaoad" name="denykakaoad" ${custUpdate.DENYKAKAONOMAL eq "1" ? "checked":""}>&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">DM</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denydmnomal" name="denydmnomal" ${custUpdate.DENYDMNOMAL eq "1" ? "checked":""}>&nbsp; 일반</label>&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmsurvey" name="denydmsurvey" ${custUpdate.DENYDMSURVEY eq "1" ? "checked":""}>&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmseminar" name="denydmseminar" ${custUpdate.DENYDMSEMINAR eq "1" ? "checked":""}>&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmad" name="denydmad" ${custUpdate.DENYDMAD eq "1" ? "checked":""}>&nbsp; 광고</label>
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denydmnews" name="denydmnews" ${custUpdate.DENYDMNEWS eq "1" ? "checked":""}>&nbsp; 뉴스레터</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">전화</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denytelad" name="denytelad" ${custUpdate.DENYTELAD eq "1" ? "checked":""}>&nbsp; 광고</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denytelsurvey" name="denytelsurvey" ${custUpdate.DENYTELSURVEY eq "1" ? "checked":""}>&nbsp; 해피콜</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">기타</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="1" id="denyfax" name="denyfax" ${custUpdate.DENYFAX eq "1" ? "checked":""}>&nbsp; FAX</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="1" id="denyvisit" name="denyvisit" ${custUpdate.DENYVISIT eq "1" ? "checked":""}>&nbsp; 방문</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">메모</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="memo" id="memo" cols="30" rows="5">${custUpdate.MEMO}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>

            <br/>

            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left save">등록</button>
                    <a href="/cust/${custUpdate.CUSTNO}" class="btn btn-default pull-right">취소</a>
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
<!-- validate -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/crud_validate.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<!-- daumAPI -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- crud -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/cust.js"></script>
<script>
    $(document).ready(function() {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>
</html>

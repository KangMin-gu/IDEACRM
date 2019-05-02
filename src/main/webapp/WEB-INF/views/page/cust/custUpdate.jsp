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
<c:set var="menuactive" value='cust'/>
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
                        <a href="${pageContext.request.contextPath}/cust/${custDetail.CUSTNO}">고객 상세정보</a>
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
                    <button type="submit" class="btn btn-default pull-left save">수정</button>
                    <a class="btn btn-default pull-right" href="/cust/${custDetail.CUSTNO}">취소</a>
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
                        <form:form id="command" action="/cust/modified/${custDetail.CUSTNO}" method="post">
                            <div class="tab-content">
                                <div role="tabpanel" id="tab-1" class="tab-pane active">
                                    <div class="panel-body">

                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">고객명</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm name" id="custname" name="custname" value="${custDetail.CUSTNAME}">
                                            </div>
                                            <label class="col-sm-2 col-form-label">성별</label>
                                            <div class="radio-inline i-checks">
                                                <c:forEach var="sex" items="${SEX}">
                                                    <label><input type="radio" value="${sex.codeval}" name="sex" ${custDetail.SEX eq sex.codeval ? "checked" :"" }> <i></i>&nbsp;${sex.codename}</label>&nbsp;&nbsp;
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">생년월일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm date" id="birth" name="birth" value="${custDetail.BIRTH}" readonly>
                                            </div>
                                            <label class="col-sm-2 col-form-label">이메일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm email" id="email" name="email" value="${custDetail.EMAIL}">
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
                                                            <option value="${mobile.codeval}" ${custDetail.MOBILE1 eq mobile.codeval ? "selected" :"" }>${mobile.codename}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm req-phone" id="mobile2" name="mobile2" value="${custDetail.MOBILE2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm req-phone" id="mobile3" name="mobile3" value="${custDetail.MOBILE3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
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
                                                                <option value="${phone.codeval}" ${custDetail.HOMTEL1 eq phone.codeval ? "selected" :"" }>${phone.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="homtel2" name="homtel2" value="${custDetail.HOMTEL2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="homtel3" name="homtel3" value="${custDetail.HOMTEL3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
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
                                                            <option value="${married.codeval}" ${custDetail.MARRIED eq married.codeval ? "selected" :"" }>${married.codename}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">결혼기념일</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm date" id="weddingday" name="weddingday" value="${custDetail.WEDDINGDAY}"  readonly>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직업</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm" id="job" name="job" value="${custDetail.JOB}">
                                            </div>
                                            <label class="col-sm-2 col-form-label">취미</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-sm" id="hobby" name="hobby" value="${custDetail.HOBBY}">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">주소</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" class="form-control form-control-sm" id="homaddr1" name="homaddr1" value="${custDetail.HOMADDR1}" readonly></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm" id="homaddr2" name="homaddr2" value="${custDetail.HOMADDR2}" readonly></div>
                                                    <div class="col-md-4"><input type="text" class="form-control form-control-sm" id="homaddr3" name="homaddr3" value="${custDetail.HOMADDR3}"></div>
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
                                                <input type="text" class="form-control form-control-sm searchparam"  autocomplete="off" name="cliname" value="${custDetail.CLINAME}" readonly>
                                                <input type="hidden" class="searchparam" name="clino" id="clino" value="${custDetail.CLINO}">
                                                <span class="input-group-addon" style="height:31px;"> <a><i class="fa fa-search"></i></a> </span>
                                            </div>
                                            <label class="col-sm-2 col-form-label">홈페이지</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm url" id="wrkurl" name="wrkurl" value="${custDetail.WRKURL}">
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">소속 부서</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="deptname" name="deptname" value="${custDetail.DEPTNAME}">
                                            </div>
                                            <label class="col-sm-2 col-form-label">직책</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control form-control-sm" id="duty" name="duty" value="${custDetail.DUTY}">
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
                                                                <option value="${phone.codeval}" ${custDetail.WRKTEL1 eq phone.codeval ? "selected" : "" }>${phone.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrktel2" name="wrktel2" value="${custDetail.WRKTEL2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrktel3" name="wrktel3" value="${custDetail.WRKTEL3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">직장 FAX</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <select class="form-control m-b" id="wrkfax1" name="wrkfax1">
                                                            <option value="">선택</option>
                                                            <c:forEach var="fax" items="${FAX}">
                                                                <option value="${fax.codeval}" ${custDetail.WRKFAX1 eq fax.codeval ? "selected":"" }>${fax.codename}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrkfax2" name="wrkfax2" value="${custDetail.WRKFAX2}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm phone" id="wrkfax3" name="wrkfax3" value="${custDetail.WRKFAX3}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">직장 주소</label>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-md-2"><input type="text" class="form-control form-control-sm" id="wrkaddr1" name="wrkaddr1" value="${custDetail.WRKADDR1}" readonly></div>
                                                    <div class="col-md-3"><input type="text" class="form-control form-control-sm" id="wrkaddr2" name="wrkaddr2" value="${custDetail.WRKADDR2}" readonly></div>
                                                    <div class="col-md-4"><input type="text" class="form-control form-control-sm" id="wrkaddr3" name="wrkaddr3" value="${custDetail.WRKADDR3}"> </div>
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
                                                        <option value="${custgubun.codeval}" ${custDetail.CUSTGUBUN eq custgubun.codeval ? "selected":""}>${custgubun.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">고객등급</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="custgrade" name="custgrade">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="custgrade" items="${CUSTGRADE}">
                                                        <option value="${custgrade.codeval}" ${custDetail.CUSTGRADE eq custgrade.codeval ? "selected":""}>${custgrade.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">활동등급</label>
                                            <div class="col-sm-2">
                                                <select class="form-control m-b" id="actgrade" name="actgrade">
                                                    <option value="0">선택</option>
                                                    <c:forEach var="actgrade" items="${ACTGRADE}">
                                                        <option value="${actgrade.codeval}" ${custDetail.ACTGRADE eq actgrade.codeval ? "selected":""}>${actgrade.codename}</option>
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
                                                        <option value="${mailto.codeval}" ${custDetail.MAILTO eq mailto.codeval ? "selected":""}>${mailto.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 col-form-label">담당자</label>
                                            <div class="col-sm-2 input-group owner" id="owner_" >
                                                <input type="text" class="form-control form-control-sm searchparam"  autocomplete="off" name="owner_" value="${custDetail.OWNER_}" readonly>
                                                <input type="hidden" class="searchparam" name="owner" id="owner" value="${custDetail.OWNER}">
                                                <span class="input-group-addon" style="height:31px;"> <a><i class="fa fa-search"></i></a> </span>
                                            </div>
                                            <label class="col-sm-2 col-form-label">정보활용</label>
                                            <div class="col-sm-2">
                                                <div class="radio-inline i-checks">
                                                    <c:forEach var="infoagree" items="${INFOAGREE}">
                                                        <label><input type="radio" value="${infoagree.codeval}" name="infoagree" ${custDetail.INFOAGREE eq infoagree.codeval ? "checked":""}> <i></i>&nbsp;${infoagree.codename}</label>&nbsp;&nbsp;
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <div class="col-sm-2">수신거부</div>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">EMAIL</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYMAILNOMAL}" id="denymailnomal" name="denymailnomal" >&nbsp; 일반</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYMAILSURVEY}" id="denymailsurvey" name="denymailsurvey" >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYMAILSEMINAR}" id="denymailseminar" name="denymailseminar" >&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYMAILAD}" id="denymailad" name="denymailad" >&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">SMS</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYSMSNOMAL}" id="denysmsnomal" name="denysmsnomal" >&nbsp; 일반</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYSMSSURVEY}" id="denysmssurvey" name="denysmssurvey" >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYSMSSEMINAR}" id="denysmsseminar" name="denysmsseminar" >&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYSMSAD}" id="denysmsad" name="denysmsad" >&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">KAKAO</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAONOMAL}" id="denykakaonomal" name="denykakaonomal" >&nbsp; 일반</label>&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAOSURVEY}" id="denykakaosurvey" name="denykakaosurvey" >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAOSEMINAR}" id="denykakaoseminar" name="denykakaoseminar" >&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYKAKAOAD}" id="denykakaoad" name="denykakaoad" >&nbsp; 광고</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">DM</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYDMNOMAL}" id="denydmnomal" name="denydmnomal" >&nbsp; 일반</label>&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMSURVEY}" id="denydmsurvey" name="denydmsurvey" >&nbsp; 해피콜</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMSEMINAR}" id="denydmseminar" name="denydmseminar" >&nbsp; 세미나</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMAD}" id="denydmad" name="denydmad" >&nbsp; 광고</label>
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYDMNEWS}" id="denydmnews" name="denydmnews" >&nbsp; 뉴스레터</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">전화</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYTELAD}" id="denytelad" name="denytelad" >&nbsp; 광고</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYTELSURVEY}" id="denytelsurvey" name="denytelsurvey" >&nbsp; 해피콜</label>
                                                </div>
                                                <div class="hr-line-dashed"></div>
                                                <div class="row">
                                                    <label class="col-sm-2 col-form-label">기타</label>
                                                    <label class="checkbox-inline i-checks"> <input type="checkbox" value="${custDetail.DENYFAX}" id="denyfax" name="denyfax" >&nbsp; FAX</label>&nbsp;&nbsp;
                                                    <label class="i-checks"> <input type="checkbox" value="${custDetail.DENYVISIT}" id="denyvisit" name="denyvisit" >&nbsp; 방문</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">메모</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="memo" id="memo" cols="30" rows="5">${custDetail.MEMO}</textarea>
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
                    <a class="btn btn-default pull-right" href="/cust/${custDetail.CUSTNO}">취소</a>
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
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
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
        iCheckClick(false);
    });
</script>
</body>
</html>

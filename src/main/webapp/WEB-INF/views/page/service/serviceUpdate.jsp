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
                <h2>서비스 관리</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/service">서비스 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/service/${serviceInfo.SERVICENO}">서비스 정보</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>서비스 정보 수정</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <form:form action="/service/modified/${serviceInfo.SERVICENO}" method="POST">
                <div class="row">
                    <div class="col-lg-12">
                        <button type="submit" class="btn btn-default pull-left save">저장</button>
                        <a href="/service/${serviceInfo.SERVICENO}" class="btn btn-default pull-right">취소</a>
                    </div>
                </div>

                <br/>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>서비스 정보</h5>
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
                                        <tobdy>
                                            <tr>
                                                <th>고객명</th>
                                                <td>${serviceInfo.CUSTNAME}</td>
                                                    <!--
                                                    <div style="display: inline-block">
                                                        <input type="text" class="form-control form-control-sm" style="width:230px;">
                                                    </div>
                                                    <div style="display: inline-block">
                                                            <a><i class="fa fa-search fa-lg"></i></a>
                                                    </div>
                                                    -->
                                                <!--
                                                    <div class="input-group owner" id="custno_" >
                                                        <input type="text" class="form-control" autocomplete="off" name="custno_" value="${serviceInfo.CUSTNAME}">
                                                        <input type="hidden" name="custno" id="custno" value="${serviceInfo.CUSTNO}">
                                                        <span class="input-group-addon">
                                                            <a><i class="fa fa-search"></i></a>
                                                        </span>
                                                    </div>
                                                </td>
                                                -->
                                                <th>자택전화</th>
                                                <td>${serviceInfo.HOMTEL}</td>
                                                <th>휴대전화</th>
                                                <td>${serviceInfo.MOBILE}</td>
                                                <th>이메일</th>
                                                <td>${serviceInfo.EMAIL}</td>
                                            </tr>
                                            <tr>
                                                <th>고객 주소</th>
                                                <td colspan="7">${serviceInfo.CUSTADDRESS}</td>
                                            </tr>
                                        </tobdy>
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
                                <h5>접수 정보</h5>
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
                                        <tobdy>
                                            <tr>
                                                <th>접수일</th>
                                                <td>
                                                        ${serviceInfo.RECEPTIONDATE_}
                                                </td>
                                                <th>접수자</th>
                                                <td>
                                                        ${serviceInfo.SERVICEOWNER_}
                                                </td>
                                                <th>구분</th>
                                                <td>
                                                        ${serviceInfo.SERVICETYPE_}
                                                </td>
                                                <th>유형</th>
                                                <td>
                                                    ${serviceInfo.SERVICECODE_}
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>처리담당자</th>
                                                <td>
                                                        ${serviceInfo.OWNER_}
                                                </td>
                                                <th>채널</th>
                                                <td>
                                                    ${serviceInfo.SERVICECHANNEL_}
                                                </td>
                                                <th>진행단계</th>
                                                <td>${serviceInfo.SERVICESTEP_}</td>
                                                <th>이관여부</th>
                                                <td>${serviceInfo.CONVEYYN}</td>
                                            </tr>
                                        </tobdy>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row ">

                    <div class="col-lg-12">
                        <div class="tabs-container">
                            <ul class="nav nav-tabs" role="tablist">
                                <li><a class="nav-link active" data-toggle="tab" href="#tab-1">상세정보</a></li>
                                <li><a class="nav-link" data-toggle="tab" href="#tab-2">현상파악</a></li>
                                <li><a class="nav-link" data-toggle="tab" href="#tab-3">처리정보</a></li>
                            </ul>
                            <div class="tab-content">
                                <div role="tabpanel" id="tab-1" class="tab-pane active">
                                    <div class="panel-body">
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
                                                <tobdy>
                                                    <tr>
                                                        <th>제품명</th>
                                                        <td colspan="7">
                                                            <c:forEach var="product" items="${product }">
                                                                <div class="product">
                                                                        ${product.PRODUCTBNAME } / ${product.PRODUCTMNAME } / ${product.PRODUCTSNAME }
                                                                </div>
                                                            </c:forEach>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>접수내용</th>
                                                        <td colspan="7">
                                                            ${serviceInfo.SERVICENAME}
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>상담내용</th>
                                                        <td colspan="7">
                                                            ${serviceInfo.SERVICEDESC}
                                                        </td>
                                                    </tr>
                                                </tobdy>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div role="tabpanel" id="tab-2" class="tab-pane">
                                    <div class="panel-body">
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
                                                <tobdy>
                                                    <tr>
                                                        <th>방문예약일</th>
                                                        <td>
                                                            <div class="input-group" style="width:230px;">
                                                                <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                                <input class="form-control form-control-sm date reward" autocomplete="off" name="visitdate" id="visitdate" type="text"  value="${rewardInfo.VISITDATE_}" />
                                                            </div>
                                                        </td>
                                                        <th>방문예약시간</th>
                                                        <td>
                                                            <div style="display: inline-block">
                                                                <select class="form-control reward" name="visitapm" id="visitapm" style="width:70px;">
                                                                    <option value="0">선택</option>
                                                                    <c:forEach var="apm" items="${APM }">
                                                                        <c:choose>
                                                                            <c:when test="${rewardInfo.VISITAPM eq apm.codeval}">
                                                                                <option selected label="${apm.codename }" value="${apm.codeval }"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option label="${apm.codename }" value="${apm.codeval }"/>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>

                                                                </select>
                                                            </div>
                                                            <div style="display: inline-block">
                                                                <select class="form-control reward" name="visithour" id="visithour" style="width:70px;">
                                                                    <c:forEach var="hour" items="${HOUR }">
                                                                        <c:choose>
                                                                            <c:when test="${rewardInfo.VISITHOUR eq hour.codeval}">
                                                                                <option selected label="${hour.codename }" value="${hour.codeval }"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option label="${hour.codename }" value="${hour.codeval }"/>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <span style="display: inline-block">시</span>
                                                            <div style="display: inline-block">
                                                                <select class="form-control reward" name="visitminute" id="visitminute" style="width:70px;">
                                                                    <c:forEach var="minute" items="${MINUTE }">
                                                                        <c:choose>
                                                                            <c:when test="${rewardInfo.VISITMINUTE eq minute.codeval}">
                                                                                <option selected label="${minute.codename }" value="${minute.codeval }"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option label="${minute.codename }" value="${minute.codeval }"/>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <span style="display: inline-block">분</span>
                                                        </td>
                                                        <th>담당자</th>
                                                        <td>
                                                            <div class="input-group" style="width:200px;">
                                                                <input type="text" class="form-control reward" autocomplete="off" name="rewardowner_" value="${serviceInfo.OWNER_}" style="width:150px;">
                                                                <input type="hidden" name="rewardowner" id="rewardowner" class="reward" value="${serviceInfo.OWNER}">
                                                                <span class="input-group-addon">
                                                                    <a><i class="fa fa-search"></i></a>
                                                                </span>
                                                            </div>
                                                        </td>
                                                        <th>현상</th>
                                                        <td>
                                                            <select class="form-control reward" style="width:180px;" name="rewardtype" id="rewardtype">
                                                                <option value="0">선택</option>
                                                                <c:forEach var="rewardType" items="${REWARDTYPE }">
                                                                    <c:choose>
                                                                        <c:when test="${rewardInfo.REWARDTYPE eq rewardType.codeval}">
                                                                            <option selected label="${rewardType.codename }" value="${rewardType.codeval }"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option label="${rewardType.codename }" value="${rewardType.codeval }"/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:forEach>
                                                            </select>
                                                        </td>
                                                        <th>지연원인구분</th>
                                                        <td>
                                                            <select class="form-control reward" style="width:180px;" name="causecode" id="causecode">
                                                                <option value="0">선택</option>
                                                                <c:forEach var="causeCode" items="${CAUSECODE }">
                                                                    <c:choose>
                                                                        <c:when test="${rewardInfo.CAUSECODE eq causeCode.codeval}">
                                                                            <option selected label="${causeCode.codename }" value="${causeCode.codeval }"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option label="${causeCode.codename }" value="${causeCode.codeval }"/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:forEach>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>방문주소</th>
                                                        <td colspan="9">
                                                            <div style="display: inline-block"><input type="text" id="visitaddr1" name="visitaddr1" class="form-control form-control-sm reward" value="${rewardInfo.VISITADDR1}"></div>
                                                            <div style="display: inline-block"><input type="text" id="visitaddr2" name="visitaddr2" class="form-control form-control-sm reward" value="${rewardInfo.VISITADDR2}"></div>
                                                            <div style="display: inline-block"><input type="text" id="visitaddr3" name="visitaddr3" class="form-control form-control-sm reward" value="${rewardInfo.VISITADDR3}"></div>
                                                            <div style="display: inline-block"><button class="btn btn-white btn-sm daumzip reward" id="visitaddr" type="submit">주소 검색</button></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>상세내역</th>
                                                        <td colspan="9">
                                                            <textarea class="tinymce reward" id="rewarddesc" name="rewarddesc">${rewardInfo.REWARDDESC}</textarea>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>지연사유</th>
                                                        <td colspan="9">
                                                            <textarea id="delaydesc" name="delaydesc" class="form-control reward" style="resize: none;" rows="4">${rewardInfo.DELAYDESC}</textarea>
                                                        </td>
                                                    </tr>
                                                </tobdy>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                                <div role="tabpanel" id="tab-3" class="tab-pane">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered" style="white-space:nowrap;">
                                                <colgroup>
                                                    <col width="5%">
                                                    <col width="25%">
                                                    <col width="5%">
                                                    <col width="25%">
                                                    <col width="5%">
                                                    <col width="25%">
                                                </colgroup>
                                                <tobdy>
                                                    <tr>
                                                        <th>처리일</th>
                                                        <td>
                                                            <div class="input-group" style="width:230px;">
                                                                <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                                <input class="form-control form-control-sm date ract" autocomplete="off" type="text" id="ractdate" name="ractdate" value="${ractInfo.RACTDATE}"  />
                                                            </div>
                                                        </td>
                                                        <th>처리담당자</th>
                                                        <td>
                                                            <div class="input-group owner" id="ractowner_" >
                                                                <input type="text" class="form-control ract" autocomplete="off" name="ractowner_" value="${serviceInfo.OWNER_}">
                                                                <input type="hidden" name="ractowner ract" id="ractowner" value="${serviceInfo.OWNER}">
                                                                <span class="input-group-addon">
                                                                <a><i class="fa fa-search"></i></a>
                                                            </span>
                                                            </div>
                                                        </td>
                                                        <th>처리발송여부</th>
                                                        <td>
                                                            <select class="form-control ract" style="width:230px;">
                                                                <option value="0">발송</option>
                                                                <option value="1">미발송</option>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>처리내용</th>
                                                        <td colspan="5">
                                                            <textarea class="tinymce ract" name="ractdesc" id="ractdesc">${ractInfo.RACTDESC}</textarea>
                                                        </td>
                                                    </tr>
                                                </tobdy>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>

                <br/>

            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left save">저장</button>
                    <a href="/service/${serviceInfo.SERVICENO}" class="btn btn-default pull-right">취소</a>
                </div>
            </div>

                <br/>

                <input type="hidden" class="" name="serviceno" id="serviceno" value="${serviceInfo.SERVICENO}"/>
                <input type="hidden" class="" name="servicestep" id="servicestep" value="${serviceInfo.SERVICESTEP}"/>

                <c:choose>
                    <c:when test="${rewardInfo.REWARDNO eq null}">
                        <input type="hidden" class="" name="rewardno" id="rewardno" value="0"/>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" class="" name="rewardno" id="rewardno" value="${rewardInfo.REWARDNO}"/>
                    </c:otherwise>
                </c:choose>
            <c:choose>
                <c:when test="${ractInfo.RACTNO eq null}">
                    <input type="hidden" class="" name="ractno" id="ractno" value="0"/>
                </c:when>
                <c:otherwise>
                    <input type="hidden" class="" name="ractno" id="ractno" value="${ractInfo.RACTNO}"/>
                </c:otherwise>
            </c:choose>
                <input type="hidden" class="" name="custno" id="custno" value="${serviceInfo.CUSTNO}"/>
            </form:form>
        </div>


        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/plugins/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>

<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- daumAPI -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- api js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/service.js"></script>
<script>
    $(document).ready(function() {
        serviceStep();
    });

</script>
</body>
</html>

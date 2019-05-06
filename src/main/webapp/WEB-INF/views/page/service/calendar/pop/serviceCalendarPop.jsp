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
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
</head>
<style>
</style>
<body class="gray-bg">
<br/>
<a class="btn btn-default pull-right" style="margin-right: 10px;" id="submitBtn"  onclick="javascript:moveDetail();">서비스 상세로 이동</a>
<div class="wrapper wrapper-content animated fadeInRight">
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
                                    <td id="custname">${serviceInfo.CUSTNAME}
                                        <input type="hidden" id="custno" name="custno" value="${serviceInfo.CUSTNO}"/>
                                    </td>
                                    <th>자택전화</th>
                                    <td id="homtel">${serviceInfo.HOMTEL1} ${serviceInfo.HOMTEL2} ${serviceInfo.HOMTEL3}</td>
                                    <th>휴대전화</th>
                                    <td id="mobile">${serviceInfo.MOBILE1} ${serviceInfo.MOBILE2} ${serviceInfo.MOBILE3}</td>
                                    <th>이메일</th>
                                    <td id="email">${serviceInfo.EMAIL}</td>
                                </tr>
                                <tr>
                                    <th>고객 주소</th>
                                    <td colspan="7">${serviceInfo.HOMADDR1} ${serviceInfo.HOMADDR2} ${serviceInfo.HOMADDR3}</td>
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
                                    <td>${serviceInfo.RECEPTIONDATE_}</td>
                                    <th>접수자</th>
                                    <td>${serviceInfo.SERVICEOWNER_}</td>
                                    <th>구분</th>
                                    <td>${serviceInfo.SERVICETYPE_}</td>
                                    <th>유형</th>
                                    <td>${serviceInfo.SERVICECODE_} </td>
                                </tr>
                                <tr>
                                    <th>처리담당자</th>
                                    <td>${serviceInfo.OWNER_}</td>
                                    <th>채널</th>
                                    <td>${serviceInfo.SERVICECHANNEL_}</td>
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
                                        </tr>
                                        <tr>
                                            <th>접수내용</th>
                                            <td colspan="7">${serviceInfo.SERVICENAME}</td>
                                        </tr>
                                        <tr>
                                            <th>상담내용</th>
                                            <td colspan="5">${serviceInfo.SERVICEDESC}</td>
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
                                    <tobdy>
                                        <tr>
                                            <th>방문예약일</th>
                                            <td>${rewardInfo.VISITDATE_}</td>
                                            <th>방문예약시간</th>
                                            <td>${rewardInfo.VISITTIME_}</td>
                                            <th>담당자</th>
                                            <td>${serviceInfo.OWNER_}</td>
                                            <th>현상</th>
                                            <td>${rewardInfo.REWARDTYPE_}</td>
                                            <th>지연원인구분</th>
                                            <td>${rewardInfo.CAUSECODE_}</td>
                                        </tr>
                                        <tr>
                                            <th>방문주소</th>
                                            <td colspan="9">${rewardInfo.VISITADDR1} ${rewardInfo.VISITADDR2} ${rewardInfo.VISITADDR3}</td>
                                        </tr>
                                        <tr>
                                            <th>상세내역</th>
                                            <td colspan="9">${rewardInfo.REWARDDESC}</td>
                                        </tr>
                                        <tr>
                                            <th>지연사유</th>
                                            <td colspan="9">${rewardInfo.DELAYDESC}</td>
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
                                            <td>${ractInfo.RACTDATE_}</td>
                                            <th>처리담당자</th>
                                            <td>${serviceInfo.OWNER_}</td>
                                            <th>처리발송여부</th>
                                            <td>${ractInfo.SENDYN_}</td>
                                        </tr>
                                        <tr>
                                            <th>처리내용</th>
                                            <td colspan="5">${ractInfo.RACTDESC}</td>
                                        </tr>
                                    </tobdy>
                                </table>
                                <input type="hidden" id="serviceno" name="serviceno" value="${serviceInfo.SERVICENO}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <br/>

    <div class="row ">
        <div class="col-lg-12">
            <div class="tabs-container">
                <ul class="nav nav-tabs detail" role="tablist">
                    <li><a class="nav-link active" data-toggle="tab" href="#tab-4">처리이력</a></li>
                    <li><a class="nav-link" data-toggle="tab" href="#tab-5">이관이력</a></li>
                </ul>

                <div class="tab-content">
                    <div role="tabpanel" id="tab-4" url="/service/tab/ract/${serviceInfo.SERVICENO}" class="tab-pane active">
                        <div class="panel-body">
                            <table class="tabfootable table table-stripped">
                                <thead>
                                <tr>
                                    <th data-visible="false" data-name="RACTNO">처리번호</th>
                                    <th data-name="RACTDATE_">처리일</th>
                                    <th data-name="RACTTYPE_">처리유형</th>
                                    <th data-name="OWNER_">담당자</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="9">
                                        <ul class="pagination pull-left"></ul>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>

                    <div role="tabpanel" id="tab-5" url="/service/tab/delivery/${serviceInfo.SERVICENO}" class="tab-pane">
                        <div class="panel-body">
                            <table class="tabfootable table table-stripped" data-sorting="true">
                                <thead>
                                <tr>
                                    <th data-visible="false" data-name="CONVEYLNO">이관번호</th>
                                    <th data-name="CONVEYDATE">이관일자</th>
                                    <th data-name="CONVEYREASON_">이관사유</th>
                                    <th data-name="PREVOWNER_">이전담당자</th>
                                    <th data-name="NEXTOWNER_">이관 담당자</th>
                                    <th data-name="CONVEYDESC">비고</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="3">
                                        <ul class="pagination pull-right"></ul>
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

    <br/>
</div>


<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>


<!-- footable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!-- common -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<!-- api,service -->
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/service.js"></script>

</body>
</html>
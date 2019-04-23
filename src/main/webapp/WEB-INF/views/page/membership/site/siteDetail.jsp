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
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
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
                <h2>회원사 정보</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <c:if test="${sessionScope.CHKAUTH eq '30'}">
                        <li class="breadcrumb-item active">
                            <a href="${pageContext.request.contextPath}/common/site">회원사 목록</a>
                        </li>
                    </c:if>
                    <li class="breadcrumb-item">
                        <strong>회원사 정보</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">

                <div class="col-lg-12">
                    <form:form action="/common/site/del/${siteInfo.SITEID}" method="POST">
                        <c:if test="${sessionScope.CHKAUTH eq '20' or sessionScope.CHKAUTH eq '30'}">
                            <c:if test="${sessionScope.CHKAUTH eq '30'}">
                                <a href="/common/site" class="btn btn-default pull-left">목록</a>
                                <button type="submit" class="btn btn-default pull-right">삭제</button>
                            </c:if>
                            <a href="/common/site/modified/${siteInfo.SITEID}" class="btn btn-default pull-right">수정</a>
                        </c:if>
                    </form:form>
                </div>

            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>회원사 정보</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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
                                        <th>회원사명</th>
                                        <td><span id="sitename">${siteInfo.SITENAME}</span></td>
                                        <th>사업자번호</th>
                                        <td>${siteInfo.BSNO}</td>
                                        <th>법인번호</th>
                                        <td>${siteInfo.INCNO}</td>
                                        <th>대표자명</th>
                                        <td>${siteInfo.PRSDNAME}</td>
                                    </tr>
                                    <tr>
                                        <th>전화번호</th>
                                        <td>${siteInfo.TELNO}</td>
                                        <th>팩스번호</th>
                                        <td>${siteInfo.FAXTEL}</td>
                                        <th>휴대전화</th>
                                        <td>${siteInfo.MOBILE}</td>
                                        <th>이메일</th>
                                        <td>${siteInfo.EMAIL}</td>
                                    </tr>
                                    <tr>
                                        <th>업태</th>
                                        <td>${siteInfo.COTYPE}</td>
                                        <th>업종</th>
                                        <td>${siteInfo.BSCOND}</td>
                                        <th>종목</th>
                                        <td>${siteInfo.BSTYPE}</td>
                                        <th>기업규모</th>
                                        <td>${siteInfo.SITESIZE_}</td>
                                    </tr>
                                    <tr>
                                        <th rowspan="3">주소 및 위치</th>
                                        <td colspan="8">${siteInfo.ADDR1}<span id="addr"> ${siteInfo.ADDR2} ${siteInfo.ADDR3}</span></td>
                                    </tr>
                                    <tr>
                                        <td colspan="8"><div id="map" style="width:100%;height:300px;"></div></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <!-- 회원사상태 및 계약정보는 manager만 권한. -->
            <c:if test="${sessionScope.CHKAUTH eq '30'}">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>회원사 상태</h5>
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
                                        <th>가입일</th>
                                        <td>${siteInfo.FREGDATE_}</td>
                                        <th>서비스상태</th>
                                        <td>${siteInfo.ISDELETE_}</td>
                                        <th>담당자</th>
                                        <td>${siteInfo.OWNER_}</td>
                                    </tr>
                                    <tr>
                                        <th>계정</th>
                                        <td>${siteInfo.ADMINID}</td>
                                        <th>비밀번호</th>
                                        <td><button type="button" class="btn btn-w-m btn-xs btn-primary">초기화</button></td>
                                        <th>회원사로고</th>
                                        <td>${siteInfo.SITELOGO}</td>
                                    </tr>
                                    <tr>
                                        <th>회원사 메모</th>
                                        <td colspan="11">${siteInfo.SITEMEMO}</td>
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
                            <h5>CTI 정보</h5>
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
                                        <th>CTI 서버 IP</th>
                                        <td>${ctiInfo.IP}</td>
                                        <th>CTI 소켓 IP</th>
                                        <td>${ctiInfo.SOCKETIP}</td>
                                        <th>CTI PORT</th>
                                        <td>${ctiInfo.PORT}</td>
                                        <th>CTI 대표번호</th>
                                        <td>${ctiInfo.TELNO}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <br/>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>계약정보</h5>
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
                                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">사용자</a></li>
                                            <li><a class="nav-link license" data-toggle="tab" href="#tab-2">라이센스</a></li>
                                            <li><a class="nav-link totalCnt" data-toggle="tab" href="#tab-3">IDEACRM 발송수</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" id="tab-1" url="/common/site/tab/user/${siteInfo.SITEID}" class="tab-pane active">
                                                <div class="panel-body">
                                                    <a href="${pageContext.request.contextPath}/company/user/input" class="btn btn-w-m btn-xs pull-right btn-primary" style="margin-bottom: 10px;">사용자등록</a>
                                                    <table class="tabfootable table table-stripped">
                                                        <thead>
                                                        <tr>
                                                            <th data-visible="false" data-sorted="true" data-direction="DESC" data-name="NO">고객번호</th>
                                                            <th data-visible="false" data-name="URL">URL</th>
                                                            <th data-name="USERNAME" data-formatter="formatter">사용자명</th>
                                                            <th data-name="USERID" data-breakpoints="xs sm">사용자ID</th>
                                                            <th data-name="MOBILE" data-breakpoints="xs sm">전화번호</th>
                                                            <th data-name="EMAIL" data-breakpoints="xs sm">이메일</th>
                                                            <th data-name="USERDUTY" data-breakpoints="xs sm">직책</th>
                                                            <th data-name="FREGDATE_" data-breakpoints="xs sm">입사일자</th>
                                                            <th data-name="CHKAUTH_" data-breakpoints="xs sm">사용자권한</th>
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
                                            <div role="tabpanel" id="tab-2" class="tab-pane">
                                                <div class="panel-body">
                                                    <a href="${pageContext.request.contextPath}/license/${siteInfo.SITEID}" class="btn btn-w-m btn-xs pull-right btn-primary" style="margin-bottom: 10px;">라이센스관리</a>
                                                    <div class="table-responsive">
                                                        <table class="table table-bordered" style="white-space:nowrap;">
                                                            <colgroup>
                                                                <col width="5%">
                                                                <col width="5%">
                                                                <col width="5%">
                                                                <col width="5%">
                                                                <col width="5%">
                                                            </colgroup>
                                                            <tbody>
                                                            <tr>
                                                                <th>모듈명</th>
                                                                <th>상태</th>
                                                                <th>수량</th>
                                                                <th>현재사용량</th>
                                                                <th>반영날짜</th>
                                                            </tr>
                                                            <tr>
                                                                <th><span name="licenseno" id="custlicenseno" value="1">고객관리</span></th>
                                                                <td><span name="isdelete" id="custisdelete"></span></td>
                                                                <td><span name="licensecnt" id="custlicensecnt"></span></td>
                                                                <td><span name="usecnt" id="custusecnt"></span></td>
                                                                <td><span name="edtdate" id="custedtdate"></span></td>
                                                            </tr>
                                                            <tr>
                                                                <th><span name="licenseno" id="accountcenseno" value="2">영업관리</span></th>
                                                                <td><span name="isdelete" id="accountisdelete"></span></td>
                                                                <td><span name="licensecnt" id="accountlicensecnt"></span></td>
                                                                <td><span name="usecnt" id="accountusecnt"></span></td>
                                                                <td><span name="edtdate" id="accountedtdate"></span></td>
                                                            </tr>
                                                            <tr>
                                                                <th><span name="licenseno" id="servicelicenseno" value="3">서비스관리</span></th>
                                                                <td><span name="isdelete" id="serviceisdelete"></span></td>
                                                                <td><span name="licensecnt" id="servicelicensecnt"></span></td>
                                                                <td><span name="usecnt" id="serviceusecnt"></span></td>
                                                                <td><span name="edtdate" id="serviceedtdate"></span></td>
                                                            </tr>
                                                            <tr>
                                                                <th><span name="licenseno" id="campaignlicenseno" value="4">캠페인</span></th>
                                                                <td><span name="isdelete" id="campaignisdelete"></span></td>
                                                                <td><span name="licensecnt" id ="campaignlicensecnt"></span></td>
                                                                <td><span name="usecnt" id="campaignusecnt"></span></td>
                                                                <td><span name="edtdate" id="campaignedtdate"></span></td>
                                                            </tr>
                                                            <tr>
                                                                <th><span name="licenseno" id="voclicenseno" value="5">콜센터</span></th>
                                                                <td><span name="isdelete" id="vocisdelete"></span></td>
                                                                <td><span name="licensecnt" id="voclicensecnt"></span></td>
                                                                <td><span name="usecnt" id="ctiusecnt"></span></td>
                                                                <td><span name="edtdate" id="ctiedtdate"></span></td>
                                                            </tr>
                                                            <tr>
                                                                <th>라이센스활성수</th>
                                                                <td colspan="2"><span id="totallicensecnt"></span></td>
                                                                <th>총 사용량</th>
                                                                <td colspan="2"><span id="totalusercnt"></span></td>
                                                            </tr>
                                                            </tbody>
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
                                                                <col width="15%">
                                                                <col width="15%">
                                                                <col width="15%">
                                                                <col width="15%">
                                                                <col width="15%">
                                                            </colgroup>
                                                            <tbody>
                                                                <tr>
                                                                    <td><span id="daterange"></span></td>
                                                                    <th>SMS</th>
                                                                    <th>MMS</th>
                                                                    <th>LMS</th>
                                                                    <th>KAKAO</th>
                                                                    <th>EMAIL</th>
                                                                </tr>
                                                                <tr>
                                                                    <th>단가</th>
                                                                    <td><span id="smscharge"></span></td>
                                                                    <td><span id="mmscharge"></span></td>
                                                                    <td><span id="lmscharge"></span></td>
                                                                    <td><span id="kakaocharge"></span></td>
                                                                    <td><span id="emailcharge"></span></td>
                                                                </tr>
                                                                <tr>
                                                                    <th>발송수</th>
                                                                    <td><span id="smscnt"></span></td>
                                                                    <td><span id="mmscnt"></span></td>
                                                                    <td><span id="lmscnt"></span></td>
                                                                    <td><span id="kakaocnt"></span></td>
                                                                    <td><span id="emailcnt"></span></td>
                                                                </tr>
                                                                <tr>
                                                                    <th>금액(원)</th>
                                                                    <td><span id="smstotal"></span></td>
                                                                    <td><span id="mmstotal"></span></td>
                                                                    <td><span id="lmstotal"></span></td>
                                                                    <td><span id="kakaototal"></span></td>
                                                                    <td><span id="emailtotal"></span></td>
                                                                </tr>
                                                                <tr>
                                                                    <th colspan="4">총금액(원)</th>
                                                                    <td colspan="2"><span id="mergemoney"></span></td>
                                                                </tr>
                                                            </tbody>
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
            </div>
                <input type="hidden" class="searchparam" id="todayfr" name="todayfr" value="">
                <input type="hidden" class="searchparam" id="todayto" name="todayto" value="">
                <input type="hidden" class="searchparam" id="siteid" name="siteid" value="${siteInfo.SITEID}"/>
            </c:if>





            <div class="row">
                <div class="col-lg-12">
                    <form:form action="/common/site/del/${siteInfo.SITEID}" method="POST">
                        <c:if test="${sessionScope.CHKAUTH eq '20'}">
                            <c:if test="${sessionScope.CHKAUTH eq '30'}">
                                <a href="/common/site" class="btn btn-default pull-left">목록</a>
                                <button type="submit" class="btn btn-default pull-right">삭제</button>
                            </c:if>
                            <a href="/common/site/modified/${siteInfo.SITEID}" class="btn btn-default pull-right">수정</a>
                        </c:if>
                    </form:form>
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
<!-- Jasny -->
<script src="${pageContext.request.contextPath}/resources/js/jasny-bootstrap.min.js"></script>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<!-- daum map -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=60c1fc75825cf6619b0ff66b5aca7161&libraries=services"></script>

<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/site.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/license.js"></script>
<script>
    $(document).ready(function() {
        map('map','addr','sitename');
        var todayto = today();
        var todayfr = todayto.substring(0,8) +'01';

        $('#daterange').text(todayfr + '~' + todayto);

        $('#todayto').val(todayto);
        $('#todayfr').val(todayfr);

        $('.license').click(function(e){
            var siteid = $('#siteid').val();
            licenseDetailPage(siteid);
        });
    });
</script>
</body>
</html>

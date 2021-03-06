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
    <link href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css" rel="stylesheet">
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
                <h2>회원사 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <c:if test="${sessionScope.CHKAUTH eq '30'}">
                        <li class="breadcrumb-item active">
                            <a href="${pageContext.request.contextPath}/common/site">회원사 목록</a>
                        </li>
                    </c:if>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/common/site/${siteInfo.SITEID}">회원사 정보</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>회원사 정보 수정</strong>
                    </li>
                </ol>
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <form:form id="logoFile" action="/common/site/modified/${siteInfo.SITEID}" method="POST" enctype="multipart/form-data">
            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left">저장</button>
                    <a href="/common/site/${siteInfo.SITEID}" class="btn btn-default pull-right">취소</a>
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
                                            <td><input type="text" class="form-control form-control-sm name" name="sitename" required id="sitename" value="${siteInfo.SITENAME}" style="width:248px;"></td>
                                            <th>사업자번호</th>
                                            <td>
                                                <div style="display: inline-block"><input type="text" name="bsno1" id="bsno1" minlength="3" maxlength="3" class="form-control form-control-sm" value="${siteInfo.BSNO1}" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" name="bsno2" id="bsno2" minlength="2" maxlength="2" class="form-control form-control-sm" value="${siteInfo.BSNO2}" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" name="bsno3" id="bsno3" minlength="5" maxlength="5" class="form-control form-control-sm" value="${siteInfo.BSNO3}" style="width:80px;"></div>
                                                <div>
                                                    <label class="error" for="bsno1"></label><label class="error" for="bsno2"></label><label class="error" for="bsno3"></label>
                                                </div>
                                            </td>
                                            <th>법인번호</th>
                                            <td>
                                                <div style="display: inline-block"><input type="text" name="incno1" id="incno1" minlength="6" maxlength="6" class="form-control form-control-sm" value="${siteInfo.INCNO1}" style="width:123px;"></div>
                                                <div style="display: inline-block"><input type="text" name="incno2" id="incno2" minlength="7" maxlength="7" class="form-control form-control-sm" value="${siteInfo.INCNO2}" style="width:123px;"></div>
                                                <div>
                                                    <label class="error" for="incno1"></label><label class="error" for="incno2"></label>
                                                </div>
                                            </td>
                                            <th>대표자명</th>
                                            <td><input type="text" class="form-control form-control-sm" name="prsdname" id="prsdname" value="${siteInfo.PRSDNAME}" style="width:230px;"></td>
                                        </tr>
                                        <tr>
                                            <th>전화번호</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control testconnect" name="telno1" id="telno1" style="width:80px;">
                                                        <option value="0" label="선택"></option>
                                                        <c:forEach var="phone" items="${PHONE}">
                                                            <c:choose>
                                                                <c:when test="${siteInfo.TELNO1 eq phone.codeval}">
                                                                    <option selected label="${phone.codename }" value="${phone.codeval }"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option label="${phone.codename }" value="${phone.codeval }"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block"><input type="text" name="telno2" id="telno2" minlength="3" maxlength="4" class="form-control form-control-sm testconnect" value="${siteInfo.TELNO2}" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" name="telno3" id="telno3" minlength="3" maxlength="4" class="form-control form-control-sm testconnect" value="${siteInfo.TELNO3}" style="width:80px;"></div>
                                                <div>
                                                    <label class="error" for="telno1"></label><label class="error" for="telno2"></label><label class="error" for="telno3"></label>
                                                </div>
                                            </td>
                                            <th>팩스번호</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control" name="faxtel1" id="faxtel1" style="width:80px;">
                                                        <option value="0" label="선택"></option>
                                                        <c:forEach var="fax" items="${FAX}">
                                                            <c:choose>
                                                                <c:when test="${siteInfo.FAXTEL1 eq fax.codeval}">
                                                                    <option selected label="${fax.codename }" value="${fax.codeval }"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option label="${fax.codename }" value="${fax.codeval }"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block"><input type="text" name="faxtel2" id="faxtel2" minlength="3" maxlength="4" class="form-control form-control-sm req-phone" value="${siteInfo.FAXTEL2}" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" name="faxtel3" id="faxtel3" minlength="3" maxlength="4" class="form-control form-control-sm req-phone" value="${siteInfo.FAXTEL3}" style="width:80px;"></div>
                                                <div>
                                                    <label class="error" for="faxtel1"></label><label class="error" for="faxtel2"></label><label class="error" for="faxtel3"></label>
                                                </div>
                                            </td>
                                            <th>휴대전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control" name="mobile1" id="mobile1" style="width:80px;">
                                                        <option value="0" label="선택"></option>
                                                        <c:forEach var="mobile" items="${MOBILE}">
                                                            <c:choose>
                                                                <c:when test="${siteInfo.MOBILE1 eq mobile.codeval}">
                                                                    <option selected label="${mobile.codename }" value="${mobile.codeval }"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option label="${mobile.codename }" value="${mobile.codeval }"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block"><input type="text" name="mobile2" id="mobile2" minlength="3" maxlength="4" class="form-control form-control-sm req-phone" value="${siteInfo.MOBILE2}" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" name="mobile3" id="mobile3" minlength="3" maxlength="4" class="form-control form-control-sm req-phone" value="${siteInfo.MOBILE3}" style="width:80px;"></div>
                                                <div>
                                                    <label class="error" for="mobile1"></label><label class="error" for="mobile2"></label><label class="error" for="mobile3"></label>
                                                </div>
                                            </td>
                                            <th>이메일</th>
                                            <td><input type="text" class="form-control form-control-sm" name="email" id="email" value="${siteInfo.EMAIL}" style="width:230px;"></td>
                                        </tr>
                                        <tr>
                                            <th>업태</th>
                                            <td><input type="text" class="form-control form-control-sm" name="cotype" id="cotype" value="${siteInfo.COTYPE}" style="width:248px;"></td>
                                            <th>업종</th>
                                            <td><input type="text" class="form-control form-control-sm" name="bscond" id="bscond" value="${siteInfo.BSCOND}" style="width:248px;"></td>
                                            <th>종목</th>
                                            <td><input type="text" class="form-control form-control-sm" name="bstype" id="bstype" value="${siteInfo.BSTYPE}" style="width:248px;"></td>
                                            <th>기업규모</th>
                                            <td>
                                                <select class="form-control" name="sitesize" id="sitesize" style="width:230px;">
                                                    <option value="0" label="선택"></option>
                                                    <c:forEach var="companySize" items="${COMPANYSIZE}">
                                                        <c:choose>
                                                            <c:when test="${siteInfo.SITESIZE eq companySize.codeval}">
                                                                <option selected label="${companySize.codename }" value="${companySize.codeval }"/>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option label="${companySize.codename }" value="${companySize.codeval }"/>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th rowspan="3">주소 및 위치</th>
                                            <td colspan="8">
                                                <div style="display: inline-block"><input type="text" name="addr1" id="addr1" readonly class="form-control form-control-sm" value="${siteInfo.ADDR1}"></div>
                                                <div style="display: inline-block"><input type="text" name="addr2" id="addr2" readonly class="form-control form-control-sm" value="${siteInfo.ADDR2}"></div>
                                                <div style="display: inline-block"><input type="text" name="addr3" id="addr3" class="form-control form-control-sm" value="${siteInfo.ADDR3}"></div>
                                                <div style="display: inline-block"><button class="btn btn-white btn-sm daumzip" type="submit">주소 검색</button></div>
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
                                        <td>
                                                ${siteInfo.OWNER_}
                                            <input type="hidden" name="owner" id="owner" value="${siteInfo.OWNER}"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>계정</th>
                                        <td>${siteInfo.ADMINID}</td>
                                        <th>비밀번호</th>
                                        <td>
                                            <c:if test="${sessionScope.CHKAUTH eq '30'}">
                                                <button type="button" id="passwordreset" class="btn btn-w-m btn-xs btn-primary ">초기화</button>
                                            </c:if>
                                        </td>
                                        <th>회원사로고</th>
                                        <td>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                    <span class="btn btn-outline-secondary btn-file">
                                                        <span class="fileinput-new">파일선택</span>
                                                        <span class="fileinput-exists">변경</span>
                                                        <input id="files" type="file" class="logoChk" name="file" multiple>
                                                    </span>
                                                <span id="logoChk" class="fileinput-filename"></span>
                                                <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="float: none">&times;</a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>회원사 메모</th>
                                        <td colspan="11">
                                            <textarea name="sitememo" id="sitememo" class="form-control" style="resize: none;" value="${siteInfo.SITEMEMO}" rows="4">${siteInfo.SITEMEMO}</textarea>
                                        </td>
                                    </tr>
                                    </tbody>
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
                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">CTI 정보</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-2">Kakao 정보</a></li>
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
                                            <tbody>
                                            <tr>
                                                <th>CTI 서버 IP</th>
                                                <td>
                                                    <input type="text" name="ip" id="ip" class="form-control form-control-sm" value="${ctiInfo.IP}" style="width:200px;">
                                                </td>
                                                <th>CTI 소켓 IP</th>
                                                <td>
                                                    <input type="text" name="socketip" id="socketip" class="form-control form-control-sm" value="${ctiInfo.SOCKETIP}" style="width:200px;">
                                                </td>
                                                <th>CTI PORT</th>
                                                <td>
                                                    <input type="text" name="port" id="port" class="form-control form-control-sm" value="${ctiInfo.PORT}" style="width:200px;">
                                                </td>
                                                <th>CTI 대표번호</th>
                                                <td>
                                                    <input type="text" name="telno" id="telno" class="form-control form-control-sm" value="${ctiInfo.TELNO}" style="width:200px;">
                                                </td>
                                            </tr>
                                            <input type="hidden" name="siteid" id="siteid" value="${siteInfo.SITEID}"/>
                                            </tbody>
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
                                                <col width="20%">
                                                <col width="5%">
                                                <col width="20%">
                                                <col width="5%">
                                                <col width="20%">
                                                <col width="5%">
                                                <col width="20%">
                                            </colgroup>
                                            <tbody>
                                            <c:forEach var="kko" items="${kkoInfo}">
                                                <tr>
                                                    <th>플러스친구</th>
                                                    <td>${kko.PLUSFRIEND}</td>
                                                    <th>대표발신번호</th>
                                                    <td>${kko.KKOTELNO}</td>
                                                    <th>서비스번호</th>
                                                    <td>${kko.KKOSERVICENO}</td>
                                                    <th>구분값</th>
                                                    <td>${kko.KKOGUBUN}</td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
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
                    <button type="submit" class="btn btn-default pull-left">저장</button>
                    <a href="/common/site/${siteInfo.SITEID}" class="btn btn-default pull-right">취소</a>
                </div>
            </div>

            <br/>
</form:form>
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
<!-- validate -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/crud_validate.js"></script>
<!-- daumAPI -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- 공용js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/fileChk.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/site.js"></script>
<script>
    $(document).ready(function() {

        $('#passwordreset').click(function(e){
            var siteid = $('#siteid').val();
            masterPasswordReset(siteid);
        });
    });
</script>
</body>
</html>

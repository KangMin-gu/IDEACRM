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
</head>
<body>
<c:set var="menuactive" value='formatM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>서식 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/company/format">서식 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/company/format/${formatInfo.FORMATNO}">서식 정보</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>서식 정보 수정</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <form:form action="/company/format/input" method="POST">
            <div class="row">
                <div class="col-lg-12">
                    <a href="/company/format" class="btn btn-default pull-left">목록</a>
                    <button type="submit" class="btn btn-default pull-right">저장</button>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>서식 등록</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </div>
                        </div>
                        <div class="ibox-content">
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
                                    <tbody>
                                    <tr>
                                        <th>서식명</th>
                                        <td>
                                            <input type="text" class="form-control form-control name" name="formatname" id="formatname" value="${formatInfo.FORMATNAME}">
                                        </td>
                                        <th>사용메뉴</th>
                                        <td>
                                            <select class="form-control m-b" name="usemenu" id="usemenu" style="width: 100px;">
                                                <option value="0">선택</option>
                                                <c:forEach var="license" items="${license}">
                                                    <c:choose>
                                                        <c:when test="${formatInfo.SENDTYPE eq license.LICENSENO}">
                                                            <option selected label="${license.LICENSENAME }" value="${license.LICENSENO }"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option label="${license.LICENSENAME }" value="${license.LICENSENO }"/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <th>발송매체</th>
                                        <td>
                                            <select class="form-control m-b" name="sendtype" id="sendtype" style="width: 100px;">
                                                <option value="0">선택</option>
                                                <c:forEach var="formType" items="${FORMTYPE}">
                                                    <c:choose>
                                                        <c:when test="${formatInfo.SENDTYPE eq formType.codeval}">
                                                            <option selected label="${formType.codename }" value="${formType.codeval }"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${formType.codeval}">${formType.codename}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <c:if test="${sessionScope.MASTERYN eq 1}">
                                    <tr class="kko">
                                        <th>카카오 서비스번호</th>
                                        <td>
                                            <input type="text" class="form-control " name="kkoserviceno" id="kkoserviceno" value="${formatInfo.KKOSERVICENO}">
                                        </td>
                                        <th>카카오 템플릿번호</th>
                                        <td>
                                            <input type="text" class="form-control" name="kkotempleteno" id="kkotempleteno" value="${formatInfo.KKOTEMPLETENO}">
                                        </td>
                                    </tr>
                                    </c:if>
                                    <tr>
                                        <th>서식</th>
                                        <td colspan="5">
                                            <textarea class="tinymce" name="formatdesc" id="formatdesc">${formatInfo.FORMATDESC}</textarea>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </form:form>
        </div>

        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/plugins/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/crud_validate.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/format.js"></script>

<script>
    var check = "${sessionScope.MASTERYN}";
    $('.kko').hide();
    $('#sendtype').change(function(e){
        if(e.target.value == 3){
            KKOCHECK(check);
        }
    });
</script>
</body>
</html>

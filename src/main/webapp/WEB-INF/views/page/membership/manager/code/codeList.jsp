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
    <link href="${pageContext.request.contextPath}/resources/css/footable.bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
</head>
<style>
</style>
<body>
<c:set var="menuactive" value='code'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>회원사코드</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>회원사코드 관리</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table style="white-space:nowrap;">
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
                                        <th>코드그룹명</th>
                                        <td>
                                            <input class="form-control form-control-sm searchparam" type="text" name="codegrp" id="codegrp" style="width: 150px;">
                                        </td>
                                        <th>코드명</th>
                                        <td>
                                            <input class="form-control form-control-sm searchparam" type="text" name="codename" id="codename" style="width: 150px;">
                                        </td>
                                        <th>코드값</th>
                                        <td>
                                            <input class="form-control form-control-sm searchparam" type="text" name="codeval" id="codeval" style="width: 150px;">
                                        </td>
                                        <th>사용메뉴</th>
                                        <td>
                                            <select class="form-control searchparam" name="usingmenu" id="usingmenu" style="width:180px;">
                                                <option label="선택" value=""></option>
                                                <c:forEach var="allLicense" items="${allLicense}">
                                                    <c:forEach var="siteLicense" items="${siteLicense}">
                                                        <c:if test="${allLicense.licenseno eq siteLicense.LICENSENO}">
                                                            <option label="${allLicense.licensename}" value="${allLicense.licenseno}"></option>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <button type="button" id="search" class="btn btn-w-m btn-primary">검색</button>
                                        </td>
                                        <td>
                                            <button type="button" id="reset" class="btn btn-w-m btn-default">초기화</button>
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
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>코드 목록</h5>
                        </div>
                        <div class="ibox-content">
                            <div>
                                <div style="display: inline-block;">
                                    <select class="form-control" id="paging" style="width:80px;margin-left: 10px;">
                                        <c:forEach var="paging" items="${PAGING}">
                                            <option vale="${paging.codeval}">${paging.codename}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <table class="footable table table-striped head codeList"  data-paging="true">
                                <thead>
                                <tr>
                                    <th data-visible="false" data-name="NO">서비스번호</th>
                                    <th data-visible="false" data-name="URL">URL</th>
                                    <th data-name="CODEGRP">코드그룹명</th>
                                    <th data-name="CODENAME" data-breakpoints="xs sm">코드명</th>
                                    <th data-name="UPPERCODENAME" data-breakpoints="xs sm">상위그룹코드</th>
                                    <th data-name="CODEVAL" data-breakpoints="xs sm">코드값</th>
                                    <th data-name="USINGMENU" data-breakpoints="xs sm">사용메뉴</th>
                                    <th data-name="REGDATE" data-breakpoints="xs sm">등록일시</th>
                                    <th data-visible="false" data-name="EDTDATE" data-sorted="true" data-direction="DESC" >등록일시</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <td>
                                        <div class="footable-pagination-wrapper">
                                            <ul class="pagination"></ul>
                                        </div>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>코드 등록</h5>
                        </div>
                        <div class="ibox-content body">
                            <button type="button" class="btn btn-default pull-right" id="delete" style="margin-bottom: 10px;  margin-left: 7px">삭제</button>
                            <button type="button" class="btn btn-default pull-right" id="cancel" style="margin-bottom: 10px;  margin-left: 7px">취소</button>
                            <button type="button" class="btn btn-default pull-right" id="update" style="margin-bottom: 10px;  margin-left: 7px">수정</button>
                            <button type="button" class="btn btn-default pull-right" id="save" style="margin-bottom: 10px;  margin-left: 7px">저장</button>
                            <button type="button" class="btn btn-default pull-right" id="create" style="margin-bottom: 10px;  margin-left: 7px">추가</button>
                            <button type="button" class="btn btn-default pull-right" id="bodyreset" style="margin-bottom: 10px; margin-left: 7px">초기화</button>
                                <div class="table-responsive">
                                    <table class="table table-bordered " style="white-space:nowrap;">
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
                                        <tbody>
                                            <tr>
                                                <th>코드그룹명</th>
                                                <td>
                                                    <input type="text" class="form-control form-control-sm" name="codegrp" id="viewcodegrp" style="width:200px;">
                                                </td>
                                                <th>코드명</th>
                                                <td>
                                                    <input type="text" class="form-control form-control-sm" name="codename" id="viewcodename" style="width:200px;">
                                                </td>
                                                <th>코드값</th>
                                                <td>
                                                    <input type="text" class="form-control form-control-sm" name="codeval" id="viewcodeval" style="width:200px;">
                                                </td>
                                                <th>상위그룹코드</th>
                                                <td>
                                                    <input type="text" class="form-control" name="viewuppercodegrp_" id="viewuppercodegrp_" style="width:200px;">
                                                    <input type="hidden" class="form-control" name="viewuppercodegrp_" id="viewuppercodegrp">
                                                </td>
                                                    <input type="hidden" id="codeno" name="codeno" value=""/>
                                                <th>사용메뉴</th>
                                                <td>
                                                    <select class="form-control" name="viewusingmenu" id="viewusingmenu" style="width:150px;">
                                                        <option label="선택" value="0"></option>
                                                        <c:forEach var="allLicense" items="${allLicense}">
                                                            <c:forEach var="siteLicense" items="${siteLicense}">
                                                                <c:if test="${allLicense.licenseno eq siteLicense.LICENSENO}">
                                                                    <option label="${allLicense.licensename}" value="${allLicense.licenseno}"></option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                        </div>
                    </div>
                </div>
            </div>


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
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/code.js"></script>

<script>
    $(document).ready(function() {
        $('#search').click(function(e){
            footableSearchList('/company/code/${sessionScope.ENCSITEID}', $('.codeList'));
        });
        footableSearchList('/company/code/${sessionScope.ENCSITEID}', $('.codeList'));
        btnFirst();

        $('#viewuppercodegrp_').click(function(e){
            if($('#viewuppercodegrp_').attr('readonly') != 'readonly'){
                openNewWindow('상위코드','/popuppercode',e.target.id,'600','800')
            }
        });

    });
</script>
</body>
</html>

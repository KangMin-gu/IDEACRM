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
    <link href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css" rel="stylesheet">
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
                <h2>공지사항 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/">공지사항 목록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>공지사항 등록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>

<form:form>
        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">등록</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>

            <br/>

            <div class="mail-box">
                <div class="mail-body">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">제목:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="">
                            </div>
                        </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">말머리:</label>
                        <div class="col-sm-10">
                            <select class="form-control m-b" style="width: 100px;">
                                <option value="Bahamas">일반</option>
                                <option value="Bahrain">중요</option>
                                <option value="Bangladesh">알림</option>
                                <option value="Barbados">참고</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="mail-text h-200">
                    <textarea class="tinymce" id="mytextarea"></textarea>
                    <div class="clearfix"></div>
                </div>
                <br/>
                <div class="fileinput fileinput-new" data-provides="fileinput">
                    <span class="btn btn-outline-secondary btn-file">
                        <span class="fileinput-new">파일선택</span>
                        <span class="fileinput-exists">변경</span>
                        <input type="file" name="..." multiple>
                    </span>
                    <span class="fileinput-filename"></span>
                    <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="float: none">&times;</a>
                </div>

                <div class="clearfix"></div>

            </div>

            <br/>

        </div>
</form:form>
        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- Jasny -->
<script src="${pageContext.request.contextPath}/resources/js/jasny-bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>

<script>
    $(document).ready(function() {

    });
</script>
</body>
</html>

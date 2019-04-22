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
                        <a href="${pageContext.request.contextPath}/">목록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>공지사항 등록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>

        <form:form id="multiFile" action="/voc/notice/input" enctype="multipart/form-data" method="post">
        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left">등록</button>
                    <a href="${pageContext.request.contextPath}/voc/notice" class="btn btn-default pull-right">취소</a>
                </div>
            </div>

            <br/>

            <div class="mail-box">
                <div class="mail-body">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="title">제목:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" id="title" name="title">
                            </div>
                        </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="tag">말머리:</label>
                        <div class="col-sm-10">
                            <select class="form-control m-b" id="tag" name="tag" style="width: 100px;">
                                <option value="0">전체</option>
                                <option value="1">일반</option>
                                <option value="2">중요</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="mail-text h-200">
                    <textarea id="content" name="content"></textarea>
                    <div class="clearfix"></div>
                </div>
                <br/>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">첨부파일</label>
                    <div class="col-sm-10">
                        <div class="fileinput fileinput-new" data-provides="fileinput">
                                                    <span class="btn btn-outline-secondary btn-file">
                                                        <span class="fileinput-new">파일선택</span>
                                                        <span class="fileinput-exists">변경</span>
                                                        <input id="files" type="file" class="fileChk" name="file" multiple>
                                                    </span>
                            <span id="filesChk" class="fileinput-filename"></span>
                            <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="float: none">&times;</a>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left">등록</button>
                    <a href="${pageContext.request.contextPath}/company/notice" class="btn btn-default pull-right">취소</a>
                </div>
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
<script src="${pageContext.request.contextPath}/resources/js/crud/fileChk.js"></script>
<script>
    $(document).ready(function() {
        tinymce.init({
            selector: '#content',
            height : 400,
            language:'ko_KR'
        });
    });
</script>
</body>
</html>

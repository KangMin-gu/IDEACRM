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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<style>
</style>
<body>
<c:set var="menuactive" value='allnotice'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>IDEA 공지사항</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/">공지사항 목록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>공지사항 상세</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <a href="${pageContext.request.contextPath}/notice" class="btn btn-default pull-left">목록</a>
                    <c:if test="${CHKAUTH eq 30}">
                        <a href="${pageContext.request.contextPath}/notice/del/${notice.NTNUM}" class="btn btn-default pull-right" style="margin-left: 5px;">삭제</a>
                        <a href="${pageContext.request.contextPath}/notice/modified/${notice.NTNUM}" class="btn btn-default pull-right">수정</a>
                    </c:if>
                </div>
            </div>

            <br/>
            <div class="mail-box-header">
                <h3>
                    <span class="font-normal">제목: </span>${notice.TITLE}
                </h3>
                <div class="mail-tools tooltip-demo m-t-md">
                    <h5>
                        <span class="font-normal">말머리: </span>${notice.TAG}
                    </h5>
                    <h5>
                        <span class="float-right font-normal">2018-04-21</span>
                        <span class="font-normal">글쓴이: </span>${notice.WRITER}
                    </h5>
                </div>
            </div>
            <div class="mail-box">
                <div class="mail-body">
                    ${notice.CONTENT}
                </div>

                <c:if test="${fn:length(fileInfo) > 0}">
                    <div class="mail-attachment">
                        <p>
                            <span><i class="fa fa-paperclip"></i> 첨부파일 - </span>
                            <c:forEach var="file" items="${fileInfo}">
                                <a href="${pageContext.request.contextPath}/download/${file.FILEID}">${file.ORGFILENAME}</a>
                                |
                            </c:forEach>
                        </p>

                        <div class="attachment">
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </c:if>
                <div class="clearfix"></div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <a href="${pageContext.request.contextPath}/notice" class="btn btn-default pull-left">목록</a>
                    <c:if test="${CHKAUTH eq 30}">
                        <a href="${pageContext.request.contextPath}/notice/del/${notice.NTNUM}" class="btn btn-default pull-right" style="margin-left: 5px;">삭제</a>
                        <a href="${pageContext.request.contextPath}/notice/modified/${notice.NTNUM}" class="btn btn-default pull-right">수정</a>
                    </c:if>
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
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
        $('.footable3').footable();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
    });
</script>
</body>
</html>

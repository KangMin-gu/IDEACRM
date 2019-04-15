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
    <link href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css" rel="stylesheet">
    <!-- choosen -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/chosen/chosen.css" rel="stylesheet">
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

        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <%@ include file="/WEB-INF/views/common/insideNotice.jsp"%>
                <div class="col-lg-9 animated fadeInRight">
                    <div class="mail-box-header">
                        <h2>
                            편지 작성
                        </h2>
                    </div>
                    <div class="mail-box">
                    <form:form action="/compose" method="post" enctype="multipart/form-data">
                        <div class="mail-body">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label" for="touser">받는이:</label>
                                    <div class="col-sm-10">
                                        <select id="touser" name="touser" class="chosen-select" multiple="multiple" tabindex="2">
                                            <c:forEach var="tmp" items="${companyUserData }">
                                                <option value="${tmp.USERNO}">${tmp.USERNAME}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label" for="title">제목:</label>
                                    <div class="col-sm-10">
                                        <input id="title" name="title" type="text" class="form-control" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">첨부파일:</label>
                                    <div class="col-sm-10">
                                        <div class="fileinput fileinput-new" data-provides="fileinput">
                                                    <span class="btn btn-outline-secondary btn-file">
                                                        <span class="fileinput-new">파일선택</span>
                                                        <span class="fileinput-exists">변경</span>
                                                        <input id="file" type="file" class="fileChk" name="file" multiple
                                                               accept=".xls,.xlsx,.doc,.docx,.ppt,.pptx,.pdf,.jpg,.gif,.tif,.bmp,.mov,.ogg,.zip,.wav,.txt,.png,.PNG">
                                                    </span>
                                            <span id="filesChk" class="fileinput-filename"></span>
                                            <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="float: none">&times;</a>
                                        </div>
                                    </div>
                                </div>
                        </div>

                        <div class="mail-text h-200">
                            <textarea id="content" name="content"></textarea>
                            <div class="clearfix"></div>
                        </div>

                        <div class="mail-body text-right tooltip-demo">
                            <a href="mailbox.html" class="btn btn-white btn-sm float-left"><i class="fa fa-pencil"></i> 초기화</a>
                            <a href="mailbox.html" class="btn btn-white btn-sm float-left"><i class="fa fa-times"></i> 취소</a>
                            <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-reply"></i>발송 </button>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    </form:form>
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
<!-- Jasny -->
<script src="${pageContext.request.contextPath}/resources/js/jasny-bootstrap.min.js"></script>
<script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=qiomflc75y0odisulm50wv2jdwxsbp5opxqrombuvtzoqm4p"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/fileChk.js"></script>
<script>
    $(document).ready(function() {
        tinymce.init({
            selector: '#content',
            height : 400,
            language:'ko_KR'
        });

        $('.chosen-select').chosen(
            {
                width:"100%",
                search_contains : true
            }
        );
    });

</script>
</body>
</html>

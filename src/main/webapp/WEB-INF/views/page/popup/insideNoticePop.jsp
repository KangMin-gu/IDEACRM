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
    <!-- orris -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <!-- choosen -->1
    <link href="${pageContext.request.contextPath}/resources/css/plugins/chosen/chosen.css" rel="stylesheet">
</head>
<style>
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <form:form id="multiFile" action="/popbox" enctype="multipart/form-data" method="post">
    <div class="ibox">
        <div class="ibox-title">
            <h5>Email 발송</h5>
        </div>
        <div class="ibox-content">
            <div class="table-responsive">
                <table class="table table-bordered" style="white-space:nowrap;">
                    <colgroup>
                        <col width="10%">
                        <col width="90%">
                    </colgroup>
                    <tbody>
                       <tr>
                           <th>보내는사람</th>
                           <td>
                               ${USERNAME}
                           </td>
                       </tr>
                        <tr>
                            <th>받는사람</th>
                            <td>
                                <select id="touser" name="touser" class="chosen-select" multiple="multiple" tabindex="2">
                                    <c:forEach var="tmp" items="${companyUserData }">
                                        <option value="${tmp.USERNO}" <c:if test="${tmp.USERNO eq noteInfo.FROMUSERNO || tmp.USERNO eq reno}">selected</c:if>>${tmp.USERNAME}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td>
                                <input id="title" name="title" class="form-control form-control-sm" type="text" style="height: 30px;">
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td>
                                <textarea id="content" name="content"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>첨부파일</th>
                            <td>
                                <div class="fileinput fileinput-new" data-provides="fileinput">
                                                    <span class="btn btn-outline-secondary btn-file">
                                                        <span class="fileinput-new">파일선택</span>
                                                        <span class="fileinput-exists">변경</span>
                                                        <input id="files" type="file" class="fileChk" name="file" multiple>
                                                    </span>
                                    <span id="filesChk" class="fileinput-filename"></span>
                                    <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="float: none">&times;</a>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <button type="button" class="btn btn-default pull-left cancel">취소</button>
    <button type="submit" id="send" class="btn btn-primary pull-right save" >발송</button>
    <input type="hidden" id="linkurl" name="linkurl">
    </form:form>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/popJs.jsp"%>

<script src="${pageContext.request.contextPath}/resources/js/jasny-bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/chosen.jquery.js"></script>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
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

        var linkurl = document.referrer;
        $('#linkurl').val(linkurl);

    });

    $('.chosen-select').chosen(
        {
            width:"100%",
            search_contains : true
        }
    );

    $('#send').click(function(){
        var result = confirm('메일 발송하시겠습니까?');
        if(result){
            return true;
        }else{
            return false;
        }
    });
    $('.cancel').click(function(){
        close();
    });
</script>
</body>
</html>

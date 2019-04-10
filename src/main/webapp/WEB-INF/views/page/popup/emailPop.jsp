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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- orris -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
</head>
<style>
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox">
        <div class="ibox-title">
            <h5>Email 발송</h5>
        </div>
        <div class="ibox-content">
            <div class="table-responsive">
                <table class="table table-bordered" style="white-space:nowrap;">
                    <colgroup>
                        <col width="20%">
                        <col width="80%">
                    </colgroup>
                    <tbody>
                       <tr>
                           <th>보내는사람</th>
                           <td>
                               강민구
                           </td>
                       </tr>
                        <tr>
                            <th>받는사람</th>
                            <td>
                                <input class="form-control form-control-sm" type="text" style="height: 30px;">
                            </td>
                        </tr>
                        <tr>
                            <th>참조</th>
                            <td>
                                <input class="form-control form-control-sm" type="text" style="height: 30px;">
                            </td>
                        </tr>
                        <tr>
                            <th>숨은참조</th>
                            <td>
                                <input class="form-control form-control-sm" type="text" style="height: 30px;">
                            </td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td>
                                <input class="form-control form-control-sm" type="text" style="height: 30px;">
                            </td>
                        </tr>
                       <tr>
                           <th>템플릿</th>
                           <td>
                               <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                   <option value="">02</option>
                                   <option value="">031</option>
                                   <option value="">017</option>
                                   <option value="">018</option>
                               </select>
                           </td>
                       </tr>
                        <tr>
                            <th>내용</th>
                            <td>
                                <textarea id="mytextarea"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>첨부파일</th>
                            <td>
                                <input type="file" class="form-control" multiple>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=qiomflc75y0odisulm50wv2jdwxsbp5opxqrombuvtzoqm4p"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>
<script>
    $(document).ready(function() {
        tinymce.init({
            selector: '#mytextarea',
            height : 400,
            language:'ko_KR'
        });
    });


</script>
</body>
</html>

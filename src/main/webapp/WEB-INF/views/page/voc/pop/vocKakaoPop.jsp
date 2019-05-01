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
            <h5>KAKAO 발송</h5>
        </div>
        <div class="ibox-content">
            <div class="table-responsive">
                <table class="table table-bordered" style="white-space:nowrap;">
                    <colgroup>
                        <col width="20%">
                        <col width="30%">
                        <col width="20%">
                        <col width="30%">
                    </colgroup>
                    <tr>
                        <input type="hidden" id="service_seqno" value="0">
                        <input type="hidden" id="template_code" value="">
                        <input type="hidden" name="custno" id="custno"/>
                        <input type="hidden" name="mobile" id="mobile"/>
                        <th>고객명</th>
                        <td id="custname"></td>
                        <th>고객번호</th>
                        <td id="custmobile"></td>
                    </tr>
                    <tr>
                        <th>서식</th>
                        <td colspan="3">
                            <select class="form-control form-control-sm" id="kakaoFormat" style="height: 30px;">
                                <option value="">선택</option>
                                <c:forEach var="list" items="${formList}" varStatus="status">
                                    <option value="${status.index}">${list.FORMATNAME}</option>
                                </c:forEach>
                                <c:forEach var="list" items="${formList}" varStatus="status">
                                    <input type="hidden" id="service_seqno${status.index}" value="${list.KKOSERVICENO}">
                                    <input type="hidden" id="template_code${status.index}" value="${list.KKOTEMPLETENO}">
                                    <input type="hidden" id="formatdesc${status.index}" value="${list.FORMATDESC}">
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea name="send_message" id="send_message" class="form-control" style="resize: none;" rows="10" readonly></textarea>
                        </td>
                    </tr>
                </table>
                <button type="button" class="btn btn-default pull-left popCloseBtn">취소</button>
                <button type="button" class="btn btn-default pull-right" id="kakaoSendBtn">발송</button>
            </div>
        </div>
    </div>

</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>
<script>
    $(document).ready(function(){
        var custName = opener.$('#custname').val();
        var mobile = opener.$('#mobile1').val()+''+opener.$('#mobile2').val()+''+opener.$('#mobile3').val();
        var custNo = opener.$('#custno').val();

        $('#custname').text(custName);
        $('#custmobile').text(mobile);
        $('#custno').val(custNo);
        $('#mobile').val(mobile);
    });

</script>
</body>
</html>

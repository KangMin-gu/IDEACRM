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
            <h5>SMS 발송</h5>
        </div>
        <div class="ibox-content">
            <form:form action="/voc/pop/sms/input" method="post" onsubmit="return false;">
                <div class="table-responsive">
                    <table class="table table-bordered" style="white-space:nowrap;">
                        <colgroup>
                            <col width="20%">
                            <col width="30%">
                            <col width="20%">
                            <col width="30%">
                        </colgroup>
                        <tr>
                            <th>고객명</th>
                            <td id="custname"></td>
                            <th>고객연락처</th>
                            <td id="custmobile"></td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <textarea name="senddesc" id="senddesc" class="form-control" style="resize: none;" rows="10"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>글자Byte수</th>
                            <td colspan="3" id="bytelength">0/80</td>
                        </tr>
                    </table>
                    <button type="button" class="btn btn-default pull-left">취소</button>
                    <button type="submit" class="btn btn-default pull-right save" >발송</button>
                </div>
                <input type="hidden" name="lengthtype" id="lengthtype"/>
                <input type="hidden" name="custno" id="custno"/>
                <input type="hidden" name="mobile" id="mobile"/>
            </form:form>
        </div>
    </div>



    <div class="tabs-container">
        <ul class="nav nav-tabs" role="tablist">
            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">자주쓰는 멘트</a></li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" id="tab-1" class="tab-pane active">
                <div class="panel-body">
                    <table class="formFootable table table-stripped" data-page-size="8" data-filter=#filter>
                        <thead>
                        <tr>
                            <th data-visible="false" data-name="FORMATNO">템플릿번호</th>
                            <th data-visible="false" data-name="FORMATNAME">템플릿명</th>
                            <th data-visible="false" data-name="FORMATDESC">내용</th>
                            <th data-name="FORMATNAME_">템플릿명</th>
                            <th data-name="FORMATDESC_">내용</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="2">
                                <ul class="pagination float-center"></ul>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>


</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/popJs.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script>
    $(document).ready(function() {
        footableSearchList('/voc/pop/sms', $('.formFootable'));

        var custName = opener.$('#custname').val();
        var mobile = opener.$('#mobile1').val()+''+opener.$('#mobile2').val()+''+opener.$('#mobile3').val();
        var custNo = opener.$('#custno').val();

        $('#custname').text(custName);
        $('#custmobile').text(mobile);
        $('#custno').val(custNo);
        $('#mobile').val(mobile);
    });
    $('.save').click(function(e){
        debugger;
        // var data = $('#command').serialise();
        smsToLms('senddesc');
        var mobile = opener.$('#mobile1').val()+''+opener.$('#mobile2').val()+''+opener.$('#mobile3').val();
        var custNo = opener.$('#custno').val();
        var senddesc = $('#senddesc').val();
        lengthtype = $('#lengthtype').val();
        var data = {"mobile":mobile,"custno":custNo,"senddesc":senddesc,"lengthtype":lengthtype};

        $.ajax({
            url: '/voc/pop/sms/input',
            method: "POST",
            dataType: "json",
            data: data,
            cache: false,
            success: function (data) {
                debugger;
                alert('발송 하였습니다.');
                 window.close();
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    });

    $('#senddesc').keyup(function(e){
        var lengthtype = $('#lengthtype').val();
        var str = $(this).val();
        var textLength = getTextLength(str);
        var textSize = textLength;
        textLength = textLength +'/ 80';
        $('#bytelength').text(textLength);
        if(textSize > 80){
            if(lengthtype != 1){
                smsToLms('senddesc');
            }
        }
    });



</script>
</body>
</html>

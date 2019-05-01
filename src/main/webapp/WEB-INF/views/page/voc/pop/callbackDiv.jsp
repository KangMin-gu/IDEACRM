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
    <link href="${pageContext.request.contextPath}/resources/css/footable.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/vocDivide.css" rel="stylesheet">
</head>
<body>
<div class="wrapper wrapper-content">
    <div>
        <div class="ibox-left col-5">
            <h2>콜백 리스트</h2>
            <div class="ibox-content row">
                <div class="box col-12" style="padding-left: 0px;padding-right: 0px;">
                    <div class="col-lg-4 float-right text-right mb-2 w-100" style="padding-right: 0px;padding-bottom: 15px;padding-top: 0px*">
                        <br>
                    </div>
                </div>
            </div>
            <div class="ibox-content row border-top-0 pt-lg-0 tooltip-demo">
                <div class="table-responsive">
                    <table class="footable table table-striped callList">
                        <thead>
                        <tr>
                            <th data-name="CUSTNAME"><input type="checkbox" id="checkAll" onclick="selectCheckbox('custno');"/>서비스번호</th>
                            <th data-name="CUSTNAME" data-formatter="serviceformatter">발신번호</th>
                            <th data-name="CUSTNAME">사용자 ID</th>
                            <th data-name="CUSTNAME">콜백번호</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <td colspan="4" style="text-align:center">
                                <ul class="pagination float-center"></ul>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>

        <div class="ibox-right col-5">
            <h2>사용자 리스트</h2>
            <div class="ibox-content row">
                <div class="box col-12" style="padding-left: 0px;padding-right: 0px;">
                    <div class="col-lg-4 float-right text-right mb-2 w-100" style="padding-right: 0px;padding-bottom: 0px;padding-top: 0px*">
                        <button id="passDiv" class="btn btn-primary btn-large">수동분배</button>
                        <button id="autoDiv" class="btn btn-primary btn-large">자동분배</button>
                    </div>
                </div>
            </div>
            <div class="ibox-content row border-top-0 pt-lg-0 tooltip-demo">
                <div class="table-responsive">
                    <table class="footable table table-striped userList">
                        <thead>
                        <tr>
                            <th data-name="SERVICENAME"><input type="checkbox" id="checkAll" onclick="selectCheckbox('custno');"/>서비스번호</th>
                            <th data-name="SERVICENAME" data-formatter="serviceformatter">사용자명</th>
                            <th data-name="SERVICENAME">사용자 ID</th>
                            <th data-name="SERVICENAME">할당된 콜백수</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <td colspan="4" style="text-align:center">
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
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script> <!-- radioBox-->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc_callback_div.js"></script>

<script>
    $(document).ready(function () {
        footableSearchList('/cust', $('.callList'));
        footableSearchList('/service', $('.userList'));
        //callBackList(1);
        //ctiUserList(1);
    });
</script>


</body>

</html>

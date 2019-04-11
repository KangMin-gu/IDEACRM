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
    <link href="${pageContext.request.contextPath}/resources/css/footable.bootstrap.min.css" rel="stylesheet">
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
            <h5>거래처 조회</h5>
        </div>
        <div class="ibox-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-4">
                            <tr>
                                <th>거래처명</th>
                                <td>
                                    <div class="input-group" style="width:230px;">
                                        <input class="form-control form-control-sm searchparam" name="cliname" id="cliname" type="text" />
                                        <button type="button" id="search" class="btn btn-primary">검색</button>
                                    </div>
                                </td>
                            </tr>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <table class="popfootable table table-stripped" data-sorting="true">
                        <thead>
                        <tr data-formatter="test">
                            <th data-visible="false" data-name="CLINO">고객번호</th>
                            <th data-name="CLINAME" >고객명</th>
                            <th data-name="CLIADDR">주소</th>
                            <th data-name="TELNO">대표전화</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                        <tfoot>

                        </tfoot>
                    </table>
                </div>

                <input type="hidden" id="parentid" name="parentid" value=""/>
            </div>
        </div>
    </div>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<!-- api js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script>
    $(document).ready(function() {
        $('#search').click(function(e){
            footableSearchList('/popaccount');
        });
        footableSearchList('/popaccount');
    });

</script>
</body>
</html>

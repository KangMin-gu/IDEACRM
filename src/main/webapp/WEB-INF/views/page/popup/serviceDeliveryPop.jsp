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
    <<link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css" rel="stylesheet">
</head>
<style>
</style>
<body class="gray-bg">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>서비스 이관</h2>
        </div>
    </div>
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-content body">
                        <button type="button" class="btn btn-primary pull-right" id="conveySave" style="margin-bottom: 10px;  margin-left: 7px">저장</button>
                        <div class="table-responsive">
                            <table class="table table-bordered" style="white-space:nowrap;">
                                <colgroup>
                                    <col width="11%">
                                    <col width="22%">
                                    <col width="11%">
                                    <col width="22%">
                                    <col width="11%">
                                    <col width="22%">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th>서비스명</th>
                                    <td>
                                        ${serviceInfo.SERVICENAME}
                                        <input type="hidden" class="form-control searchparam" name="serviceno" id="serviceno" value="${serviceInfo.SERVICENO}" />
                                    </td>
                                    <th>접수일자</th>
                                    <td>
                                        ${serviceInfo.RECEPTIONDATE_}
                                    </td>
                                    <th>현담당자</th>
                                    <td>
                                        ${serviceInfo.OWNER_ }
                                        <input type="hidden" class="form-control searchparam" name="prevowner" id="prevowner" value="${serviceInfo.OWNER}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>이관일자</th>
                                    <td>
                                        <input type="text" class="form-control form-control-sm date searchparam" name="conveydate" id="conveydate" style="width:200px;">
                                    </td>
                                    <th>이관사유</th>
                                    <td>
                                        <select class="form-control searchparam" name="conveyreason" id="conveyreason">
                                            <option label="선택" value=""/>
                                            <c:forEach var="conveyReason" items="${CONVEYREASON }">
                                                <option label="${conveyReason.codename }" value="${conveyReason.codeval }"/>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <th>이관담당자</th>
                                    <td>
                                        <div class="input-group owner" id="nextowner_" style="width:250px">
                                            <input type="text" class="form-control" autocomplete="off" name="nextowner_" value="">
                                            <input type="hidden" class="searchparam" name="nextowner" id="nextowner" value="0">
                                            <span class="input-group-addon">
                                                <a><i class="fa fa-search"></i></a>
                                            </span>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="conveydesc">비고</label></th>
                                    <td colspan="5">
                                        <textarea class="searchparam" id="conveydesc" name="conveydesc" cols="140" rows="9"></textarea>
                                        <input type="hidden" id="no" name="no"/>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- FooTable -->
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
    <!-- datePicker -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<!-- api js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/crud/service.js"></script>
<script>
    $(document).ready(function() {

    });

</script>
</body>
</html>

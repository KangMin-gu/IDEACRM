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
    <!-- orris -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
</head>
<style>
    th{
        background-color: #f5f6f7;
    }
</style>
<body>

<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

        <form:form>
            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">적용</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>라이센스 관리</h5>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="5%">
                                        <col width="5%">
                                        <col width="5%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>모듈명</th>
                                            <th>상태</th>
                                            <th>수량</th>
                                            <th>반영날짜</th>
                                        </tr>
                                        <tr>
                                            <th>고객관리</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">활성</option>
                                                    <option value="">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                    <option value="">3</option>
                                                    <option value="">4</option>
                                                </select>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>영업관리</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">활성</option>
                                                    <option value="">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                    <option value="">3</option>
                                                    <option value="">4</option>
                                                </select>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>서비스관리</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">활성</option>
                                                    <option value="">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                    <option value="">3</option>
                                                    <option value="">4</option>
                                                </select>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>캠페인</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">활성</option>
                                                    <option value="">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                    <option value="">3</option>
                                                    <option value="">4</option>
                                                </select>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>콜센터</th>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">활성</option>
                                                    <option value="">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="" id="" style="height: 30px;">
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                    <option value="">3</option>
                                                    <option value="">4</option>
                                                </select>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>라이센스활성수</th>
                                            <td colspan="3"></td>
                                        </tr>
                                        <tr>
                                            <th>총유저수</th>
                                            <td colspan="3"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">적용</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>
        </form:form>
        </div>


        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
</body>
</html>

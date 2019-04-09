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
    th{
        background-color: #f5f6f7;
    }
    .denny{
        background-color: #f3f1f0;
    }
</style>
<body>

<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>서식 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/">서식 등록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>서식 등록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
<form:form>
            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">목록</button>
                    <button type="button" class="btn btn-default pull-right">삭제</button>
                    <button type="button" class="btn btn-default pull-right">수정</button>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>서식 등록</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="25%">
                                        <col width="5%">
                                        <col width="25%">
                                        <col width="5%">
                                        <col width="25%">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>서식명</th>
                                        <td>
                                            <input type="text" class="form-control form-control-sm">
                                        </td>
                                        <th>사용메뉴</th>
                                        <td>
                                            <select class="form-control m-b" style="width: 100px;height: 30px;">
                                                <option value="Bahamas">일반</option>
                                                <option value="Bahrain">중요</option>
                                                <option value="Bangladesh">알림</option>
                                                <option value="Barbados">참고</option>
                                                <option value="Barbados">점검</option>
                                                <option value="Barbados">업데이트</option>
                                            </select>
                                        </td>
                                        <th>발송매체</th>
                                        <td>
                                            <select class="form-control m-b" style="width: 100px;height: 30px;">
                                                <option value="Bahamas">일반</option>
                                                <option value="Bahrain">중요</option>
                                                <option value="Bangladesh">알림</option>
                                                <option value="Barbados">참고</option>
                                                <option value="Barbados">점검</option>
                                                <option value="Barbados">업데이트</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>서식</th>
                                        <td colspan="5">
                                            <textarea id="mytextarea"></textarea>
                                        </td>
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
                    <button type="button" class="btn btn-default pull-left">목록</button>
                    <button type="button" class="btn btn-default pull-right">삭제</button>
                    <button type="button" class="btn btn-default pull-right">수정</button>
                </div>
            </div>

            <br/>
            </form:form>
        </div>

        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<script src="https://cloud.tinymce.com/5/tinymce.min.js?apiKey=qiomflc75y0odisulm50wv2jdwxsbp5opxqrombuvtzoqm4p"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>
<script>
    $(document).ready(function() {
        tinymce.init({
            selector: '#mytextarea, #mytextarea2,#mytextarea3 ',
            height : 400,
            language:'ko_KR'
        });
    });
</script>
</body>
</html>

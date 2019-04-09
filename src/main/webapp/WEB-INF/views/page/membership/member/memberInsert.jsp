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
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
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
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>사용자 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>사용자 등록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">


            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">등록</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>사용자 등록</h5>
                        </div>
                        <div class="ibox-content" >
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form:form>
                                            <div class="form-group  row">
                                                <label class="col-sm-2 col-form-label">사용자명</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control form-control-sm">
                                                </div>
                                                <label class="col-sm-2 col-form-label">ID</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control form-control-sm">
                                                </div>
                                            </div>
                                            <div class="form-group  row">
                                                <label class="col-sm-2 col-form-label">비밀번호</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control form-control-sm">
                                                </div>
                                                <label class="col-sm-2 col-form-label">비밀번호확인</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control form-control-sm">
                                                </div>
                                            </div>
                                            <div class="form-group  row">
                                                <label class="col-sm-2 col-form-label">휴대번호</label>
                                                <div class="col-sm-4">
                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <select class="form-control m-b">
                                                                <option value="Bahamas">010</option>
                                                                <option value="Bahrain">011</option>
                                                                <option value="Bangladesh">017</option>
                                                                <option value="Barbados">018</option>
                                                                <option value="Belarus">019</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                        <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                    </div>
                                                </div>
                                                <label class="col-sm-2 col-form-label">전화번호</label>
                                                <div class="col-sm-4">
                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <select class="form-control m-b">
                                                                <option value="Bahamas">010</option>
                                                                <option value="Bahrain">011</option>
                                                                <option value="Bangladesh">017</option>
                                                                <option value="Barbados">018</option>
                                                                <option value="Belarus">019</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-3"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                        <div class="col-md-3"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group  row">
                                                <label class="col-sm-2 col-form-label">이메일</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control form-control-sm">
                                                </div>
                                                <label class="col-sm-2 col-form-label">관리자여부</label>
                                                <div class="col-sm-4">
                                                    <select class="form-control" style="width:100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group  row">
                                                <label class="col-sm-2 col-form-label">직책</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control form-control-sm">
                                                </div>
                                                <label class="col-sm-2 col-form-label">CTI번호</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control form-control-sm">
                                                </div>
                                            </div>
                                            <div class="form-group  row">
                                                <label class="col-sm-2 col-form-label">메모</label>
                                                <div class="col-sm-10">
                                                    <textarea name="need" id="" class="form-control" style="resize: none;" rows="4"></textarea>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">등록</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
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
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('#daterange').daterangepicker();
    });
</script>
</body>
</html>

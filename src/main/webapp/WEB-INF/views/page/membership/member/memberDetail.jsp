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
                <h2>사용자 정보</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/">사용자 목록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>사용자 정보</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <form:form action="/company/user/del/${userInfo.USERNO}" method="POST">
                        <a href="/company/user" class="btn btn-default pull-left">목록</a>
                        <a href="#" class="btn btn-default" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                        <button type="submit" class="btn btn-default pull-right">삭제</button>
                        <a href="/company/user/modified/${userInfo.USERNO}" class="btn btn-default pull-right">수정</a>
                    </form:form>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>사용자 정보</h5>
                        </div>
                        <div class="ibox-content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>사용자명 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.USERNAME}</p>
                                                </div>
                                                <div class="col-sm-2">
                                                    <p>ID : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.USERID}</p>
                                                </div>
                                            </div>
                                        <!--관리자일경우 비밀번호 초기화 row 생성-->
                                        <c:if test="${sessionScope.CHKAUTH eq '20' or sessionScope.CHKAUTH eq '30'}">
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>비밀번호 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <button type="button" class="btn btn-w-m btn-xs btn-primary">초기화</button>
                                                </div>
                                            </div>
                                        </c:if>
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>전화번호 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.TELNO1} ${userInfo.TELNO2} ${userInfo.TELNO3}</p>
                                                </div>
                                                <div class="col-sm-2">
                                                    <p>휴대전화 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.MOBILE1} ${userInfo.MOBILE2} ${userInfo.MOBILE3}</p>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>Email : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.EMAIL}</p>
                                                </div>
                                                <div class="col-sm-2">
                                                    <p>관리자여부 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.CHKAUTH_}</p>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>직책 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.USERDUTY}</p>
                                                </div>
                                                <div class="col-sm-2">
                                                    <p>CTI전화번호 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.CTITELNO}</p>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>CTIID : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.CTIID}</p>
                                                </div>
                                                <div class="col-sm-2">
                                                    <p>CTIPW : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.CTIPASS}</p>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>메모 : </p>
                                                </div>
                                                <div class="col-sm-10">
                                                    <p>${userInfo.USERDESC}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <form:form action="/company/user/del/${userInfo.USERNO}" method="POST">
                        <a href="/company/user" class="btn btn-default pull-left">목록</a>
                        <a href="#" class="btn btn-default" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                        <button type="submit" class="btn btn-default pull-right">삭제</button>
                        <a href="/company/user/modified/${userInfo.USERNO}" class="btn btn-default pull-right">수정</a>
                    </form:form>
                </div>
            </div>

            <br/>

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
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- daum map -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=60c1fc75825cf6619b0ff66b5aca7161&libraries=services"></script>
<script>
    $(document).ready(function() {

    });
</script>
</body>
</html>

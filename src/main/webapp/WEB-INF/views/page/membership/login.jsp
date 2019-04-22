<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>IDEA CRM</title>
    <!-- link includ -->
    <%@ include file="/WEB-INF/views/includ/link.jsp"%>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div style="margin-top:100px;">
        <div>
            <a href="${pageContext.request.contextPath}/">
                <img style="width:300px;" src="${pageContext.request.contextPath}/resources/img/crud/welcomlogo.png" alt="" />
            </a>
        </div>
        <!--  <h4>고객 관계를 생각하는 IDEA CRM에 오신 것을 환영합니다.</h4> -->

        <form:form id="loginChk" class="m-t" role="form" action="${pageContext.request.contextPath}/login" method="post">
            <input type="hidden" name="url" value="${url }"/>
            <div class="form-group">
                <input id="userid" name="userid" type="text" class="form-control" placeholder="계정" autofocus="autofocus" required>
            </div>
            <div class="form-group">
                <input id="userpassword" name="userpassword" type="password" class="form-control" placeholder="비밀번호" required>
            </div>

            <div class="form-check float-left">
                <input type="checkbox" class="form-check-input" id="isSave">
                <label class="form-check-label" for="isSave">아이디 저장</label>
            </div>

            <button type="submit" class="btn btn-primary block full-width m-b" style="margin-top: 50px;">로그인</button>
            <small>Chrome, IE 11이상의 버전에 최적화 되어 있습니다.</small>
        </form:form>
        <br/>
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-xs-4">공지사항</div>
                <div class="col-xs-4">
                    <a class="btn btn-primary btn-xs" href="">전체</a>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-xs-12">
                    <table class="table">
                        <colgroup>
                            <col style="width: 25%;">
                            <col style="width: 15%;">
                            <col style="width: 60%;">
                        </colgroup>
                        <tbody>
                        <c:forEach var="crudNotice" items="${notice }">
                            <tr>
                                    <td>${crudNotice.TAGNAME }</td>
                                <c:choose>
                                    <c:when test="${fn:length(crudNotice.TITLE) > 14}">
                                        <c:if test="${crudNotice.REGDATE } "></c:if>
                                        <td><a href="/notice/${crudNotice.NTNUM}" style="text-decoration:none ; color:#000000;"><c:out value="${fn:substring(crudNotice.TITLE,0,20)}"/>....</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="/notice/${crudNotice.NTNUM}" style="text-decoration:none ; color:#000000;"><c:out value="${crudNotice.TITLE}"/></a></td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${crudNotice.REGDATE }</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<p class="text-muted text-center"><small>고객센터 : 02-336-7800 주소: 서울특별시 마포구 독막로 10 성지빌딩 5층 509호</small></p>
<p class="text-muted text-center"> <small>Copyright CRUD XaaS SYSTEM &copy; 2018</small> </p>

<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/inspinia.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/login.js"></script>
</body>
</html>
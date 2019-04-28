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
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/company/user">사용자 목록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/company/user/${userInfo.USERNO}">사용자 정보</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>사용자 정보 수정</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <form:form action="/company/user/modified/${userInfo.USERNO}" method="POST">
            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left">저장</button>
                    <a href="/company/user/${userInfo.USERNO}" class="btn btn-default pull-right">취소</a>
                </div>
            </div>

            <br/>

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

                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">사용자명</label>
                                            <div class="col-sm-4">
                                                <input type="text" name="username" id="username" value="${userInfo.USERNAME}" class="form-control form-control-sm name">
                                            </div>
                                            <label class="col-sm-2 col-form-label">ID</label>
                                            <div class="col-sm-4">
                                                    ${userInfo.USERID}
                                            </div>
                                        </div>
                                        <c:choose>
                                            <c:when  test="${userInfo.USERNO eq sessionScope.ENCUSERNO}">
                                                <div class="form-group  row">
                                                    <label class="col-sm-2 col-form-label">비밀번호</label>
                                                    <div class="col-sm-4">
                                                        <input type="password" name="userpassword" id="userpassword" class="form-control form-control-sm password">
                                                    </div>
                                                    <label class="col-sm-2 col-form-label">비밀번호확인</label>
                                                    <div class="col-sm-4">
                                                        <input type="password" class="form-control form-control-sm confirmpassword">
                                                    </div>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
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
                                            </c:otherwise>
                                        </c:choose>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">휴대번호</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <select class="form-control m-b" id="mobile1" name="mobile1">
                                                            <option label="선택" value="0"></option>
                                                            <c:forEach var="mobile" items="${MOBILE}">
                                                                <c:choose>
                                                                    <c:when test="${userInfo.MOBILE1 eq mobile.codeval}">
                                                                        <option selected label="${mobile.codename }" value="${mobile.codeval }"/>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option label="${mobile.codename }" value="${mobile.codeval }"/>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-4"><input type="text" id="mobile2" name="mobile2" minlength="3" maxlength="4" value="${userInfo.MOBILE2}" class="form-control form-control-sm"></div>
                                                    <div class="col-md-4"><input type="text" id="mobile3" name="mobile3" minlength="3" maxlength="4" value="${userInfo.MOBILE3}" class="form-control form-control-sm"></div>
                                                    <div>
                                                        <label class="error" for="mobile1"></label><label class="error" for="mobile2"></label><label class="error" for="mobile3"></label>
                                                    </div>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 col-form-label">전화번호</label>
                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <select class="form-control m-b" name="telno1" id="telno1" >
                                                            <option label="선택" value="0"></option>
                                                            <c:forEach var="phone" items="${PHONE}">
                                                                <c:choose>
                                                                    <c:when test="${userInfo.TELNO1 eq phone.codeval}">
                                                                        <option selected label="${phone.codename }" value="${phone.codeval }"/>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option label="${phone.codename }" value="${phone.codeval }"/>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-4"><input type="text" name="telno2" id="telno2" minlength="3" maxlength="4" value="${userInfo.TELNO2}" class="form-control form-control-sm"></div>
                                                    <div class="col-md-4"><input type="text" name="telno3" id="telno3" minlength="3" maxlength="4" value="${userInfo.TELNO3}" class="form-control form-control-sm"></div>
                                                    <div>
                                                        <label class="error" for="telno1"></label><label class="error" for="telno2"></label><label class="error" for="telno3"></label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">이메일</label>
                                            <div class="col-sm-4">
                                                <input type="text" name="email" id="email" value="${userInfo.EMAIL}" class="form-control form-control-sm adminemail">
                                            </div>
                                    <c:choose>
                                        <c:when test="${sessionScope.CHKAUTH eq 20 or sessionScope.CHKAUTH eq 30}">
                                            <label class="col-sm-2 col-form-label">관리자여부</label>
                                            <div class="col-sm-4">
                                                <select class="form-control" name="chkauth" id="chkauth" style="width:130px;">
                                                    <c:forEach var="chkAuth_" items="${CHKAUTH_}">
                                                        <option label="${chkAuth_.codename}" value="${chkAuth_.codeval}"></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">직책</label>
                                            <div class="col-sm-4">
                                                <input type="text" name="userduty" id="userduty" autocomplete="off" class="form-control form-control-sm" value="${userInfo.USERDUTY}">
                                            </div>
                                        </div>
                                        </c:when>
                                        <c:otherwise>
                                        <label class="col-sm-2 col-form-label">직책</label>
                                        <div class="col-sm-4">
                                            <input type="text" name="userduty" id="userduty" autocomplete="off" class="form-control form-control-sm" value="${userInfo.USERDUTY}">
                                        </div>
                                    </div>
                                        </c:otherwise>

                                    </c:choose>
                                        <div class="form-group  row">
                                            <label class="col-sm-2 col-form-label">메모</label>
                                            <div class="col-sm-10">
                                                <textarea name="userdesc" id=" userdesc" class="form-control" value="${uesrInfo.USERDESC}" style="resize: none;" rows="4">${uesrInfo.USERDESC}</textarea>
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
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>사용자 등록</h5>
                        </div>
                        <div class="ibox-content" >
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group  row">
                                            <label class="col-sm-1 col-form-label">CTI번호</label>
                                            <div class="col-sm-3">
                                                <input type="text" name="ctitelno" id="ctitelno" value="${ctiUserInfo.CTITELNO}" class="form-control form-control-sm">
                                            </div>
                                            <label class="col-sm-1 col-form-label">CTIID</label>
                                            <div class="col-sm-3">
                                                <input type="text" name="ctiid" id="ctiid" value="${ctiUserInfo.CTIID}" class="form-control form-control-sm">
                                            </div>
                                            <label class="col-sm-1 col-form-label">CTIPW</label>
                                            <div class="col-sm-3">
                                                <input type="text" name="ctipw" id="ctipw" value="${ctiUserInfo.CTIPW}" class="form-control form-control-sm">
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
                    <button type="submit" class="btn btn-default pull-left">저장</button>
                    <a href="/company/user/${userInfo.USERNO}" class="btn btn-default pull-right">취소</a>
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
<!-- validate -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/crud_validate.js"></script>

<script>
    $(document).ready(function() {
    });
</script>
</body>
</html>

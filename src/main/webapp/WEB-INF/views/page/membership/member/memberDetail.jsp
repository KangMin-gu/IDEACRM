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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/dualListbox/bootstrap-duallistbox.min.css" rel="stylesheet">
</head>
<style>
</style>
<body>
<c:set var="menuactive" value='myinfoM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>내 정보</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>내 정보</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <a href="/myinfo/modified/${userInfo.USERNO}" class="btn btn-default pull-right">수정</a>
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
                                        <input type="hidden" name="userno" id="userno" value="${userInfo.USERNO}">
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
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>전화번호 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.MOBILE1} ${userInfo.MOBILE2} ${userInfo.MOBILE3}</p>
                                                </div>
                                                <div class="col-sm-2">
                                                    <p>휴대전화 : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.TELNO1} ${userInfo.TELNO2} ${userInfo.TELNO3}</p>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <p>Email : </p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <p>${userInfo.EMAIL}</p>
                                                </div>
                                                    <c:choose>
                                                        <c:when test="${sessionScope.CHKAUTH eq 20 or sessionScope.CHKAUTH eq 30}">
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
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                                <div class="col-sm-2">
                                                                    <p>직책 : </p>
                                                                </div>
                                                                <div class="col-sm-4">
                                                                    <p>${userInfo.USERDUTY}</p>
                                                                </div>
                                                            </div>
                                                        </c:otherwise>
                                                     </c:choose>
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
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>CTI 정보</h5>
                        </div>
                        <div class="ibox-content">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="col-sm-2">
                                                <p>CTI전화번호 : </p>
                                            </div>
                                            <div class="col-sm-2">
                                                <p>${ctiUserInfo.CTITELNO}</p>
                                            </div>
                                            <div class="col-sm-1">
                                                <p>CTIID : </p>
                                            </div>
                                            <div class="col-sm-3">
                                                <p>${ctiUserInfo.CTIID}</p>
                                            </div>
                                            <div class="col-sm-1">
                                                <p>CTIPW : </p>
                                            </div>
                                            <div class="col-sm-3">
                                                <p>${ctiUserInfo.CTIPASS}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/plugins/dualListbox/jquery.bootstrap-duallistbox.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/member.js"></script>
<script>
    $(document).ready(function() {

        $('.dual_select').bootstrapDualListbox({
            selectorMinimalHeight: 160
        });

//$(".bootstrap-duallistbox-container").find("*").prop("disabled",true);

        var unselected = $('#licenseno option:not(:selected)')
        var selected = $('#licenseno option:selected');
        var this_value="";
        var selected_value="";

//위에 jstl로 2중 foreach를 사용해서 이중포문 안쓰려고 헀는데 selected된 값과 selected되지 않은 값이 동시에 만들어져서
// selected가 아닌 값을 지우면 동시에 사라지는 현상이 생겨서 어쩔수없이 다시 2중 each문을 사용해서 selected 값과 selected가 아닌 값을 비교해서 selected가 아닌 값을 remove
        $.each(selected,function(index){
            selected_value = $(this).val();
            $.each(unselected,function(index){
                this_value = $(this).val();
                if(selected_value == this_value){
                    $(this).remove();
                }
            });
        });
// bootstrapDaulListbox의 제공기능중 하나로 option 값을 지웠을때 새로고침을 해주는 역할
        $('.dual_select').bootstrapDualListbox('refresh',true);
    });
</script>
</body>
</html>

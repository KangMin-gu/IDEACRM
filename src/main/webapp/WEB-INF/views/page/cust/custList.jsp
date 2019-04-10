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
    <!--<link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.core.css" rel="stylesheet">-->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.bootstrap.min.css" rel="stylesheet">
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
                <h2>고객 목록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>고객 목록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">

                        <div class="ibox-content">
                            <form:form id="custListSearchForm" action="/cust">
                                <div class="table-responsive">
                                    <table style="white-space:nowrap;">
                                        <colgroup>
                                            <col width="5%">
                                            <col width="10%">
                                            <col width="5%">
                                            <col width="10%">
                                            <col width="5%">
                                            <col width="10%">
                                            <col width="5%">
                                            <col width="10%">
                                            <col width="5%">
                                            <col width="10%">
                                            <col width="5%">
                                            <col width="10%">
                                        </colgroup>
                                        <tbody>
                                        <tr>
                                            <th>등록일</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                    <input class="form-control form-control-sm daterange searchparam" type="text" id="regdate" name="regdate" />
                                                </div>
                                            </td>
                                            <th>회원구분</th>
                                            <td><!--Todo.코드로 받아오기-->
                                                <select class="form-control searchparam" style="width:100px;" id="custgubun" name="custgubun">
                                                    <option value="">선택</option>
                                                    <c:forEach var="CUSTGUBUN" items="${CUSTGUBUN}"  >
                                                    <option value="${CUSTGUBUN.codeval}">${CUSTGUBUN.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <th>고객등급</th>
                                            <td><!--Todo.코드로 받아오기-->
                                                <select class="form-control searchparam" style="width:100px;" id="custgrade" name="custgrade">
                                                    <option value="">선택</option>
                                                    <c:forEach var="CUSTGRADE" items="${CUSTGRADE}"  >
                                                        <option value="${CUSTGRADE.codeval}">${CUSTGRADE.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <th>활동등급</th>
                                            <td><!--Todo.코드로 받아오기-->
                                                <select class="form-control searchparam" style="width:100px;" id="actgrade" name="actgrade">
                                                    <option value="">선택</option>
                                                    <c:forEach var="ACTGRADE" items="${ACTGRADE}"  >
                                                        <option value="${ACTGRADE.codeval}">${ACTGRADE.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <th>정보활용</th>
                                            <td>
                                                <select class="form-control searchparam" style="width:100px;" id="infoagree" name="infoagree">
                                                    <option value="">전체</option>
                                                    <c:forEach var="INFOAGREE" items="${INFOAGREE}"  >
                                                    <option value="${INFOAGREE.codeval}" ${INFOAGREE.codeval eq "1" ? "selected" :""}>${INFOAGREE.codename}</option>
                                                    </c:forEach>

                                                </select>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-w-m btn-primary" id="custListSearch">검색</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>고객명</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="custname" name="custname">
                                            </td>
                                            <th>휴대전화</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="mobile" name="mobile">
                                            </td>
                                            <th>이메일</th>
                                            <td>
                                                <input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="email" name="email">
                                            </td>
                                            <th>직장명</th>
                                            <td>
                                                <!--<input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="cliname" name="cliname">-->
                                                <div class="input-group client" id="cliname" >
                                                    <input type="text" class="form-control form-control-sm searchparam"  autocomplete="off" name="cliname" readonly>
                                                    <input type="hidden" class="searchparam" name="clino" id="clino" value="">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </div>
                                            </td>
                                            <th>담당자</th>
                                            <td>
                                                <!--<input class="form-control form-control-sm searchparam" type="text" style="width: 150px;" id="owner" name="owner">-->
                                                <div class="input-group owner" id="owner_" >
                                                    <input type="text" class="form-control form-control-sm searchparam"  autocomplete="off" name="owner_" readonly>
                                                    <input type="hidden" class="searchparam" name="owner" id="owner" value="">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </div>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-w-m btn-default" id="reset">초기화</button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>회원사 고객 목록</h5>
                        </div>
                        <div class="ibox-content">
                            <button type="button" class="btn btn-sm" id="test"><i class="fa fa-file-excel-o"></i></button>
                            <a class="btn btn-default pull-right" href="/cust/input">추가</a>
                            <button class="btn btn-default pull-right" onclick="custMultyDelete();">삭제</button>
                            <form class="deleteForm" action="/cust/del" method="post">
                            <table class="footable table table-stripped "  data-paging="true" data-filter=#filter data-sorting="true">
                                <thead>
                                <tr>
                                    <th data-name="CUSTNO" data-breakpoints="xs sm" data-formatter="custListChkBoxFormatter" data-sortable="false"><input type="checkbox" id="checkAll" onclick="selectCheckbox('custno');"/></th>
                                    <th data-name="CUSTNAME" data-formatter="custListFormatter">고객명</th>
                                    <th data-name="CLINAME" data-breakpoints="xs sm">직장</th>
                                    <th data-name="DEPTNAME" data-breakpoints="xs sm">부서</th>
                                    <th data-name="MOBILE_" data-breakpoints="xs sm">휴대폰</th>
                                    <th data-name="EMAIL" data-breakpoints="xs sm">이메일</th>
                                    <th data-name="OWNER_" data-breakpoints="xs sm">담당자</th>
                                    <th data-name="CUSTGUBUN" data-breakpoints="xs sm">회원구분</th>
                                    <th data-name="CUSTGRADE" data-breakpoints="xs sm">고객등급</th>
                                    <th data-name="REGDATE" data-breakpoints="xs sm">등록일</th>
                                </tr>
                                </thead>
                            </table>
                            </form>
                        </div>
                    </div>
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
<script src="${pageContext.request.contextPath}/resources/js/footable.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- crud js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/cust.js"></script>
<script>
    $(document).ready(function() {
        footableSearchList('/cust');
    });
    $('#custListSearch').click(function(e){
        footableSearchList('/cust');
    });



$('#test').click(function(){
    var param = searchDataToJson();
    $.ajax({
        type: 'POST',
        url: '/custexcel',
        data: param,
        async: false,
        success: function(data) {
            if(data != null) {
                alert('삭제 되었습니다.');
            }
            location.href = "/cust";
        },error:function(request,status,error){
            alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
        }
    });
});

</script>
</body>
</html>

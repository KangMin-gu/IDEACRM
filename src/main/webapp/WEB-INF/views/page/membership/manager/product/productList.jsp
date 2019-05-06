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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/jsTree/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<style>
    .jstree-open > .jstree-anchor > .fa-folder:before {
        content: "\f07c";
    }

    .jstree-default .jstree-icon.none {
        width: 0;
    }
</style>
<body>
<c:set var="menuactive" value='productM'/>
<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>제품 관리</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>제품 관리</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">

                <div class="col-lg-6">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>제품 리스트</h5>
                        </div>
                        <div class="ibox-content">
                            <form id="jsTreeForm">
                                <div class="input-group">
                                    <input id="jsTreeVal" type="text" placeholder="제품 검색">
                                    <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit" style="height: 35px;">
                                        <span class="sr-only">검색</span>
                                        <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                                </div>
                            </form>
                            <div id="jstreeSet">

                            </div>
                        </div>
                    </div>
                </div>



                <div class="col-lg-6">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>제품 정보</h5>
                            <div class=" pull-right" style="margin-bottom: 0px;top: 9px;right: 15px;bottom: 0px;">
                                <a class="btn btn-default" onclick="prdFormReset()" href="#">추가</a>
                            </div>
                        </div>
                        <form:form id="productForm" method="post" action="/company/product/insert">
                            <div class="ibox-content">
                                <div class="table-responsive">
                                    <table style="white-space:nowrap;">
                                        <colgroup>
                                            <col width="5%">
                                            <col width="30%">
                                            <col width="5%">
                                            <col width="30%">
                                        </colgroup>
                                        <tbody>
                                        <tr>
                                            <th>카테고리 생성</th>
                                            <td>
                                                <select class="form-control form-control-sm" id="grpno" style="width: 150px;">
                                                    <option >선택</option>
                                                    <option value="0">상위메뉴</option>
                                                    <option value="1">하위메뉴</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr class="grpInput">
                                            <th><label for="grpname">그룹명</label></th>
                                            <td><input type="text" class="form-control-sm form-control" id="grpname" name="grpname" style="width: 150px;"></td>
                                        </tr>
                                        <tr class="downInput">
                                            <th><label for="grpupper">그룹명</label></th>
                                            <td>
                                                <select class="form-control form-control-sm" name="grpupper" id="grpupper" style="width: 150px;">
                                                    <option >선택</option>
                                                    <c:forEach var="highList" items="${highList}"  >
                                                        <option value="${highList.PRDNO}">${highList.PRDNAME}</option>
                                                    </c:forEach>
                                                </select>
                                                <input type="hidden" id="prdno" name="prdno">
                                            </td>
                                            <th><label for="prdvalue">제품코드</label></th>
                                            <td><input type="text" class="form-control-sm form-control" id="prdvalue" name="prdvalue" style="width: 150px;"></td>
                                        </tr>
                                        <tr class="downInput">
                                            <th><label for="erpno">회사코드</label></th>
                                            <td><input type="text" class="form-control-sm form-control" id="erpno" name="erpno" style="width: 150px;"></td>
                                            <th><label for="prdname">제품명</label></th>
                                            <td><input type="text" class="form-control-sm form-control" id="prdname" name="prdname" style="width: 200px;"></td>
                                        </tr>
                                        <tr class="downInput">
                                            <th><label for="prdprice">가격</label></th>
                                            <td>
                                                <input type="text" class="form-control-sm form-control" id="prdprice" name="prdprice" style="width: 100px;">
                                            </td>
                                            <th><label for="prddesc">제품설명</label></th>
                                            <td><input type="text" class="form-control-sm form-control" id="prddesc" name="prddesc"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <br/>
                                    <button type="submit" id="saveBtn" class="btn btn-default pull-right">저장</button>
                                    </form:form>
                                    <a href="#" onclick="productUpdate()" id="updateBtn" class="btn btn-default pull-right">수정</a>
                                    <a href="#" onclick="productDel()" id="deleteBtn" class="btn btn-default pull-left">삭제</a>
                                    <button id="resetBtn" class="btn btn-default pull-right">초기화</button>
                                </div>
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
<%@ include file="/WEB-INF/views/includ/menuactive.jsp"%>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/product.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jstree.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script>

</script>
</body>
</html>

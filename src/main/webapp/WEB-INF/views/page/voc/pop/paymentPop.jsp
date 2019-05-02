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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- orris  -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
</head>
<style>
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox">
                    <div class="ibox-title">
                        <h5>상품 목록</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-striped ibox-right cti-user-list" style="white-space:nowrap;">
                                        <colgroup>
                                            <col width="20%">
                                            <col width="10%">
                                            <col width="10%">
                                            <col width="10%">
                                        </colgroup>
                                        <thead>
                                        <tr>
                                            <th>상품명</th>
                                            <th>가격</th>
                                            <th>수량</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                폴리코산 10mg (30정)
                                            </td>
                                            <td>
                                                29000원
                                            </td>
                                            <td>
                                                <select class="form-control" style="width: 100px;" name="" id="">
                                                    <option value="">0</option>
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                </select>
                                            </td>
                                            <td><button class="btn btn-primary">담기</button></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                폴리코산 10mg (30정)
                                            </td>
                                            <td>
                                                29000원
                                            </td>
                                            <td>
                                                <select class="form-control" style="width: 100px;" name="" id="">
                                                    <option value="">0</option>
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                </select>
                                            </td>
                                            <td><button class="btn btn-primary">담기</button></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                폴리코산 10mg (30정)
                                            </td>
                                            <td>
                                                29000원
                                            </td>
                                            <td>
                                                <select class="form-control" style="width: 100px;" name="" id="">
                                                    <option value="">0</option>
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                </select>
                                            </td>
                                            <td><button class="btn btn-primary">담기</button></td>
                                        </tr>
                                        </tbody>
                                        <tfoot>
                                        </tfoot>
                                    </table>
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
                        <h5>장바구니 리스트</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-striped ibox-right cti-user-list" style="white-space:nowrap;">
                                        <colgroup>
                                            <col width="20%">
                                            <col width="10%">
                                            <col width="10%">
                                            <col width="10%">
                                        </colgroup>
                                        <thead>
                                        <tr>
                                            <th>상품명</th>
                                            <th>가격</th>
                                            <th>수량</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                폴리코산 10mg (30정)
                                            </td>
                                            <td>
                                                29000원
                                            </td>
                                            <td>
                                                <select class="form-control" style="width: 100px;" name="" id="">
                                                    <option value="">0</option>
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                </select>
                                            </td>
                                            <td><button class="btn btn-warning">삭제</button></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                폴리코산 10mg (30정)
                                            </td>
                                            <td>
                                                29000원
                                            </td>
                                            <td>
                                                <select class="form-control" style="width: 100px;" name="" id="">
                                                    <option value="">0</option>
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                </select>
                                            </td>
                                            <td><button class="btn btn-warning">삭제</button></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                폴리코산 10mg (30정)
                                            </td>
                                            <td>
                                                29000원
                                            </td>
                                            <td>
                                                <select class="form-control" style="width: 100px;" name="" id="">
                                                    <option value="">0</option>
                                                    <option value="">1</option>
                                                    <option value="">2</option>
                                                </select>
                                            </td>
                                            <td><button class="btn btn-warning">삭제</button></td>
                                        </tr>
                                        </tbody>
                                        <tfoot>
                                        </tfoot>
                                    </table>
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
                    <h5>구매자 정보</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="10%">
                                        <col width="40%">
                                        <col width="10%">
                                        <col width="40%">
                                    </colgroup>
                                    <tr>
                                        <th>구매자</th>
                                        <td colspan="3">강민구</td>
                                    </tr>
                                    <tr>
                                        <th>전화번호</th>
                                        <td>02-394-8574</td>
                                        <th>휴대전화</th>
                                        <td>010-7120-3655</td>
                                    </tr>
                                    <tr>
                                        <th>구매자 주소</th>
                                        <td colspan="3">강민구</td>
                                    </tr>
                                </table>
                            </div>

                            <br/>
                            <label class="i-checks"> <input type="checkbox" value="1" id="denysmsad" name="denysmsad">&nbsp; 구매자 정보와 동일</label>

                            <div class="table-responsive">
                                <table class="table" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="10%">
                                        <col width="40%">
                                        <col width="10%">
                                        <col width="40%">
                                    </colgroup>
                                    <tr>
                                        <th>받는이</th>
                                        <td colspan="3">
                                            <input class="form-control form-control-sm" type="text" style="width: 100px;">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>전화번호</th>
                                        <td>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm vocCustInput" name="mobile1" id="mobile1" style="width: 80px;height: 30px;padding-top: 2.5px;">
                                                    <option value="">선택</option>
                                                    <c:forEach var="mobile" items="${MOBILE}">
                                                        <option value="${mobile.codeval}">${mobile.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm vocCustInput" type="text" name="mobile2" id="mobile2" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm vocCustInput" type="text" name="mobile3" id="mobile3" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                        </td>
                                        <th>휴대전화</th>
                                        <td>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm vocCustInput" name="mobile1" id="mobile1" style="width: 80px;height: 30px;padding-top: 2.5px;">
                                                    <option value="">선택</option>
                                                    <c:forEach var="mobile" items="${MOBILE}">
                                                        <option value="${mobile.codeval}">${mobile.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm vocCustInput" type="text" name="mobile2" id="mobile2" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm vocCustInput" type="text" name="mobile3" id="mobile3" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>받는이 주소</th>
                                        <td colspan="3">
                                            <div class="row">
                                                <div class="col-md-2"><input type="text" class="form-control form-control-sm voc vocSvInput" id="visitaddr1" name="visitaddr1" readonly></div>
                                                <div class="col-md-4"><input type="text" class="form-control form-control-sm voc vocSvInput" id="visitaddr2" name="visitaddr2" readonly></div>
                                                <div class="col-md-4"><input type="text" class="form-control form-control-sm voc vocSvInput" id="visitaddr3" name="visitaddr3"></div>
                                                <div class="col-md-2"><button class="btn btn-white btn-sm daumzip voc" type="button" id="visitaddr">주소 검색</button></div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>배송 메모</th>
                                        <td colspan="3"><input class="form-control form-control-sm" type="text"></td>
                                    </tr>
                                </table>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <button type="button" class="btn btn-default pull-left">취소</button>
        <a href="${pageContext.request.contextPath}/order" class="btn btn-primary pull-right">결제</a>

    </div>
</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/popJs.jsp"%>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>

</body>
</html>

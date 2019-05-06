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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/jsTree/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- orris  -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
</head>
<style>
</style>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-6">
                <div class="ibox">
                    <div class="ibox-title">
                        <h5>상품 목록</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-lg-12">
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
                </div>
            </div>



            <div class="col-lg-6">
                <div class="ibox">
                    <div class="ibox-title">
                        <h5>장바구니 리스트</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-striped" id="backetList" style="white-space:nowrap;">
                                        <colgroup>
                                            <col width="20%">
                                            <col width="20%">
                                            <col width="20%">
                                            <col width="20%">
                                        </colgroup>
                                        <thead>
                                        <tr>
                                            <th>상품명</th>
                                            <th>가격</th>
                                            <th>수량</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody id="productBacketList">
                                        </tbody>
                                        <tfoot>
                                        <tr>
                                            <td>총가격 <span  id="payPrice"></span></td>
                                            <input type="hidden" id="totalPrice">
                                        </tr>
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
                                        <td colspan="3"><span id="buyNametext"></span></td>
                                        <input type="hidden" id="buyName">
                                        <input type="hidden" id="buyuserNo">
                                    </tr>
                                    <tr>
                                        <th>전화번호</th>
                                        <td><span id="buyTel"></span></td>
                                        <input type="hidden"  id="buyTel1">
                                        <input type="hidden"  id="buyTel2">
                                        <input type="hidden"  id="buyTel3">
                                        <th>휴대전화</th>
                                        <td><span id="buyPhone"></span></td>
                                        <input type="hidden"  id="buyPhone1">
                                        <input type="hidden"  id="buyPhone2">
                                        <input type="hidden"  id="buyPhone3">
                                    </tr>
                                    <tr>
                                        <th>구매자 주소</th>
                                        <td><span id="buyAddr"></span></td>
                                        <input type="hidden"  id="buyAddr1">
                                        <input type="hidden"  id="buyAddr2">
                                        <input type="hidden"  id="buyAddr3">
                                        <th>구매자 이메일</th>
                                        <td><span class="buyEmail" id="buyEmailtext"></span></td>
                                        <input type="hidden" id="buyEmail">
                                    </tr>
                                </table>
                            </div>

                            <br/>
                            <input type="checkbox" id="sameChk" />&nbsp; 구매자 정보와 동일
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
                                            <input class="form-control form-control-sm" id="deliveryname" name="deliveryname" type="text" style="width: 200px;">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>전화번호</th>
                                        <td>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="deliverytel1" id="deliverytel1" style="width: 80px;height: 30px;padding-top: 2.5px;">
                                                    <option>선택</option>
                                                    <c:forEach var="phone" items="${PHONE}">
                                                        <option value="${phone.codeval}">${phone.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm" type="text" name="deliverytel2" id="deliverytel2" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm" type="text" name="deliverytel3" id="deliverytel3" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                        </td>
                                        <th>휴대전화</th>
                                        <td>
                                            <div style="display: inline-block">
                                                <select class="form-control form-control-sm" name="deliverymobile1" id="deliverymobile1" style="width: 80px;height: 30px;padding-top: 2.5px;">
                                                    <option>선택</option>
                                                    <c:forEach var="mobile" items="${MOBILE}">
                                                        <option value="${mobile.codeval}">${mobile.codename}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm" type="text" name="deliverymobile2" id="deliverymobile2" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                            <div style="display: inline-block">
                                                <input class="form-control form-control-sm" type="text" name="deliverymobile3" id="deliverymobile3" style="width: 70px; height: 30px;" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>받는이 주소</th>
                                        <td colspan="3">
                                            <div class="row">
                                                <div class="col-md-2"><input type="text" class="form-control form-control-sm"  id="deliveryaddr1" name="deliveryaddr1" readonly></div>
                                                <div class="col-md-4"><input type="text" class="form-control form-control-sm"  id="deliveryaddr2" name="deliveryaddr2" readonly></div>
                                                <div class="col-md-4"><input type="text" class="form-control form-control-sm" id="deliveryaddr3" name="deliveryaddr3"></div>
                                                <div class="col-md-2"><button class="btn btn-white btn-sm daumzip" type="button">주소 검색</button></div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>배송 메모</th>
                                        <td colspan="3"><input class="form-control form-control-sm" type="text" id="deliverydesc" name="deliverydesc"></td>
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

        <button class="btn btn-primary pull-right" id="orderBtn">주문서 작성</button>

    </div>
</div>
<!--js  includ-->
<%@ include file="/WEB-INF/views/includ/popJs.jsp"%>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jstree.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/payment.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script>
</script>
</body>
</html>

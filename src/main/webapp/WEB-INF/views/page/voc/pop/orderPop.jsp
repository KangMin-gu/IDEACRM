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
    <link href="${pageContext.request.contextPath}/resources/css/footable.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- orris -->
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
                        <h5>주문 상세</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered ibox-right cti-user-list" style="white-space:nowrap; text-align: center;">
                                        <colgroup>
                                            <col width="5%">
                                            <col width="15%">
                                            <col width="5%">
                                            <col width="15%">
                                            <col width="5%">
                                            <col width="15%">
                                        </colgroup>
                                        <tbody>
                                        <tr>
                                            <th colspan="6" style="text-align: left; background-color: lightgrey;">제품정보 정보</th>
                                            <input type="hidden" id="buyno" value="${orderResult.BUYNO}"/>
                                            <input type="hidden" id="prdResSize" value="${prdResSize}"/>
                                        </tr>
                                        <c:forEach var="tmp" varStatus="status" items="${orderProductResult }" >
                                            <tr>
                                                <th>제품명</th>
                                                <td id="prdname${status.index}" style="text-align: right">${tmp.PRDNAME}</td>
                                                <th>수량</th>
                                                <td id="prdea${status.index}" style="text-align: right">${tmp.PRDEA}</td>
                                                <th>가격</th>
                                                <td id="prdprice${status.index}" style="text-align: right">${tmp.PRDPRICE}</td>
                                            </tr>
                                        </c:forEach>
                                        <tr>
                                            <th colspan="5" style="text-align: center">총 상품가격</th>
                                            <td style="text-align: right">${orderResult.TOTALPRICE}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

<br/>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered ibox-right cti-user-list" style="white-space:nowrap; text-align: center;">
                                        <colgroup>
                                            <col width="5%">
                                            <col width="15%">
                                            <col width="5%">
                                            <col width="15%">
                                            <col width="5%">
                                            <col width="15%">
                                        </colgroup>
                                        <tr>
                                            <th colspan="8" style="text-align: left; background-color: lightgrey;">받는사람 정보</th>
                                        </tr>
                                        <tr>
                                            <th>받는사람</th>
                                            <td id="deliveryname">${orderResult.DELIVERYNAME}</td>
                                            <th>휴대전화</th>
                                            <td id="deliverymobile">${orderResult.MOBILE}</td>
                                            <th>자택전화</th>
                                            <td id="deliveryhomtel">${orderResult.HOMTEL}</td>
                                            <th>주소</th>
                                            <td id="deliveryaddr">${orderResult.ADDR}</td>
                                        </tr>
                                        <tr>
                                            <th>배송요청사항</th>
                                            <td id="deleverydesc" colspan="7">${orderResult.DELIVERYDESC}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <br/>
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
                                            <th colspan="4" style="background-color: lightgrey;">결제정보</th>
                                        </tr>
                                        <tr>
                                            <th >총 상품가격</th>
                                            <td id="totalprice">${orderResult.TOTALPRICE}</td>
                                        </tr>
                                        <tr>
                                            <th>총 결제금액</th>
                                            <td>${orderResult.TOTALPRICE}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <button type="button" class="btn btn-default pull-left cancel">취소</button>
        <button type="submit" id="send" class="btn btn-primary pull-right save vocPayCompleteBtn" >확인</button>

</div>
<!--js includ-->
<%@ include file="/WEB-INF/views/includ/popJs.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/voc.js"></script>

</body>
</html>

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
    <!-- orris -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
</head>
<style>
    th{
        background-color: #f5f6f7;
    }
</style>
<body>

<div id="wrapper">
    <%@ include file="/WEB-INF/views/common/leftsidebar.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <%@ include file="/WEB-INF/views/common/top_v2.jsp"%>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

        <form:form action="/company/license/input/${siteid}" method="POST">
            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left">적용</button>
                    <a href="/common/site/${siteid}" class="btn btn-default pull-right">취소</a>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>라이센스 관리</h5>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="5%">
                                        <col width="5%">
                                        <col width="5%">
                                        <col width="5%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>모듈명</th>
                                            <th>상태</th>
                                            <th>수량</th>
                                            <th>현재사용량</th>
                                            <th>반영날짜</th>
                                        </tr>
                                        <tr>
                                            <th><span name="useLicenseDtoList[0].licenseno" id="custlicenseno" value="1">고객관리</span></th>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[0].isdelete" id="custisdelete" style="height: 35px;">
                                                    <option value="0">활성</option>
                                                    <option value="1">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[0].licensecnt" id="custlicensecnt" style="height: 35px;">
                                                    <c:forEach begin="0" end="50" step="1" varStatus="status">
                                                        <option value="${status.count}">${status.count}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><span name="usecnt" id="custusecnt"></span></td>
                                            <td><span name="edtdate" id="custedtdate"></span></td>
                                            <input type="hidden" name="useLicenseDtoList[0].licenseno" value="1"/>
                                        </tr>
                                        <tr>
                                            <th><span name="useLicenseDtoList[1].licenseno" id="accountcenseno" value="2">영업관리</span></th>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[1].isdelete" id="accountisdelete" style="height: 35px;">
                                                    <option value="0">활성</option>
                                                    <option value="1">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[1].licensecnt" id="accountlicensecnt" style="height: 35px;">
                                                    <option value="0">0</option>
                                                    <c:forEach begin="0" end="50" step="1" varStatus="status">
                                                        <option value="${status.count}">${status.count}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><span name="usecnt" id="accountusecnt"></span></td>
                                            <td><span name="edtdate" id="accountedtdate"></span></td>
                                            <input type="hidden" name="useLicenseDtoList[1].licenseno" value="2"/>
                                        </tr>
                                        <tr>
                                            <th><span name="useLicenseDtoList[2].licenseno" id="servicelicenseno" value="3">서비스관리</span></th>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[2].isdelete" id="serviceisdelete" style="height: 35px;">
                                                    <option value="0">활성</option>
                                                    <option value="1">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[2].licensecnt" id="servicelicensecnt" style="height: 35px;">
                                                    <option value="0">0</option>
                                                    <c:forEach begin="0" end="50" step="1" varStatus="status">
                                                        <option value="${status.count}">${status.count}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><span name="usecnt" id="serviceusecnt"></span></td>
                                            <td><span name="edtdate" id="serviceedtdate"></span></td>
                                            <input type="hidden" name="useLicenseDtoList[2].licenseno" value="3"/>
                                        </tr>
                                        <tr>
                                            <th><span name="useLicenseDtoList[3].licenseno" id="campaignlicenseno" value="4">캠페인</span></th>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[3].isdelete" id="campaignisdelete" style="height: 35px;">
                                                    <option value="0">활성</option>
                                                    <option value="1">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[3].licensecnt" id="campaignlicensecnt" style="height: 35px;">
                                                    <option value="0">0</option>
                                                    <c:forEach begin="0" end="50" step="1" varStatus="status">
                                                        <option value="${status.count}">${status.count}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><span name="usecnt" id="campaignusecnt"></span></td>
                                            <td><span name="edtdate" id="campaignedtdate"></span></td>
                                            <input type="hidden" name="useLicenseDtoList[3].licenseno" value="4"/>
                                        </tr>
                                        <tr>
                                            <th><span name="useLicenseDtoList[4].licenseno" id="voclicenseno" value="5">콜센터</span></th>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[4].isdelete" id="vocisdelete" style="height: 35px;">
                                                    <option value="0">활성</option>
                                                    <option value="1">비활성</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control form-control-sm" name="useLicenseDtoList[4].licensecnt" id="voclicensecnt" style="height: 35px;">
                                                    <option value="0">0</option>
                                                    <c:forEach begin="0" end="50" step="1" varStatus="status">
                                                        <option value="${status.count}">${status.count}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><span name="usecnt" id="ctiusecnt" value=""></span></td>
                                            <td><span name="edtdate" id="ctiedtdate"></span></td>
                                            <input type="hidden" name="useLicenseDtoList[4].licenseno" value="5"/>
                                        </tr>
                                        <tr>
                                            <th>라이센스활성수</th>
                                            <td colspan="2"><span id="totallicensecnt"></span></td>
                                            <th>총유저수</th>
                                            <td colspan="2"><span id="totalusercnt"></span></td>
                                        </tr>
                                    <input type="hidden" name="siteid" id="siteid" value="${siteid}"/>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left">적용</button>
                    <a href="/common/site/${siteid}" class="btn btn-default pull-right">취소</a>
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
<!-- Morris -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crud/license.js"></script>
<script>
$(document).ready(function() {
    var siteid = $('#siteid').val();
    licenseInsertPage(siteid);
});
</script>
</body>

</html>

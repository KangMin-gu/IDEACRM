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
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
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
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>영업 신규</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/cust">영업 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>영업 신규</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">목록</button>
                    <a href="#" class="btn btn-default" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-mobile fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-comment fa-lg"></i></a>
                    <button type="button" class="btn btn-default pull-right">삭제</button>
                    <button type="button" class="btn btn-default pull-right">수정</button>
                </div>
            </div>

            <br/>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>영업 신규등록</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-bordered" style="white-space:nowrap;">
                                    <colgroup>
                                        <col width="5%">
                                        <col width="20%">
                                        <col width="5%">
                                        <col width="20%">
                                        <col width="5%">
                                        <col width="20%">
                                        <col width="5%">
                                        <col width="20%">
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>영업건명</th>
                                            <td>전북도시가스 콜센터 고도화</td>
                                            <th>거래처명</th>
                                            <td>전북도시가스</td>
                                            <th>담당자</th>
                                            <td>강민구</td>
                                            <th>제품명</th>
                                            <td>IDEA PACKAGE</td>
                                        </tr>
                                        <tr>
                                            <th>현 단계진입일</th>
                                            <td>전북도시가스 콜센터 고도화</td>
                                            <th>현 단계</th>
                                            <td>전북도시가스</td>
                                            <th>영업건 구분</th>
                                            <td>강민구</td>
                                            <th>확률</th>
                                            <td>IDEA PACKAGE</td>
                                        </tr>
                                        <tr>
                                            <th>예상 수주일</th>
                                            <td>전북도시가스 콜센터 고도화</td>
                                            <th>예상 수주액</th>
                                            <td>전북도시가스</td>
                                            <th>실 수주일</th>
                                            <td>강민구</td>
                                            <th>실 수주액</th>
                                            <td>IDEA PACKAGE</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>부가 사항</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <colgroup>
                                        <col width="10%">
                                        <col width="40%">
                                        <col width="10%">
                                        <col width="40%">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>요구사항</th>
                                        <td></td>
                                        <th>해결방안</th>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <th>고객사 메모</th>
                                        <td></td>
                                        <th>영업 메모</th>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <th>거절 사유</th>
                                        <td></td>
                                        <th>극복 방안</th>
                                        <td></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">목록</button>
                    <a href="#" class="btn btn-default" style="margin-left:20px;"><i class="fa fa-envelope fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-mobile fa-lg"></i></a>
                    <a href="#" class="btn btn-default"><i class="fa fa-comment fa-lg"></i></a>
                    <button type="button" class="btn btn-default pull-right">삭제</button>
                    <button type="button" class="btn btn-default pull-right">수정</button>
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
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('#daterange').daterangepicker();
        $('#daterange2').daterangepicker();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>
</html>

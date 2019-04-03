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
                <h2>서비스 정보 수정</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/service">서비스 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/service/${serviceInfo.SERVICENO}">서비스 정보</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>서비스 정보 수정</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <a href="/service/${serviecInfo.SERVICENO}" class="btn btn-default pull-right">취소</a>
                    <button type="button" class="btn btn-default pull-right">저장</button>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>서비스 정보</h5>
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
                                    <tobdy>
                                        <tr>
                                            <th>고객명</th>
                                            <td></td>
                                            <th>자택전화</th>
                                            <td></td>
                                            <th>휴대전화</th>
                                            <td></td>
                                            <th>이메일</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>고객 주소</th>
                                            <td colspan="7"></td>
                                        </tr>
                                    </tobdy>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row ">
                <div class="col-lg-12">
                    <div class="tabs-container">
                        <ul class="nav nav-tabs" role="tablist">
                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1">접수정보</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-2">현상파악</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-3">처리파악</a></li>
                        </ul>

                        <div class="tab-content">
                            <div role="tabpanel" id="tab-1" class="tab-pane active">
                                <div class="panel-body">
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
                                            <tobdy>
                                                <tr>
                                                    <th>접수일</th>
                                                    <td></td>
                                                    <th>접수자</th>
                                                    <td></td>
                                                    <th>제품명</th>
                                                    <td></td>
                                                    <th>처리담당자</th>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <th>접수구분</th>
                                                    <td></td>
                                                    <th>접수유형1</th>
                                                    <td></td>
                                                    <th>접수유형2</th>
                                                    <td></td>
                                                    <th>진행단계</th>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <th>서비스명</th>
                                                    <td colspan="7"></td>
                                                </tr>
                                                <tr>
                                                    <th>접수내용</th>
                                                    <td colspan="7">

                                                    </td>
                                                </tr>
                                            </tobdy>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div role="tabpanel" id="tab-2" class="tab-pane">
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" style="white-space:nowrap;">
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
                                            <tobdy>
                                                <tr>
                                                    <th>방문예약일</th>
                                                    <td></td>
                                                    <th>방문예약시간</th>
                                                    <td></td>
                                                    <th>담당자</th>
                                                    <td></td>
                                                    <th>현상</th>
                                                    <td></td>
                                                    <th>원인구분</th>
                                                    <td></td>
                                                    <th>방문주소</th>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <th>상세내역</th>
                                                    <td colspan="11"></td>
                                                </tr>
                                                <tr>
                                                    <th>지연사유</th>
                                                    <td colspan="11"></td>
                                                </tr>
                                            </tobdy>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div role="tabpanel" id="tab-3" class="tab-pane">
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" style="white-space:nowrap;">
                                            <colgroup>
                                                <col width="5%">
                                                <col width="25%">
                                                <col width="5%">
                                                <col width="25%">
                                                <col width="5%">
                                                <col width="25%">
                                            </colgroup>
                                            <tobdy>
                                                <tr>
                                                    <th>처리일</th>
                                                    <td></td>
                                                    <th>처리담당자</th>
                                                    <td></td>
                                                    <th>처리발송여부</th>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <th>처리내용</th>
                                                    <td colspan="5"></td>
                                                </tr>
                                            </tobdy>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>

            <br/>

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
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>
</html>

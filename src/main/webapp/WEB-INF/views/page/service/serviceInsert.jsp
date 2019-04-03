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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
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
                <h2>서비스 신규 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/service">서비스 목록</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>서비스 등록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
        <form:form action="/serviceinsert" method="post">
            <div class="row">
                <div class="col-lg-12">
                    <button type="submit" class="btn btn-default pull-left">저장</button>
                    <a href="/service" class="btn btn-default pull-right">취소</a>
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
                                            <td>
                                                <!--
                                                <div style="display: inline-block">
                                                    <input type="text" class="form-control form-control-sm" style="width:230px;">
                                                </div>
                                                <div style="display: inline-block">
                                                        <a><i class="fa fa-search fa-lg"></i></a>
                                                </div>
                                                -->
                                                <div class="input-group owner" id="custno_" >
                                                    <input type="text" class="form-control" autocomplete="off" name="custno_">
                                                    <input type="hidden" name="custno" id="custno">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </div>
                                            </td>
                                            <th>자택전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control" style="width:80px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block;">
                                                    <input type="text" class="form-control form-control-sm" style="width:80px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input type="text" class="form-control form-control-sm" style="width:80px;">
                                                </div>
                                            </td>
                                            <th>휴대전화</th>
                                            <td>
                                                <div style="display: inline-block">
                                                        <select class="form-control" style="width:80px;">
                                                            <option value="Bahamas">010</option>
                                                            <option value="Bahrain">011</option>
                                                            <option value="Bangladesh">017</option>
                                                            <option value="Barbados">018</option>
                                                            <option value="Belarus">019</option>
                                                        </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <input type="text" class="form-control form-control-sm" style="width:80px;">
                                                </div>
                                                <div style="display: inline-block">
                                                    <input type="text" class="form-control form-control-sm" style="width:80px;">
                                                </div>
                                            </td>
                                            <th>이메일</th>
                                            <td>
                                                <input type="text" class="form-control form-control-sm" style="width:230px;">
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>고객 주소</th>
                                            <td colspan="7">
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-1" class="form-control form-control-sm"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-5" class="form-control form-control-sm"></div>
                                                <div style="display: inline-block"><button class="btn btn-white btn-sm" type="submit">주소 검색</button></div>
                                            </td>
                                        </tr>
                                    </tobdy>
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
                            <h5>접수 정보</h5>
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
                                            <th>접수일</th>
                                            <td>
                                                <div class="input-group" style="width:230px;">
                                                    <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                    <input class="form-control form-control-sm date" name="receptiondate" id="receptiondate" type="text"/>
                                                </div>
                                            </td>
                                            <th>접수자</th>
                                            <td>
                                                <div class="input-group owner" id="serviceowner_" >
                                                    <input type="text" class="form-control" autocomplete="off" name="serviceowner_" value="${sessionScope.USERNAME}">
                                                    <input type="hidden" name="serviceowner" id="serviceowner" value="${sessionScope.USERNO}">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </div>
                                            </td>
                                            <th>구분</th>
                                            <td>
                                                <!-- radio -->
                                                <div class="i-checks">
                                                    <label class="mr-2 mb-0"><input type="radio" value="1" id="servicetype" name="servicetype">문의</label>
                                                    <label class="mr-2 mb-0"><input type="radio" value="2" id="servicetype2" name="servicetype">A/S</label>
                                                </div>
                                            </td>
                                            <th>유형</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control" name="servicecode1" id="servicecode1" style="width: 100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control" name="servicecode2" id="servicecode2" style="width: 100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>처리담당자</th>
                                            <td>
                                                <div class="input-group owner" id="owner_" >
                                                    <input type="text" class="form-control" autocomplete="off" name="owner_">
                                                    <input type="hidden" name="owner" id="owner">
                                                    <span class="input-group-addon">
                                                        <a><i class="fa fa-search"></i></a>
                                                    </span>
                                                </div>
                                            </td>
                                            <th>채널</th>
                                            <td>
                                                <select class="form-control" name="servicechannel" id="servicechannel" style="width:230px;">
                                                    <option value="Bahamas">010</option>
                                                    <option value="Bahrain">011</option>
                                                    <option value="Bangladesh">017</option>
                                                    <option value="Barbados">018</option>
                                                    <option value="Belarus">019</option>
                                                </select>
                                            </td>
                                            <th>진행단계</th>
                                            <td>접수</td>
                                            <th>제품명</th>
                                            <td>
                                                <div style="display: inline-block">
                                                    <select class="form-control" name="product11" id="product11" style="width: 100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control" name="product12" id="product12" style="width: 100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                                <div style="display: inline-block">
                                                    <select class="form-control" name="product13" id="product13" style="width: 100px;">
                                                        <option value="Bahamas">010</option>
                                                        <option value="Bahrain">011</option>
                                                        <option value="Bangladesh">017</option>
                                                        <option value="Barbados">018</option>
                                                        <option value="Belarus">019</option>
                                                    </select>
                                                </div>
                                            </td>
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
                            <li><a class="nav-link" data-toggle="tab" href="#tab-3">처리정보</a></li>
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
                                                    <th>접수내용</th>
                                                    <td colspan="7">
                                                        <textarea name="servicename" id="servicename" class="form-control" style="resize: none;" rows="1"></textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>상담내용</th>
                                                    <td colspan="7">
                                                        <textarea class="tinymce" name="servicedesc" id="servicedesc"></textarea>
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
                                                <col width="15%">
                                                <col width="5%">
                                                <col width="15%">
                                                <col width="5%">
                                                <col width="15%">
                                                <col width="5%">
                                                <col width="15%">
                                                <col width="5%">
                                                <col width="15%">
                                            </colgroup>
                                            <tobdy>
                                                <tr>
                                                    <th>방문예약일</th>
                                                    <td>
                                                        <div class="input-group" style="width:230px;">
                                                            <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                            <input class="form-control form-control-sm date" name="visitdate" id="visitdate" type="text" id="daterange"  />
                                                        </div>
                                                    </td>
                                                    <th>방문예약시간</th>
                                                    <td>
                                                        <div style="display: inline-block;">
                                                            <input type="text" class="form-control form-control-sm" style="width:100px;">
                                                        </div>
                                                        <div style="display: inline-block">
                                                            <input type="text" class="form-control form-control-sm" style="width:100px;">
                                                        </div>
                                                    </td>
                                                    <th>담당자</th>
                                                    <td>
                                                        <input type="text" class="form-control form-control-sm" style="width:230px;">
                                                    </td>
                                                    <th>현상</th>
                                                    <td>
                                                        <select class="form-control" style="width:230px;" name="rewardtype" id="rewardtype">
                                                            <option value="Bahamas">010</option>
                                                            <option value="Bahrain">011</option>
                                                            <option value="Bangladesh">017</option>
                                                            <option value="Barbados">018</option>
                                                            <option value="Belarus">019</option>
                                                        </select>
                                                    </td>
                                                    <th>원인구분</th>
                                                    <td>
                                                        <select class="form-control" style="width:230px;" name="causecode" id="causecode">
                                                            <option value="Bahamas">010</option>
                                                            <option value="Bahrain">011</option>
                                                            <option value="Bangladesh">017</option>
                                                            <option value="Barbados">018</option>
                                                            <option value="Belarus">019</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>방문주소</th>
                                                    <td colspan="9">
                                                        <div style="display: inline-block"><input type="text" id="visitaddr1" name="visitaddr1" class="form-control form-control-sm"></div>
                                                        <div style="display: inline-block"><input type="text" id="visitaddr2" name="visitaddr2" class="form-control form-control-sm"></div>
                                                        <div style="display: inline-block"><input type="text" id="visitaddr3" name="visitaddr3" class="form-control form-control-sm"></div>
                                                        <div style="display: inline-block"><button class="btn btn-white btn-sm daumzip" id="visitaddr" type="submit">주소 검색</button></div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>상세내역</th>
                                                    <td colspan="9">
                                                        <textarea class="tinymce"></textarea>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>지연사유</th>
                                                    <td colspan="9">
                                                        <textarea name="need" id="" class="form-control" style="resize: none;" rows="4"></textarea>
                                                    </td>
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
                                                    <td>
                                                        <div class="input-group" style="width:230px;">
                                                            <span class="input-group-addon" style="height:31px;"><i class="fa fa-calendar fa-sm"></i></span>
                                                            <input class="form-control form-control-sm date" type="text" id="daterange3"  />
                                                        </div>
                                                    </td>
                                                    <th>처리담당자</th>
                                                    <td>
                                                        <input type="text" class="form-control form-control-sm" style="width:230px;">
                                                    </td>
                                                    <th>처리발송여부</th>
                                                    <td>
                                                        <select class="form-control" style="width:230px;">
                                                            <option value="Bahamas">010</option>
                                                            <option value="Bahrain">011</option>
                                                            <option value="Bangladesh">017</option>
                                                            <option value="Barbados">018</option>
                                                            <option value="Belarus">019</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>처리내용</th>
                                                    <td colspan="5">
                                                        <textarea class="tinymce"></textarea>
                                                    </td>
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
                    <button type="button" class="btn btn-default pull-left">저장</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>

            <br/>
        </form:form>
        </div>


        <div class="footer">
            <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        </div>

    </div>
</div>

<!--js includ-->
<%@ include file="/WEB-INF/views/includ/js.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/plugins/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tinymce_ko_KR.js"></script>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!--datarange-->
<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>

<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- daumAPI -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- api js -->
<script src="${pageContext.request.contextPath}/resources/js/crud/api.js"></script>

</body>
</html>

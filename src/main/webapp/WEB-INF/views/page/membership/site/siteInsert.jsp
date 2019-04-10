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
    <link href="${pageContext.request.contextPath}/resources/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/daterangepicker-bs3.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css" rel="stylesheet">
</head>
<style>
    th{
        background-color: #f5f6f7;
    }
    .denny{
        background-color: #f3f1f0;
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
                <h2>회원사 등록</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="${pageContext.request.contextPath}/">메인</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <a href="${pageContext.request.contextPath}/">회원사 목록</a>
                    </li>
                    <li class="breadcrumb-item">
                        <strong>회원사 등록</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
<form:form>
            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-default pull-left">등록</button>
                    <button type="button" class="btn btn-default pull-right">취소</button>
                </div>
            </div>

            <br/>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>회원사 정보</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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
                                            <th>회원사명</th>
                                            <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                            <th>사업자번호</th>
                                            <td>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" style="width:80px;"></div>
                                            </td>
                                            <th>법인번호</th>
                                            <td>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" style="width:100px;"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" style="width:100px;"></div>
                                            </td>
                                            <th>대표자명</th>
                                            <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                        </tr>
                                        <tr>
                                            <th>전화번호</th>
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
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" style="width:80px;"></div>
                                            </td>
                                            <th>팩스번호</th>
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
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" style="width:80px;"></div>
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
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm" style="width:80px;"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm" style="width:80px;"></div>
                                            </td>
                                            <th>이메일</th>
                                            <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                        </tr>
                                        <tr>
                                            <th>업태</th>
                                            <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                            <th>업종</th>
                                            <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                            <th>종목</th>
                                            <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                            <th>기업규모</th>
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
                                            <th rowspan="3">주소 및 위치</th>
                                            <td colspan="8">
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-2" class="form-control form-control-sm"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-3" class="form-control form-control-sm"></div>
                                                <div style="display: inline-block"><input type="text" placeholder=".col-md-4" class="form-control form-control-sm"></div>
                                                <div style="display: inline-block"><button class="btn btn-white btn-sm" type="submit">주소 검색</button></div>
                                            </td>
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
                            <h5>계정 등록</h5>
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
                                        <th>계정</th>
                                        <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                        <th>비밀번호</th>
                                        <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                        <th>비밀번호 확인</th>
                                        <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                    </tr>
                                    <tr>
                                        <th>서비스상태</th>
                                        <td>
                                            <select class="form-control" style="width:230px;">
                                                <option value="Bahamas">010</option>
                                                <option value="Bahrain">011</option>
                                                <option value="Bangladesh">017</option>
                                                <option value="Barbados">018</option>
                                                <option value="Belarus">019</option>
                                            </select>
                                        </td>
                                        <th>담당자</th>
                                        <td><input type="text" class="form-control form-control-sm" style="width:200px;"></td>
                                        <th>회원사로고</th>
                                        <td>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <span class="btn btn-outline-secondary btn-file">
                                                    <span class="fileinput-new">파일선택</span>
                                                    <span class="fileinput-exists">변경</span>
                                                    <input type="file" name="...">
                                                </span>
                                                <span class="fileinput-filename"></span>
                                                <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="float: none">&times;</a>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>회원사 메모</th>
                                        <td colspan="11">
                                            <textarea name="need" id="" class="form-control" style="resize: none;" rows="4"></textarea>
                                        </td>
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
                    <button type="button" class="btn btn-default pull-left">등록</button>
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
<!-- Jasny -->
<script src="${pageContext.request.contextPath}/resources/js/jasny-bootstrap.min.js"></script>
<!-- FooTable -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/footable/footable.all.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js"></script>
<!-- daum map -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=60c1fc75825cf6619b0ff66b5aca7161&libraries=services"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
        $('.footable3').footable();
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
    });
</script>
</body>
</html>
